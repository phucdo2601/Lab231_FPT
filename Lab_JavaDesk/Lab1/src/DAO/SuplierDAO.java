/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.SupRolde;
import DTO.Supplier;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author ASUS
 */
public class SuplierDAO {

    public static Connection cn;
    public static Statement stm;
    public static PreparedStatement pstm;
    public static ResultSet rs;

    public static Vector<Supplier> getAccounts() {
        Vector<Supplier> result = new Vector<>();
        try {
            cn = myLibrary.myConnection.makeConnection();
            if (cn != null) {
                String sql = "select [supCode],[supName]"
                        + ",[address],[collaborating]\n"
                        + "from tblSuppliers";
                stm = cn.createStatement();
                rs = stm.executeQuery(sql);
                while (rs.next()) {
                    String supCode = rs.getString("supCode");
                    String supName = rs.getString("supName");
                    String address = rs.getString("address");
                    boolean collaborating = rs.getBoolean("collaborating");
                    Supplier sp = new Supplier(supCode, supName, address, collaborating);
                    result.add(sp);
                }
            }
        } catch (Exception e) {
            if (cn == null) {
                System.out.println("SQL Server lost connected!");
            }
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                if (cn == null) {
                    System.out.println("SQL Server lost connected!");
                }
                e.printStackTrace();
            }
        }
        return result;
    }

    public static Vector<SupRolde> getRole() {
        Vector<SupRolde> result = new Vector<>();
        cn = myLibrary.myConnection.makeConnection();
        try {
            String sql = "select [supCode],[supName]"
                    + "from tblSuppliers";;
            Statement st = cn.createStatement();//cung cap cac phuong thuc de truy van voi co so du lieu
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String supCode = rs.getString("supCode");
                String supName = rs.getString("supName");
                SupRolde r = new SupRolde(supCode, supName);
                result.add(r);
            }
        } catch (SQLException e) {
            System.out.println("The name of type date is not matched with Sql Server");
        } catch (NullPointerException ex) {
            System.out.println("The data is not valid!");
            ex.printStackTrace();
        }
        return result;
    }

    public static int insertSuplier(Supplier sp) {
        int result = 0;
        try {
            cn = myLibrary.myConnection.makeConnection();
            if (cn != null) {
                String sql = "insert tblSuppliers(supCode, supName, address, "
                        + "collaborating) values\n"
                        + "(?,?,?,?)";
                pstm = cn.prepareStatement(sql);
                pstm.setString(1, sp.getSupCode());
                pstm.setString(2, sp.getSupName());
                pstm.setString(3, sp.getAddress());
                pstm.setBoolean(4, sp.isCollaborating());
                result = pstm.executeUpdate();
                
            }
        } catch (SQLException e) {
            System.out.println("SQL Server lost connected!");
        } catch (NullPointerException e) {
            System.out.println("The input is not valid!");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                if (cn == null) {
                    System.out.println("SQL Server lost connected!");
                }
                e.printStackTrace();
            }
        }
        return result;
    }

    public static int updateSuplier(Supplier sp) {
        int result = 0;
        try {
            cn = myLibrary.myConnection.makeConnection();
            if (cn != null) {
                String sql = "update tblSuppliers\n"
                        + "set supName = ?, address = ?, collaborating = ?\n"
                        + "where supCode = ?";
                pstm = cn.prepareStatement(sql);
                pstm.setString(1, sp.getSupName());
                pstm.setString(2, sp.getAddress());
                pstm.setBoolean(3, sp.isCollaborating());
                pstm.setString(4, sp.getSupCode());
                result = pstm.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("SQL Server lost connected!");
        } catch (NullPointerException e) {
            System.out.println("The input is not valid!");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                if (cn == null) {
                    System.out.println("SQL Server lost connected!");
                }
                e.printStackTrace();
            }
        }
        return result;
    }

    public static int deleteSuplier(String supCode) {
        int result = 0;
        try {
            cn = myLibrary.myConnection.makeConnection();
            if (cn != null) {
                String sql = "delete from tblSuppliers\n"
                        + "where supCode = ?";
                pstm = cn.prepareStatement(sql);
                pstm.setString(1, supCode);
                result = pstm.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("SQL Server lost connected!");
        } catch (NullPointerException e) {
            System.out.println("The input is not valid!");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                if (cn == null) {
                    System.out.println("SQL Server lost connected!");
                }
                e.printStackTrace();
            }
        }
        return result;
    }

    public Supplier getSupByID(String supCode) {
        Supplier sp = new Supplier();
        try {
            cn = myLibrary.myConnection.makeConnection();
            if (cn != null) {
                String sql = "select supCode, supName, address, collaborating\n"
                        + "from tblSuppliers\n"
                        + "where supCode = ?";
                pstm = cn.prepareStatement(sql);
                pstm.setString(1, supCode);
                rs = pstm.executeQuery();
                while (rs.next()) {                    
                    sp.setSupCode(rs.getString("supCode"));
                    sp.setSupName(rs.getString("supName"));
                    sp.setAddress(rs.getString("address"));
                    sp.setCollaborating(rs.getBoolean("collaborating"));
                    return sp;
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Server lost connected!");
        } catch (NullPointerException e) {
            System.out.println("The input is not valid!");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                if (cn == null) {
                    System.out.println("SQL Server lost connected!");
                }
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SuplierDAO sd = new SuplierDAO();

        System.out.println("=> " + sd.getAccounts());
        System.out.println("=> " + sd.getRole());
    }
}
