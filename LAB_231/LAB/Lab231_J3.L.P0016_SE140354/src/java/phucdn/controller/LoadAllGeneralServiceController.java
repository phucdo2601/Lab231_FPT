/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import phucdn.dao.CategoryDAO;
import phucdn.dao.ItemDAO;
import phucdn.dtos.object.CategoryDTO;
import phucdn.dtos.object.ItemDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "LoadAllGeneralServiceController", urlPatterns = {"/LoadAllGeneralServiceController"})
public class LoadAllGeneralServiceController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(LoadAllGeneralServiceController.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("txtUsername");
        String roleUser = (String) session.getAttribute("roleUser");
        CategoryDTO cateDTO = new CategoryDTO();
        ItemDAO itDAO = new ItemDAO();
        ItemDTO dto = new ItemDTO();
        CategoryDAO cateDAO = new CategoryDAO();
        try {
            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            int count = itDAO.getNumberItems();
            int endPage = count/20;
            if (count % 20 != 0) {
                endPage++;
            }
            List<ItemDTO> listPageContent = itDAO.pagingItem(index, 20);
            request.setAttribute("pageConItem", listPageContent);
            request.setAttribute("pageNum", endPage);
            
            List<CategoryDTO> cateList = new ArrayList<>();
            cateList = cateDAO.getAllCategory();
            request.setAttribute("cateList", cateList);
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        } catch (Exception e) {
            LOGGER.error(e);
            log("Error at LoadAllGeneralServiceController: " + e.getMessage());
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
