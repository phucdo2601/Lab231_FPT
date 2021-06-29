/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phucdn.dao.AccountDAO;
import phucdn.dtos.AccountDTO;
import phucdn.dtos.AccountErrorObject;

/**
 *
 * @author phucd
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private final static String ADMIN = "admin.jsp";
    private final static String USER = "UserCategoryAndProductController";
    private final static String ERROR = "error.jsp";
    private final static String INVALID = "login.jsp";
    private final static String ERROR_LOGIN = "login.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");

        //luu account len cookies de luu thong tin dang nhap cua minh
        Cookie u = new Cookie("userP", username);
        Cookie p = new Cookie("passP", password);
        try {

            boolean valid = true;
            AccountErrorObject errorObj = new AccountErrorObject();
            HttpSession session = request.getSession();
            if (username.length() == 0) {
                valid = false;
                errorObj.setUsernameError("Username is not Blank!");
            }
            if (password.length() == 0) {
                valid = false;
                errorObj.setPasswordError("Password is not Blank!");
            }

            if (valid) {
                AccountDAO dao = new AccountDAO();
                String role = dao.checkLogin(username, password);
                if (role.equals("failed")) {
                    url = ERROR_LOGIN;
                    request.setAttribute("ERROR_LOGIN", "Username or Password is not valid!");
                } else if (role.equals("failedStatus")) {
                    request.setAttribute("ERROR", "Account has been blocked for a small time! Please login again!");
                } else {
                    if (role.equals("admin")) {
                        url = ADMIN;
                        session.setAttribute("USERNAME", username);
                        session.setAttribute("roleAcc", role);
//                        session.setMaxInactiveInterval(86400);

                        //set thoi gian ton tai cua cookies tren broswer
                        u.setMaxAge(60 * 5);
                        p.setMaxAge(60 * 5);
                    } else if (role.equals("user")) {
                        url = USER;
                        //lay session cua username
                        session.setAttribute("USERNAME", username);
                        session.setAttribute("roleAcc", role);
//                        session.setMaxInactiveInterval(86400);

                        //set thoi gian ton tai cua cookies tren broswer
                        u.setMaxAge(60 * 5);
                        p.setMaxAge(60 * 5);
                    } else {
                        request.setAttribute("ERROR", errorObj);
                    }
                }
            } else {
                url = INVALID;
                request.setAttribute("INVALID", errorObj);
            }
        } catch (Exception e) {
            log("ERROR at LoginServlet: " + e.getMessage());
        } finally {
            //luu cookies tren trinh duyet ma ban su dung
            response.addCookie(u);
            response.addCookie(p);
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
//        /**
//         * luu username, pass lai thanh text username, pass
//         */
//        //b1: get user, pass from cookies
//        Cookie arr[] = request.getCookies();
//        for (Cookie o : arr) {
//            if (o.getName().equals("passP")) {
//                request.setAttribute("password", o.getValue());
//            }
//        }
        //b2: set username, pass to login form 
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
