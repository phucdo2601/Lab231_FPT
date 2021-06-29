/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.user.order;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import phucdn.dao.BookingDAO;
import phucdn.dtos.object.BookingDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "UserViewHistoryController", urlPatterns = {"/UserViewHistory"})
public class UserViewHistoryController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(UserViewHistoryController.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        BookingDAO bookDAO = new BookingDAO();
        HttpSession session = request.getSession();
        String index = request.getParameter("index");
        if (index == null) {
            index = "1";
        }
        int indexPage = Integer.parseInt(index);
        String username = (String) session.getAttribute("txtUsername");
        try {
            int count = bookDAO.getNumberBookingByUserID(username);
            int endPage = count / 20;
            if (count % 20 != 0) {
                endPage++;
            }

            List<BookingDTO> pagingContentByUserID = bookDAO.pagingBookByUserID(indexPage, 20, username);
            request.setAttribute("pageConByUserID", pagingContentByUserID);
            request.setAttribute("pageNumUser", endPage);
            request.getRequestDispatcher("History.jsp").forward(request, response);
        } catch (Exception e) {
            log("Error at UserViewHistoryController..." + e.getMessage());
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
