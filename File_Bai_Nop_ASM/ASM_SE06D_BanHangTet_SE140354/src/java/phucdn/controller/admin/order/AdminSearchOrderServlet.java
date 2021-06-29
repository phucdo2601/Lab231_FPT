/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.admin.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phucdn.dao.OrderDAO;
import phucdn.dtos.OrderDTO;

/**
 *
 * @author phucd
 */
@WebServlet(name = "AdminSearchOrderServlet", urlPatterns = {"/AdminSearchOrderServlet"})
public class AdminSearchOrderServlet extends HttpServlet {

    private static final String SUCCESS = "adminOrder.jsp";
    private static final String ERROR = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        String txtAdminSearchOrder = request.getParameter("txtAdminSearchOrder");
        OrderDAO orderDAO = new OrderDAO();

        try {
            List<OrderDTO> listSeach = null;
            if (txtAdminSearchOrder == null) {
                listSeach = orderDAO.findOrderLikeByOrderId(txtAdminSearchOrder);
                request.setAttribute("SearchOrderInfo", listSeach);
                url = SUCCESS;
            } else {
                listSeach = orderDAO.findOrderLikeByOrderId(txtAdminSearchOrder);
                if (listSeach != null) {
                    request.setAttribute("SearchOrderInfo", listSeach);
                    request.setAttribute("txtAdminSearchOrder", txtAdminSearchOrder);
                    url = SUCCESS;
                }else{
                    url = ERROR;
                    request.setAttribute("ERROR", "Your action is not valid!");
                }

            }
        } catch (Exception e) {
            log("Error at AdminSearchOrderServlet: " + e.getMessage());
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
