/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.Department;
import transferobjects.builder.DepartmentBuilder;

/**
 *
 * @author kyle
 */
public class DepartmentFactory extends AbstractFactory<Department> {
    
    @Override
    public Department createFromResultSet(ResultSet rs) {
        try {
            DepartmentBuilder builder = new DepartmentBuilder();
            return builder
                    .setDepartmentNumber(rs)
                    .setName(rs)
                    .get();
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Department createFromMap(Map<String, String[]> map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
