/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import phucdn.db.DBUitls;
import phucdn.dto.object.BookingDetailsDTO;

/**
 *
 * @author ASUS
 */
public class BookingDetailsDAO {

    public Connection con;
    public PreparedStatement stm;
    public ResultSet rs;

    public void closeConnection()
            throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public boolean createBookingDetails(BookingDetailsDTO dto)
            throws Exception {
        boolean result = false;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "insert into bookingDetails(bookingDeID, bookingID, "
                        + "itemID, itemName, imgUrl, quantity, price) values\n"
                        + "(?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getBookingDeID());
                stm.setString(2, dto.getBookingID());
                stm.setString(3, dto.getItemID());
                stm.setString(4, dto.getItemName());
                stm.setString(5, dto.getImgUrl());
                stm.setInt(6, dto.getQuantity());
                stm.setDouble(7, dto.getPrice());
                result = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<BookingDetailsDTO> loadListHisBookDeByBookID(String id)
            throws Exception {
        List<BookingDetailsDTO> result = new ArrayList<>();
        BookingDetailsDTO dto = null;
        String bookingDeID;
        String bookingID;
        String itemID;
        String itemName;
        String imgUrl;
        int quantity;
        double price;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "select bookingDeID, bookingID, itemID, itemName, "
                        + "imgUrl, quantity, price\n"
                        + "from bookingDetails\n"
                        + "where bookingID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    bookingDeID = rs.getString("bookingDeID");
                    bookingID = rs.getString("bookingID");
                    itemID = rs.getString("itemID");
                    itemName = rs.getString("itemName");
                    imgUrl = rs.getString("imgUrl");
                    quantity = rs.getInt("quantity");
                    price = rs.getDouble("price");
                    dto = new BookingDetailsDTO(bookingDeID, bookingID, itemID, itemName, imgUrl, quantity, price);
                    result.add(dto);
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }
}
