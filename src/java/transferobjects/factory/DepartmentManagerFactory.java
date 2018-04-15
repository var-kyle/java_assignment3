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
import transferobjects.DepartmentManager;
import transferobjects.builder.DepartmentManagerBuilder;

/**
 *
 * @author kyle
 */
public class DepartmentManagerFactory extends AbstractFactory<DepartmentManager> {

    @Override
    public DepartmentManager createFromResultSet(ResultSet rs) {
        try {
            DepartmentManagerBuilder builder = new DepartmentManagerBuilder();
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
    public DepartmentManager createFromMap(Map<String, String[]> map) {
        DepartmentManagerBuilder builder = new DepartmentManagerBuilder();
        return builder
                .setEmployeeNumber(map)
                .setDepartmentNumber(map)
                .setFromDate(map)
                .setToDate(map)
                .get();
    }

}
