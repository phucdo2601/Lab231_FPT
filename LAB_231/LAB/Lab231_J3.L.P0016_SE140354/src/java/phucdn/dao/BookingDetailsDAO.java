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
import phucdn.dtos.object.BookingDetailsDTO;

/**
 *
 * @author ASUS
 */
public class BookingDetailsDAO implements Serializable {

    public Connection con;
    public PreparedStatement stm;
    public ResultSet rs;

    public void closeConnection() throws Exception {

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

    public boolean insertBookingDetails(BookingDetailsDTO dto) throws Exception {
        boolean result = false;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "insert into bookingDetail([bookingDetailsID], \n"
                        + "[bookingID], [itemID], [itemName], [quantity], \n"
                        + "[imgUrl], [dateBegin], [dateEnd])\n"
                        + "values (?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getBookingDetailsID());
                stm.setString(2, dto.getBookingID());
                stm.setString(3, dto.getItemID());
                stm.setString(4, dto.getItemName());
                stm.setInt(5, dto.getQuantity());
                stm.setString(6, dto.getImgUrl());
                stm.setDate(7, dto.getDateOfBegin());
                stm.setDate(8, dto.getDateOfEnd());
                result = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<BookingDetailsDTO> getBookDetailsByBookID(String id) throws Exception {
        List<BookingDetailsDTO> result = new ArrayList<>();
        String bookingID;
        String bookingDetailsID;
        String itemID;
        String itemName;
        int quantity;
        String imgUrl;
        Date dateOfBegin;
        Date dateOfEnd;
        BookingDetailsDTO dto = null;

        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select [bookingDetailsID],[bookingID],\n"
                        + "[itemID],[itemName],[quantity],\n"
                        + "[imgUrl],[dateBegin],[dateEnd]\n"
                        + "from [bookingDetail]\n"
                        + "where [bookingID] = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    bookingDetailsID = rs.getString("bookingDetailsID");
                    bookingID = rs.getString("bookingID");
                    itemID = rs.getString("itemID");
                    itemName = rs.getString("itemName");
                    quantity = rs.getInt("quantity");
                    imgUrl = rs.getString("imgUrl");
                    dateOfBegin = rs.getDate("dateBegin");
                    dateOfEnd = rs.getDate("dateEnd");
                    dto = new BookingDetailsDTO(bookingDetailsID, bookingID, itemID, itemName, quantity, imgUrl, dateOfBegin, dateOfEnd);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<BookingDetailsDTO> getBookingDetailsIDsByBookingID(String bookID)
            throws Exception {
        List<BookingDetailsDTO> result = new ArrayList<>();
        BookingDetailsDTO bookDeDTO = null;
        String bookingDetailsID = null;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select bookingDetailsID\n"
                        + "from bookingDetail\n"
                        + "where bookingID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, bookID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    bookingDetailsID = rs.getString("bookingDetailsID");
                    bookDeDTO = new BookingDetailsDTO(bookingDetailsID);
                    result.add(bookDeDTO);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

}
