/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects.builder;

import java.sql.ResultSet;
import java.sql.SQLException;
import transferobjects.DepartmentEmployee;

/**
 *
 * @author kyle
 */
public class DepartmentEmployeeBuilder {
    private static final String COL_EMP_NO = "emp_no";
    private static final String COL_DEPT_NO = "dept_no";
    private static final String COL_FROM_DATE = "from_date";
    private static final String COL_TO_DATE = "to_date";
    private DepartmentEmployee deptEmp = new DepartmentEmployee();
    
    public DepartmentEmployeeBuilder setEmployeeNumber(ResultSet rs) throws SQLException{
        deptEmp.setEmployeeNumber(rs.getInt(COL_EMP_NO));
        return this;
    }
    
    public DepartmentEmployeeBuilder setDepartmentNumber(ResultSet rs) throws SQLException{
        deptEmp.setDepartmentNumber(rs.getString(COL_DEPT_NO));        
        return this;
    }
    
    public DepartmentEmployeeBuilder setFromDate(ResultSet rs) throws SQLException {
        deptEmp.setFromDate(rs.getDate(COL_FROM_DATE));
        return this;
    }
    
    public DepartmentEmployeeBuilder setToDate(ResultSet rs) throws SQLException {
        deptEmp.setToDate(rs.getDate(COL_TO_DATE));
        return this;
    }
    
    public DepartmentEmployee get() {
        return deptEmp;
    }
}
