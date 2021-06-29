/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.admin.category;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AdminUpdateCategoryServlet", urlPatterns = {"/AdminUpdateCategoryServlet"})
public class AdminUpdateCategoryServlet extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "SearchCategoryServlet";
    private static final String INVALID = "adminUpdateCategory.jsp";

//    chua hoan tat
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = ERROR;
        try {
            String categoryID = request.getParameter("txtCategoryID");
            String categoryName = request.getParameter("txtCategoryName");
            String description = request.getParameter("txtDescription");
            String test = request.getParameter("ckBuying");
            boolean status = false;
            if (test!= null) {
                status = true;
            }
            CategoryDTO cateDto = new CategoryDTO(categoryID, categoryName, description, status);
            CategoryErrorObject errorObj = new CategoryErrorObject();
            boolean valid = true;
            
            String lastSearch = request.getParameter("txtCateLastSearchValue");
            
            if (categoryID.length() == 0) {
                valid = false;
                errorObj.setCategoryIDError("Category id can not be blank!");
            }
            
            if (categoryName.length() == 0) {
                valid = false;
                errorObj.setCategoryNameError("Category name can not be blank!");
            }
            
            if (description.length() == 0) {
                valid = false;
                errorObj.setCategoryDescriptionError("Descrption can not be blank!");
            }
            
            if (valid) {
                CategoryDAO cateDAO = new CategoryDAO();
                if (cateDAO.updateCategory(cateDto)) {
                    url = "AdminMainController?AAction=SearchCate&txtCategory="
                            +lastSearch;
                }else{
                    request.setAttribute("ERROR", "Update Failed!");
                }
            }else{
                url = INVALID;
                request.setAttribute("INVALID", errorObj);
                request.setAttribute("cateDto", cateDto);
            }
            
        } catch (Exception e) {
            log("ERROR at AdminUpdateCategoryServlet: "+e.getMessage());
            e.printStackTrace();
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
