/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.user.order;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import phucdn.dao.BookingDAO;
import phucdn.dao.BookingDetailsDAO;
import phucdn.dao.ItemDAO;
import phucdn.dtos.object.BookingDTO;
import phucdn.dtos.object.BookingDetailsDTO;
import phucdn.dtos.object.CartObj;
import phucdn.dtos.object.ItemDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "UserBookingController", urlPatterns = {"/UserBookingController"})
public class UserBookingController extends HttpServlet {

    private static final Logger LOGGER
            = Logger.getLogger(UserBookingController.class);
    private static final String ERROR = "cartBorrow.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        CartObj cart = (CartObj) session.getAttribute("Cart");
        HashMap<String, ItemDTO> click = cart.getCart();
        String urlReWriting = null;
        try {
            String txtItemID = request.getParameter("txtItemID");
            String txtItemName = request.getParameter("txtItemName");
            String txtQuantity = request.getParameter("txtQuantity");
            int quantity = Integer.parseInt(txtQuantity);
            if (quantity <= 0) {
                request.setAttribute("wrongQuantity", "Quantity is bigger than 0!!!");
                urlReWriting = ERROR;
                request.getRequestDispatcher(ERROR).forward(request, response);
            }
            String txtImg = request.getParameter("txtImg");
            String txtDateBegin = request.getParameter("txtDateBegin");
            String txtDateReturn = request.getParameter("txtDateReturn");
            String userID = (String) session.getAttribute("txtUsername");
            long mills = System.currentTimeMillis();
            Timestamp dateCur = new Timestamp(mills);
            String orderID = "OB" + dateCur.getTime();
            SimpleDateFormat spdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateBeginChangeForm = spdf.parse(txtDateBegin);
            java.util.Date dateReturnChangeForm = spdf.parse(txtDateReturn);
            Date dateBegin = new Date(dateBeginChangeForm.getTime());
            Date dateReturn = new Date(dateReturnChangeForm.getTime());
            BookingDTO bDTO = new BookingDTO(userID, orderID, dateCur);
            BookingDAO bDAO = new BookingDAO();
            ItemDAO itDAO = new ItemDAO();
            BookingDetailsDAO bdDA0 = new BookingDetailsDAO();
            boolean addBooking = bDAO.insertBooking(bDTO);
            int count = (int) dateCur.getTime();
            if (addBooking) {
                for (Map.Entry<String, ItemDTO> entry : click.entrySet()) {
                    count++;
                    String key = entry.getKey();
                    ItemDTO value = entry.getValue();
                    String itemID = entry.getValue().getItemID();
                    String itemName = entry.getValue().getItemName();
                    String imgURL = entry.getValue().getImgUrl();
                    int quantityBook = entry.getValue().getQuantity();
                    String bookingDeID = "STK" + itemID + count;
                   
                    BookingDetailsDTO bdDto = new BookingDetailsDTO(bookingDeID, orderID, itemID, itemName, quantityBook, imgURL, dateBegin, dateReturn);
                    boolean addBookingDE = bdDA0.insertBookingDetails(bdDto);
//                    boolean changeQuanAfterBook = itDAO.changeQuanAfterBook(key, quantity);
                }
                session.setAttribute("txtUsername", userID);
                session.removeAttribute("Cart");
                urlReWriting = "LoadAllGeneralServiceController";
                request.getRequestDispatcher(urlReWriting).forward(request, response);
            }
        } catch (Exception e) {
            log("Error at UserBookingController: " + e.getMessage());
            LOGGER.error(e);
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
