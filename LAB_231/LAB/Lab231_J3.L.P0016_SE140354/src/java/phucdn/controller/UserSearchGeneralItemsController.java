/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import phucdn.dao.CategoryDAO;
import phucdn.dao.ItemDAO;
import phucdn.dtos.object.ItemDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "UserSearchGeneralItemsController", urlPatterns = {"/UserSearchGeneralItemsController"})
public class UserSearchGeneralItemsController extends HttpServlet {

    private static final String ERROR = "search.jsp";
    private static final String SEARCH_3_CONS = "itemListSearch.jsp";
    private static final Logger LOGGER = Logger.getLogger(UserSearchGeneralItemsController.class);
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = ERROR;
        String itemName = request.getParameter("txtItemName");
        String cateName = request.getParameter("cboRole");
        ItemDAO itDAO = new ItemDAO();
        CategoryDAO cateDAO = new CategoryDAO();

        try {

            String datePickString = request.getParameter("txtDateSearch");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf1.parse(datePickString);
            java.sql.Date datePick = new java.sql.Date(date.getTime());
            String cateid = cateDAO.getCategoryIDByCateName(cateName);
           
            ArrayList<ItemDTO> listSearch = (ArrayList<ItemDTO>) itDAO.getItemsByCateIDNameAndDate(itemName, cateid, datePick);
            if (listSearch != null) {
                url = SEARCH_3_CONS;
                request.setAttribute("userItemSearch", listSearch);
                request.setAttribute("findDone", "Da Tim Dc");

            } else {
                request.setAttribute("errorMessage", "You action is not valid! Please input again!!");
            }
        } catch (Exception e) {
            log("Error at UserSearchGeneralItemsController..." + e.getMessage());
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
