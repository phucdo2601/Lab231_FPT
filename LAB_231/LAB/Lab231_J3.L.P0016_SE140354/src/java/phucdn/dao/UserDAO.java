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
import phucdn.db.DBUtils;
import phucdn.dtos.object.UserDTO;

/**
 *
 * @author ASUS
 */
public class UserDAO implements Serializable {

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

    public String checkLoginRole(String username, String password) throws Exception {
        String role = "falied";
        String status = "New";
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select [roleID], [status]\n"
                        + "from [user]\n"
                        + "where userID = ? COLLATE SQL_Latin1_General_CP1_CS_AS\n"
                        + "AND\n"
                        + "[password] = ? COLLATE SQL_Latin1_General_CP1_CS_AS";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    status = rs.getString("status");
                    if (status.equals("Active")) {
                        role = rs.getString("roleID");
                    } else if (status.equals("New")) {
                        role = "faliedStatus";
                    }
                }
            }
        }  finally {
            closeConnection();
        }
        return role;
    }

    public String checkLoginAuthen(String username, String password) throws Exception {
        String role = "falied";
        String status = "New";
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select [roleID], [status]\n"
                        + "from [user]\n"
                        + "where userID = ? COLLATE SQL_Latin1_General_CP1_CS_AS\n"
                        + "AND\n"
                        + "[password] = ? COLLATE SQL_Latin1_General_CP1_CS_AS";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    status = rs.getString("status");
                }
            }
        }  finally {
            closeConnection();
        }
        return status;
    }

    public boolean createAccount(UserDTO dto) throws Exception {
        boolean result = false;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "insert into [user]([userID],\n"
                        + "[password],[fullname],[address],\n"
                        + "[createDate],[roleID],[phoneNumber],[status]) \n"
                        + "values(?,?,?,?,?,?,?,'New')";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getUserID());
                stm.setString(2, dto.getPassword());
                stm.setString(3, dto.getFullname());
                stm.setString(4, dto.getAddress());
                stm.setTimestamp(5, dto.getCreateDate());
                stm.setString(6, dto.getRole());
                stm.setString(7, dto.getPhoneNumber());
                result = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean activateAcc(String username) throws Exception {
        boolean result = false;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "update [user]\n"
                        + "set [status] =  'Active'\n"
                        + "where [userID] = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                result = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public String checkGmailLogin(String mail) throws Exception {
        String role = null;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select [roleID]\n"
                        + "from [user]\n"
                        + "where userID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, mail);
                rs = stm.executeQuery();
                if (rs.next()) {
                    role = rs.getString("roleID");
                }
            }
        } finally {
            closeConnection();
        }
        return role;
    }

    public String checkGmailAuthen(String mail) throws Exception {
        String status = null;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select [status]\n"
                        + "from [user]\n"
                        + "where userID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, mail);
                rs = stm.executeQuery();
                if (rs.next()) {
                    status = rs.getString("status");
                }
            }
        } finally {
            closeConnection();
        }
        return status;
    }

    public String reFindAccount(String username) throws Exception {
        String status = null;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select [status]\n"
                        + "from [user]\n"
                        + "where userID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                rs = stm.executeQuery();
                if (rs.next()) {
                    status = rs.getString("status");
                }
            }
        }  finally {
            closeConnection();
        }
        return status;
    }

}
