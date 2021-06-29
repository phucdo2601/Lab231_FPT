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
import phucdn.dao.BookingStatusDAO;
import phucdn.dtos.object.BookingDTO;
import phucdn.dtos.object.BookingStatusDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "AdminViewOrderList", urlPatterns = {"/AdminViewOrderList"})
public class AdminViewOrderList extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(AdminViewOrderList.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        BookingDAO bDAO = new BookingDAO();
        BookingStatusDAO bookStaDAO = new BookingStatusDAO();
        String adminIndexPage = request.getParameter("index");

        try {
            if (adminIndexPage == null) {
                adminIndexPage = "1";
            }
            int index = Integer.parseInt(adminIndexPage);
            int count = bDAO.getNumberBookings();
            int endPage = count / 20;
            if (count % 20 != 0) {
                endPage++;
            }
            List<BookingDTO> listOrderConPageContent = bDAO.pagingBooking(index, 20);
            request.setAttribute("pageNumAdmin", endPage);
            request.setAttribute("AdminPageOrContent", listOrderConPageContent);

            //load BookingStatus
            List<BookingStatusDTO> listStatusBook = bookStaDAO.getAllBookingStatus();
            request.setAttribute("listBookStatus", listStatusBook);

            request.getRequestDispatcher("Manager.jsp").forward(request, response);
        } catch (Exception e) {
            log("Error at AdminViewOrderList: " + e.getMessage());
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
