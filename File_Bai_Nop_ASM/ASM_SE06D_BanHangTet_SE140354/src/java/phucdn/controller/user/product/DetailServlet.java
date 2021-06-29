/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.user.product;

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
@WebServlet(name = "DetailServlet", urlPatterns = {"/DetailServlet"})
public class DetailServlet extends HttpServlet {

    private static final String SUCCESS = "detail.jsp";
    private static final String ERROR = "error.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("productID");
        String cateID = request.getParameter("cateID");
        String cID = request.getParameter("cID");
        String url = ERROR;
        try {
            //load product detail
            ProductDAO proDAO = new ProductDAO();
            ProductDTO proDTO = proDAO.findProductByPrimaryKey(id);
            if (proDTO != null) {
                    url = SUCCESS;
                    request.setAttribute("detail", proDTO);
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
            
            //load recommemItems
            List<ProductDTO> listRecommenItems = proDAO.getRecommenItems(cID);
            if (listRecommenItems != null) {
                url = SUCCESS;
                request.setAttribute("listRecommend", listRecommenItems);
            }
        } catch (Exception e) {
            log("Error at DetailServlet: "+e.getMessage());
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
