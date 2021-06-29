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
import phucdn.dtos.sendEmail.SendEmail;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "SendReActivateCodeController", urlPatterns = {"/SendReActivateCodeController"})
public class SendReActivateCodeController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(SendReActivateCodeController.class);
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String txtUsername = request.getParameter("txtUsername");
        String url = "";
        UserDAO uDAO = new UserDAO();
        String status = null;
        SendEmail sm = new SendEmail();
        String codeReActivate = null;
        try {
            status =uDAO.reFindAccount(txtUsername);
            if (status.equals("New")) {
                codeReActivate = sm.getRandom();
                
                boolean test = sm.sendEmail(txtUsername, codeReActivate);
                if (test) {
                    url = "confirmAcc.jsp";
                    session.setAttribute("txtUsername", txtUsername);
                    session.setAttribute("txtVerifyCodeSession", codeReActivate);
                }
            }else{
                
            }
        } catch (Exception e) {
            log("Error at SendReActivateCodeController: "+e.getMessage());
            LOGGER.error(e);
        }finally{
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
