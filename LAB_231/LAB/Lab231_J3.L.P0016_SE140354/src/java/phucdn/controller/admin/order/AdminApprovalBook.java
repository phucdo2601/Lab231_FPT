/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.admin.order;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import phucdn.dao.BookingDAO;
import phucdn.dao.BookingDetailsDAO;
import phucdn.dao.ItemDAO;
import phucdn.dtos.object.BookingDetailsDTO;
import phucdn.dtos.object.ItemDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "AdminApprovalBook", urlPatterns = {"/AdminApprovalBook"})
public class AdminApprovalBook extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(AdminApprovalBook.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        BookingDAO bDAO = new BookingDAO();
        BookingDetailsDAO bookDeDAO = new BookingDetailsDAO();
        String url = "";
        ItemDAO itDAO = new ItemDAO();
        boolean changeQuanItem = false;
        boolean approval = false;
        try {
            String txtBookingID = request.getParameter("txtBookingID");
            List<ItemDTO> listQuantitysByBookingID = itDAO.getQuantityItemsByBookingID(txtBookingID);
            for (ItemDTO quan : listQuantitysByBookingID) {
                if (quan.getQuantity() > 0) {
                    approval = bDAO.approvalBooking(txtBookingID);
                }else{
                    approval = false;
                }
            }
            if (approval) {
                List<BookingDetailsDTO> listBookingDe = bookDeDAO.getBookingDetailsIDsByBookingID(txtBookingID);
                for (BookingDetailsDTO bookDeDTO : listBookingDe) {
                    
                    changeQuanItem = itDAO.changeQuantityAfterApproval(bookDeDTO.getBookingDetailsID());
                }
                
                request.setAttribute("responseAdminMsg", "Approval Done!");
                request.getRequestDispatcher("AOrder?AAction=viewOrderRe").forward(request, response);
            }else{
                url = "AOrder?AAction=Reject";
                request.setAttribute("responseAdminMsg", "Reject done! Because of not having enough items for borrowing!!!");
                request.getRequestDispatcher(url).forward(request, response);
            }
        } catch (Exception e) {
            log("Error at AdminApprovalBook....");
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
