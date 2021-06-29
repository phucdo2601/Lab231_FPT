/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import phucdn.db.DBUtils;
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
    PromoStatusDAO pmsDAO = new PromoStatusDAO();
    RoleUserDAO ruDAO = new RoleUserDAO();

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
            con = DBUtils.makeConnection_1();
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
    
    public UserDTO loadUserByUserID(String userLog)
            throws Exception {
        
        UserDTO dto = null;
        String userID;
        String password;
        String fullname;
        String email;
        String phone;
        String imgURL;
        String roleID;
        String status;
        String promoStatus;
        int rankPromo;
        Date dateOfCreate;
        Date dateOfAddPromo;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select userID, [password],fullname, phone, email, imgUrl, "
                        + "roleID, [status], promoStatus, rankPromo, "
                        + "dateOfCreate, dateOfAddPromo\n"
                        + "from [user]\n"
                        + "where userID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, userLog);
                rs = stm.executeQuery();
                while (rs.next()) {
                    userID = rs.getString("userID");
                    password = rs.getString("password");
                    fullname = rs.getString("fullname");
                    email = rs.getString("email");
                    phone = rs.getString("phone");
                    imgURL = rs.getString("imgUrl");
                    roleID = rs.getString("roleID");
                    status = rs.getString("status");
                    promoStatus = rs.getString("promoStatus");
                    rankPromo = rs.getInt("rankPromo");
                    dateOfCreate = rs.getDate("dateOfCreate");
                    dateOfAddPromo = rs.getDate("dateOfAddPromo");
                    dto = new UserDTO(userID, password, fullname, email, phone, imgURL, roleID, status, promoStatus, rankPromo, dateOfCreate, dateOfAddPromo);
                }
            }
        }  finally {
            closeConnection();
        }
        return dto;
    }

    public List<UserDTO> loadAllUser()
            throws Exception {
        List<UserDTO> result = new ArrayList<>();
        UserDTO dto = null;
        String userID;
        String fullname;
        String email;
        String phone;
        String imgURL;
        String roleID;
        String status;
        String promoStatus;
        int rankPromo;
        Date dateOfCreate;
        Date dateOfAddPromo;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select userID, fullname, phone, email, imgUrl, "
                        + "roleID, [status], promoStatus, rankPromo, "
                        + "dateOfCreate, dateOfAddPromo\n"
                        + "from [user]\n";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    userID = rs.getString("userID");
                    fullname = rs.getString("fullname");
                    email = rs.getString("email");
                    phone = rs.getString("phone");
                    imgURL = rs.getString("imgUrl");
                    roleID = rs.getString("roleID");
                    status = rs.getString("status");
                    promoStatus = rs.getString("promoStatus");
                    rankPromo = rs.getInt("rankPromo");
                    dateOfCreate = rs.getDate("dateOfCreate");
                    dateOfAddPromo = rs.getDate("dateOfAddPromo");
                    dto = new UserDTO(userID, null, fullname, email, phone, imgURL, roleID, status, promoStatus, rankPromo, dateOfCreate, dateOfAddPromo);
                    result.add(dto);
                }
            }
        }  finally {
            closeConnection();
        }
        return result;
    }

    public List<UserDTO> loadUserByRoleID(String roleID)
            throws Exception {
        List<UserDTO> result = new ArrayList<>();
        UserDTO dto = null;
        String userID;
        String fullname;
        String email;
        String phone;
        String imgURL;
        String status;
        String promoStatus;
        int rankPromo;
        Date dateOfCreate;
        Date dateOfAddPromo;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select userID, fullname, phone, email, imgUrl, "
                        + "roleID, [status], promoStatus, rankPromo, "
                        + "dateOfCreate, dateOfAddPromo\n"
                        + "from [user]\n"
                        + "where roleID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, roleID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    userID = rs.getString("userID");
                    fullname = rs.getString("fullname");
                    email = rs.getString("email");
                    phone = rs.getString("phone");
                    imgURL = rs.getString("imgUrl");
                    roleID = rs.getString("roleID");
                    status = rs.getString("status");
                    promoStatus = rs.getString("promoStatus");
                    rankPromo = rs.getInt("rankPromo");
                    dateOfCreate = rs.getDate("dateOfCreate");
                    dateOfAddPromo = rs.getDate("dateOfAddPromo");
                    dto = new UserDTO(userID, null, fullname, email, phone, imgURL, roleID, status, promoStatus, rankPromo, dateOfCreate, dateOfAddPromo);
                    result.add(dto);
                }
            }
        }  finally {
            closeConnection();
        }
        return result;
    }

    public boolean adminCreateAccount(UserDTO dto)
            throws Exception {
        boolean result = false;
        
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "insert into [user] (userID, [password], \n"
                        + "fullname, phone, [email], [imgUrl], [roleID], \n"
                        + "[status], [promoStatus], [dateOfCreate])\n"
                        + "values (?,?,?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getUserID());
                stm.setString(2, EncryptWithSHA256.hassPassBySHA256(dto.getPassword()));
                stm.setString(3, dto.getFullname());
                stm.setString(4, dto.getPhone());
                stm.setString(5, dto.getEmail());
                stm.setString(6, dto.getImgURL());
                stm.setString(7, dto.getRoleID());
                stm.setString(8, dto.getStatus());
                stm.setString(9, dto.getPromoStatus());
                stm.setDate(10, dto.getDateOfCreate());
                result = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<UserDTO> findUserLikeByFullname(String search)
            throws Exception {
        List<UserDTO> result = new ArrayList<>();
        UserDTO dto = null;
        String userID;
        String fullname;
        String email;
        String phone;
        String imgURL;
        String roleID;
        String status;
        String promoStatus;
        int rankPromo;
        Date dateOfCreate;
        Date dateOfAddPromo;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select userID, fullname, phone, \n"
                        + "email, imgUrl, roleID, [status], \n"
                        + "promoStatus, rankPromo, \n"
                        + "dateOfCreate, dateOfAddPromo\n"
                        + "from [user]\n"
                        + "where fullname like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    userID = rs.getString("userID");
                    fullname = rs.getString("fullname");
                    email = rs.getString("email");
                    phone = rs.getString("phone");
                    imgURL = rs.getString("imgUrl");
                    roleID = rs.getString("roleID");
                    status = rs.getString("status");
                    promoStatus = rs.getString("promoStatus");
                    rankPromo = rs.getInt("rankPromo");
                    dateOfCreate = rs.getDate("dateOfCreate");
                    dateOfAddPromo = rs.getDate("dateOfAddPromo");
                    dto = new UserDTO(userID, null, fullname, email, phone, imgURL, roleID, status, promoStatus, rankPromo, dateOfCreate, dateOfAddPromo);
                    result.add(dto);
                }
            }
        }  finally {
            closeConnection();
        }
        return result;
    }

    public boolean updateAccount(UserDTO dto)
            throws Exception {
        boolean result = false;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "update [user]\n"
                        + "set [password] = ?, fullname = ?, phone =?,\n"
                        + "email = ?, imgUrl = ?\n"
                        + "where userID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, EncryptWithSHA256.hassPassBySHA256(dto.getPassword()));
                stm.setString(2, dto.getFullname());
                stm.setString(3, dto.getPhone());
                stm.setString(4, dto.getEmail());
                stm.setString(5, dto.getImgURL());
                stm.setString(6, dto.getUserID());
                result = stm.executeUpdate() > 0;
            }
        }  finally {
            closeConnection();
        }
        return result;
    }

    public boolean deleteAccount(String userID)
            throws Exception {
        boolean result = false;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "update [user]\n"
                        + "set status = 'InActive'\n"
                        + "where userID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, userID);
                result = stm.executeUpdate() > 0;
            }
        }  finally {
            closeConnection();
        }
        return result;
    }

    public boolean reActiveAcc(String userID)
            throws Exception {
        boolean result = false;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "update [user]\n"
                        + "set status = 'Active'\n"
                        + "where userID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, userID);
                result = stm.executeUpdate() > 0;
            }
        }  finally {
            closeConnection();
        }
        return result;
    }
    
    public boolean adminUpRole(String user)
            throws Exception{
        boolean result = false;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "update [user]\n"
                        + "set roleID = ?\n"
                        + "where userID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, ruDAO.loadAdminRole());
                stm.setString(2, user);
                result = stm.executeUpdate() > 0;
            }
        }  finally {
            closeConnection();
        }
        return result;
    }

    public boolean addAccToPromoList(String userIdUp, int point)
            throws Exception {
        boolean result = false;
        long mills = System.currentTimeMillis();
        Date dateOfAddPromo = new Date(mills);
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "update [user]\n"
                        + "set promoStatus = ?, rankPromo = ?, dateOfAddPromo = ?\n"
                        + "where userID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, pmsDAO.loadProStaActiveID());
                stm.setInt(2, point);
                stm.setDate(3, dateOfAddPromo);
                stm.setString(4, userIdUp);
                result = stm.executeUpdate() > 0;
            }
        }  finally {
            closeConnection();
        }
        return result;
    }

    public List<UserDTO> loadPromotionLists()
            throws Exception {
        List<UserDTO> result = new ArrayList<>();
        UserDTO dto = null;
        String userID;
        String fullname;
        String email;
        String phone;
        String imgURL;
        String roleID;
        String status;
        String promoStatus;
        int rankPromo;
        Date dateOfCreate;
        Date dateOfAddPromo;
        try {
            con = DBUtils.makeConnection_1();
            if (con != null) {
                String sql = "select userID, fullname, phone, email, imgUrl, "
                        + "roleID, [status], promoStatus, rankPromo, "
                        + "dateOfCreate, dateOfAddPromo\n"
                        + "from [user]\n"
                        + "where promoStatus = ?\n"
                        + "ORDER BY dateOfAddPromo ";
                stm = con.prepareStatement(sql);
                stm.setString(1, pmsDAO.loadProStaActiveID());
                rs = stm.executeQuery();
                while (rs.next()) {
                    userID = rs.getString("userID");
                    fullname = rs.getString("fullname");
                    email = rs.getString("email");
                    phone = rs.getString("phone");
                    imgURL = rs.getString("imgUrl");
                    roleID = rs.getString("roleID");
                    status = rs.getString("status");
                    promoStatus = rs.getString("promoStatus");
                    rankPromo = rs.getInt("rankPromo");
                    dateOfCreate = rs.getDate("dateOfCreate");
                    dateOfAddPromo = rs.getDate("dateOfAddPromo");
                    dto = new UserDTO(userID, null, fullname, email, phone, imgURL, roleID, status, promoStatus, rankPromo, dateOfCreate, dateOfAddPromo);
                    result.add(dto);
                }
            }

        }  finally {
            closeConnection();
        }
        return result;
    }

}
