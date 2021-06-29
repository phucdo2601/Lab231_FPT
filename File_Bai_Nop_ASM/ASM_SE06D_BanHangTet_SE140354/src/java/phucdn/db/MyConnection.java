/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author phucd
 */
public class MyConnection implements Serializable{
    public static Connection con = null;
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException, Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=JavaWeFptAsmBanHangTet", "sa", "12345678");
        System.out.println("Connection is OK!");
        return con;
    }
    
    public static void main(String[] args) throws Exception{
        getConnection();
    }
}
