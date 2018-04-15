/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects.builder;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import transferobjects.Salary;

/**
 *
 * @author kyle
 */
public class SalaryBuilder {
    private static final String COL_EMP_NO = "emp_no";
    private static final String COL_SALARY = "salary";
    private static final String COL_FROM_DATE = "from_date";
    private static final String COL_TO_DATE = "to_date";
    private static final String MAP_FROM_DATE = "salary_from_date";
    private static final String MAP_TO_DATE = "salary_to_date";
    private Salary salary = new Salary();
    
    public SalaryBuilder setEmployeeNumber(ResultSet rs) throws SQLException{
        salary.setEmployeeNumber(rs.getInt(COL_EMP_NO));
        return this;
    }
    
    public SalaryBuilder setSalary(ResultSet rs) throws SQLException{
        salary.setSalary(rs.getInt(COL_SALARY));        
        return this;
    }
    
    public SalaryBuilder setFromDate(ResultSet rs) throws SQLException {
        salary.setFromDate(rs.getDate(COL_FROM_DATE));
        return this;
    }
    
    public SalaryBuilder setToDate(ResultSet rs) throws SQLException {
        salary.setToDate(rs.getDate(COL_TO_DATE));
        return this;
    }
    
    public SalaryBuilder setEmployeeNumber(Map<String, String[]> map) {
        if (map.containsKey(COL_EMP_NO))
            salary.setEmployeeNumber(Integer.parseInt(map.get(COL_EMP_NO)[0]));
        return this;
    }
    
    public SalaryBuilder setSalary(Map<String, String[]> map) {
        salary.setSalary(Integer.parseInt(map.get(COL_SALARY)[0]));        
        return this;
    }
    
    public SalaryBuilder setFromDate(Map<String, String[]> map) {
        salary.setFromDate(Date.valueOf(map.get(MAP_FROM_DATE)[0]));
        return this;
    }
    
    public SalaryBuilder setToDate(Map<String, String[]> map) {
        salary.setToDate(Date.valueOf(map.get(MAP_TO_DATE)[0]));
        return this;
    }
    
    public Salary get(){
        return salary;
    }
}
