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
import javax.naming.NamingException;
import phucdn.db.DBUtils;
import phucdn.dtos.object.RoleDTO;

/**
 *
 * @author ASUS
 */
public class RoleDAO implements Serializable {

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

    public List<RoleDTO> getAllRole() throws Exception, NamingException {
        List<RoleDTO> result = new ArrayList<>();
        String roleID;
        String roleName;
        RoleDTO rDto = null;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select roleID, roleName\n"
                        + "from roleUser";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    roleID = rs.getString("roleID");
                    roleName = rs.getString("roleName");
                    rDto = new RoleDTO(roleID, roleName);
                    result.add(rDto);
                }
            }
        }  finally {
            closeConnection();
        }
        return result;
    }

    public String selectRoleNameByRoleID(String roleName) throws Exception {
        String result = null;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select roleID\n"
                        + "from roleUser\n"
                        + "where roleName = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, roleName);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = rs.getString("roleID");
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
