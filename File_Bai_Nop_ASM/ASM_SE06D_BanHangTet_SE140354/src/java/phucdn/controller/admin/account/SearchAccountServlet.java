/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.admin.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phucdn.dao.AccountDAO;
import phucdn.dtos.AccountDTO;

/**
 *
 * @author phucd
 */
@WebServlet(name = "SearchAccountServlet", urlPatterns = {"/SearchAccountServlet"})
public class SearchAccountServlet extends HttpServlet {
    private static final String ADMIN = "adminAccount.jsp";
    private static final String ERROR = "error.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String searchAcc = request.getParameter("txtAccount");
            AccountDAO accDAO = new AccountDAO();
            List<AccountDTO> result = null;
            if (searchAcc ==  null) {
                result = accDAO.findByLikeUsername(searchAcc);
                request.setAttribute("SearchAccINFO", result);
                url = ADMIN;
            }else{
                result = accDAO.findByLikeUsername(searchAcc);
                if (result != null) {
                    request.setAttribute("SearchAccINFO", result);
                    request.setAttribute("txtAccount", searchAcc);
                    url = ADMIN;
                }
            }
            
        } catch (Exception e) {
            log("Error at SearchAccountServlet: "+e.getMessage());
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
