/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import phucdn.dao.CategoryDAO;
import phucdn.dao.ItemDAO;
import phucdn.dto.errorObj.ItemErrorObj;
import phucdn.dto.object.ItemDTO;
import phucdn.dto.object.UploadImage;

/**
 *
 * @author ASUS
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
@WebServlet(name = "AdminInsertItemController", urlPatterns = {"/AdminInsertItemController"})
public class AdminInsertItemController extends HttpServlet {

    private static final String ERROR = "AdminInsertItemPageController";
    private static final String SUCCESS = "AdminLoadItemPageController";
    private static final Logger LOGGER = Logger.getLogger(AdminInsertItemController.class);
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = ERROR;
        ItemDTO itDTO = new ItemDTO();
        ItemDAO itDAO = new ItemDAO();
        CategoryDAO cateDAO = new CategoryDAO();
        UploadImage uploadImg = new UploadImage();
        String itemID = request.getParameter("txtItemID");
        String itemName = request.getParameter("txtItemName");
        String cateString = request.getParameter("cboCate");
        String image = uploadImg.uploadFile(request);
        String author = request.getParameter("txtAuthor");
        String txtPrice = request.getParameter("txtPrice");
        String txtQuantity = request.getParameter("txtQuantity");
        double price = 0;
        int quantity = 0;
        boolean isInsert = false;
        long mills = System.currentTimeMillis();
        Timestamp dateOfCreate = new Timestamp(mills);
        ItemErrorObj error = new ItemErrorObj();
        boolean bErr = false;

        try {
            
            if (txtPrice != null) {
                price = Double.parseDouble(txtPrice);
                if (price <= 0) {
                    bErr = true;
                    error.setPriceErr("Price of Item is not valid!(The price is begin 0.1)");
                }
            }
            if (txtQuantity != null) {
                quantity = Integer.parseInt(txtQuantity);
                if (quantity <= 0) {
                    bErr = true;
                    error.setQuantityErr("The quantity of this item is not valid!(The number of quantity is greater than 0!)");
                }
            }
            if (!itemID.matches("^[B]{1}[S]{1}\\d{6}$")) {
                bErr = true;
                error.setItemIDErr("Item ID must begin with BS and have the digit code with 6 numbers.");
            }
            if (itemName.trim().length() > 50) {
                bErr = true;
                error.setItemNameErr("The length of book is not larger 50 characters!");
            }
            if (author.trim().length() >= 50) {
                bErr = true;
                error.setAuthorErr("The length of author is not larger 50 characters!");
            }
            if (bErr) {
                request.setAttribute("errorInsertItem", error);
            } else {
                String realCate = cateDAO.getCateIDByCateName(cateString);

                itDTO = new ItemDTO(itemID, itemName, author, realCate, quantity, image, price, dateOfCreate, "", "Active");
                isInsert = itDAO.createBook(itDTO);
                if (isInsert) {
                    url = SUCCESS;
                    request.setAttribute("successMsg", "Insert Book is done!");
                } else {
                    request.setAttribute("errorInsertItemMsg", "Insert Product is Failed!");
                }
            }
        }catch(SQLException e){
            log("Error at AdminInsertItemController: " + e.getMessage());
            error.setItemIDErr("The item id is existed in the system!");
            request.setAttribute("errorInsertItem", error);
            LOGGER.error(e);
        } catch (Exception e) {
            log("Error at AdminInsertItemController: " + e.getMessage());
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
