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
@WebServlet(name = "AdminMainController", urlPatterns = {"/AdminMainController"})
public class AdminMainController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String SEARCH_CATE = "SearchCategoryServlet";
    private static final String SEARCH_ACC = "SearchAccountServlet";
    private static final String SEARCH_PRODUCT = "SearchProductServlet";
    private static final String DELETE_PRODUCT = "AdminDeleteProductServlet";
    private static final String EDIT_PRODUCT = "EditProductServlet";
    private static final String RESET_PRODUCT ="adminProduct.jsp";
    private static final String UPDATE_PRODUCT = "AdminUpdateProductServlet";
    private static final String DELETE_CATEGORY = "AdminDeleteCategorySevlet";
    private static final String EDIT_CATEGORY = "AdminEditCategoryServlet";
    private static final String RESET_CATEGORY = "adminCategory.jsp";
    private static final String EDIT_ACCOUNT = "AdminEditAccountServlet";
    private static final String UPDATE_CATEGORY = "AdminUpdateCategoryServlet";
    private static final String DELETE_ACCOUNT = "AdminDeleteAccountServlet";
    private static final String UPDATE_ACCOUNT = "AdminUpdateAccountServlet";
    private static final String RESET_ACCOUNT = "adminAccount.jsp";
    private static final String ADIMN_PAGE ="admin.jsp";
    private static final String INSERT_CATEGORY = "AdminInsertCategoryServlet";
    private static final String INSERT_PRODUCT = "AdminInsertProductServlet";
    private static final String SEARCH_ORDER = "AdminSearchOrderServlet";
    private static final String RESET_ORDER = "adminOrder.jsp";
    private static final String VIEW_PRODUCT_OUT_OF_CATE_ID = "AdminViewProOutOfCateIDServlet";
    private static final String ADD_PRO_ON_CART_ID = "AdminAddProOnCateIDServlet";
    private static final String ADMIN_VIEW_ORDER_DETAIL = "ViewOrderDetail";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("AAction");
            if (action.equals("SearchCate")) {
                url = SEARCH_CATE;
            }else if (action.equals("SearchAccount")) {
                url = SEARCH_ACC;
            }else if (action.equals("Search Product")) {
                url = SEARCH_PRODUCT;
            }else if (action.equals("DeleteProduct")) {
                url = DELETE_PRODUCT;
            }else if (action.equals("Edit Product")) {
                url = EDIT_PRODUCT;
            }else if (action.equals("Reset Product")) {
                url = RESET_PRODUCT;
            }else if (action.equals("UpdateProduct")) {
                url = UPDATE_PRODUCT;
            }else if (action.equals("DeleteCategory")) {
                url = DELETE_CATEGORY;
            }else if (action.equals("Edit Category")) {
                url = EDIT_CATEGORY;
            }else if (action.equals("Reset Category")) {
                url = RESET_CATEGORY;
            }else if (action.equals("Update Category")) {
                url = UPDATE_CATEGORY;
            }else if (action.equals("DeleteAccount")) {
                url = DELETE_ACCOUNT;
            }else if (action.equals("ResetAccount")) {
                url = RESET_ACCOUNT;
            }else if (action.equals("Edit Account")) {
                url = EDIT_ACCOUNT;
            } else if (action.equals("UpdateAccount")) {
                url = UPDATE_ACCOUNT;
            } else if (action.equals("Role Back")) {
                url = ADIMN_PAGE;
            }else if (action.equals("InsertCategory")) {
                url = INSERT_CATEGORY;
            }else if (action.equals("InsertProduct")) {
                url = INSERT_PRODUCT;
            }else if (action.equals("SearchOrder")) {
                url = SEARCH_ORDER;
            }else if (action.equals("ResetOrder")) {
                url = RESET_ORDER;
            }else if (action.equals("ViewProductOutOfCateID")) {
                url = VIEW_PRODUCT_OUT_OF_CATE_ID;
            }else if (action.equals("AddProductOnCateID")) {
                url = ADD_PRO_ON_CART_ID;
            }else if (action.equals("AdminViewOrderDetail")) {
                url = ADMIN_VIEW_ORDER_DETAIL;
            }
            else{
                request.setAttribute("ERROR", "Data input is not valid!");
            }
        } catch (Exception e) {
            log("Error at AdminMainController: "+e.getMessage());
            e.printStackTrace();
        }finally{
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
