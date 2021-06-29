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
import phucdn.dto.object.DiscountDTO;

/**
 *
 * @author ASUS
 */
public class DiscountDAO implements Serializable {

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

    public boolean createDiscount(DiscountDTO dto)
            throws Exception {
        boolean result = false;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "insert into discount(discountID, discountName, \n"
                        + "rateDis, isUsing,dateOfCreate, userID, isAddAcc)\n"
                        + "values(?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getDisID());
                stm.setString(2, dto.getDisName());
                stm.setInt(3, dto.getRateDis());
                stm.setBoolean(4, dto.isIsUsing());
                stm.setDate(5, dto.getDateOfCreate());
                stm.setString(6, dto.getUserID());
                stm.setBoolean(7, dto.isIsAddAcc());
                result = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<DiscountDTO> getAllDiscounts()
            throws Exception {
        List<DiscountDTO> result = new ArrayList<>();
        DiscountDTO dto = null;
        String disID = null;
        String disName = null;
        int rateDis = 0;
        boolean isUsing = false;
        boolean isAddAcc = false;
        Date dateOfCreate = null;
        String userID = null;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "select [discountID], [discountName], \n"
                        + "[rateDis], [isUsing], [isAddAcc],[dateOfCreate], \n"
                        + "[userID]\n"
                        + "from discount";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    disID = rs.getString("discountID");
                    disName = rs.getString("discountName");
                    rateDis = rs.getInt("rateDis");
                    isUsing = rs.getBoolean("isUsing");
                    isAddAcc = rs.getBoolean("isAddAcc");
                    dateOfCreate = rs.getDate("dateOfCreate");
                    userID = rs.getString("userID");
                    dto = new DiscountDTO(disID, disName, rateDis, isUsing,
                            isAddAcc, dateOfCreate, userID);
                    result.add(dto);
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean addAccToDiscountID(String disID, String userID)
            throws Exception {
        boolean result = false;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "update discount\n"
                        + "set isAddAcc= 1, userID = ?\n"
                        + "where discountID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, disID);
                result = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<DiscountDTO> loadListDisByUserID(String id)
            throws Exception {
        List<DiscountDTO> result = new ArrayList<>();
        DiscountDTO dto = null;
        String disID = null;
        boolean isAddAcc = false;
        boolean isUsing = false;
        int rateDis = 0;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "select discountID, rateDis, isAddAcc, isUsing\n"
                        + "from discount\n"
                        + "where userID = ? and isAddAcc = 1 and isUsing = 0";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    disID = rs.getString("discountID");
                    rateDis = rs.getInt("rateDis");
                    isAddAcc = rs.getBoolean("isAddAcc");
                    isUsing = rs.getBoolean("isUsing");
                    dto = new DiscountDTO(disID, null, rateDis, isUsing,
                            isAddAcc, null, id);
                    result.add(dto);
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }

    public DiscountDTO loadDiscountByDiscountID(String id)
            throws Exception {
        DiscountDTO result = null;
        String discountID = null;
        int rateDis = 0;
        boolean isUsing = false;
        boolean isAddAcc = false;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "select discountID, rateDis, isAddAcc, isUsing\n"
                        + "from discount\n"
                        + "where discountID = ?\n";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    discountID = rs.getString("discountID");
                    rateDis = rs.getInt("rateDis");
                    isAddAcc = rs.getBoolean("isAddAcc");
                    isUsing = rs.getBoolean("isUsing");
                    result = new DiscountDTO(discountID, null, rateDis, isUsing, isAddAcc, null, id);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean updateUsingDiscount(String id)
            throws Exception {
        boolean result = false;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "update discount\n"
                        + "set isUsing = 1\n"
                        + "where discountID = ?";
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
    
    public boolean removeUserInDiscountID(String userID)
            throws Exception{
        boolean result = false;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "";
                stm = con.prepareStatement(sql);
                stm.setString(1, userID);
                
            }
        } catch (Exception e) {
        }
        finally{
            closeConnection();
        }
        return result;
    }
}
