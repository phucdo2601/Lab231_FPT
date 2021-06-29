/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phucdn.dao.DiscountDAO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "AdminAccToDisController", urlPatterns = {"/AdminAccToDisController"})
public class AdminAccToDisController extends HttpServlet {

    private static final String SUCCESS = "AdminLoadDiscountPageController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = "error.jsp";
        String userChoose = request.getParameter("userList");
        String disID = request.getParameter("txtDisID");
        DiscountDAO disDAO = new DiscountDAO();
        boolean isAddToDisID = false;
        try {
            if (userChoose != null) {
                isAddToDisID = disDAO.addAccToDiscountID(disID, userChoose);
                if (isAddToDisID) {
                    url = SUCCESS;
                    request.setAttribute("successMSG", "Add Account to Discount ID is done!");
                }
            }
        } catch (Exception e) {
            log("Error at AdminAccToDisController: " + e.getMessage());
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
