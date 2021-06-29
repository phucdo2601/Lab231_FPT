/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myLibrary;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ASUS
 */
public class myConnection {
    
    public static Connection makeConnection(){
        Connection cn = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
                    + "databasename = Lab221ItemManagement; username = sa;"
                    + "password=12345678");
            if (cn != null) {
                System.out.println("Connection is OK!");
            }
        } catch (Exception e) {
            if(cn == null){
                System.out.println("Connection is Failed! Please check again "
                        + "connection with Sql Server in netbean and port in "
                        + "sql server 2014 configuration!");
            }
            e.printStackTrace();
        }
        return cn;
    }
    
    public static void main(String[] args) {
        myConnection cn1 = new myConnection();
        cn1.makeConnection();
    }
}
