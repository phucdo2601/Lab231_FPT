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
import phucdn.dao.ProductDAO;
import phucdn.dtos.ProductDTO;

/**
 *
 * @author phucd
 */
@WebServlet(name = "UserSearchByAjaxServlet", urlPatterns = {"/UserSearchByAjaxServlet"})
public class UserSearchByAjaxServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String txtSearch = request.getParameter("txtSearch");
        ProductDAO proDAO = new ProductDAO();
        PrintWriter out = response.getWriter();
        try {
            List<ProductDTO> listFindLikeByName = proDAO.findProductLikeByName(txtSearch);
            if (listFindLikeByName != null) {
                request.setAttribute("listProduct", listFindLikeByName);
                request.setAttribute("txtValueSearch", txtSearch);
                for (ProductDTO p : listFindLikeByName) {
                    out.println("<div class=\"productByAjax col-12 col-md-6 col-lg-4\">\n"
                            + "                        <div class=\"product-image-wrapper\">\n"
                            + "                            <div class=\"single-products\">\n"
                            + "                                <div class=\"productinfo text-center\">\n"
                            + "                                    <img src=\"" + p.getImage() + "\" style=\"width: 200px; height: 200px\" alt=\"\" />\n"
                            + "                                    <h2>" + p.getPrice() + " VND</h2>\n"
                            + "                                    <p><a href=\"DetailServlet?productID=" + p.getProductID() + "\">" + p.getProductName() + "</a></p>\n"
                            + "                                    <a href=\"#\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>Add to cart</a>\n"
                            + "                                </div>\n"
                            + "                                <div class=\"product-overlay\">\n"
                            + "                                    <div class=\"overlay-content\">\n"
                            + "                                        <h2>" + p.getPrice() + " VND</h2>\n"
                            + "                                        <p><a href=\"DetailServlet?productID=" + p.getProductID() + "\">" + p.getProductName() + "</a></p>\n"
                            + "                                        <a href=\"#\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>Add to cart</a>\n"
                            + "                                    </div>\n"
                            + "                                </div>\n"
                            + "                            </div>\n"
                            + "                            <div class=\"choose\">\n"
                            + "                                <ul class=\"nav nav-pills nav-justified\">\n"
                            + "                                    <li><a href=\"#\"><i class=\"fa fa-plus-square\"></i>Add to wishlist</a></li>\n"
                            + "                                    <li><a href=\"DetailServlet?productID=" + p.getProductID() + "\"><i class=\"fa fa-plus-square\"></i>View More</a></li>\n"
                            + "                                </ul>\n"
                            + "                            </div>\n"
                            + "                        </div>\n"
                            + "                    </div>");
                }
            }
        } catch (Exception e) {
            log("Error at UserSearchByAjaxServlet: " + e.getMessage());
            e.printStackTrace();
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
