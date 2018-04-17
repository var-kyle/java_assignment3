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
 * builds salary objects from results sets or parameter maps
 *
 * @author kyle, keith
 */
public class SalaryBuilder {
    private static final String COL_EMP_NO = "emp_no";
    private static final String COL_SALARY = "salary";
    private static final String COL_FROM_DATE = "from_date";
    private static final String COL_TO_DATE = "to_date";
    private static final String MAP_FROM_DATE = "salary_from_date";
    private static final String MAP_TO_DATE = "salary_to_date";
    private Salary salary = new Salary();
    
    /**
     * sets the employee number from a result set
     * @param rs
     * @return
     * @throws SQLException 
     */
    public SalaryBuilder setEmployeeNumber(ResultSet rs) throws SQLException{
        salary.setEmployeeNumber(rs.getInt(COL_EMP_NO));
        return this;
    }
    
    /**
     * sets the salary from a result set
     * @param rs
     * @return
     * @throws SQLException 
     */
    public SalaryBuilder setSalary(ResultSet rs) throws SQLException{
        salary.setSalary(rs.getInt(COL_SALARY));        
        return this;
    }
    
    /**
     * sets the from date from a result set
     * @param rs
     * @return
     * @throws SQLException 
     */
    public SalaryBuilder setFromDate(ResultSet rs) throws SQLException {
        salary.setFromDate(rs.getDate(COL_FROM_DATE));
        return this;
    }
    
    /**
     * sets the to date from a result set
     * @param rs
     * @return
     * @throws SQLException 
     */
    public SalaryBuilder setToDate(ResultSet rs) throws SQLException {
        salary.setToDate(rs.getDate(COL_TO_DATE));
        return this;
    }
    
    /**
     * sets the employee number from a map
     * @param map
     * @return 
     */
    public SalaryBuilder setEmployeeNumber(Map<String, String[]> map) {
        if (map.containsKey(COL_EMP_NO))
            salary.setEmployeeNumber(Integer.parseInt(map.get(COL_EMP_NO)[0]));
        return this;
    }
    
    /**
     * sets the salary from a map
     * @param map
     * @return 
     */
    public SalaryBuilder setSalary(Map<String, String[]> map) {
        salary.setSalary(Integer.parseInt(map.get(COL_SALARY)[0]));        
        return this;
    }
    
    /**
     * sets the from date from a map
     * @param map
     * @return 
     */
    public SalaryBuilder setFromDate(Map<String, String[]> map) {
        salary.setFromDate(Date.valueOf(map.get(MAP_FROM_DATE)[0]));
        return this;
    }
    
    
    /**
     * sets the to date from a map
     * @param map
     * @return 
     */
    public SalaryBuilder setToDate(Map<String, String[]> map) {
        salary.setToDate(Date.valueOf(map.get(MAP_TO_DATE)[0]));
        return this;
    }
    
    /**
     * gets a built salary object
     * @return 
     */
    public Salary get(){
        return salary;
    }
}
