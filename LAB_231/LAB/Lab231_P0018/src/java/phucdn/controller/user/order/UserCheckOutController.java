/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.user.order;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phucdn.dao.BookingDAO;
import phucdn.dao.BookingDetailsDAO;
import phucdn.dao.DiscountDAO;
import phucdn.dao.ItemDAO;
import phucdn.dto.object.BookingDTO;
import phucdn.dto.object.BookingDetailsDTO;
import phucdn.dto.object.CartObj;
import phucdn.dto.object.ItemDTO;
import phucdn.dto.object.PaymentDTO;
import phucdn.dto.object.PaymentServices;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "UserCheckOutController", urlPatterns = {"/UserCheckOutController"})
public class UserCheckOutController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS_NORMAL = "LoadAllServiceController";
    private static final String SUCCESS_PAY_PAL = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        CartObj cart = (CartObj) session.getAttribute("Cart");
        BookingDTO bookDTO = new BookingDTO();
        BookingDAO bookDAO = new BookingDAO();
        DiscountDAO disDAO = new DiscountDAO();
        BookingDetailsDTO bookDeDTO = new BookingDetailsDTO();
        BookingDetailsDAO bookDeDAO = new BookingDetailsDAO();
        ItemDAO itDAO = new ItemDAO();
        boolean isCreateBooking = false;
        boolean changeQuanAfterCheckingOut = false;
        String url = ERROR;
        HashMap<String, ItemDTO> clik = cart.getCart();
        String userID = request.getParameter("txtUsername");
        String customerName = request.getParameter("txtCustomerName");
        String adddress = request.getParameter("txtAddressShipping");
        String phone = request.getParameter("txtPhone");
        String email = request.getParameter("txtEmail");
        String discountID = request.getParameter("txtDiscountID");
        String txtSubTotal = request.getParameter("txtSubTotal");
        String txtShipping = request.getParameter("txtShipping");
        String txtTax = request.getParameter("txtTax");
        String txtTotal = request.getParameter("txtTotal");
        double subTotal = Double.parseDouble(txtSubTotal);
        double shipping = Double.parseDouble(txtShipping);
        double tax = Double.parseDouble(txtTax);
        double total = Double.parseDouble(txtTotal);
        String payMethod = request.getParameter("payMethod");
        long mills = System.currentTimeMillis();
        Date dateOfCreate = new Date(mills);
        String bookingID = "B" + dateOfCreate.getTime();
        int count = (int) dateOfCreate.getTime();
       
        try {
            for (Map.Entry<String, ItemDTO> entry : clik.entrySet()) {
                String key = entry.getKey();
                
                ItemDTO value = entry.getValue();
                String idItem = entry.getValue().getItemID();
                int quanItem = entry.getValue().getQuantity();           
                int getQuanOfItem = itDAO.getQuantityOfItemID(key);
                if (getQuanOfItem < 0) {
                    request.setAttribute("errorMessage", "The book shopping cart is cancel  because of not having enough the quantity of books at the Inventory!");
                }
            }

            if (payMethod.equals("rdPaypal")) {
                bookDTO = new BookingDTO(bookingID, userID, customerName, phone,
                        email, adddress, dateOfCreate, discountID, payMethod,
                        subTotal, shipping, tax, total, "Waiting");
                isCreateBooking = bookDAO.createBooking(bookDTO);
                if (isCreateBooking) {
                    if (discountID != null) {
                        boolean isUpdateUsingDis = disDAO.updateUsingDiscount(discountID);
                    }
                    boolean isCreateBookingDe = false;
                    for (Map.Entry<String, ItemDTO> entry : clik.entrySet()) {
                        count++;
                        String key = entry.getKey();
                        ItemDTO value = entry.getValue();
                        String itemName = entry.getValue().getItemName();
                        String imgUrl = entry.getValue().getImgUrl();
                        int quantity = entry.getValue().getQuantity();
                        String bookingDetailsID = "STK" + key + count;
                        double price = entry.getValue().getPrice();
                        bookDeDTO = new BookingDetailsDTO(bookingDetailsID, bookingID, key, itemName, imgUrl, quantity, price);
                        isCreateBookingDe = bookDeDAO.createBookingDetails(bookDeDTO);
                        if (isCreateBookingDe) {
                            changeQuanAfterCheckingOut = itDAO.changeQuanItemAfterCheckOut(key, quantity);                        
                        }

                    }
                    session.removeAttribute("Cart");
                    PaymentDTO ordDetails = new PaymentDTO(bookingID, txtSubTotal, txtShipping, txtTax, txtTotal);
                    PaymentServices payServices = new PaymentServices();
                    String approvalLink = payServices.authorizePayment(ordDetails);
                    url = approvalLink;
                    response.sendRedirect(url);
                }
            } else if (payMethod.equals("rdCash")) {

                boolean isCreateBookingDe = false;
                bookDTO = new BookingDTO(bookingID, userID, customerName, phone,
                        email, adddress, dateOfCreate, discountID, payMethod,
                        subTotal, shipping, tax, total, "Finish");
                isCreateBooking = bookDAO.createBooking(bookDTO);
                if (isCreateBooking) {
                    if (discountID != null) {
                        boolean isUpdateUsingDis = disDAO.updateUsingDiscount(discountID);
                    }
                    for (Map.Entry<String, ItemDTO> entry : clik.entrySet()) {
                        count++;
                        String key = entry.getKey();
                        ItemDTO value = entry.getValue();
                        String itemName = entry.getValue().getItemName();
                        String imgUrl = entry.getValue().getImgUrl();
                        int quantity = entry.getValue().getQuantity();
                        String bookingDetailsID = "STK" + key + count;
                        double price = entry.getValue().getPrice();
                        bookDeDTO = new BookingDetailsDTO(bookingDetailsID, bookingID, key, itemName, imgUrl, quantity, price);
                        isCreateBookingDe = bookDeDAO.createBookingDetails(bookDeDTO);
                        if (isCreateBookingDe) {
                            changeQuanAfterCheckingOut = itDAO.changeQuanItemAfterCheckOut(key, quantity);
                        }

                    }
                    url = SUCCESS_NORMAL;
                    
                    session.removeAttribute("Cart");
                    request.setAttribute("successMessage", "Checking out the book order is done!");
                    request.getRequestDispatcher(url).forward(request, response);
                } else {
                    url = ERROR;
                    request.setAttribute("errorMessage", "Your Checking Out Normal is not valid!");
                    request.getRequestDispatcher(url).forward(request, response);
                }
            } else {
                url = ERROR;
                request.setAttribute("errorMessage", "Your Action is not valid!");
                request.getRequestDispatcher(url).forward(request, response);

            }
        } catch (Exception e) {
            log("Error at UserCheckOutController: " + e.getMessage());
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
