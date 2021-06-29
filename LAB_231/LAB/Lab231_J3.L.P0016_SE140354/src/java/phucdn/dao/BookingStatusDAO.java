/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import phucdn.db.DBUtils;
import phucdn.dtos.object.BookingStatusDTO;

/**
 *
 * @author ASUS
 */
public class BookingStatusDAO implements Serializable {

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

    public List<BookingStatusDTO> getAllBookingStatus() throws Exception {
        List<BookingStatusDTO> result = new ArrayList<>();
        BookingStatusDTO dto = null;
        String bookingStatusID = null;
        String bookingStatusName = null;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select [bookingStatusID], [bookingStatusName]\n"
                        + "from [dbo].[bookingStatus]";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    bookingStatusID = rs.getString("bookingStatusID");
                    bookingStatusName = rs.getString("bookingStatusName");
                    dto = new BookingStatusDTO(bookingStatusID, bookingStatusName);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

}
