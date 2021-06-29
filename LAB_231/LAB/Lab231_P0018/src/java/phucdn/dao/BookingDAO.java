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
import phucdn.db.DBUitls;
import phucdn.dto.object.BookingDTO;

/**
 *
 * @author ASUS
 */
public class BookingDAO implements Serializable {

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

    public boolean createBooking(BookingDTO dto)
            throws Exception {
        boolean result = false;

        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "insert into booking([bookingID], [userID],\n"
                        + "[fullname], [phone], [email], [address],\n"
                        + "[dateOfCreate], [discountID], [paymentMethod], \n"
                        + "[subTotal], [shipping], \n"
                        + "[tax], [total], [status]) values (?,?,?,?,?,?,?,?,?,?,?,\n"
                        + "?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getBookingID());
                stm.setString(2, dto.getUserID());
                stm.setString(3, dto.getFullname());
                stm.setString(4, dto.getPhone());
                stm.setString(5, dto.getEmail());
                stm.setString(6, dto.getAddress());
                stm.setDate(7, dto.getDateOfCreate());
                stm.setString(8, dto.getDiscountID());
                stm.setString(9, dto.getPaymentMethod());
                stm.setDouble(10, dto.getSubTotal());
                stm.setDouble(11, dto.getShipping());
                stm.setDouble(12, dto.getTax());
                stm.setDouble(13, dto.getTotal());
                stm.setString(14, dto.getStatus());
                result = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<BookingDTO> loadHistoryBookingByUserID(String id)
            throws Exception {
        List<BookingDTO> result = new ArrayList<>();
        BookingDTO dto = null;
        String bookingID;
        String userID;
        String fullname;
        String phone;
        String email;
        String address;
        Date dateOfCreate;
        String discountID;
        String paymentMethod;
        double subTotal;
        double shipping;
        double tax;
        double total;
        String status;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "select [bookingID], [userID],\n"
                        + "[fullname], [phone], [email], [address],\n"
                        + "[dateOfCreate], [discountID], [paymentMethod], \n"
                        + "[subTotal], [shipping], \n"
                        + "[tax], [total], [status]\n"
                        + "from booking\n"
                        + "where userID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    bookingID = rs.getString("bookingID");
                    userID = rs.getString("userID");
                    fullname = rs.getString("fullname");
                    phone = rs.getString("phone");
                    email = rs.getString("email");
                    address = rs.getString("address");
                    dateOfCreate = rs.getDate("dateOfCreate");
                    discountID = rs.getString("discountID");
                    paymentMethod = rs.getString("paymentMethod");
                    subTotal = rs.getDouble("subTotal");
                    shipping = rs.getDouble("shipping");
                    tax = rs.getDouble("tax");
                    total = rs.getDouble("total");
                    status = rs.getString("status");
                    dto = new BookingDTO(bookingID, userID, fullname, phone, email, address, dateOfCreate, discountID, paymentMethod, subTotal, shipping, tax, total, status);
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
