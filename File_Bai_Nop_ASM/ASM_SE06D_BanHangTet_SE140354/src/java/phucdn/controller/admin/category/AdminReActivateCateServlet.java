/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.admin.category;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phucdn.dao.CategoryDAO;
import phucdn.dtos.CategoryDTO;

/**
 *
 * @author phucd
 */
@WebServlet(name = "AdminReActivateCateServlet", urlPatterns = {"/AdminReActivateCateServlet"})
public class AdminReActivateCateServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String txtReCate = request.getParameter("txtCategory");
        String statusMess = request.getParameter("chkCateStatus");
        boolean status = true;
        if (statusMess != null) {
            status = true;
        }
        CategoryDAO cateDAO = new CategoryDAO();
        CategoryDTO cateDTO = new CategoryDTO(txtReCate, status);
        try {
            boolean result = cateDAO.reActivateCate(txtReCate);
            if (result != false) {
                out.println("<tr id=\"ajaxReActCate\">\n" +
"            <td><%= countCate1%></td>\n" +
"            <td>"+cateDTO.getCategoryID()+"</td>\n" +
"            <td>"+cateDTO.getCategoryName()+"</td>\n" +
"            <td>"+cateDTO.getDescription()+"</td>\n" +
"            <td>\n" +
"                <input type=\"checkbox\" name=\"chkCateStatus\" value=\"ADMIN\" \n" +
"                       <%\n" +
"                           if ("+cateDTO.isStatus()+") {\n" +
"                       %>\n" +
"                       checked=\"checked\"\n" +
"                       <%\n" +
"                           }\n" +
"                       %>\n" +
"                       />\n" +
"            </td>\n" +
"            <td>\n" +
"                <a href=\"AdminMainController?AAction=DeleteCategory&id=" + cateDTO.getCategoryID() + "&txtCategory=<%= request.getParameter(\"txtCategory\")%>\">\n" +
"                    Delete</a> \n" +
"            </td>\n" +
"            <td>\n" +
"                <form action=\"AdminMainController\" method=\"POST\">\n" +
"                    <input type=\"hidden\" name=\"txtCategoryID\" value=\"<%= cateDto.getCategoryID()%>\" />\n" +
"                    <input type=\"hidden\" name=\"txtCategory\" value=\"<%= request.getParameter(\"txtCategory\")%>\" />\n" +
"                    <input type=\"submit\" value=\"Edit Category\" name=\"AAction\" />\n" +
"                </form>\n" +
"            </td>\n" +
"        </tr>");
            }
        } catch (Exception e) {
            log("Error at AdminReActivateCateServlet: "+e.getMessage());
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
