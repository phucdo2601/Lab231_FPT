/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author ASUS
 */
public class ItemDAO {

    public static Connection cn;
    public static Statement stm;
    public static PreparedStatement pstm;
    public static ResultSet rs;

    public static Vector<Item> getAllItems() {
        Vector<Item> result = new Vector<>();
        try {
            cn = myLibrary.myConnection.makeConnection();
            if (cn != null) {
                String sql = "select [itemCode],[itemName],[supCode],[unit],"
                        + "[price],[supplying]\n"
                        + "from tblItems";
                stm = cn.createStatement();
                rs = stm.executeQuery(sql);
                while (rs.next()) {
                    Item it = new Item();
                    it.setItemCode(rs.getString(1));
                    it.setItemName(rs.getString(2));
                    it.setSupCode(rs.getString(3));
                    it.setUnit(rs.getString(4));
                    it.setPrice(rs.getDouble(5));
                    it.setSupplying(rs.getBoolean(6));
                    result.add(it);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static int insertItem(Item it) {
        int result = 0;
        try {
            cn = myLibrary.myConnection.makeConnection();
            if (cn != null) {
                String sql = "insert tblItems(itemCode, itemName, supCode, "
                        + "unit, price, supplying) values \n"
                        + "(?,?,?,?,?,?)";
                pstm = cn.prepareStatement(sql);
                pstm.setString(1, it.getItemCode());
                pstm.setString(2, it.getItemName());
                pstm.setString(3, it.getSupCode());
                pstm.setString(4, it.getUnit());
                pstm.setDouble(5, it.getPrice());
                pstm.setBoolean(6, it.isSupplying());
                result = pstm.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("SQL Server lost connected!");
        } catch (NullPointerException ex) {
            System.out.println("The input is not valid!");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                if (cn == null) {
                    System.out.println("SQL Server lost connected!");
                }
                e.printStackTrace();
            }
        }
        return result;
    }

    public static int updateItem(Item it) {
        int result = 0;
        try {
            cn = myLibrary.myConnection.makeConnection();
            if (cn != null) {
                String sql = "update tblItems \n"
                        + "set itemName = ?, supCode = ?, unit = ?, price = ?, "
                        + "supplying = ?\n"
                        + "where itemCode = ?";
                pstm = cn.prepareStatement(sql);
                pstm.setString(1, it.getItemName());
                pstm.setString(2, it.getSupCode());
                pstm.setString(3, it.getUnit());
                pstm.setDouble(4, it.getPrice());
                pstm.setBoolean(5, it.isSupplying());
                pstm.setString(6, it.getItemCode());
                result = pstm.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("SQL Server lost connected!");
        } catch (NullPointerException e) {
            System.out.println("The input is not valid!");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                if (cn == null) {
                    System.out.println("SQL Server lost connected!");
                }
            }
        }
        return result;
    }

    public static int deleteItem(String itemCode) {
        int result = 0;
        try {
            cn = myLibrary.myConnection.makeConnection();
            if (cn != null) {
                String sql = "delete from tblItems where itemCode = ?";
                pstm = cn.prepareStatement(sql);
                pstm.setString(1, itemCode);

                result = pstm.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("SQL Server lost connected!");
        } catch (NullPointerException e) {
            System.out.println("The input is not valid!");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                if (cn == null) {
                    System.out.println("SQL Server lost connected!");
                }
            }
        }
        return result;
    }

    public Item getItemByID(String idItem) {
        Item it = new Item();
        try {
            cn = myLibrary.myConnection.makeConnection();
            if (cn != null) {
                String sql = "select itemCode, itemName, unit, price, "
                        + "supplying, supCode from tblItems\n"
                        + "where itemCode = ?";
                pstm = cn.prepareStatement(sql);
                pstm.setString(1, idItem);
                rs = pstm.executeQuery();
                while (rs.next()) {                    
                    it.setItemCode(rs.getString("itemCode"));
                    it.setItemName(rs.getString("itemName"));
                    it.setSupCode(rs.getString("supCode"));
                    it.setUnit(rs.getString("unit"));
                    it.setPrice(rs.getDouble("price"));
                    it.setSupplying(rs.getBoolean("supplying"));
                    return it;
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Server lost connected!");
        } catch (NullPointerException e) {
            System.out.println("The input is not valid!");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                if (cn == null) {
                    System.out.println("SQL Server lost connected!");
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ItemDAO id = new ItemDAO();
        System.out.println("=>" + id.getAllItems());
    }
}
