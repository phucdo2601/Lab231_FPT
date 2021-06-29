/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.user.book;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phucdn.dao.CategoryDAO;
import phucdn.dao.ItemDAO;
import phucdn.dto.object.CategoryDTO;
import phucdn.dto.object.ItemDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "UserSearchByProductByItemNameController", urlPatterns = {"/UserSearchByProductByItemNameController"})
public class UserSearchByProductByItemNameController extends HttpServlet {

    private static final String SUCCESS = "home.jsp";
    private static final String ERROR = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = ERROR;
        String txtSearch = request.getParameter("txtSearch");
        String cateID = request.getParameter("cateID");
        try {
            //ham search 
            ItemDAO itDAO = new ItemDAO();
            List<ItemDTO> listFindLikeByName = itDAO.findItemsLikeByName(txtSearch);
            if (listFindLikeByName != null) {
                url = SUCCESS;
                request.setAttribute("listProduct", listFindLikeByName);
                request.setAttribute("txtValueSearch", txtSearch);
            }
            
            CategoryDAO cateDAO = new CategoryDAO();
            List<CategoryDTO> listCate = cateDAO.loadAllCates();
            if (listCate != null) {
                url = SUCCESS;
                request.setAttribute("listCategory", listCate);
                request.setAttribute("tag", cateID);
            }
            
            ItemDTO lastItem = itDAO.getLastProduct();
            if (lastItem != null) {
                url = SUCCESS;
                request.setAttribute("lastProduct", lastItem);
            }
        } catch (Exception e) {
            log("Error at UserSearchByProductByItemNameController: "+e.getMessage());
            e.printStackTrace();
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
