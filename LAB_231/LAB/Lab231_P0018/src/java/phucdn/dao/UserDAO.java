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
import phucdn.db.DBUitls;
import phucdn.dto.object.EncryptWithSHA256;
import phucdn.dto.object.UserDTO;

/**
 *
 * @author ASUS
 */
public class UserDAO implements Serializable {

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

    public String checkLoginRole(String username, String password) throws Exception {
        String role = "falied";
        String status = "New";
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "select [roleID], [status]\n"
                        + "from [user]\n"
                        + "where userID = ? COLLATE SQL_Latin1_General_CP1_CS_AS\n"
                        + "AND\n"
                        + "[password] = ? COLLATE SQL_Latin1_General_CP1_CS_AS";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, EncryptWithSHA256.hassPassBySHA256(password));
                rs = stm.executeQuery();
                if (rs.next()) {
                    status = rs.getString("status");
                    if (status.equals("Active")) {
                        role = rs.getString("roleID");
                    } else if (status.equals("InActive")) {
                        role = "BanAccount";
                    }
                }
            }
        } finally {
            closeConnection();
        }
        return role;
    }

    public List<UserDTO> loadAllUserWithUserRole()
            throws Exception {
        List<UserDTO> result = new ArrayList<>();
        UserDTO dto = new UserDTO();
        String userID = null;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "select userID\n"
                        + "from [user]\n"
                        + "where roleID = 'user'";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    userID = rs.getString("userID");
                    dto = new UserDTO(userID, null, null, null, null, null, null, null, null);
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

    public UserDTO loadInfoByUserID(String id)
            throws Exception {
        UserDTO result = null;
        String userID;
        String fullname;
        String phone;
        String email;
        String address;
        String roleID;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "select userID, fullname, "
                        + "phone, email, [address], roleID\n"
                        + "from [user]\n"
                        + "where userID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    userID = rs.getString("userID");
                    fullname = rs.getString("fullname");
                    phone = rs.getString("phone");
                    email = rs.getString("email");
                    address = rs.getString("address");
                    roleID = rs.getString("roleID");
                    result = new UserDTO(userID, phone, fullname, phone, email, address, roleID, null, null);
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }

    
}
