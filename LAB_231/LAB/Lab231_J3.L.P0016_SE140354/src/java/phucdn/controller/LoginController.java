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
import phucdn.dao.UserDAO;
import phucdn.dtos.google.VerifyRecaptcha;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private static final String ERROR = "login.jsp";
    private static final String SUCCESS = "LoadAllGeneralServiceController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = ERROR;
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        HttpSession session = request.getSession();
        boolean verify = VerifyRecaptcha.verifyRacapt(gRecaptchaResponse);
        UserDAO uDAO = new UserDAO();
        String checkLoginRole = null;
        String checkLoginAuthen = null;
        try {
            checkLoginRole = uDAO.checkLoginRole(username, password);
            checkLoginAuthen = uDAO.checkLoginAuthen(username, password);
            

            if (verify && checkLoginRole.equals("emp") || checkLoginRole.equals("ld") || checkLoginRole.equals("mng") && checkLoginAuthen.equals("Active")) {

                session.setAttribute("txtUsername", username);
                session.setAttribute("roleUser", checkLoginRole);
                url = "LoadAllGeneralServiceController";

            } else if(checkLoginRole.equals("faliedStatus")) {
                System.out.println(checkLoginAuthen);
                url = "reActiveAcc.jsp";
                request.setAttribute("AccNotActivate", "Your Account"
                        + " is not Activate! Please click Next Button "
                        + "to give code for activate account"
                        + "(Before click its button. Please check again your username(email).)");
                request.setAttribute("txtUsernameReAcc", username);

            }else{
                url = ERROR;
                request.setAttribute("errorMessageRole", "Your username or password is not correct! Please input again!");
            }
        } catch (Exception e) {
            log("Error at LoginController");
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
