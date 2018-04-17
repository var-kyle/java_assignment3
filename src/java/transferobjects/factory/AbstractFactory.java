/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * abstract implementation of the factory interface
 *
 * @author kyle, keith
 */
public abstract class AbstractFactory <T> implements Factory<T> {

    @Override
    public abstract T createFromResultSet(ResultSet rs);
    
    @Override
    public List<T> createListFromResultSet(ResultSet rs){
        List<T> results = new LinkedList<>();
        
        try {
            while( rs.next()){
                T result = createFromResultSet(rs);
                if (result != null) {
                   results.add(result); 
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbstractFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return results;
    }

    @Override
    public abstract T createFromMap(Map<String, String[]> map);
    
}
