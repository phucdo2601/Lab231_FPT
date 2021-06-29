/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phucdn.dao.DiscountDAO;
import phucdn.dao.UserDAO;
import phucdn.dto.object.DiscountDTO;
import phucdn.dto.object.UserDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private final static String ADMIN = "admin.jsp";
    private final static String USER = "LoadAllServiceController";
    private final static String ERROR = "error.jsp";
    private final static String INVALID = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String url = ERROR;
        UserDAO uDAO = new UserDAO();
        DiscountDAO disDAO = new DiscountDAO();
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String role = null;
        try {
            role = uDAO.checkLoginRole(username, password);
            if (role.equals("user")) {
                url = USER;
                List<DiscountDTO> listDiscountByUserID = disDAO.loadListDisByUserID(username);
                UserDTO loadInfoByUserID = uDAO.loadInfoByUserID(username);
                session.setAttribute("listDiscount", listDiscountByUserID);
                session.setAttribute("USERNAME", username);
                session.setAttribute("roleAcc", role);
                session.setAttribute("infoUser", loadInfoByUserID);
            } else if (role.equals("admin")) {
                url = ADMIN;
                session.setAttribute("USERNAME", username);
                session.setAttribute("roleAcc", role);
            } else if (role.equals("falied")) {
                url = INVALID;
                request.setAttribute("errorMessageRole", "Your username or password is not valid!");
            } else if (role.equals("BanAccount")) {
                request.setAttribute("errorMessage",
                        "Your account is banned for a "
                        + "little time! Please Login again!");
            }
        } catch (Exception e) {
            log("Error at LoginController: " + e.getMessage());
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
