/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author kyle
 */
public class DataSource {
    private javax.sql.DataSource ds;    
    private static DataSource singleton;
    
    private DataSource(){}
   
    private void getDataSource(){
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            ds = (javax.sql.DataSource) envContext.lookup("jdbc/Employees");
        } catch (NamingException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Only use one connection for this application, prevent memory leaks.
     * @return 
     */
    private Connection createConnection() {
        
        Connection conn = null;
        
        try {
            conn = ds.getConnection();
        } catch(SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
    }    
    
    public static Connection getConnection(){
        if (singleton == null){
            singleton = new DataSource();
            singleton.getDataSource();
        }
        return singleton.createConnection();
    }
}
