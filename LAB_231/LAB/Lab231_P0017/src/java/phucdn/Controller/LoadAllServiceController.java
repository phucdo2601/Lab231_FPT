/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.Controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phucdn.dao.RoleUserDAO;
import phucdn.dao.UserDAO;
import phucdn.dto.object.UserDTO;

/**
 *
 * @author ASUS
 */

@WebServlet(name = "LoadAllServiceController", urlPatterns = {"/loadAllService"})
public class LoadAllServiceController extends HttpServlet {

    private static final String SUCCESS = "home.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String txtUsername = (String) session.getAttribute("txtUsername");
        String txtRole = (String) session.getAttribute("txtRole");
        String url = SUCCESS;
        UserDAO uDAO = new UserDAO();
        RoleUserDAO ruDAO = new RoleUserDAO();

        try {
            if (txtRole.equals("admin")) {
                List<UserDTO> listAllAccount = uDAO.loadAllUser();
                List<UserDTO> listAdminAcc = uDAO.loadUserByRoleID(txtRole);
                List<UserDTO> listUserAcc = uDAO.loadUserByRoleID("user");
                int quanRoleAcc = ruDAO.countRole();
                request.setAttribute("listAllAcc", listAllAccount);
                request.setAttribute("listAdmin", listAdminAcc);
                request.setAttribute("listUser", listUserAcc);
                request.setAttribute("quanRole", quanRoleAcc);
            }
            UserDTO accLogin = uDAO.loadUserByUserID(txtUsername);
            request.setAttribute("accLogin", accLogin);
            session.setAttribute("txtUsername", txtUsername);
            session.setAttribute("txtRole", txtRole);
            
        } catch (Exception e) {
            log("Error at LoadAllServiceController: " + e.getMessage());
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
