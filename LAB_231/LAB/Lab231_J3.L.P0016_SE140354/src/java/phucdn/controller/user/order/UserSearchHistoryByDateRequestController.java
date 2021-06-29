/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.user.order;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "UserSearchHistoryByDateRequestController", urlPatterns = {"/UserSearchHistoryByDateRequest"})
public class UserSearchHistoryByDateRequestController extends HttpServlet {

    private static final Logger LOGGER = 
            Logger.getLogger(UserSearchHistoryByDateRequestController.class);
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String txtDateConfirm = request.getParameter("txtDateConfirm");
        BookingDAO bookDAO = new BookingDAO();
        String url = "";
        try {
            String txtUsername = (String) session.getAttribute("txtUsername");
            SimpleDateFormat spdf = new SimpleDateFormat("yyyy-MM-dd");
            Date transDateUtil = spdf.parse(txtDateConfirm);
            java.sql.Date sqlDateConfirm = new java.sql.Date(transDateUtil.getTime());
            List<BookingDTO> listBookFindByTimeConfirm = bookDAO.userFindBookingByDateConfirm(sqlDateConfirm, txtUsername);
            if (listBookFindByTimeConfirm != null) {
                url = "History.jsp";
                request.setAttribute("uListSearchByDateConfirm", listBookFindByTimeConfirm);
                request.getRequestDispatcher(url).forward(request, response);
            }
        } catch (Exception e) {
            log("Error at UserSearchHistoryByDateRequest: "+e.getMessage());
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
