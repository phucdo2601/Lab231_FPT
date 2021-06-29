/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.admin.product;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phucdn.dao.ProductDAO;
import phucdn.dtos.ProductDTO;

/**
 *
 * @author phucd
 */
@WebServlet(name = "AdminReActivateProServlet", urlPatterns = {"/AdminReActivateProServlet"})
public class AdminReActivateProServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String txtReActPro = request.getParameter("txtProduct");
        String statusMess = request.getParameter("chkProStatus");
        PrintWriter out = response.getWriter();
        boolean status = true;
        if (statusMess != null) {
            status = true;
        }
        ProductDTO dto = new ProductDTO(statusMess, status);
        ProductDAO proDAO = new ProductDAO();
        try {
            boolean result = proDAO.reActivatePro(txtReActPro);
            if (result != false) {
                out.println("<tr id=\"ajaxReActPro\">\n"
                        + "                        <td><%= countProduct1%></td>\n"
                        + "                        <td>" + dto.getProductID() + "</td>\n"
                        + "                        <td><%= dto.getCategoryID()%></td>\n"
                        + "                        <td><%= dto.getProductName()%></td>\n"
                        + "                        <td><img src = <%= dto.getImage()%> alt=<%= dto.getProductName()%> style=\"height: 100px; width: 100px\"/></td>\n"
                        + "                        <td><%= dto.getDescription()%></td>\n"
                        + "                        <td><%= dto.getUnit()%></td>\n"
                        + "                        <td><%= dto.getPrice()%></td>\n"
                        + "                        <td><%= dto.getQuantity()%></td>\n"
                        + "                        <td><%= dto.getSale()%></td>\n"
                        + "                        <td>\n"
                        + "                            <input type=\"checkbox\" name=\"chkProStatus\" value=\"ADMIN\" \n"
                        + "                                   <%\n"
                        + "                                       if (" + dto.isStatus() + ") {\n"
                        + "                                   %>\n"
                        + "                                   checked=\"checked\"\n"
                        + "                                   <%\n"
                        + "                                       }\n"
                        + "                                   %>\n"
                        + "                                   />\n"
                        + "                        </td>\n"
                        + "                        <td>\n"
                        + "                            <a href=\"AdminMainController?AAction=DeleteProduct&id=<%= dto.getProductID()%>&txtProduct=<%= request.getParameter(\"txtProduct\")%>\">Delete</a> \n"
                        + "                        </td>\n"
                        + "                        <td>\n"
                        + "                            <form action=\"AdminMainController\" method=\"POST\">\n"
                        + "                                <input type=\"hidden\" name=\"txtProductID\" value=\"<%= dto.getProductID()%>\" />\n"
                        + "                                <input type=\"hidden\" name=\"txtProduct\" value=\"<%= request.getParameter(\"txtProduct\")%>\" />\n"
                        + "                                <input type=\"submit\" value=\"Edit Product\" name=\"AAction\" />\n"
                        + "                            </form>\n"
                        + "                        </td>\n"
                        + "                    </tr>");
            }
        } catch (Exception e) {
            log("Error at AdminReActivateProServlet: " + e.getMessage());
            e.printStackTrace();
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
