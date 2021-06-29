/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.admin.product;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phucdn.dao.ProductDAO;
import phucdn.dtos.ProductDTO;
import phucdn.dtos.ProductErrorObject;

/**
 *
 * @author phucd
 */
@WebServlet(name = "AdminUpdateProductServlet", urlPatterns = {"/AdminUpdateProductServlet"})
public class AdminUpdateProductServlet extends HttpServlet {

    private static final String ERROR ="error.jsp";
    private static final String SUCCESS = "SearchProductServlet";
    private static final String INVALID = "adminUpdateProduct.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = ERROR;
        try {
            String productID = request.getParameter("txtProductID");
            String categoryID = request.getParameter("txtCategoryID");
            String productName = request.getParameter("txtProductName");
            String description = request.getParameter("txtDescription");
            double price = Double.parseDouble(request.getParameter("txtPrice"));
            int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
            int sale = Integer.parseInt(request.getParameter("txtSale"));
            String unit = request.getParameter("txtUnit");
            ProductDTO dto = new ProductDTO(productID, categoryID, productName, description, quantity, price, sale, unit);
            ProductErrorObject errorObj = new ProductErrorObject();
            boolean valid = true;
            
            if (categoryID.length() == 0) {
                valid = false;
                errorObj.setCategoryIDError("Category id can not be blank!");
            }
            if (productName.length() == 0) {
                valid = false;
                errorObj.setProductNameError("Product name can not be blank!");
            }
            if (description.length() == 0) {
                valid = false;
                errorObj.setDescrptionError("Descrption can not be blank!");
            }
            if (price < 0) {
                valid = false;
                errorObj.setPriceError("Price is not valid");
            }
            if (quantity < 0) {
                valid = false;
                errorObj.setQuantityError("Quantity is not valid!");
            }
            if (sale < 0) {
                valid = false;
                errorObj.setSaleError("Sale is not valid!");
            }
            
            if (valid) {
                ProductDAO proDAO = new ProductDAO();
                if (proDAO.updateProduct(dto)) {
                    url = SUCCESS;
                }else{
                    request.setAttribute("ERROR", "Update Failed!");
                }
            }else{
                url = INVALID;
                request.setAttribute("INVALID", errorObj);
                request.setAttribute("DTO", dto);
            }
        } catch (Exception e) {
            log("ERROR at AdminUpdateProductServlet: "+e.getMessage());
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
