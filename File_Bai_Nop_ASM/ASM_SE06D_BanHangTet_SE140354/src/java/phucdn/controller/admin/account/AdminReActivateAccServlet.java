/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.admin.account;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AdminReActivateAccServlet", urlPatterns = {"/AdminReActivateAccServlet"})
public class AdminReActivateAccServlet extends HttpServlet {

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
        String txtReAct = request.getParameter("txtAccount");
        String statusMess = request.getParameter("chkStatus");
        boolean status = true;
        if (statusMess != null) {
            status = true;
        }
        PrintWriter out = response.getWriter();
        AccountDAO accDAO = new AccountDAO();
        AccountDTO dto = new AccountDTO(txtReAct, status);

        try {
            boolean result = accDAO.reActivateAcc(txtReAct);
            if (result != false) {
                out.println("<tr id=\"ajaxReActAcc\">\n"
                        + "            <td>\n"
                        + "                <%= countAcc1%>\n"
                        + "            </td>\n"
                        + "            <td>" + dto.getUsername()
                        + "            </td>\n"
                        + "            <td>\n"
                        + "                <%= dto.getFullname()%>\n"
                        + "\n"
                        + "            </td>\n"
                        + "            <td>\n"
                        + "                <%= dto.getAddress()%>\n"
                        + "\n"
                        + "            </td>\n"
                        + "            <td>\n"
                        + "                <%= dto.getPhone()%>\n"
                        + "\n"
                        + "            </td>\n"
                        + "            <td>\n"
                        + "                <%= dto.getEmail()%>\n"
                        + "\n"
                        + "            </td>\n"
                        + "            <td>\n"
                        + "                <input type=\"checkbox\" name=\"chkStatus\" value=\"ADMIN\" \n"
                        + "                       <%\n"
                        + "                           if (" + dto.isStatus() + ") {\n"
                        + "                       %>\n"
                        + "                       checked=\"checked\"\n"
                        + "                       <%\n"
                        + "                           }\n"
                        + "                       %>\n"
                        + "                       />\n"
                        + "            </td>\n"
                        + "            <td>\n"
                        + "                <a href=\"AdminMainController?AAction=DeleteAccount&id=<%= dto.getUsername()%>&txtAccount=<%= request.getParameter(\"txtAccount\")%>\">\n"
                        + "                    Delete</a> \n"
                        + "            </td>\n"
                        + "            <td>\n"
                        + "                <form action=\"AdminMainController\" method=\"POST\">\n"
                        + "                    <input type=\"hidden\" name=\"txtUsername\" value=\"<%= dto.getUsername()%>\" />\n"
                        + "                    <input type=\"hidden\" name=\"txtAccount\" value=\"<%= request.getParameter(\"txtAccount\")%>\" />\n"
                        + "                    <input type=\"submit\" value=\"Edit Account\" name=\"AAction\" />\n"
                        + "                </form>\n"
                        + "            </td>\n"
                        + "        </tr>");
            }
        } catch (Exception e) {
            log("Error at AdminReActivateAccServlet: " + e.getMessage());
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
