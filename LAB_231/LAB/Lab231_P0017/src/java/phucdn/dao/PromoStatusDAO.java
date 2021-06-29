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
import phucdn.db.DBUtils;

/**
 *
 * @author ASUS
 */
public class PromoStatusDAO implements Serializable {

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

    public String loadProStaActiveID()
            throws Exception {
        String result = null;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select promoStatusID\n"
                        + "from promoStatus\n"
                        + "where promoStatusID = 'Active'";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = rs.getString("promoStatusID");
                }
            }

        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }

    public String loadProStatusNonActive()
            throws Exception {
        String result = null;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select promoStatusID\n"
                        + "from promoStatus\n"
                        + "where promoStatusID = 'NonActive'";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = rs.getString("promoStatusID");
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
