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
import phucdn.db.DBUtils;
import phucdn.dto.object.RoleUserDTO;

/**
 *
 * @author ASUS
 */
public class RoleUserDAO implements Serializable {

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

    public List<RoleUserDTO> loadListRole()
            throws Exception {
        List<RoleUserDTO> result = new ArrayList<>();
        String roleUserID = null;
        String roleUserName = null;
        RoleUserDTO ruDTO = null;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select roleUserID, roleUserName\n"
                        + "from roleUser";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    roleUserID = rs.getString("roleUserID");
                    roleUserName = rs.getString("roleUserName");
                    ruDTO = new RoleUserDTO(roleUserID, roleUserName);
                    result.add(ruDTO);
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }

    public String selectRoleIDByRoleName(String roleName)
            throws Exception {
        String result = null;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select roleUserID\n"
                        + "from roleUser\n"
                        + "where roleUserName = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, roleName);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = rs.getString("roleUserID");
                }
            }

        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }

    public int countRole()
            throws Exception {
        int result = 0;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select count(roleUserID)\n"
                        + "from roleUser";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    result = rs.getInt(1);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public String loadAdminRole() {
        String result = null;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select roleUserID\n"
                        + "from roleUser\n"
                        + "where roleUserName = 'Management'";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = rs.getString("roleUserID");
                }
            }
        } catch (Exception e) {
        }
        return result;
    }
}
