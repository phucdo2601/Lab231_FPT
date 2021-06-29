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
import phucdn.dtos.google.GmailUtils;
import phucdn.dtos.google.GoogleAccDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "LoginGoogleController", urlPatterns = {"/LoginGoogleController"})
public class LoginGoogleController extends HttpServlet {

    private static Logger LOGGER = Logger.getLogger(LoginGoogleController.class);
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String code = request.getParameter("code");
        UserDAO uDAO = new UserDAO();
        HttpSession session = request.getSession();
        
        String url = "";
        try {
            if (code == null || code.isEmpty()) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                String accessToken = GmailUtils.getToken(code);
                GoogleAccDTO goAcc = GmailUtils.getUserInfo(accessToken);
                String email = goAcc.getEmail();
                String checkLogin = uDAO.checkGmailLogin(email);
                String checkAuthen = uDAO.checkGmailAuthen(email);
                if (checkLogin != null) {
                    if (checkAuthen.equals("Active")) {
                        url = "LoadAllGeneralServiceController";
                        session.setAttribute("roleUser", checkLogin);
                        session.setAttribute("txtUsername", email);
                    }else {
                        url = "reActiveAcc.jsp";
                        request.setAttribute("AccNotActivate", "Your Account"
                                + " is not Activate! Please click Next Button "
                                + "to give code for activate account"
                                + "(Before click its button. Please check again your username(email).)");
                        request.setAttribute("txtUsernameReAcc", email);
                    }
                }else{
                    url = "MainController?action=changeSignUp";
                    request.setAttribute("NotHavingAcc", "Not Having Account in this system!");
                    request.setAttribute("txtUsernameGmail", email);
                }
                
            }
        } catch (Exception e) {
            log("Error at LoginGoogleController: "+e.getMessage());
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
