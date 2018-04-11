/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects.builder;

import java.sql.ResultSet;
import java.sql.SQLException;
import transferobjects.Employee;

/**
 *
 * @author kyle
 */
public class EmployeeBuilder {
    private static final String COL_EMP_NO = "emp_no";
    private static final String COL_FIRST_NAME = "first_name";
    private static final String COL_LAST_NAME = "last_name";
    private static final String COL_GENDER = "gender";
    private static final String COL_BIRTH_DATE = "birth_date";
    private static final String COL_HIRE_DATE = "hire_date";
    private Employee employee = new Employee();
    
    public EmployeeBuilder setEmployeeNumber(ResultSet rs) throws SQLException{
        employee.setEmployeeNumber(rs.getInt(COL_EMP_NO));
        return this;
    }
    
    public EmployeeBuilder setFirstName(ResultSet rs) throws SQLException{
        employee.setFirstName(rs.getString(COL_FIRST_NAME));        
        return this;
    }
    
    public EmployeeBuilder setLastName(ResultSet rs) throws SQLException {
        employee.setLastName(rs.getString(COL_LAST_NAME));
        return this;
    }
    
    public EmployeeBuilder setGender(ResultSet rs) throws SQLException {
        employee.setGender(rs.getString(COL_GENDER));
        return this;
    }
    
    public EmployeeBuilder setBirthDate(ResultSet rs) throws SQLException {
        employee.setBirthDate(rs.getDate(COL_BIRTH_DATE));
        return this;
    }
    
    public EmployeeBuilder setHireDate(ResultSet rs) throws SQLException {
        employee.setHireDate(rs.getDate(COL_HIRE_DATE));
        return this;
    }
    
    public Employee get(){
        return employee;
    }
}
