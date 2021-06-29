package phucdn.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import phucdn.dao.CategoryDAO;
import phucdn.dao.ItemDAO;
import phucdn.dtos.object.CategoryDTO;
import phucdn.dtos.object.ItemDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(urlPatterns = {"/UserViewBorrowDetailPageController"})
public class UserViewBorrowDetailPageController extends HttpServlet {

    private static final String ERROR = "itemList.jsp" ;
    private static final String SUCCESS = "borrowItemDetail.jsp";
    private static final Logger LOGGER = 
            Logger.getLogger(UserViewBorrowDetailPageController.class);
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        String index = request.getParameter("index");
        ItemDAO itDAO = new ItemDAO();
        CategoryDAO cateDAO = new CategoryDAO();
        ItemDTO result = null;
        try {
            result = itDAO.viewItemDetail(index);
            if (result != null) {
                url = SUCCESS;
                request.setAttribute("itDe", result);
                List<CategoryDTO> cateList = new ArrayList<>();
            cateList = cateDAO.getAllCategory();
            request.setAttribute("cateList", cateList);
            }else{
                request.setAttribute("errorMessage", "Your action is not valid!");
            }
        } catch (Exception e) {
            log("Error at UserViewBorrowDetailPage: "+e.getMessage());
            LOGGER.error(e);
        }
        finally{
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
