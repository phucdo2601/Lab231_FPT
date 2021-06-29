/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phucdn.dao.AccountDAO;
import phucdn.dtos.AccountDTO;
import phucdn.dtos.AccountErrorObject;

/**
 *
 * @author phucd
 */
@WebServlet(name = "InsertAccServlet", urlPatterns = {"/InsertAccServlet"})
public class InsertAccServlet extends HttpServlet {
    private static final String LOGIN_PAGE = "login.jsp";
    private static final String INSERT_ERR_PAGE = "createAccount.jsp";
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
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String fullname = request.getParameter("txtFullname");
        long mills = System.currentTimeMillis();
        Timestamp dateOfPost = new Timestamp(mills);
        boolean bErr = false;
        AccountErrorObject errors = new AccountErrorObject();
        String url = INSERT_ERR_PAGE;
        try {
            if (username.trim().length() < 6 || username.trim().length() > 20) {
                bErr = true;
                errors.setUsernameError("User phai co kich thuoc tu 6-20 ky tu");
            }
            if (password.trim().length() < 6 || password.trim().length() > 30) {
                bErr = true;
                errors.setPasswordError("Password phai co kich thuoc tu 6-30 ky tu");
            }
            if (!confirm.trim().equals(password.trim())) {
                bErr = true;
                errors.setConfirmError("Confirm khong khop voi pass ");
            }
            if (fullname.trim().length() < 2 || fullname.trim().length() > 50) {
                bErr = true;
                errors.setFullnameError("Fullname phai co kich thuoc tu 2-50 ky tu");
            }
            
            if (bErr) {
                request.setAttribute("INSERTERRS", errors);
            }else{
                AccountDTO dto = new AccountDTO(username, password, fullname, "", "", "", "user", true, dateOfPost);
                AccountDAO accDAO = new AccountDAO();
                boolean result = accDAO.insertAccount(dto);
                if (result) {
                    url = LOGIN_PAGE;
                }
            }
        } catch (SQLException ex) {
            log("CreateNewServlet SQL " + ex.getMessage());
            errors.setUsernameisExisted(username + " da ton tai");
            // dua loi sai len lai Scope
            request.setAttribute("INSERTERRS", errors);
        } catch (ClassNotFoundException ex) {
            log("CreateNewServlet ClassNotFound " + ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(InsertAccServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
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
