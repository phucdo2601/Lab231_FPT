/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.user.order;

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
@WebServlet(name = "Order", urlPatterns = {"/Order"})
public class OrderController extends HttpServlet {

    private static final String USER_BOOKING = "UserBookingController";
    private static final String USER_VIEW_HISTORY_ORDER = "UserViewHistory";
    private static final String USER_DELETE_HISTORY_ORDER = "UserDeleteHistory";
    private static final String USER_VIEW_BOOK_DETAILS = "UserViewBookDetails";
    private static final String USER_RETURN_ITEM = "UserReturnItems";
    private static final String USER_SEARCH_ORDER_HIS_BY_ITEM_NAME
            = "UserSearchHistoryByItemName";
    private static final String USER_SEARCH_ORDER_HIS_BY_DATE_REQ
            = "UserSearchHistoryByDateRequest";
    private static final Logger LOGGER = Logger.getLogger(OrderController.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "";
        String action = request.getParameter("OAction");
        try {
            if (action.equals("Booking")) {
                url = USER_BOOKING;
            } else if (action.equals("viewHistory")) {
                url = USER_VIEW_HISTORY_ORDER;
            } else if (action.equals("Delete")) {
                url = USER_DELETE_HISTORY_ORDER;
            } else if (action.equals("ViewDetails")) {
                url = USER_VIEW_BOOK_DETAILS;
            } else if (action.equals("USearchBookByName")) {
                url = USER_SEARCH_ORDER_HIS_BY_ITEM_NAME;
            } else if (action.equals("USearchBookByDate")) {
                url = USER_SEARCH_ORDER_HIS_BY_DATE_REQ;
            } else if (action.equals("Return")) {
                url = USER_RETURN_ITEM;
            }
        } catch (Exception e) {
            log("Error at OrderController: " + e.getMessage());
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
