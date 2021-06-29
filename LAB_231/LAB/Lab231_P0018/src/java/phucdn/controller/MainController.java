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

/**
 *
 * @author ASUS
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private static final String LOAD_ALL_SERVICE = "LoadAllServiceController";
    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginController";
    private static final String LOGOUT = "LogoutController";
    private static final String SEARCH_BY_CATE = "SearchByCateIDController";
    private static final String SEARCH_BY_ITEM = "UserSearchByProductByItemNameController";
    private static final String ADD_CART = "AddCartController";
    private static final String INCREASE_QUAN_ON_CART = "IncreaseItemQuanAtCartController";
    private static final String DECREASE_QUAN_ON_CART = "DecreaseItemQuanAtCartController";
    private static final String DELETE_CART = "DeleteCartController";
    private static final String USER_ADD_DISCOUNT = "UserAddDiscountOnBillController";
    private static final String USER_VIEW_HISTORY = "UserViewHistoryController";
    private static final String SEARCH_PRICE_RANGE = "SearchPriceRangeController";
    private static final String VIEW_ORDER_DETAILS = "ViewOrderDetailsController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = LOAD_ALL_SERVICE;
        String action = request.getParameter("action");
        try {
            if (action.equals("Login")) {
                url = LOGIN;
            } else if (action.equals("Logout")) {
                url = LOGOUT;
            } else if (action.equals("searchByCateID")) {
                url = SEARCH_BY_CATE;
            } else if (action.equals("USearchByProductByItemName")) {
                url = SEARCH_BY_ITEM;
            } else if (action.equals("Add to Cart")) {
                url = ADD_CART;
            } else if (action.equals("increaseItemQuanAtCart")) {
                url = INCREASE_QUAN_ON_CART;
            } else if (action.equals("decreaseItemQuanAtCart")) {
                url = DECREASE_QUAN_ON_CART;
            } else if (action.equals("deleteCart")) {
                url = DELETE_CART;
            } else if (action.equals("UAddDiscountOnBill")) {
                url = USER_ADD_DISCOUNT;
            } else if (action.equals("UViewHistory")) {
                url = USER_VIEW_HISTORY;
            } else if (action.equals("searchPriceRange")) {
                url = SEARCH_PRICE_RANGE;
            } else if (action.equals("viewOrderDetails")){
                url = VIEW_ORDER_DETAILS;
            }
        } catch (Exception e) {
            log("ERROR at MainController: " + e.getMessage());
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
