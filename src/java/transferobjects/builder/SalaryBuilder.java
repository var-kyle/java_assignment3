/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects.builder;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public Salary get(){
        return salary;
    }
}
