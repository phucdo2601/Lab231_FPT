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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import phucdn.db.DBUtils;
import phucdn.dtos.object.BookingDTO;

/**
 *
 * @author ASUS
 */
public class BookingDAO implements Serializable {

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

    public boolean insertBooking(BookingDTO dto) throws Exception {
        boolean result = false;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "insert into booking\n"
                        + "(userID, bookingID, timOfCreate, "
                        + "timeOfConfirm, [status])\n"
                        + "values(?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getUserId());
                stm.setString(2, dto.getBookingID());
                stm.setTimestamp(3, dto.getDateOfBook());
                stm.setTimestamp(4, dto.getDateOfConfirm());
                stm.setString(5, "New");
                result = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean approvalBooking(String bookingID) throws Exception {
        boolean result = false;
        long mills = System.currentTimeMillis();
        Timestamp dateOfConfirm = new Timestamp(mills);
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "update booking\n"
                        + "set [status] = 'Accept',\n"
                        + "[timeOfConfirm] = ?\n"
                        + "where bookingID = ?";
                stm = con.prepareStatement(sql);
                stm.setTimestamp(1, dateOfConfirm);
                stm.setString(2, bookingID);
                result = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean adminDeleteBooking(String bookingID) throws Exception {
        boolean result = false;
        long mills = System.currentTimeMillis();
        Timestamp dateOfConfirm = new Timestamp(mills);
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "update booking\n"
                        + "set [status] = 'Delete',\n"
                        + "[timeOfConfirm] = ?\n"
                        + "where bookingID = ?";
                stm = con.prepareStatement(sql);
                stm.setTimestamp(1, dateOfConfirm);
                stm.setString(2, bookingID);
                result = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean userDeleteBooking(String bookingID) throws Exception {
        boolean result = false;
        long mills = System.currentTimeMillis();
        Timestamp dateOfConfirm = new Timestamp(mills);
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "update booking\n"
                        + "set [status] = 'inActive',\n"
                        + "[timeOfConfirm] = ?\n"
                        + "where bookingID = ?";
                stm = con.prepareStatement(sql);
                stm.setTimestamp(1, dateOfConfirm);
                stm.setString(2, bookingID);
                result = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean userReturnItems(String bookingID) throws Exception {
        boolean result = false;
        long mills = System.currentTimeMillis();
        Timestamp dateOfConfirm = new Timestamp(mills);
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "update booking\n"
                        + "set [status] = 'Returned',\n"
                        + "[timeOfConfirm] = ?\n"
                        + "where bookingID = ?";
                stm = con.prepareStatement(sql);
                stm.setTimestamp(1, dateOfConfirm);
                stm.setString(2, bookingID);
                result = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public int getNumberBookings() throws Exception {
        int result = 0;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select count(bookingID)\n"
                        + "from booking";
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

    public int getNumberBookingByUserID(String id) throws Exception {
        int result = 0;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select count(bookingID)\n"
                        + "from booking\n"
                        + "where userID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
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

    public List<BookingDTO> pagingBooking(int index, int rows) throws Exception {
        List<BookingDTO> result = new ArrayList<>();
        String bookingID = null;
        String userID = null;
        Timestamp dateOfCreate;
        Timestamp dateOfConfirm;
        String status;
        BookingDTO dto = null;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select bookingID, userID,\n"
                        + "[timOfCreate], [timeOfConfirm],\n"
                        + "[status]\n"
                        + "from booking\n"
                        + "order by bookingID\n"
                        + "OFFSET ? rows fetch next ? rows only";
                stm = con.prepareStatement(sql);
                stm.setInt(1, (index - 1) * rows);
                stm.setInt(2, rows);
                rs = stm.executeQuery();
                while (rs.next()) {
                    bookingID = rs.getString("bookingID");
                    userID = rs.getString("userID");
                    dateOfCreate = rs.getTimestamp("timOfCreate");
                    dateOfConfirm = rs.getTimestamp("timeOfConfirm");
                    status = rs.getString("status");
                    dto = new BookingDTO(userID, bookingID, dateOfCreate, dateOfConfirm, status);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<BookingDTO> pagingBookByUserID(int index, int rows,
            String userID) throws Exception {
        List<BookingDTO> result = new ArrayList<>();
        String bookingID = null;
        Timestamp dateOfCreate;
        Timestamp dateOfConfirm;
        String status;
        BookingDTO dto = null;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select bookingID, userID,\n"
                        + "[timOfCreate], [timeOfConfirm],\n"
                        + "[status]\n"
                        + "from booking\n"
                        + "where [userID] = ?\n"
                        + "order by bookingID\n"
                        + "OFFSET ? rows fetch next ? rows only";
                stm = con.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setInt(2, (index - 1) * rows);
                stm.setInt(3, rows);
                rs = stm.executeQuery();
                while (rs.next()) {
                    bookingID = rs.getString("bookingID");
                    userID = rs.getString("userID");
                    dateOfCreate = rs.getTimestamp("timOfCreate");
                    dateOfConfirm = rs.getTimestamp("timeOfConfirm");
                    status = rs.getString("status");
                    dto = new BookingDTO(userID, bookingID, dateOfCreate, dateOfConfirm, status);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<BookingDTO> adminFindBooking(Date dateBegin, Date dateEnd, String itemName, String status, String bookingIDFind) throws Exception {
        List<BookingDTO> result = new ArrayList<>();
        BookingDTO dto = null;
        String bookingID;
        Timestamp dateOfCreate;
        Timestamp dateOfConfirm;
        String userID;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select book.bookingID, book.userID, book.[status], book.timOfCreate, book.timeOfConfirm\n"
                        + "from booking book Inner join bookingDetail bookDe\n"
                        + "on book.bookingID = bookDe.bookingID\n"
                        + "where bookDe.dateBegin between ? and ? \n"
                        + "and bookDe.dateEnd between ? and ? \n"
                        + "or bookDe.itemName like ?\n"
                        + "or book.[status] = ?\n"
                        + "or book.bookingID like ?";
                stm = con.prepareStatement(sql);
                stm.setDate(1, dateBegin);
                stm.setDate(2, dateEnd);
                stm.setDate(3, dateBegin);
                stm.setDate(4, dateEnd);
                stm.setString(5, "%" + itemName + "%");
                stm.setString(6, status);
                stm.setString(7, "%" + bookingIDFind + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    bookingID = rs.getString("bookingID");
                    userID = rs.getString("userID");
                    status = rs.getString("status");
                    dateOfCreate = rs.getTimestamp("timOfCreate");
                    dateOfConfirm = rs.getTimestamp("timeOfConfirm");
                    dto = new BookingDTO(userID, bookingID, dateOfCreate, dateOfConfirm, status);
                    result.add(dto);
                }

            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<BookingDTO> userFindBookingByResourceName(String itemName, String username)
            throws Exception {
        List<BookingDTO> result = new ArrayList<>();
        String bookingID = null;
        String userID = null;
        String status = null;
        Timestamp dateOfCreate = null;
        Timestamp dateOfConfirm = null;
        BookingDTO dto = new BookingDTO();
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select book.bookingID, book.userID, book.[status], "
                        + "book.timOfCreate, book.timeOfConfirm\n"
                        + "from booking book Inner join bookingDetail bookDe\n"
                        + "on book.bookingID = bookDe.bookingID\n"
                        + "where bookDe.itemName LIKE ?\n"
                        + "and book.userID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + itemName + "%");
                stm.setString(2, username);
                rs = stm.executeQuery();
                while (rs.next()) {
                    bookingID = rs.getString("bookingID");
                    userID = rs.getString("userID");
                    status = rs.getString("status");
                    dateOfCreate = rs.getTimestamp("timOfCreate");
                    dateOfConfirm = rs.getTimestamp("timeOfConfirm");
                    dto = new BookingDTO(userID, bookingID, dateOfCreate, dateOfConfirm, status);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<BookingDTO> userFindBookingByDateConfirm(Date dateConfirmSerch, String username) throws Exception {
        List<BookingDTO> result = new ArrayList<>();
        String bookingID = null;
        String userID = null;
        String status = null;
        Timestamp dateOfCreate = null;
        Timestamp dateOfConfirm = null;
        BookingDTO dto = new BookingDTO();
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select bookingID, userID, [status], timOfCreate, timeOfConfirm\n"
                        + "from booking \n"
                        + "where (select format(timeOfConfirm, 'yyyy-MM-dd')) <= ?\n"
                        + "and [userID] = ?";
                stm = con.prepareStatement(sql);
                stm.setDate(1, dateConfirmSerch);
                stm.setString(2, username);
                rs = stm.executeQuery();
                while (rs.next()) {
                    bookingID = rs.getString("bookingID");
                    userID = rs.getString("userID");
                    status = rs.getString("status");
                    dateOfCreate = rs.getTimestamp("timOfCreate");
                    dateOfConfirm = rs.getTimestamp("timeOfConfirm");
                    dto = new BookingDTO(userID, bookingID, dateOfCreate, dateOfConfirm, status);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

}
