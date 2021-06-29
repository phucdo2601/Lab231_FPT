/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.Controller.admin.cartPromo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phucdn.dto.object.CartObj;
import phucdn.dto.object.UserDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "AdminAddPromoCartController", urlPatterns = {"/AdminAddPromoCartController"})
public class AdminAddPromoCartController extends HttpServlet {

    private static final String SUCCESS = "loadAllService";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String url = SUCCESS;
        String txtUsernameAdd = request.getParameter("txtUsernameAdd");
        String txtFullnameAdd = request.getParameter("txtFullnameAdd");
        String txtEmailAdd = request.getParameter("txtEmailAdd");
        String txtPhoneAdd = request.getParameter("txtPhoneAdd");
        String txtImgUrlAdd = request.getParameter("txtImgUrlAdd");

        try {
            CartObj cartPromo = (CartObj) session.getAttribute("Cart");
            String adminAdd = (String) session.getAttribute("txtUsername");
            UserDTO uDTO = new UserDTO(txtUsernameAdd, "", txtFullnameAdd,
                    txtEmailAdd, txtPhoneAdd, txtImgUrlAdd);
            if (cartPromo == null) {
                if (adminAdd != null) {
                    cartPromo = new CartObj(adminAdd);
                }
            }
            uDTO.setRankPromo(5);

            if (cartPromo.getCart().containsKey(txtUsernameAdd)) {
                request.setAttribute("errorMSG", "This Account is still in the promo cart!");
            } else {
                url = SUCCESS;
                cartPromo.addToCart(uDTO);
                session.setAttribute("Cart", cartPromo);
                request.setAttribute("successMSG", "Add Account into the Promo cart is done!");
            }
        } catch (Exception e) {
            log("Error at AdminAddPromoCartController: " + e.getMessage());
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
