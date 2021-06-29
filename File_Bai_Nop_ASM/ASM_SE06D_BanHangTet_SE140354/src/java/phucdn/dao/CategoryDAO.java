/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import phucdn.db.MyConnection;
import phucdn.dtos.CategoryDTO;

/**
 *
 * @author phucd
 */
public class CategoryDAO {

    public Connection con = null;
    public PreparedStatement stm = null;
    public ResultSet rs = null;

    public void closeConnection() throws SQLException, ClassNotFoundException {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<CategoryDTO> findCategoryByCateID(String search) throws SQLException, ClassNotFoundException {
        List<CategoryDTO> result = null;
        CategoryDTO dto = null;
        String categoryID;
        String categoryName;
        String description;
        boolean status;
        result = new ArrayList<>();
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "select categoryID, categoryName, description,status\n"
                        + "from Category where categoryID like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    categoryID = rs.getString("categoryID");
                    categoryName = rs.getString("categoryName");
                    description = rs.getString("description");
                    status = rs.getBoolean("status");
                    dto = new CategoryDTO(categoryID, categoryName, description, status);
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

    public boolean updateCategory(CategoryDTO dto) throws Exception {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "update Category set categoryName = ?, description = ?,"
                        + "status = ?\n"
                        + "where categoryID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getCategoryName());
                stm.setString(2, dto.getDescription());
                stm.setBoolean(3, dto.isStatus());
                stm.setString(4, dto.getCategoryID());
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            System.out.println("Error at updateCategory: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean deleteCategory(String id) throws Exception {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "delete Category where categoryID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            System.out.println("Error at deleteCategory: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }

    public CategoryDTO findCateByPrimaryKey(String id) throws Exception {
        CategoryDTO result = null;
        String categoryName;
        String description;
        boolean status;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "select categoryName, description,status\n"
                        + "from Category where categoryID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    categoryName = rs.getString("categoryName");
                    description = rs.getString("description");
                    status = rs.getBoolean("status");
                    result = new CategoryDTO(id, categoryName, description, status);
                }
            }
        } catch (Exception e) {
            System.out.println("Error at findCateByPrimaryKey: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insertCate(CategoryDTO dto) throws Exception {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "insert Category(categoryID, categoryName, description, status, dateOfPost) \n"
                        + "values (?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getCategoryID());
                stm.setString(2, dto.getCategoryName());
                stm.setString(3, dto.getDescription());
                stm.setBoolean(4, dto.isStatus());
                stm.setTimestamp(5, dto.getDateOfPost());
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean deleteCategory2(String id) throws Exception {
        boolean result = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "update Category set [status] = 'false' where "
                        + "categoryID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                result = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            System.out.println("Error at delete Cate 2: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public boolean reActivateCate(String id) throws Exception{
        boolean result = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "update Category set [status] = 'true' where "
                        + "categoryID =?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                result = stm.executeUpdate() >0;
            }
        } catch (Exception e) {
            System.out.println("Error at reActivateCate: ");
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return result;
    }

    public List<CategoryDTO> loadCategoryID() throws Exception {
        List<CategoryDTO> result = new ArrayList<>();
        return result;
    }

}
