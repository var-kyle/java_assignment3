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
import transferobjects.Employee;
import transferobjects.builder.EmployeeBuilder;

/**
 *
 * @author kyle
 */
public class EmployeeFactory extends AbstractFactory<Employee> {

    @Override
    public Employee createFromResultSet(ResultSet rs) {
        try {
            EmployeeBuilder builder = new EmployeeBuilder();
            return builder
                    .setEmployeeNumber(rs)
                    .setFirstName(rs)
                    .setLastName(rs)
                    .setGender(rs)
                    .setBirthDate(rs)
                    .setHireDate(rs)
                    .get();
        } catch (SQLException ex) {
            Logger.getLogger(TitleFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Employee createFromMap(Map<String, String[]> map) {
        EmployeeBuilder builder = new EmployeeBuilder();
        return builder
                //.setEmployeeNumber(map)
                .setFirstName(map)
                .setLastName(map)
                .setGender(map)
                .setBirthDate(map)
                .setHireDate(map)
                .get();
    }

}
