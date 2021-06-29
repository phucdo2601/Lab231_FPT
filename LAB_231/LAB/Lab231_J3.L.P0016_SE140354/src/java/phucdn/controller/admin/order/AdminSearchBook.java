/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.admin.order;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import phucdn.dao.BookingDAO;
import phucdn.dao.BookingStatusDAO;
import phucdn.dtos.object.BookingDTO;
import phucdn.dtos.object.BookingStatusDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "AdminSearchBook", urlPatterns = {"/AdminSearchBook"})
public class AdminSearchBook extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(AdminSearchBook.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String txtBookingIDSearch = request.getParameter("txtBookingIDSearch");
        String txtDateBeginSearch = request.getParameter("txtDateBeginSearch");
        String txtDateEndSearch = request.getParameter("txtDateEndSearch");
        String txtItemName = request.getParameter("txtItemName");
        String status = request.getParameter("cboStatusRole");
        BookingDAO bookDAO = new BookingDAO();
        BookingStatusDAO bookStaDAO = new BookingStatusDAO();
        String url = "";
        try {
            SimpleDateFormat spdf = new SimpleDateFormat("yyyy-MM-dd");

            Date formDateBegin = spdf.parse(txtDateBeginSearch);
            Date formDateEnd = spdf.parse(txtDateEndSearch);
            java.sql.Date sqlDateBegin = new java.sql.Date(formDateBegin.getTime());
            java.sql.Date sqlDateEnd = new java.sql.Date(formDateEnd.getTime());
            List<BookingDTO> listAdminSearch = bookDAO.adminFindBooking(sqlDateBegin, sqlDateEnd, txtItemName, status, txtBookingIDSearch);
            List<BookingStatusDTO> listStatusBook = bookStaDAO.getAllBookingStatus();
            if (listAdminSearch != null) {
                url = "Manager.jsp";
                request.setAttribute("adminListSearch", listAdminSearch);
                request.setAttribute("listBookStatus", listStatusBook);
            } else {
                url = "Manager.jsp";
                request.setAttribute("errorMessage", "Your Search is not data. Please search agian!");
                request.setAttribute("listBookStatus", listStatusBook);
            }

        } catch (Exception e) {
            log("Error at AdminSearchBook..." + e.getMessage());
            LOGGER.error(e);
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
