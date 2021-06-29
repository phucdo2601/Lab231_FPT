/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.admin.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
@WebServlet(name = "AdminInsertProductServlet", urlPatterns = {"/AdminInsertProductServlet"})
public class AdminInsertProductServlet extends HttpServlet {

    private static final String SUCCESS = "adminProduct.jsp";
    private static final String INVALID_PRO = "adminInsertProduct.jsp";
    private static final String ERROR = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = ERROR;
        String productID = request.getParameter("txtProductID");
        String categoryID = request.getParameter("txtCategoryID");
        String productName = request.getParameter("txtProductName");
        String image = request.getParameter("txtImage");
        String priceMess = request.getParameter("txtPrice");
        double price = 0;
        ProductErrorObject errorObj = new ProductErrorObject();
        boolean checkValid = true;
        String quantityMess = request.getParameter("txtQuantity");
        int quantity = 0;
        String saleMess = request.getParameter("txtSale");
        int sale = 0;
        String unit = request.getParameter("txtUnit");
        long millis = System.currentTimeMillis();
        Timestamp dateOfPost = new Timestamp(millis);
//        LocalDateTime dateP = java.time.LocalDateTime.now();
//        System.out.println(dateP);

        ProductDAO proDAO = new ProductDAO();

        try {
            if (productID.trim().length() == 0) {
                checkValid = false;
                errorObj.setProductIDError("Product ID is not blank!");
            }
            if (categoryID.trim().length() == 0) {
                checkValid = false;
                errorObj.setCategoryIDError("Category ID is not blank!");
            }
            if (image.trim().length() == 0) {
                checkValid = false;
                errorObj.setImageError("Image is not Blank!");
            }
            if (productName.trim().length() == 0) {
                checkValid = false;
                errorObj.setProductNameError("Product name is not Blank!");
            }
            if (unit.trim().length() == 0) {
                checkValid = false;
                errorObj.setUnitError("Unit is not Blank!");
            }
            if (quantityMess.trim().length() == 0) {
                checkValid = false;
                errorObj.setQuantityError("Quanity is not Balnk!");
            } else {
                quantity = Integer.parseInt(quantityMess);
            }
            if (priceMess.trim().length() == 0) {
                checkValid = false;
                errorObj.setPriceError("Price is not blank!");
            } else {
                price = Double.parseDouble(priceMess);
            }
            if (saleMess.trim().length() == 0) {
                checkValid = false;
                errorObj.setSaleError("Sale is not Blank!");
            } else {
                sale = Integer.parseInt(saleMess);
            }
            if (checkValid) {
                ProductDTO proDTO = new ProductDTO(productID, categoryID, productName, image, "", price, quantity, sale, unit, dateOfPost, true);
                boolean result = proDAO.insertProduct(proDTO);
                if (result) {
                    url = SUCCESS;
                } else {
                    url = ERROR;
                    request.setAttribute("ERROR", "Insert Category Failed!");
                }
            } else {
                url = INVALID_PRO;
                request.setAttribute("INVALID_PRO", errorObj);
            }
        } catch (SQLException e) {
            log("Error at AdminInsertProduct: " + e.getMessage());
            e.printStackTrace();
            if (e.getMessage().equals("duplicate")) {
                errorObj.setProductIDIsExisted("Product id is duplicated!");
                url = INVALID_PRO;
                request.setAttribute("INVALID_PRO", errorObj);
            }
        } catch (Exception e) {
            log("Error at AdminInsertProductServlet: " + e.getMessage());
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
