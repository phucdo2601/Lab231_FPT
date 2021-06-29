/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.user.category;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phucdn.dao.CategoryDAO;
import phucdn.dao.ProductDAO;
import phucdn.dtos.CategoryDTO;
import phucdn.dtos.ProductDTO;

/**
 *
 * @author phucd
 */
@WebServlet(name = "UserCategoryServlet", urlPatterns = {"/UserCategoryServlet"})
public class UserCategoryServlet extends HttpServlet {

    private static final String SUCCESS = "Home.jsp";
    private static final String ERROR = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String cateID = request.getParameter("cateID");
        String url = ERROR;
        try {
            //load all product by cateID
            ProductDAO proDAO = new ProductDAO();
            List<ProductDTO> listProByCateID = proDAO.getAllProductByCateID(cateID);
            if (listProByCateID != null) {
                url = SUCCESS;
                request.setAttribute("listProduct", listProByCateID);
            }

            //load category
            CategoryDAO cateDA0 = new CategoryDAO();
            List<CategoryDTO> listCategory = cateDA0.findCategoryByCateID("");
            if (listCategory != null) {
                url = SUCCESS;
                request.setAttribute("listCategory", listCategory);
                request.setAttribute("tag", cateID);
            }
            
            //load new Product 
            ProductDTO lastProduct = proDAO.getLastProduct();
            if (lastProduct != null) {
                url = SUCCESS;
                request.setAttribute("lastProduct", lastProduct);
            }
            
            List<ProductDTO> listThreeNewProductOnAdv = proDAO.getTop3NewProduct();
            if (listThreeNewProductOnAdv != null) {
               url = SUCCESS;
               request.setAttribute("listThreeNewProductOnAdv", listThreeNewProductOnAdv);
            }
        } catch (Exception e) {
            log("Error at UserCategoryServletL: " + e.getMessage());
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
