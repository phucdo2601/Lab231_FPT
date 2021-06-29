/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.controller.admin;

import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import phucdn.dao.CategoryDAO;
import phucdn.dao.ItemDAO;
import phucdn.dto.object.ItemDTO;
import phucdn.dto.object.UploadImage;

/**
 *
 * @author ASUS
 */

@WebServlet(name = "AdminUpdateItemController", urlPatterns = {"/AdminUpdateItemController"})
public class AdminUpdateItemController extends HttpServlet {

    private static final String ERROR = "AdminEditItemController";
    private static final String SUCCESS = "AdminLoadItemPageController";

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
        String author = request.getParameter("txtAuthor");
        String txtPrice = request.getParameter("txtPrice");
        String txtQuantity = request.getParameter("txtQuantity");
        String imgUrl = request.getParameter("imgUrl");
        double price = 0;
        int quantity = 0;
        boolean isUpdate = false;
        long mills = System.currentTimeMillis();
        Timestamp dateOfCreate = new Timestamp(mills);
        String realCate = null;
        try {
            if (txtQuantity != null) {
                quantity = Integer.parseInt(txtQuantity);
            }
            if (txtPrice != null) {
                price = Double.parseDouble(txtPrice);
            }
            realCate = cateDAO.getCateIDByCateName(cateString);
            Part filePart = request.getPart("photo");
            if (uploadImg.getImageName(filePart).equals("")) {
                imgUrl = request.getParameter("imgUrl");
                
            } else {
                imgUrl = uploadImg.uploadFile(request);
            }
            
            
            itDTO = new ItemDTO(itemID, itemName, author, realCate, quantity, imgUrl, price, dateOfCreate, null, "Active");
            
            isUpdate = itDAO.updateItem(itDTO);
            if (isUpdate) {
                url = SUCCESS;
                request.setAttribute("successMsg", "Updadte item is done!");
            }else{
                 request.setAttribute("errUpdateItem", "Updadte item is done!");
            }
        } catch (Exception e) {
            log("Error at AdminUpdateItemController: "+e.getMessage());
            e.printStackTrace();
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
