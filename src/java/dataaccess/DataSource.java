package dataaccess;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * singleton implementation for the connection to the daatbase
 *
 * @author kyle, keith
 */
public class DataSource {
    private javax.sql.DataSource ds;    
    private static DataSource singleton;
    
    private DataSource(){}
   
    /**
     * sets the data source from values found in the context files
     */
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
    
    /**
     * returns the connection to the database using lazy loading
     * @return 
     */
    public static Connection getConnection(){
        if (singleton == null){
            singleton = new DataSource();
            singleton.getDataSource();
        }
        return singleton.createConnection();
    }
}
