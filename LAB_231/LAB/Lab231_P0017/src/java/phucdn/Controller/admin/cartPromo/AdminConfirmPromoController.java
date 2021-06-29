/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.Controller.admin.cartPromo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phucdn.dao.UserDAO;
import phucdn.dto.object.CartObj;
import phucdn.dto.object.UserDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "AdminConfirmPromoController", urlPatterns = {"/AdminConfirmPromoController"})
public class AdminConfirmPromoController extends HttpServlet {

    private static final String ERROR = "cartPromo.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        CartObj cart = (CartObj) session.getAttribute("Cart");
        HashMap<String, UserDTO> click = cart.getCart();
        boolean isAddPromoList = false;
        UserDAO uDAO = new UserDAO();
        try {
            String txtUserID = request.getParameter("txtUserID");
            String txtRankPrmo = request.getParameter("txtRankPro");
            for (Map.Entry<String, UserDTO> entry : click.entrySet()) {
                String key = entry.getKey();
                UserDTO value = entry.getValue();
                String txtUser = entry.getValue().getUserID();
                int rank = entry.getValue().getRankPromo();
                isAddPromoList = uDAO.addAccToPromoList(txtUser, rank);
            }
            session.removeAttribute("Cart");
            request.getRequestDispatcher("loadAllService").forward(request, response);
        } catch (Exception e) {
            log("Error at AdminConfirmPromoController: "+e.getMessage());
            
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
