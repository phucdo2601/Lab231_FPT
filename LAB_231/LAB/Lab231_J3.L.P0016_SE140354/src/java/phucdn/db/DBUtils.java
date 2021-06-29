/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucdn.db;

import java.io.Serializable;
import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author ASUS
 */
public class DBUtils implements Serializable {

    public static Connection con;

    public static Connection makeConnection_1() throws Exception {
        Context context = new InitialContext();
        Context tomcatCtx = (Context) context.lookup("java:comp/env");

        DataSource ds = (DataSource) tomcatCtx.lookup("J3.L.P0016");
        con = ds.getConnection();
        return con;
    }

    
}
