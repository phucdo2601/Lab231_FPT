/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import phucdn.dao.RoleDAO;
import phucdn.dao.UserDAO;
import phucdn.dtos.object.UserDTO;
import phucdn.dtos.objectError.UserErrorObj;
import phucdn.dtos.sendEmail.SendEmail;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "CreateAccountController", urlPatterns = {"/CreateAccountController"})
public class CreateAccountController extends HttpServlet {

    private static final String ERROR = "MainController?action=changeSignUp";
    private static final String SUCCESS = "confirmAcc.jsp";
    private static final Logger LOGGER = Logger.getLogger(CreateAccountController.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = ERROR;
        String username = request.getParameter("txtUsername");
        String fullname = request.getParameter("txtFullname");
        String address = request.getParameter("txtAddress");
        String password = request.getParameter("txtPassword");
        String rePassword = request.getParameter("txtConfirm");
        String role = request.getParameter("cboRole");
        String phoneNumber = request.getParameter("txtPhone");
        RoleDAO rDAO = new RoleDAO();
        long mills = System.currentTimeMillis();
        Timestamp createDate = new Timestamp(mills);
        HttpSession session = request.getSession();
        UserDAO uDAO = new UserDAO();
        boolean inserted = false;
        UserErrorObj errorObj = new UserErrorObj();
        boolean bErr = false;
        try {
            if (!rePassword.trim().equals(password)) {
                bErr = true;
                errorObj.setConfirmPasswordErr("Your confirm password is not match with password!");
            }
            if (!username.matches("^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$")) {
                bErr = true;
                errorObj.setUserIDErr("Your username is the email. Email format has commonly abc@xxx.yyy.zz");
            }
            if (bErr) {
                request.setAttribute("InsertedErr", errorObj);
            } else {
                String realRole = rDAO.selectRoleNameByRoleID(role);
                UserDTO uDTO = new UserDTO(username, password, fullname, address, createDate, realRole, phoneNumber);
                inserted = uDAO.createAccount(uDTO);
                if (inserted) {
                    SendEmail sm = new SendEmail();
                    String code = sm.getRandom();
                    

                    boolean test = sm.sendEmail(username, code);

                    if (test) {
                        url = SUCCESS;
                        session.setAttribute("txtUsername", username);
                        session.setAttribute("txtVerifyCodeSession", code);
                    }
                } else {
                    request.setAttribute("errorMessage", "Create Account is not valid!!");
                }
            }
        } catch(SQLException e){
            log("CreateAccountController SQL "+e.getMessage());
            errorObj.setUserIDErr("Your username is still activate in this system!");
            request.setAttribute("InsertedErr", errorObj);
            LOGGER.error(e);
        }
        catch (Exception e) {
            log("Error at CreateAccountController: " + e.getMessage());     
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
