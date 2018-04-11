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
import transferobjects.DepartmentEmployee;
import transferobjects.builder.DepartmentEmployeeBuilder;

/**
 *
 * @author kyle
 */
public class DepartmentEmployeeFactory extends AbstractFactory<DepartmentEmployee> {

    @Override
    public DepartmentEmployee createFromResultSet(ResultSet rs) {
        try {
            DepartmentEmployeeBuilder builder = new DepartmentEmployeeBuilder();
            return builder
                    .setEmployeeNumber(rs)
                    .setDepartmentNumber(rs)
                    .setFromDate(rs)
                    .setToDate(rs)
                    .get();                    
        } catch (SQLException ex) {
            Logger.getLogger(TitleFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public DepartmentEmployee createFromMap(Map<String, String[]> map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
