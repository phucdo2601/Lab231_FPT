/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import phucdn.db.DBUtils;
import phucdn.dtos.object.ItemDTO;

/**
 *
 * @author ASUS
 */
public class ItemDAO implements Serializable {

    public Connection con;
    public PreparedStatement stm;
    public ResultSet rs;

    public void closeConnection() throws Exception {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (true) {
                con.close();
            }
        } catch (Exception e) {
            System.out.println("Error at closeConnection: ");
            e.printStackTrace();
        }
    }

    public int getNumberItems() throws Exception {
        int result = 0;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select count(itemID)\n"
                        + "from item";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    result = rs.getInt(1);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ItemDTO> pagingItem(int index, int rows) throws Exception {
        List<ItemDTO> result = new ArrayList<>();
        String itemID;
        String itemName;
        String cateID;
        String colorID;
        int quantiy;
        String status;
        Date dateOfPost;
        String imgUrl;
        ItemDTO iDto = null;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select [itemID], [itemName],\n"
                        + "[colorID],[cateID],[quantity],[status],\n"
                        + "dateOfPost, imgUrl\n"
                        + "from item \n"
                        + "where quantity > 0\n"
                        + "order by itemID\n"
                        + "OFFSET ? rows fetch next ? rows only";
                stm = con.prepareStatement(sql);
                stm.setInt(1, (index - 1) * rows);
                stm.setInt(2, rows);
                rs = stm.executeQuery();
                while (rs.next()) {
                    itemID = rs.getString("itemID");
                    itemName = rs.getString("itemName");
                    colorID = rs.getString("colorID");
                    cateID = rs.getString("cateID");
                    quantiy = rs.getInt("quantity");
                    status = rs.getString("status");
                    dateOfPost = rs.getDate("dateOfPost");
                    imgUrl = rs.getString("imgUrl");
                    iDto = new ItemDTO(itemID, itemName, cateID, colorID, quantiy, status, dateOfPost, imgUrl);
                    result.add(iDto);
                }
            }
        } catch (Exception e) {
            System.out.println("Error at pagingItem in ItemDAO...");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ItemDTO> getItemsByCateID(String cateID) throws Exception {
        List<ItemDTO> result = new ArrayList<>();
        String itemID;
        String itemName;
        String colorID;
        int quantiy;
        String status;
        Date dateOfPost;
        ItemDTO iDto = null;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select itemID, itemName, cateID, colorID, quantity, dateOfPost, [status]\n"
                        + "from item\n"
                        + "where cateID = ? and quantity > 0";
                stm = con.prepareStatement(sql);
                stm.setString(1, cateID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    itemID = rs.getString("itemID");
                    itemName = rs.getString("itemName");
                    colorID = rs.getString("colorID");
                    cateID = rs.getString("cateID");
                    quantiy = rs.getInt("quantity");
                    status = rs.getString("status");
                    dateOfPost = rs.getDate("dateOfPost");
                    iDto = new ItemDTO(itemID, itemName, cateID, colorID, quantiy, status, dateOfPost);
                    result.add(iDto);
                    return result;
                }
            }
        }  finally {
            closeConnection();
        }
        return null;
    }

    public List<ItemDTO> getItemsByCateIDNameAndDate(String itemName, String cateIDFind, Date dateOfPost) throws Exception {
        List<ItemDTO> result = new ArrayList<>();
        String itemID = null;
        String cateID = null;
        String colorID = null;
        int quantiy = 0;
        String status = null;
        ItemDTO iDto = null;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select [itemID],[itemName],"
                        + "[colorID],[cateID],[quantity],"
                        + "[dateOfPost],[status]\n"
                        + "from item\n"
                        + "where itemName LIKE ? and  "
                        + "cateID = ? and CONVERT(date,dateOfPost) < CONVERT(date, ?) and quantity > 0 ";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + itemName + "%");
                stm.setString(2, cateIDFind);
                stm.setDate(3, dateOfPost);
                rs = stm.executeQuery();
                while (rs.next()) {
                    itemID = rs.getString("itemID");
                    itemName = rs.getString("itemName");
                    colorID = rs.getString("colorID");
                    cateID = rs.getString("cateID");
                    quantiy = rs.getInt("quantity");
                    status = rs.getString("status");
                    dateOfPost = rs.getDate("dateOfPost");
                    iDto = new ItemDTO(itemID, itemName, cateID, colorID, quantiy, status, dateOfPost);
                    result.add(iDto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public ItemDTO viewItemDetail(String itemID) throws Exception {
        ItemDTO result = new ItemDTO();
        String cateID;
        String itemName;
        String colorID;
        int quantiy;
        String status;
        Date dateOfPost;
        String imgURL;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select itemID, itemName, cateID, colorID, "
                        + "quantity, dateOfPost, [status], imgUrl\n"
                        + "from item\n"
                        + "where itemID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, itemID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    itemID = rs.getString("itemID");
                    itemName = rs.getString("itemName");
                    colorID = rs.getString("colorID");
                    cateID = rs.getString("cateID");
                    quantiy = rs.getInt("quantity");
                    status = rs.getString("status");
                    dateOfPost = rs.getDate("dateOfPost");
                    imgURL = rs.getString("imgUrl");
                    result = new ItemDTO(itemID, itemName, cateID, colorID, quantiy, status, dateOfPost, imgURL);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean changeQuanAfterBook(String id, int quanttiy) throws Exception {
        boolean result = false;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "update item\n"
                        + "set quantity = quantity - ?\n"
                        + "where itemID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, quanttiy);
                stm.setString(2, id);
                result = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean reUpdateQuantityItem(String bookingDeID) throws Exception {
        boolean result = false;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "update item \n"
                        + "set item.quantity = item.quantity + "
                        + "(select bookde.quantity from bookingDetail bookde where bookde.bookingDetailsID = ?)\n"
                        + "where itemID in (select bookde.itemID from bookingDetail bookde where bookde.bookingDetailsID = ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, bookingDeID);
                stm.setString(2, bookingDeID);
                result = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean changeQuantityAfterApproval(String bookingDeID)
            throws Exception {
        boolean result = false;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "update item \n"
                        + "set item.quantity = item.quantity - "
                        + "(select bookde.quantity from bookingDetail bookde where bookde.bookingDetailsID = ?)\n"
                        + "where itemID in (select bookde.itemID from bookingDetail bookde where bookde.bookingDetailsID = ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, bookingDeID);
                stm.setString(2, bookingDeID);
                result = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ItemDTO> getQuantityItemsByBookingID(String bookingID)
            throws Exception {
        List<ItemDTO> result = new ArrayList<>();
        ItemDTO itDTO = new ItemDTO();
        int quantity = 0;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select quantity\n"
                        + "from item\n"
                        + "where itemID in \n"
                        + "(select bookDe.itemID from bookingDetail \n"
                        + "bookDe where bookDe.bookingID = ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, bookingID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    quantity = rs.getInt("quantity");
                    itDTO = new ItemDTO("", "", "", "", quantity, "", null);
                    result.add(itDTO);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
