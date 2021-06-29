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
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author ASUS
 */
public class DBUitls implements Serializable{
    public static Connection con;
    

    public static Connection  makeConnection_1() throws Exception {
        Context context=new InitialContext();
        Context tomcatContext= (Context)context.lookup("java:comp/env");
        DataSource ds=(DataSource)tomcatContext.lookup("Lab231_P0018");
        Connection con=ds.getConnection(); 
        return con;
    }
    
//    public static Connection makeConnection_1() throws SQLException, ClassNotFoundException, Exception{
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Lab231_P0018_BookStore;instanceName=phucdo2601", "sa", "12345678");
//        System.out.println("Connection is OK!");
//        return con;
//    }
    
    public static void main(String[] args) throws Exception{
        makeConnection_1();
    }
}
