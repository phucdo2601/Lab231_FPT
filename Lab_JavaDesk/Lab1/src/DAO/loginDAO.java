/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class loginDAO {

    public static Connection cn = null;
    public static PreparedStatement pstm = null;
    public static Statement stm = null;
    public static ResultSet rs;

    public static String checkLogin(String username, String password) {
        String us = "";
        try {
            cn = myLibrary.myConnection.makeConnection();
            if (cn != null) {
                String sql = "select userID, password \n"
                        + "from tblUsers\n"
                        + "where userID = ? AND password = ? "
                        + "COLLATE SQL_Latin1_General_CP1_CS_AS";
                pstm = cn.prepareStatement(sql);
                pstm.setString(1, username);
                pstm.setString(2, password);
                rs = pstm.executeQuery();
                if (rs != null && rs.next()) {
                    us = rs.getString("userID");
                    
                }
            } else {
                throw new Exception("Server is close");
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
        return us;
    }
}
