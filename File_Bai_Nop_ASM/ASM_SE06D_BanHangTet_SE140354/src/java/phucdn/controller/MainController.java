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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author phucd
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginServlet";
    private static final String INSERT_ACC = "InsertAccServlet";
    private static final String CATEGORY = "UserCategoryAndProductController";
    private static final String SEARCH_PRODUCT_NAME = "UserSearchController";
    private static final String ADD_CART = "AddCartServlet";
    private static final String REMOVE_CART = "RemoveCartServlet";
    private static final String UPDATE_CART = "UpdateCartServlet";
    private static final String CHECK_OUT = "UserCheckOutServlet";
    private static final String USER_VIEW_HISTORY = "UserViewHistoryServlet";
    private static final String USER_CONFIRM_ORDERLIST = "UserConfirmListOrderServlet";
    private static final String USER_CANCEL_ORDER = "UserCancelOrderServlet";
    private static final String USER_CONFIRM_SPECIFIC_ORDER = "UserConfirmSpeOrderServlet";
    private static final String USER_VIEW_ORDER_DETAIL = "UserViewOrderDetailServlet";
    private static final String USER_VIEW_ORDER_CANCEL = "UserViewOrderCancelServlet";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String url = ERROR;
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = CATEGORY;
        try {
            String action = request.getParameter("action");
            if (action.equals("Login")) {
                url = LOGIN;
            }else if (action.equals("Create new Account")) {
                url = INSERT_ACC;
            }
            else if (action.equals("Search by Product Name")) {
                url = SEARCH_PRODUCT_NAME;
            }else if (action.equals("Add to Cart")) {
                url = ADD_CART;
            }else if (action.equals("Delete")) {
                url = REMOVE_CART;
            }else if (action.equals("Update")) {
                url = UPDATE_CART;
            }else if (action.equals("Check Out")) {
                url = CHECK_OUT;
            }else if (action.equals("UserViewHistory")) {
                url = USER_VIEW_HISTORY;
            }else if (action.equals("UserConfirmListOrder")) {
                url = USER_CONFIRM_ORDERLIST;
            }else if (action.equals("CancelOrder")) {
                url = USER_CANCEL_ORDER;
            }else if (action.equals("ConfirmOrder")) {
                url = USER_CONFIRM_SPECIFIC_ORDER;
            }else if (action.equals("ViewOrderDetail")) {
                url = USER_VIEW_ORDER_DETAIL;
            }else if (action.equals("ViewOrderCancel")) {
                url = USER_VIEW_ORDER_CANCEL;
            }else if (action.equals("UserChangePassword")) {
                url = ERROR;
                request.setAttribute("ERROR", "Your function is still developing!");
            }
            else{
                url = ERROR;
                request.setAttribute("ERROR", "Your Action is invalid!");
            }
        } catch (Exception e) {
            log("ERROR at MainController: "+e.getMessage());
//            e.printStackTrace();
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
