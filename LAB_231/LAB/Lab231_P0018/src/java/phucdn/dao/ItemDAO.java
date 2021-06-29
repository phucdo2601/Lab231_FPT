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
import phucdn.db.DBUitls;
import phucdn.dto.object.ItemDTO;

/**
 *
 * @author ASUS
 */
public class ItemDAO implements Serializable {

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

    public List<ItemDTO> loadAllItems()
            throws Exception {
        List<ItemDTO> result = new ArrayList<>();
        ItemDTO dto = null;
        String itemID = null;
        String itemName = null;
        String author = null;
        String cateID = null;
        int quantity = 0;
        double price = 0;
        String imgUrl = null;
        Timestamp dateOfCreate = null;
        String description = null;
        String status = null;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "select [itemID], [itemName],\n"
                        + "[author], [cateID], [quantity],\n"
                        + "[imgUrl], [price], [dateOfCreate],\n"
                        + "[description], [status]\n"
                        + "from item\n"
                        + "where quantity > 0 and [status] = 'Active'";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    itemID = rs.getString("itemID");
                    itemName = rs.getString("itemName");
                    author = rs.getString("author");
                    cateID = rs.getString("cateID");
                    quantity = rs.getInt("quantity");
                    imgUrl = rs.getString("imgUrl");
                    price = rs.getDouble("price");
                    dateOfCreate = rs.getTimestamp("dateOfCreate");
                    description = rs.getString("description");
                    status = rs.getString("status");
                    dto = new ItemDTO(itemID, itemName, author,
                            cateID, quantity, imgUrl, price,
                            dateOfCreate, description, status);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ItemDTO> adminLoadAllItems()
            throws Exception {
        List<ItemDTO> result = new ArrayList<>();
        ItemDTO dto = null;
        String itemID = null;
        String itemName = null;
        String author = null;
        String cateID = null;
        int quantity = 0;
        double price = 0;
        String imgUrl = null;
        Timestamp dateOfCreate = null;
        String description = null;
        String status = null;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "select [itemID], [itemName],\n"
                        + "[author], [cateID], [quantity],\n"
                        + "[imgUrl], [price], [dateOfCreate],\n"
                        + "[description], [status]\n"
                        + "from item\n"
                        + "where quantity > 0";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    itemID = rs.getString("itemID");
                    itemName = rs.getString("itemName");
                    author = rs.getString("author");
                    cateID = rs.getString("cateID");
                    quantity = rs.getInt("quantity");
                    imgUrl = rs.getString("imgUrl");
                    price = rs.getDouble("price");
                    dateOfCreate = rs.getTimestamp("dateOfCreate");
                    description = rs.getString("description");
                    status = rs.getString("status");
                    dto = new ItemDTO(itemID, itemName, author,
                            cateID, quantity, imgUrl, price,
                            dateOfCreate, description, status);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ItemDTO> findItemsLikeByName(String id)
            throws Exception {
        List<ItemDTO> result = new ArrayList<>();
        ItemDTO dto = null;
        String itemID = null;
        String itemName = null;
        String author = null;
        String cateID = null;
        int quantity = 0;
        double price = 0;
        String imgUrl = null;
        Timestamp dateOfCreate = null;
        String description = null;
        String status = null;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "select [itemID], [itemName],\n"
                        + "[author], [cateID], [quantity],\n"
                        + "[imgUrl], [price], [dateOfCreate],\n"
                        + "[description], [status]\n"
                        + "from item\n"
                        + "where quantity > 0 and [status] = 'Active'\n"
                        + "and itemName like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + id + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    itemID = rs.getString("itemID");
                    itemName = rs.getString("itemName");
                    author = rs.getString("author");
                    cateID = rs.getString("cateID");
                    quantity = rs.getInt("quantity");
                    imgUrl = rs.getString("imgUrl");
                    price = rs.getDouble("price");
                    dateOfCreate = rs.getTimestamp("dateOfCreate");
                    description = rs.getString("description");
                    status = rs.getString("status");
                    dto = new ItemDTO(itemID, itemName, author,
                            cateID, quantity, imgUrl, price,
                            dateOfCreate, description, status);
                    result.add(dto);
                }

            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ItemDTO> findItemByCateID(String id)
            throws Exception {
        List<ItemDTO> result = new ArrayList<>();
        ItemDTO dto = null;
        String itemID = null;
        String itemName = null;
        String author = null;
        String cateID = null;
        int quantity = 0;
        double price = 0;
        String imgUrl = null;
        Timestamp dateOfCreate = null;
        String description = null;
        String status = null;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "select [itemID], [itemName],\n"
                        + "[author], [cateID], [quantity],\n"
                        + "[imgUrl], [price], [dateOfCreate],\n"
                        + "[description], [status]\n"
                        + "from item\n"
                        + "where quantity > 0 and [status] = 'Active'\n"
                        + "and cateID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    itemID = rs.getString("itemID");
                    itemName = rs.getString("itemName");
                    author = rs.getString("author");
                    cateID = rs.getString("cateID");
                    quantity = rs.getInt("quantity");
                    imgUrl = rs.getString("imgUrl");
                    price = rs.getDouble("price");
                    dateOfCreate = rs.getTimestamp("dateOfCreate");
                    description = rs.getString("description");
                    status = rs.getString("status");
                    dto = new ItemDTO(itemID, itemName, author,
                            cateID, quantity, imgUrl, price,
                            dateOfCreate, description, status);
                    result.add(dto);
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ItemDTO> findItemByPriceRange(double priceBegin, double priceEnd)
            throws Exception {
        List<ItemDTO> result = new ArrayList<>();
        ItemDTO dto = null;
        String itemID = null;
        String itemName = null;
        String author = null;
        String cateID = null;
        int quantity = 0;
        double price = 0;
        String imgUrl = null;
        Timestamp dateOfCreate = null;
        String description = null;
        String status = null;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "select [itemID], [itemName],\n"
                        + "[author], [cateID], [quantity],\n"
                        + "[imgUrl], [price],[dateOfCreate],\n"
                        + "[description], [status]\n"
                        + "from item\n"
                        + "where quantity > 0 and [status] = 'Active'\n"
                        + "and price between ? and ?";
                stm = con.prepareStatement(sql);
                stm.setDouble(1, priceBegin);
                stm.setDouble(2, priceEnd);
                rs = stm.executeQuery();
                while (rs.next()) {
                    itemID = rs.getString("itemID");
                    itemName = rs.getString("itemName");
                    author = rs.getString("author");
                    cateID = rs.getString("cateID");
                    quantity = rs.getInt("quantity");
                    imgUrl = rs.getString("imgUrl");
                    price = rs.getDouble("price");
                    dateOfCreate = rs.getTimestamp("dateOfCreate");
                    description = rs.getString("description");
                    status = rs.getString("status");
                    dto = new ItemDTO(itemID, itemName, author,
                            cateID, quantity, imgUrl, price,
                            dateOfCreate, description, status);
                    result.add(dto);
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean createBook(ItemDTO dto)
            throws Exception {
        boolean result = false;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "insert into item (itemID, itemName, \n"
                        + "author, cateID, quantity, imgUrl, \n"
                        + "price, dateOfCreate, [description], [status])\n"
                        + "values (?,?,?,?,?,\n"
                        + "?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getItemID());
                stm.setString(2, dto.getItemName());
                stm.setString(3, dto.getAuthor());
                stm.setString(4, dto.getCateID());
                stm.setInt(5, dto.getQuantity());
                stm.setString(6, dto.getImgUrl());
                stm.setDouble(7, dto.getPrice());
                stm.setTimestamp(8, dto.getDateOfCreate());
                stm.setString(9, dto.getDescription());
                stm.setString(10, dto.getStatus());
                result = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean updateItem(ItemDTO dto)
            throws Exception {
        boolean result = false;
        long mills = System.currentTimeMillis();
        Timestamp dateOfUpdate = new Timestamp(mills);
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "update item\n"
                        + "set itemName = ?, author = ?,\n"
                        + "cateID = ?, quantity = ?, imgUrl = ?,\n"
                        + "price = ?, dateOfCreate = ?,\n"
                        + "[description] = ?, [status] = ?\n"
                        + "where itemID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getItemName());
                stm.setString(2, dto.getAuthor());
                stm.setString(3, dto.getCateID());
                stm.setInt(4, dto.getQuantity());
                stm.setString(5, dto.getImgUrl());
                stm.setDouble(6, dto.getPrice());
                stm.setTimestamp(7, dateOfUpdate);
                stm.setString(8, dto.getDescription());
                stm.setString(9, dto.getStatus());
                stm.setString(10, dto.getItemID());
                result = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean deleteItem(String id)
            throws Exception {
        boolean result = false;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "update item\n"
                        + "set [status] = 'InActive'\n"
                        + "where itemID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                result = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean reActivateItem(String id)
            throws Exception {
        boolean result = false;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "update item\n"
                        + "set [status] = 'Active'\n"
                        + "where itemID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                result = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }

    public ItemDTO getLastProduct() throws Exception {
        ItemDTO dto = null;
        String itemID = null;
        String itemName = null;
        String author = null;
        String cateID = null;
        int quantity = 0;
        double price = 0;
        String imgUrl = null;
        Timestamp dateOfCreate = null;
        String description = null;
        String status = null;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "select top 1 [itemID], [itemName],\n"
                        + "[author], [cateID], [quantity],\n"
                        + "[imgUrl], [price], [dateOfCreate],\n"
                        + "[description], [status]\n"
                        + "from item\n"
                        + "where quantity > 0 and [status] = 'Active'\n"
                        + "order by dateOfCreate desc";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    itemID = rs.getString("itemID");
                    itemName = rs.getString("itemName");
                    author = rs.getString("author");
                    cateID = rs.getString("cateID");
                    quantity = rs.getInt("quantity");
                    imgUrl = rs.getString("imgUrl");
                    price = rs.getDouble("price");
                    dateOfCreate = rs.getTimestamp("dateOfCreate");
                    description = rs.getString("description");
                    status = rs.getString("status");
                    dto = new ItemDTO(itemID, itemName, author,
                            cateID, quantity, imgUrl, price,
                            dateOfCreate, description, status);
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return dto;
    }

    public ItemDTO findItemByPrimaryKey(String id)
            throws Exception {
        ItemDTO dto = null;
        String itemID = null;
        String itemName = null;
        String author = null;
        String cateID = null;
        int quantity = 0;
        double price = 0;
        String imgUrl = null;
        Timestamp dateOfCreate = null;
        String description = null;
        String status = null;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "select [itemID], [itemName],\n"
                        + "[author], [cateID], [quantity],\n"
                        + "[imgUrl], [price], [dateOfCreate],\n"
                        + "[description], [status]\n"
                        + "from item\n"
                        + "where itemID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    itemID = rs.getString("itemID");
                    itemName = rs.getString("itemName");
                    author = rs.getString("author");
                    cateID = rs.getString("cateID");
                    quantity = rs.getInt("quantity");
                    imgUrl = rs.getString("imgUrl");
                    price = rs.getDouble("price");
                    dateOfCreate = rs.getTimestamp("dateOfCreate");
                    description = rs.getString("description");
                    status = rs.getString("status");
                    dto = new ItemDTO(itemID, itemName, author,
                            cateID, quantity, imgUrl, price,
                            dateOfCreate, description, status);
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return dto;
    }

    public List<ItemDTO> getRecommenItems(String search)
            throws Exception {
        List<ItemDTO> result = new ArrayList<>();
        ItemDTO dto = null;
        String itemID = null;
        String itemName = null;
        String author = null;
        String cateID = null;
        int quantity = 0;
        double price = 0;
        String imgUrl = null;
        Timestamp dateOfCreate = null;
        String description = null;
        String status = null;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "select [itemID], [itemName],\n"
                        + "[author], [cateID], [quantity],\n"
                        + "[imgUrl], [price], [dateOfCreate],\n"
                        + "[description], [status]\n"
                        + "from item\n"
                        + "where cateID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, search);
                rs = stm.executeQuery();
                while (rs.next()) {
                    itemID = rs.getString("itemID");
                    itemName = rs.getString("itemName");
                    author = rs.getString("author");
                    cateID = rs.getString("cateID");
                    quantity = rs.getInt("quantity");
                    imgUrl = rs.getString("imgUrl");
                    price = rs.getDouble("price");
                    dateOfCreate = rs.getTimestamp("dateOfCreate");
                    description = rs.getString("description");
                    status = rs.getString("status");
                    dto = new ItemDTO(itemID, itemName, author,
                            cateID, quantity, imgUrl, price,
                            dateOfCreate, description, status);
                    result.add(dto);
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }

    public int getQuantityOfItemID(String id)
            throws Exception {
        int result = 0;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "select quantity\n"
                        + "from item\n"
                        + "where itemID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = rs.getInt("quantity");
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean changeQuanItemAfterCheckOut(String id, int quantity)
            throws Exception {
        boolean result = false;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "update item\n"
                        + "set quantity = quantity - ?\n"
                        + "where itemID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, quantity);
                stm.setString(2, id);
                result = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }
}
