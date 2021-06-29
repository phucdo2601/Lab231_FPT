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
import phucdn.db.MyConnection;
import phucdn.dtos.OrderDetailDTO;

/**
 *
 * @author phucd
 */
public class OrderDetailDAO implements Serializable {

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
            System.out.println("Error at closeConnection in OrderDetailDAO: ");
            e.printStackTrace();
        }
    }

    public boolean addOrderDetail(OrderDetailDTO ordDTO) throws Exception {
        boolean result = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "insert into OrderDetail(orderDetailID,orderID,productID,productName,quantity,price)\n"
                        + "values(?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, ordDTO.getOrderDetailID());
                stm.setString(2, ordDTO.getOrderID());
                stm.setString(3, ordDTO.getProductID());
                stm.setString(4, ordDTO.getProductName());
                stm.setInt(5, ordDTO.getQuantity());
                stm.setDouble(6, ordDTO.getPrice());
                result = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            System.out.println("Error at addOrderDetail in OrderDetailDAO: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<OrderDetailDTO> findOrderDetailByPrimaryKey(String id) throws Exception {
        List<OrderDetailDTO> result = new ArrayList<>();
        String orderDetailID;
        String orderID;
        String productID;
        String productName;
        double price;
        int quantity;
        OrderDetailDTO orderDetail = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "select orderDetailID, orderID, productID, "
                        + "productName, price, quantity\n"
                        + "from OrderDetail\n"
                        + "where orderID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    orderDetailID = rs.getString("orderDetailID");
                    orderID = rs.getString("orderID");
                    productID = rs.getString("productID");
                    productName = rs.getString("productName");
                    price = rs.getDouble("price");
                    quantity = rs.getInt("quantity");
                    orderDetail = new OrderDetailDTO(orderDetailID, orderID, productID, productName, quantity, price);
                    result.add(orderDetail);
                }
            }
        } catch (Exception e) {
            System.out.println("Error at get list of Product details: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<OrderDetailDTO> userFindOrderDetailByPrimaryKey(String id) throws Exception {
        List<OrderDetailDTO> result = new ArrayList<>();
        String orderDetailID;
        String orderID;
        String productID;
        String productName;
        double price;
        int quantity;
        String image;
        OrderDetailDTO orderDetail = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "SELECT o.orderDetailID, o.orderID,o.productID,o.productName, "
                        + "o.price,o.quantity,p.[image]\n"
                        + "  FROM OrderDetail o\n"
                        + "  LEFT OUTER JOIN Product p\n"
                        + "  ON o.productID = p.productID\n"
                        + "  where orderID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    orderDetailID = rs.getString("orderDetailID");
                    orderID = rs.getString("orderID");
                    productID = rs.getString("productID");
                    productName = rs.getString("productName");
                    price = rs.getDouble("price");
                    quantity = rs.getInt("quantity");
                    image = rs.getString("image");
                    orderDetail = new OrderDetailDTO(orderDetailID, orderID, productID, productName, quantity, price, image);
                    result.add(orderDetail);
                }
            }
        } catch (Exception e) {
            System.out.println("Error at get list of Product details: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        OrderDetailDAO dao = new OrderDetailDAO();
        OrderDetailDTO dto = new OrderDetailDTO("sfds", "1614681779127", "SP10000006", "dgd", 12, 3342);
//        if (dao.addOrderDetail(dto)) {
//            System.out.println("Insert OrderDetail is Succesfully!");
//        }
        if (dao.userFindOrderDetailByPrimaryKey("1615972791327") != null) {
            System.out.println("User Find Order Detail is Successfully!");
        }
    }
}
