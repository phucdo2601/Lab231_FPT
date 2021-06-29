/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import phucdn.dao.UserDAO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "VerifyConfirmAccountController", urlPatterns = {"/VerifyConfirmAccountController"})
public class VerifyConfirmAccountController extends HttpServlet {

    private static final String ERROR = "confirmAcc.jsp";
    private static final String SUCCESS = "login.jsp";
    private static final Logger LOGGER = 
            Logger.getLogger(VerifyConfirmAccountController.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = ERROR;
        HttpSession session = request.getSession();
        String codeSend = (String) session.getAttribute("txtVerifyCodeSession");
        String codeInput = request.getParameter("txtVerifyCode");
        String username = request.getParameter("txtUsername");
        UserDAO uDAO = new UserDAO();
        boolean activateAcc = false;
        try {
            if (codeInput.equals(codeSend)) {
                activateAcc = uDAO.activateAcc(username);
                url = SUCCESS;
                request.setAttribute("successSignUp", "Your Account is activate!");
                session.removeAttribute("txtUsername");
                session.removeAttribute("txtVerifyCodeSession");
            }else{
                request.setAttribute("errorConfirm", "Acticate Code is not correct! Please Input again!");
            }

        } catch (Exception e) {
            log("Error at VerifyConfirmAccountController: " + e.getMessage());
            LOGGER.error(e);
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
