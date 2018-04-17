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
import transferobjects.Employee;

/**
 * builder to create employee objects from a result set or map
 *
 * @author kyle, keith
 */
public class EmployeeBuilder {
    private static final String COL_EMP_NO = "emp_no";
    private static final String COL_FIRST_NAME = "first_name";
    private static final String COL_LAST_NAME = "last_name";
    private static final String COL_GENDER = "gender";
    private static final String COL_BIRTH_DATE = "birth_date";
    private static final String COL_HIRE_DATE = "hire_date";
    private Employee employee = new Employee();
    
    /**
     * sets the employee number from a result set
     * @param rs
     * @return
     * @throws SQLException 
     */
    public EmployeeBuilder setEmployeeNumber(ResultSet rs) throws SQLException{
        employee.setEmployeeNumber(rs.getInt(COL_EMP_NO));
        return this;
    }
    
    /**
     * sets the first name from a result set
     * @param rs
     * @return
     * @throws SQLException 
     */
    public EmployeeBuilder setFirstName(ResultSet rs) throws SQLException{
        employee.setFirstName(rs.getString(COL_FIRST_NAME));        
        return this;
    }
    
    /**
     * sets the last name from a result set
     * @param rs
     * @return
     * @throws SQLException 
     */
    public EmployeeBuilder setLastName(ResultSet rs) throws SQLException {
        employee.setLastName(rs.getString(COL_LAST_NAME));
        return this;
    }
    
    /**
     * sets the gender from a result set
     * @param rs
     * @return
     * @throws SQLException 
     */
    public EmployeeBuilder setGender(ResultSet rs) throws SQLException {
        employee.setGender(rs.getString(COL_GENDER));
        return this;
    }
    
    /**
     * sets the birht date from a result set
     * @param rs
     * @return
     * @throws SQLException 
     */
    public EmployeeBuilder setBirthDate(ResultSet rs) throws SQLException {
        employee.setBirthDate(rs.getDate(COL_BIRTH_DATE));
        return this;
    }
    
    /**
     * sets the hire date from a result set
     * @param rs
     * @return
     * @throws SQLException 
     */
    public EmployeeBuilder setHireDate(ResultSet rs) throws SQLException {
        employee.setHireDate(rs.getDate(COL_HIRE_DATE));
        return this;
    }
    
    /**
     * sets the employee number from a map
     * @param map
     * @return
     */
    public EmployeeBuilder setEmployeeNumber(Map<String, String[]> map) {
        if (map.containsKey(COL_EMP_NO))
            employee.setEmployeeNumber(Integer.parseInt(map.get(COL_EMP_NO)[0]));
        return this;
    }
    
    /**
     * sets the first name from a map
     * @param map
     * @return
     */
    public EmployeeBuilder setFirstName(Map<String, String[]> map) {
        employee.setFirstName(map.get(COL_FIRST_NAME)[0]);        
        return this;
    }
    
    /**
     * sets the last name from a map
     * @param map
     * @return
     */
    public EmployeeBuilder setLastName(Map<String, String[]> map) {
        employee.setLastName(map.get(COL_LAST_NAME)[0]);
        return this;
    }
    
    /**
     * sets the gender from a map
     * @param map
     * @return
     */
    public EmployeeBuilder setGender(Map<String, String[]> map) {
        employee.setGender(map.get(COL_GENDER)[0]);
        return this;
    }
    
    /**
     * sets the birth date from a map
     * @param map
     * @return
     */
    public EmployeeBuilder setBirthDate(Map<String, String[]> map) {
        employee.setBirthDate(Date.valueOf(map.get(COL_BIRTH_DATE)[0]));
        return this;
    }
    
    /**
     * sets the hire date from a map
     * @param map
     * @return
     */
    public EmployeeBuilder setHireDate(Map<String, String[]> map) {
        employee.setHireDate(Date.valueOf(map.get(COL_HIRE_DATE)[0]));
        return this;
    }
    
    /**
     * gets the built employee object
     * @return 
     */
    public Employee get(){
        return employee;
    }
}
