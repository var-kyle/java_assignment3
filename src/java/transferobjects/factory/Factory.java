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
 *
 * @author kyle
 */
public interface Factory<T> {
    T createFromResultSet(ResultSet rs);
    List<T> createListFromResultSet(ResultSet rs);
    T createFromMap(Map<String, String[]> map);
}
