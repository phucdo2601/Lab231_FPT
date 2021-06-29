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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import phucdn.db.MyConnection;
import phucdn.dtos.AccountDTO;

/**
 *
 * @author phucd
 */
public class AccountDAO implements Serializable {

    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;

    public void closeConnection() throws SQLException, ClassNotFoundException, Exception {
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
            System.out.println("Error at closeConnection:");
            e.printStackTrace();
        }
    }

    public String checkLogin(String username, String password) throws SQLException, ClassNotFoundException, Exception {
        String role = "failed";
        AccountDTO accDTO = new AccountDTO();
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "select roleID, status from Account where username = ? \n"
                        + "COLLATE SQL_Latin1_General_CP1_CS_AS and password = ? \n"
                        + "COLLATE SQL_Latin1_General_CP1_CS_AS";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    boolean isStatus = rs.getBoolean("status");
                    if (isStatus == true) {
                        role = rs.getString("roleID");
                    } else {
                        role = "failedStatus";
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error at checkLogin: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return role;
    }

    public List<AccountDTO> findByLikeUsername(String search) throws Exception {
        List<AccountDTO> result = null;
        String username;
        String address;
        String fullname;
        String phone;
        String email;
        boolean status;
        AccountDTO acc = null;
        try {
            con = MyConnection.getConnection();
            String sql = "select username, fullname, address, phone, email, status\n"
                    + "from Account where roleID = 'user' and username LIKE ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + search + "%");
            rs = stm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                username = rs.getString("username");
                fullname = rs.getString("fullname");
                address = rs.getString("address");
                phone = rs.getString("phone");
                email = rs.getString("email");
                status = rs.getBoolean("status");
                acc = new AccountDTO(username, fullname, address, phone, email, status);
                result.add(acc);
            }
        } catch (Exception e) {
            System.out.println("Error at findByLikeUsername: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean updateAccount(AccountDTO dto) throws Exception {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "update Account set fullname = ?, address = ?,"
                        + " phone =?, email=?, status=?\n"
                        + "where username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getFullname());
                stm.setString(2, dto.getAddress());
                stm.setString(3, dto.getPhone());
                stm.setString(4, dto.getEmail());
                stm.setBoolean(5, dto.isStatus());
                stm.setString(6, dto.getUsername());
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            System.out.println("Error at updateAccount: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateAccount2(String username, String fullname, String address,
            String phone, String email, boolean status) throws Exception {
        boolean check = true;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "update Account set fullname = ?, address = ?,"
                        + " phone =?, email=?, status=?\n"
                        + " where username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, fullname);
                stm.setString(2, address);
                stm.setString(3, phone);
                stm.setString(4, email);
                stm.setBoolean(5, status);
                stm.setString(6, username);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error at updateAccount: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean deleteAccount(String search) throws Exception {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "delete Account where username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, search);
                check = stm.executeUpdate() > 0;

            }
        } catch (Exception e) {
            System.out.println("Error at deleteAccount: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }

    public AccountDTO findAccByPrimaryKey(String id) throws Exception {
        AccountDTO accDTO = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "select fullname, address, phone, email, status\n"
                        + "from Account where username =?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullname = rs.getString("fullname");
                    String address = rs.getString("address");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    boolean status = rs.getBoolean("status");
//                    String username = rs.getString("username");
                    accDTO = new AccountDTO(id, fullname, address, phone, email, status);

                }
            }
        } catch (Exception e) {
            System.out.println("Error at findAccByPrimaryKey: ");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return accDTO;
    }

    public boolean insertAccount(AccountDTO dto) throws Exception {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "insert into Account(username, password, "
                        + "fullname, address, email, phone, roleID, status, dateOfPost)\n"
                        + "values(?,?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getUsername());
                stm.setString(2, dto.getPassword());
                stm.setString(3, dto.getFullname());
                stm.setString(4, dto.getAddress());
                stm.setString(5, dto.getEmail());
                stm.setString(6, dto.getPhone());
                stm.setString(7, dto.getRoleID());
                stm.setBoolean(8, dto.isStatus());
                stm.setTimestamp(9, dto.getDateOfPost());
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public AccountDTO userFindByPrimaryKey(String id) throws Exception {
        AccountDTO result = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "select fullname, address, phone, email, status\n"
                        + "from Account where username =?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullname = rs.getString("fullname");
                    String address = rs.getString("address");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    result = new AccountDTO(id, fullname, address, phone, email);
                }
            }
        } catch (Exception e) {
            System.out.println("Error at userFindByPrimaryKey");
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public boolean deleteAccount2(String id) throws Exception{
        boolean result = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
               String sql = "update Account set [status] = 'false' where username = ?";
               stm = con.prepareStatement(sql);
               stm.setString(1, id);
               result = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            closeConnection();
        }
        return result;
    }
    
    public boolean reActivateAcc(String id) throws Exception{
        boolean result = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "update Account set [status] = 'true' where username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                result = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            System.out.println("Error at reActivateAcc: ");
            e.printStackTrace();
        }
        finally{
            closeConnection();
        }
        return result;
    }

}
