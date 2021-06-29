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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import phucdn.db.MyConnection;
import phucdn.dtos.OrderDTO;

/**
 *
 * @author phucd
 */
public class OrderDAO implements Serializable {

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
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            System.out.println("Error at closeConnection in OrderDAO: ");
            e.printStackTrace();
        }
    }

    public boolean addOrder(OrderDTO orDTO) throws Exception {
        boolean result = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "insert [dbo].[Order] "
                        + "(orderID, username, customerName, addressSending, "
                        + "totalPrice, payment,dateOfBooking, waiting, "
                        + "finishing, phoneNumber)\n"
                        + "values (?,?,?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, orDTO.getOrderID());
                stm.setString(2, orDTO.getUsername());
                stm.setString(3, orDTO.getCustomerName());
                stm.setString(4, orDTO.getAddressSending());
                stm.setDouble(5, orDTO.getTotalPrice());
                stm.setString(6, orDTO.getPayment());
                stm.setTimestamp(7, orDTO.getDateOfBooking());
                stm.setBoolean(8, orDTO.isWaiting());
                stm.setBoolean(9, orDTO.isFinishing());
                stm.setString(10, orDTO.getPhoneNumber());
                result = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            System.out.println("Error at addOrder in OrderDAO: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<OrderDTO> findOrderLikeByOrderId(String username) throws Exception {
        List<OrderDTO> result = new ArrayList<>();
        try {
            con = MyConnection.getConnection();
            OrderDTO ordto = null;
            String orderID;
            String customerName;
            String addressSending;
            String phone;
            double totalPrice;
            Timestamp dateOfBooking;
            String payment;
            boolean waiting;
            boolean finishing;
            Timestamp dateOfFinishing;
            if (con != null) {
                String sql = "select [orderID], [username], [customerName], [addressSending], phoneNumber, [totalPrice], \n"
                        + "[dateOfBooking], [payment], [waiting], [finishing], [dateOfFinishing]\n"
                        + "from [dbo].[Order]\n"
                        + "where username like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + username + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    orderID = rs.getString("orderID");
                    customerName = rs.getString("customerName");
                    username = rs.getString("username");
                    addressSending = rs.getString("addressSending");
                    phone = rs.getString("phoneNumber");
                    totalPrice = rs.getDouble("totalPrice");
                    dateOfBooking = rs.getTimestamp("dateOfBooking");
                    payment = rs.getString("payment");
                    waiting = rs.getBoolean("waiting");
                    finishing = rs.getBoolean("finishing");
                    dateOfFinishing = rs.getTimestamp("dateOfFinishing");
//                    ordto = new OrderDTO(orderID, username, customerName, addressSending, totalPrice, dateOfBooking, dateOfFinishing, payment, waiting, finishing);
                    ordto = new OrderDTO(orderID, username, customerName, addressSending, phone, totalPrice, dateOfBooking, dateOfFinishing, payment, waiting, finishing);
                    result.add(ordto);
                }
            }
        } catch (Exception e) {
            System.out.println("Error at findOrderLikeOrderID: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<OrderDTO> findOrderByPrimaryKeyHistory(String id) throws Exception {
        OrderDTO dto = null;
        List<OrderDTO> result = new ArrayList<>();
        String orderID;
        String username;
        String customerName;
        String addressSending;
        String phone;
        double totalPrice;
        Timestamp dateOfBooking;
        String payment;
        boolean finising;
        Timestamp dateOfFinishing;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "select orderID, username, customerName, "
                        + "addressSending, phoneNumber,totalPrice, dateOfBooking, "
                        + "payment, finishing, dateOfFinishing\n"
                        + "from [Order]\n"
                        + "where username = ? and finishing = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                stm.setBoolean(2, true);
                rs = stm.executeQuery();
                while (rs.next()) {
                    orderID = rs.getString("orderID");
                    username = rs.getString("username");
                    customerName = rs.getString("customerName");
                    addressSending = rs.getString("addressSending");
                    phone = rs.getString("phoneNumber");
                    totalPrice = rs.getDouble("totalPrice");
                    dateOfBooking = rs.getTimestamp("dateOfBooking");
                    payment = rs.getString("payment");
                    finising = rs.getBoolean("finishing");
                    dateOfFinishing = rs.getTimestamp("dateOfFinishing");
                    dto = new OrderDTO(orderID, username, customerName, addressSending, totalPrice, dateOfBooking, dateOfFinishing, payment, finising);
                    result.add(dto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public List<OrderDTO> findOrderCancelByPrimaryKeyHistory(String id) throws Exception {
        OrderDTO dto = null;
        List<OrderDTO> result = new ArrayList<>();
        String orderID;
        String username;
        String customerName;
        String addressSending;
        double totalPrice;
        Timestamp dateOfBooking;
        String payment;
        boolean finising;
        Timestamp dateOfFinishing;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "select orderID, username, customerName, "
                        + "addressSending, totalPrice, dateOfBooking, "
                        + "payment, finishing, dateOfFinishing\n"
                        + "from [Order]\n"
                        + "where username = ? and finishing = ? and waiting = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                stm.setBoolean(2, false);
                stm.setBoolean(3, false);
                rs = stm.executeQuery();
                while (rs.next()) {
                    orderID = rs.getString("orderID");
                    username = rs.getString("username");
                    customerName = rs.getString("customerName");
                    addressSending = rs.getString("addressSending");
                    totalPrice = rs.getDouble("totalPrice");
                    dateOfBooking = rs.getTimestamp("dateOfBooking");
                    payment = rs.getString("payment");
                    finising = rs.getBoolean("finishing");
                    dateOfFinishing = rs.getTimestamp("dateOfFinishing");
                    dto = new OrderDTO(orderID, username, customerName, addressSending, totalPrice, dateOfBooking, dateOfFinishing, payment, finising);
                    result.add(dto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<OrderDTO> findOrderByPrimaryKeyConfirm(String id) throws Exception {
        OrderDTO dto;
        List<OrderDTO> result = new ArrayList<>();
        String orderID;
        String username;
        String customerName;
        String addressSending;
        String phone;
        double totalPrice;
        Timestamp dateOfBooking;
        String payment;
        boolean waiting;
        boolean finising;
        Timestamp dateOfFinishing;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "select orderID, username, customerName, "
                        + "addressSending, phoneNumber,totalPrice, dateOfBooking, "
                        + "payment, waiting, finishing, dateOfFinishing\n"
                        + "from [Order]\n"
                        + "where username = ? and waiting = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                stm.setBoolean(2, true);
                rs = stm.executeQuery();
                while (rs.next()) {
                    orderID = rs.getString("orderID");
                    username = rs.getString("username");
                    customerName = rs.getString("customerName");
                    addressSending = rs.getString("addressSending");
                    phone = rs.getString("phoneNumber");
                    totalPrice = rs.getDouble("totalPrice");
                    dateOfBooking = rs.getTimestamp("dateOfBooking");
                    payment = rs.getString("payment");
                    waiting = rs.getBoolean("waiting");
                    finising = rs.getBoolean("finishing");
                    dateOfFinishing = rs.getTimestamp("dateOfFinishing");
//                    dto = new OrderDTO(orderID, username, customerName, addressSending, totalPrice, dateOfBooking, dateOfFinishing, payment, waiting, finising);
                    dto = new OrderDTO(orderID, username, customerName, addressSending, phone, totalPrice, dateOfBooking, dateOfFinishing, payment, waiting, finising);
                    result.add(dto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean cancelOrder(String id, Timestamp dateOfFinishing) throws Exception {
        boolean result = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "update [Order] set waiting = 'false', "
                        + "finishing = 'false', dateOfFinishing = ?\n"
                        + "where orderID = ?";
                stm = con.prepareStatement(sql);
                stm.setTimestamp(1, dateOfFinishing);
                stm.setString(2, id);
                result = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            System.out.println("Error at cancelOrder in OrderDAO: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public boolean confirmOrder(String id, Timestamp dateOfFinishing) throws Exception{
        boolean result = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "update [Order] set waiting = 'false', "
                        + "finishing = 'true', dateOfFinishing = ?\n"
                        + "where orderID =?";
                stm = con.prepareStatement(sql);
                stm.setTimestamp(1, dateOfFinishing);
                stm.setString(2, id);
                result = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
        }
        finally{
            closeConnection();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        OrderDAO dao = new OrderDAO();
        List<OrderDTO> listO = dao.findOrderLikeByOrderId("dung");
//        for (OrderDTO p : listO) {
//            System.out.println(p.toString());
//        }
        List<OrderDTO> listU = dao.findOrderByPrimaryKeyConfirm("dungtran0408");
        for (OrderDTO orderDTO : listO) {
            System.out.println(orderDTO.toString());
        }
//        long mills = System.currentTimeMillis();
//        Timestamp dateOfFinishing = new Timestamp(mills);
//        boolean result = dao.cancelOrder("1614940360043", dateOfFinishing);
//        if (result) {
//            System.out.println("Cancel order is successfully!");
//        }
    }
}
