/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller;

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
@WebServlet(name = "LoadMoreServelet", urlPatterns = {"/LoadMoreServelet"})
public class LoadMoreServelet extends HttpServlet {

    
    
    //su dung ajax de khi minh thao tac co thay doi chi so duy lieu gi, thi khong phai load lai trang
    //Sevlet xu ly viec load them 3 san phgam bang ajax 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //tam thoi load ra 3 san pham truoc da

        PrintWriter out = response.getWriter();
        String amount = request.getParameter("exits");
        int iAmount = Integer.parseInt(amount);
        try {
            ProductDAO proDAO = new ProductDAO();
            //cau lenh nay lay 3 san pham tiep theo dua tren so luong san san phan da hien thi
            List<ProductDTO> listThreeProduct = proDAO.getNextTenProduct(iAmount);
            if (listThreeProduct != null) {
                for (ProductDTO p : listThreeProduct) {
                    out.println("<div class=\"productByAjax col-12 col-md-6 col-lg-4\">\n" +
"                        <div class=\"product-image-wrapper\">\n" +
"                            <div class=\"single-products\">\n" +
"                                <div class=\"productinfo text-center\">\n" +
"                                    <img src=\""+p.getImage()+"\" style=\"width: 200px; height: 200px\" alt=\"\" />\n" +
"                                    <h2>"+p.getPrice()+" VND</h2>\n" +
"                                    <p><a href=\"DetailServlet?productID="+p.getProductID()+"\">"+p.getProductName()+"</a></p>\n" +
"                                    <form action=\"MainController\" method=\"POST\" class=\"productinfo text-center\">\n" +
"                                                <input type=\"hidden\" name=\"txtProductID\" value=\""+p.getProductID()+"\" />\n" +
"                                                <input type=\"hidden\" name=\"txtProductName\" value=\""+p.getProductName()+"\" />\n" +
"                                                <input type=\"hidden\" name=\"txtImage\" value=\""+p.getImage()+"\" />\n" +
"                                                <input type=\"hidden\" name=\"txtPrice\" value=\""+p.getPrice()+"\" />\n" +
"                                                <input type=\"hidden\" name=\"txtUsernameLogin\" value=\"${sessionScope.USERNAME}\" />\n" +
"                                                <button class=\"btn btn-default add-to-cart\" name=\"action\" value=\"Add to Cart\">Add to cart</button>\n" +
"                                            </form>" +
"                                </div>\n" +
"                                <div class=\"product-overlay\">\n" +
"                                    <div class=\"overlay-content\">\n" +
"                                        <h2>"+p.getPrice()+" VND</h2>\n" +
"                                        <p><a href=\"DetailServlet?productID="+p.getProductID()+"\">"+p.getProductName()+"</a></p>\n" +
"                                        <form action=\"MainController\" method=\"POST\" class=\"productinfo text-center\">\n" +
"                                                <input type=\"hidden\" name=\"txtProductID\" value=\""+p.getProductID()+"\" />\n" +
"                                                <input type=\"hidden\" name=\"txtProductName\" value=\""+p.getProductName()+"\" />\n" +
"                                                <input type=\"hidden\" name=\"txtImage\" value=\""+p.getImage()+"\" />\n" +
"                                                <input type=\"hidden\" name=\"txtPrice\" value=\""+p.getPrice()+"\" />\n" +
"                                                <input type=\"hidden\" name=\"txtUsernameLogin\" value=\"${sessionScope.USERNAME}\" />\n" +
"                                                <button class=\"btn btn-default add-to-cart\" name=\"action\" value=\"Add to Cart\">Add to cart</button>\n" +
"                                            </form>" +
"                                    </div>\n" +
"                                </div>\n" +
"                            </div>\n" +
"                            <div class=\"choose\">\n" +
"                                <ul class=\"nav nav-pills nav-justified\">\n" +
"                                    <li><a href=\"#\"><i class=\"fa fa-plus-square\"></i>Add to wishlist</a></li>\n" +
"                                    <li><a href=\"DetailServlet?productID="+p.getProductID()+"\"><i class=\"fa fa-plus-square\"></i>View More</a></li>\n" +
"                                </ul>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>");
                }
            }
        } catch (Exception e) {
            log("Error at LoadMoreServelet: " + e.getMessage());
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
