/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.user.checkout;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phucdn.dao.OrderDAO;
import phucdn.dao.OrderDetailDAO;
import phucdn.dao.ProductDAO;
import phucdn.dtos.CartObj;
import phucdn.dtos.OrderDTO;
import phucdn.dtos.OrderDetailDTO;
import phucdn.dtos.ProductDTO;

/**
 *
 * @author phucd
 */
@WebServlet(name = "UserCheckOutServlet", urlPatterns = {"/UserCheckOutServlet"})
public class UserCheckOutServlet extends HttpServlet {

    private static final String SUCCESS = "userAction.jsp";
    private static final String ERROR = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            CartObj cart = (CartObj) session.getAttribute("cart");
            HashMap<String, ProductDTO> clik = cart.getCart();

            String usernameLogin = (String) session.getAttribute("USERNAME");
            String username = request.getParameter("txtUsername");
            String address = request.getParameter("txtAddressShipping");
            String phone = request.getParameter("txtPhone");
            double total = Double.parseDouble(request.getParameter("txtTotal"));
            String reciever = request.getParameter("txtCustomerName");
            long mills = System.currentTimeMillis();
            Timestamp datePost = new Timestamp(mills);
            String orderID = "" + datePost.getTime();
            String chkCard = request.getParameter("chkCard");
            String chlCash = request.getParameter("chkCash");
            String paying = "cash";
            if (chkCard != null) {
                paying = "card";
            }
            if (chlCash != null) {
                paying = "cash";
            }
            OrderDTO orderDTO = new OrderDTO(orderID, username, reciever, address, phone, total, datePost, paying, true, false);
//            OrderDTO orderDTO = new OrderDTO(orderID, username, reciever, address, phone, total, datePost, paying, true, false);
            OrderDAO orderDAO = new OrderDAO();
            OrderDetailDAO orderDeDAO = new OrderDetailDAO();
            ProductDAO proDAO = new ProductDAO();
            boolean changeQuantity = false;
            boolean addOrder = orderDAO.addOrder(orderDTO);
            Timestamp dateCur = new Timestamp(mills);
            String dateStringCur = ""+dateCur.getTime();
            int count = (int) dateCur.getTime();
            if (addOrder) {
                for (Map.Entry<String, ProductDTO> entry : clik.entrySet()) {                   
                    count++;
                    String key = entry.getKey();
                    ProductDTO value = entry.getValue();
                    System.out.println(key);
                    System.out.println(entry.getValue().getProductName());
                    System.out.println(entry.getValue().getProductID());
                    System.out.println(entry.getValue().getPrice());
                    System.out.println(entry.getValue().getQuantity());
                    System.out.println(dateStringCur);
                    System.out.println(count);
                    String productID = entry.getValue().getProductID();
                    String productName = entry.getValue().getProductName();
                    double price = entry.getValue().getPrice();
                    int quantity = entry.getValue().getQuantity();
                    String orderDetailID = "STK"+key+count;
                    System.out.println("OrderDetailID: "+orderDetailID);
                    OrderDetailDTO orderDe = new OrderDetailDTO(orderDetailID, orderID, productID, productName, quantity, price);
                    changeQuantity = proDAO.updateQuantityProduct(key, entry.getValue().getQuantity());
                    addOrder = orderDeDAO.addOrderDetail(orderDe);
                    
                }
                session.setAttribute("USERNAME", usernameLogin);
                session.removeAttribute("cart");
                url = SUCCESS;
            }
//            for (Map.Entry<String, ProductDTO> entry : clik.entrySet()) {
////                System.out.println(entry.getKey());
////                System.out.println(entry.getValue().getProductID());
////                String productID 
//                String productID = entry.getKey();
//                String productName = entry.getValue().getProductName();
//                int quantity = entry.getValue().getQuantity();
//
//            }

        } catch (Exception e) {
            log("Error at UserCheckOutServlet: " + e.getMessage());
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
