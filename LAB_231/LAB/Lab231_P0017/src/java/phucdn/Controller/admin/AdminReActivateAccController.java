/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.Controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phucdn.dao.UserDAO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "AdminReActivateAccController", urlPatterns = {"/AdminReActivateAccController"})
public class AdminReActivateAccController extends HttpServlet {

    private static final String SUCCESS = "loadAllService";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = SUCCESS;
        String txtUsername = request.getParameter("txtUsername");
        UserDAO uDAO = new UserDAO();
        boolean isReActive = false;
        try {
            if (txtUsername != null) {
                isReActive = uDAO.reActiveAcc(txtUsername);
                if (isReActive) {
                    url = SUCCESS;
                    request.setAttribute("successMSG", "Re-Active "+txtUsername+" is done!");
                } else{
                    request.setAttribute("errorMSG", "Re-Activate Account is failed!");
                }
            } else {
                request.setAttribute("errorMSG", "Don't send a request the username for this function!");
            }
        } catch (Exception e) {
            log("Error at AdminReActivateAccController: " + e.getMessage());
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
