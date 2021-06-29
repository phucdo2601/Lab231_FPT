/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.admin.category;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phucdn.dao.CategoryDAO;
import phucdn.dtos.CategoryDTO;
import phucdn.dtos.CategoryErrorObject;

/**
 *
 * @author phucd
 */
@WebServlet(name = "AdminInsertCategoryServlet", urlPatterns = {"/AdminInsertCategoryServlet"})
public class AdminInsertCategoryServlet extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String INVALID = "adminInsertCategory.jsp";
    private static final String SUCCESS = "adminCategory.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = ERROR;
        String categoryID = request.getParameter("txtCategoryID");
        String categoryName = request.getParameter("txtCategoryName");
        String desciption = request.getParameter("txtDescription");
        long mills = System.currentTimeMillis();
        Timestamp dateOfPost = new Timestamp(mills);
        CategoryErrorObject errorObj = new CategoryErrorObject();
        boolean checkValid = true;
        try {
            if (categoryID.trim().length() == 0) {
                checkValid = false;
                errorObj.setCategoryIDError("Category ID is not Blank!");
            }
            if (categoryName.trim().length() == 0) {
                checkValid = false;
                errorObj.setCategoryNameError("Category Name is not Blank!");
            }
            if (categoryID.trim().length() > 20) {
                checkValid = false;
                errorObj.setCategoryIDError("Category ID juset have from 1 to 20 elements!");
            }
            if (categoryName.trim().length() > 200) {
                checkValid = false;
                errorObj.setCategoryNameError("Category Name just has 1 to 200 elements!");
            }

            if (checkValid) {
                CategoryDTO cateDTO = new CategoryDTO(categoryID, categoryName, desciption, true, dateOfPost);
                CategoryDAO cateDAO = new CategoryDAO();
                boolean result = cateDAO.insertCate(cateDTO);
                if (result) {
                    url = SUCCESS;
                } else {
                    url = ERROR;
                    request.setAttribute("ERROR", "Insert Category Failed!");
                }
            } else {
                url = INVALID;
                request.setAttribute("INVALID", errorObj);
            }
        } catch (Exception e) {
            log("Error at AdminInsertCategoryServlet: " + e.getMessage());
            e.printStackTrace();
            if (e.getMessage().contains("duplicate")) {
                CategoryErrorObject errObj = new CategoryErrorObject();
                errObj.setCategoryIDisExsited("Category ID is exsited!");
                url = INVALID;
                request.setAttribute("INVALID", errObj);
            }
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
