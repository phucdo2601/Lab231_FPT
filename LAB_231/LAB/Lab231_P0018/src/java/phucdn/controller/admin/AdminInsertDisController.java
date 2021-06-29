/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.admin;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import phucdn.dao.DiscountDAO;
import phucdn.dto.errorObj.DiscountErrorObj;
import phucdn.dto.object.DiscountDTO;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "AdminInsertDisController", urlPatterns = {"/AdminInsertDisController"})
public class AdminInsertDisController extends HttpServlet {

    private static final String ERROR = "adminInsert.jsp";
    private static final String SUCCESS = "AdminLoadDiscountPageController";
    private static final Logger LOGGER = Logger.getLogger(AdminInsertDisController.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = ERROR;
        DiscountDTO disDTO = new DiscountDTO();
        DiscountDAO disDAO = new DiscountDAO();
        String txtDiscountID = request.getParameter("txtDiscountID");
        String txtDiscountName = request.getParameter("txtDiscountName");
        String txtRateDis = request.getParameter("txtRateDis");
        int rateDis = 0;
        long mills = System.currentTimeMillis();
        Date dateOfCreate = new Date(mills);
        boolean isCreate = false;
        DiscountErrorObj error = new DiscountErrorObj();
        boolean bErr = false;
        try {
            if (txtRateDis != null) {
                rateDis = Integer.parseInt(txtRateDis);
                if (rateDis <= 0) {
                    bErr = true;
                    error.setRateDisErr("The rate of discount is not valid!(The rate of discount is begin 0.1)");
                }
            }
            if (txtDiscountID.matches("^[d]{1}[s]{1}[c]{1}\\d{6}$")) {
                bErr = true;
                error.setDiscountIDErr("Discount ID must begin with dsc and have the digit code with 6 numbers.");
            }
            if (bErr) {
                request.setAttribute("errorInsertDis", error);
            } else {
                disDTO = new DiscountDTO(txtDiscountID, txtDiscountName, rateDis, false, false, dateOfCreate, null);
                isCreate = disDAO.createDiscount(disDTO);
                if (isCreate) {
                    url = SUCCESS;
                    request.setAttribute("successMSG", "Admin Insert Discount is done!");
                } else {
                    request.setAttribute("errorInsertDiscountMsg", "Admin Insert Discount is failed!");
                }
            }
        }catch(SQLException e){
            log("Error at AdminInsertItemController: " + e.getMessage());
            error.setDiscountIDErr("The discount id is existed in the system!");
            request.setAttribute("errorInsertDis", error);
            LOGGER.error(e);
        } catch (Exception e) {
            log("Error at AdminInsertDisController: " + e.getMessage());
            e.printStackTrace();
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
