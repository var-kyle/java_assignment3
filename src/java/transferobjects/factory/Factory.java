/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects.factory;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 * contains methods that all factories will use
 *
 * @author kyle, keith
 */
public interface Factory<T> {
    /**
     * creates an transfer object from a result set
     * @param rs
     * @return 
     */
    T createFromResultSet(ResultSet rs);
    
    /**
     * creates a list of transfer objects from a result set
     * @param rs
     * @return 
     */
    List<T> createListFromResultSet(ResultSet rs);
    
    /**
     * creates a transfer object from a parameter map
     * @param map
     * @return 
     */
    T createFromMap(Map<String, String[]> map);
}
