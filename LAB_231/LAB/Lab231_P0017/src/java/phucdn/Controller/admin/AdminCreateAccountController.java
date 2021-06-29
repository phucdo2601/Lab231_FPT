/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.Controller.admin;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phucdn.dao.PromoStatusDAO;
import phucdn.dao.RoleUserDAO;
import phucdn.dao.UserDAO;
import phucdn.dao.UserStatusDAO;
import phucdn.dto.errorObj.UserErrorObj;
import phucdn.dto.object.UserDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "AdminCreateAccountController", urlPatterns = {"/AdminCreateAccountController"})
public class AdminCreateAccountController extends HttpServlet {

    private static final String SUCCESS = "loadAllService";
    private static final String ERROR = "AdminSignUpPageController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = ERROR;
        String username = request.getParameter("txtUsername");
        String fullname = request.getParameter("txtFullname");
        String email = request.getParameter("txtEmail");;
        String phone = request.getParameter("txtPhone");
        String cboRole = request.getParameter("cboRole");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        UserDAO uDAO = new UserDAO();
        UserDTO uDTO = null;
        boolean isCreate = false;
        UserErrorObj errorObj = new UserErrorObj();
        boolean bErr = false;
        RoleUserDAO ruDAO = new RoleUserDAO();
        PromoStatusDAO pmsDAO = new PromoStatusDAO();
        UserStatusDAO usDAO = new UserStatusDAO();
        long mills = System.currentTimeMillis();
        Date dateOfCreate = new Date(mills);
        try {
            if (!confirm.trim().equals(password)) {
                bErr = true;
                errorObj.setConfirmPassErr("Your confirm password is not match with password!");
            }
            if (!email.matches("^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$")) {
                bErr = true;
                errorObj.setEmailErr("Your email is not corret form! The sutaible form of email is x@abc.xyz");
            }
            if (!phone.matches("^\\d{10}$")) {
                bErr = true;
                errorObj.setPhoneErr("The phone number Chain is to have 10 charcters!");
            }

            if (bErr) {
                request.setAttribute("InsertedErr", errorObj);
            } else {
                String realRole = ruDAO.selectRoleIDByRoleName(cboRole);
                uDTO = new UserDTO(username, password, fullname, email, phone, "user.png", realRole, usDAO.loadActiveStatus(), pmsDAO.loadProStatusNonActive(), 0, dateOfCreate, null);
                isCreate = uDAO.adminCreateAccount(uDTO);
                if (isCreate) {
                    url = SUCCESS;
                    request.setAttribute("successMSG", "Create Account is successfully!");
                } else {
                    request.setAttribute("errorMSG", "Create Account is failed!");
                }
            }
        } catch (SQLException e) {
            log("CreateAccountController SQL " + e.getMessage());
            errorObj.setUserIDErr("Your username is still activate in this system!");
            request.setAttribute("InsertedErr", errorObj);
        } catch (ClassNotFoundException ex) {
            log("CreateNewServlet ClassNotFound " + ex.getMessage());
        } catch (Exception e) {
            log("Error at AdminCreateAccountController: " + e.getMessage());
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
