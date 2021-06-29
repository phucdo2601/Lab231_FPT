package phucdn.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import phucdn.dao.RoleDAO;
import phucdn.dtos.object.RoleDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private static final String ERROR = "login.jsp";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String SIGN_UP = "CreateAccountController";
    private static final String VERIFY_CONFIRM = "VerifyConfirmAccountController";
    private static final String LOGOUT_CONTROLLER = "LogoutController";
    private static final String ALL_SEARCH_ITEMS = "UserSearchGeneralItemsController";
    private static final String SEND_RE_ACTIVATE_CODE = "SendReActivateCodeController";
    private static final Logger LOGGER = Logger.getLogger(MainController.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = ERROR;
        String action = request.getParameter("action");
        try {
            if (action.equals("Login")) {
                url = LOGIN_CONTROLLER;
            } else if (action.equals("Create new Account")) {
                url = SIGN_UP;
            } else if (action.equals("Confirm new Account")) {
                url = VERIFY_CONFIRM;
            } else if (action.equals("changeSignUp")) {
                url = "createAcc.jsp";
                RoleDAO rDAO = new RoleDAO();
                List<RoleDTO> listRole = rDAO.getAllRole();
                request.setAttribute("listRoleUser", listRole);
            } else if (action.equals("Logout")) {
                url = LOGOUT_CONTROLLER;
            } else if (action.equals("SearchItem")) {
                url = ALL_SEARCH_ITEMS;
            } else if (action.equals("SendReActAcc")) {
                url = SEND_RE_ACTIVATE_CODE;
            }  else {
                request.setAttribute("errorMessage", "Your action in not valid!!!");
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.getMessage());
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
