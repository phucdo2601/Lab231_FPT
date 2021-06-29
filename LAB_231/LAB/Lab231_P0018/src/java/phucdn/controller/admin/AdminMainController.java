/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
@WebServlet(name = "AdminMainController", urlPatterns = {"/AdminMainController"})
public class AdminMainController extends HttpServlet {

    private final static String ERROR = "error.jsp";
    private final static String A_LOAD_ITEM = "AdminLoadItemPageController";
    private final static String A_LOAD_DISCOUNT = "AdminLoadDiscountPageController";
    private final static String A_INSERT_ITEM_PAGE = "AdminInsertItemPageController";
    private final static String A_INSERT_ITEM = "AdminInsertItemController";
    private final static String A_INSERT_DISCOUNT = "AdminInsertDisController";
    private final static String A_EDIT_ITEM = "AdminEditItemController";
    private final static String A_UPDATE_ITEM = "AdminUpdateItemController";
    private final static String A_DELETE_ITEM = "AdminDeleteItemController";
    private final static String A_RE_ACTIVATE_ITEM = "AdminReActivateItemController";
    private final static String A_REMOVE_USER_DISCOUNT = "AdminRemoveUserDiscountController";
    private final static String A_ADD_ACC_TO_DIS = "AdminAccToDisController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = ERROR;
        String action = request.getParameter("AAction");
       
        try {
            if (action.equals("ALoadItemPage")) {
                url = A_LOAD_ITEM;
            }else if (action.equals("ALoadDiscountPage")) {
                url = A_LOAD_DISCOUNT;
            }else if (action.equals("AInsertItemPage")) {
                url = A_INSERT_ITEM_PAGE;
            }else if (action.equals("AInsertItem")) {
                url = A_INSERT_ITEM;
            }else if (action.equals("AInsertDiscount")) {
                url = A_INSERT_DISCOUNT;
            }else if (action.equals("AEditItem")) {
                url = A_EDIT_ITEM;
            } else if (action.equals("AUpdateItem")) {
                url = A_UPDATE_ITEM;
            } else if (action.equals("ADeleteItem")) {
                url = A_DELETE_ITEM;
            } else if (action.equals("ARemoveUserDiscount")) {
                url = A_REMOVE_USER_DISCOUNT;
            } else if (action.equals("AReActivateItem")) {
                url = A_RE_ACTIVATE_ITEM;
            }  else if (action.equals("AAddAccToDis")) {
                url = A_ADD_ACC_TO_DIS;
            }
        } catch (Exception e) {
            log("Error at AdminMainController: "+e.getMessage());
            e.printStackTrace();
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
