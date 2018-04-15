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
import transferobjects.Salary;
import transferobjects.builder.SalaryBuilder;

/**
 *
 * @author kyle
 */
public class SalaryFactory extends AbstractFactory<Salary> {

    @Override
    public Salary createFromResultSet(ResultSet rs) {
        try {
            SalaryBuilder builder = new SalaryBuilder();
            return builder
                    .setEmployeeNumber(rs)
                    .setSalary(rs)
                    .setFromDate(rs)
                    .setToDate(rs)
                    .get();
        } catch (SQLException ex) {
            Logger.getLogger(TitleFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Salary createFromMap(Map<String, String[]> map) {
        SalaryBuilder builder = new SalaryBuilder();
        return builder
                .setEmployeeNumber(map)
                .setSalary(map)
                .setFromDate(map)
                .setToDate(map)
                .get();
    }

}
