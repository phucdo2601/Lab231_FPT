/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.log4j.Logger;
import phucdn.dao.UserDAO;
import phucdn.dto.errorObj.UserErrorObj;
import phucdn.dto.object.EncryptWithSHA256;
import phucdn.dto.object.UploadImage;
import phucdn.dto.object.UserDTO;

/**
 *
 * @author ASUS
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)

@WebServlet(name = "UpdateInfoController", urlPatterns = {"/UpdateInfoController"})
public class UpdateInfoController extends HttpServlet {

    private static final String SUCCESS = "loadAllService";
    private static final Logger LOGGER = Logger.getLogger(UpdateInfoController.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = SUCCESS;
        UploadImage upImage = new UploadImage();
        UserDAO uDAO = new UserDAO();
        String txtUsername = request.getParameter("txtUsername");
        String txtFullname = request.getParameter("txtFullname");
        String txtEmail = request.getParameter("txtEmail");
        String txtMobile = request.getParameter("txtMobile");
        String txtOldPassword = request.getParameter("txtOldPassword");
        String txtNewPassword = request.getParameter("txtNewPassword");
        String txtConfirms = request.getParameter("txtConfirm");
        String imgUrl = request.getParameter("imgUrl");
        boolean isUpdate = false;
        UserErrorObj errorObj = new UserErrorObj();
        boolean bErr = false;
        try {
            UserDTO accLogin = uDAO.loadUserByUserID(txtUsername);
            String curPass = accLogin.getPassword();
            if (!EncryptWithSHA256.hassPassBySHA256(txtOldPassword).equals(accLogin.getPassword())) {
                bErr = true;
                errorObj.setPasswordErr("The old Password is not correct!");
            }
            if (txtNewPassword.trim().length() < 8) {
                bErr = true;
                errorObj.setNewPasswordErr("The length of password is minimize 8 characters!");
            }
            if (txtConfirms.trim().length() < 8) {
                bErr = true;
                errorObj.setConfirmPassErr("The length of confirm password is minimize 8 characters!");
            }
            if (!txtConfirms.trim().equals(txtNewPassword)) {
                bErr = true;
                errorObj.setConfirmPassErr("Your confirm password is not match with the new password!");
            }
            if (!txtEmail.matches("^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$")) {
                bErr = true;
                errorObj.setEmailErr("Your email is not corret form! The sutaible form of email is x@abc.xyz");
            }
            if (!txtMobile.matches("^\\d{10}$")) {
                bErr = true;
                errorObj.setPhoneErr("The phone number digit is to have 10 charcters!");
            }
            if (bErr) {
                request.setAttribute("UpdateAccErr", errorObj);
            } else {
                Part filePart = request.getPart("photo");
                if (upImage.getImageName(filePart).equals("")) {
                    imgUrl = request.getParameter("imgUrl");
                } else {
                    imgUrl = upImage.uploadFile(request);
                }

                UserDTO dto = new UserDTO(txtUsername, txtNewPassword, txtFullname, txtEmail, txtMobile, imgUrl);
                isUpdate = uDAO.updateAccount(dto);
                if (isUpdate) {
                    url = SUCCESS;
                    request.setAttribute("successMSG", "Update is done!");
                } else {
                    request.setAttribute("errorMSG", "Update is failed!");
                }
            }

        } catch (Exception e) {
            log("Error at UpdateInfoController: " + e.getMessage());
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
