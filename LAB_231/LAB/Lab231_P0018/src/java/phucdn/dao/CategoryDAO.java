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
import phucdn.dto.object.CategoryDTO;

/**
 *
 * @author ASUS
 */
public class CategoryDAO implements Serializable {

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

    public List<CategoryDTO> loadAllCates()
            throws Exception {
        List<CategoryDTO> result = new ArrayList<>();
        CategoryDTO dto = null;
        String cateID = null;
        String cateName = null;

        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "select cateID, cateName\n"
                        + "from category";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    cateID = rs.getString("cateID");
                    cateName = rs.getString("cateName");
                    dto = new CategoryDTO(cateID, cateName);
                    result.add(dto);
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }

    public String getCateIDByCateName(String id)
            throws Exception {
        String result = null;
        try {
            con = DBUitls.makeConnection_1();
            if (con != null) {
                String sql = "select cateID\n"
                        + "from category\n"
                        + "where cateName = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = rs.getString("cateID");
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return result;
    }
}
