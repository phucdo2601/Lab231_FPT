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
import phucdn.dtos.object.CategoryDTO;

/**
 *
 * @author ASUS
 */
public class CategoryDAO implements Serializable {

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

    public List<CategoryDTO> getAllCategory() throws Exception {
        List<CategoryDTO> result = new ArrayList<>();
        CategoryDTO cateDTO = null;
        String cateID;
        String cateName;
        String roleBorrow;
        String description;

        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select [cateID],[cateName],\n"
                        + "[roleBorrow],[description]\n"
                        + "from category";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    cateID = rs.getString("cateID");
                    cateName = rs.getString("cateName");
                    roleBorrow = rs.getString("roleBorrow");
                    description = rs.getString("description");
                    cateDTO = new CategoryDTO(cateID, cateName, roleBorrow, description);
                    result.add(cateDTO);
                }
            }
        }  finally {
            closeConnection();
        }
        return result;
    }

    public String getCategoryIDByCateName(String cateName) throws Exception {
        String cateID = null;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select cateID "
                        + "from category "
                        + "where cateName = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, cateName);
                rs = stm.executeQuery();
                if (rs.next()) {
                    cateID = rs.getString("cateID");
                }
            }
        } finally {
            closeConnection();
        }
        return cateID;
    }

}
