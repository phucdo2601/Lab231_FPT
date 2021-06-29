/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.admin.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "AdminOrderController", urlPatterns = {"/AOrder"})
public class AdminOrderController extends HttpServlet {

    private static final String ADIMN_VIEW_CONFIRM_LIST_ORDER = "AdminViewOrderList";
    private static final String ADMIN_VIEW_BOOK_DETAILS = "AdminViewBookDetails";
    private static final String ADMIN_APPROVAL_BOOK = "AdminApprovalBook";
    private static final String ADMIN_REJECT_BOOK = "AdminRejectBook";
    private static final String ADIMN_SEARCH_BOOK = "AdminSearchBook";
    private static final Logger LOGGER = Logger.getLogger(AdminOrderController.class);
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = "";
        try {
            String AAction = request.getParameter("AAction");
            if (AAction.equals("viewOrderRe")) {
                url = ADIMN_VIEW_CONFIRM_LIST_ORDER;
            } else if (AAction.equals("viewDetail")) {
                url = ADMIN_VIEW_BOOK_DETAILS;
            } else if (AAction.equals("Approval")) {
                url = ADMIN_APPROVAL_BOOK;
            } else if (AAction.equals("Reject")) {
                url = ADMIN_REJECT_BOOK;
            } else if (AAction.equals("AdminSearch")) {
                url = ADIMN_SEARCH_BOOK;
            }
        } catch (Exception e) {
            log("Error at AdminOrderController: " + e.getMessage());
            e.printStackTrace();
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
