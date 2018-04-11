/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects.builder;

import java.sql.ResultSet;
import java.sql.SQLException;
import transferobjects.Department;

/**
 *
 * @author kyle
 */
public class DepartmentBuilder {
    private static final String COL_DEPT_NAME = "dept_name";
    private static final String COL_DEPT_NO = "dept_no";
    private Department dept = new Department();
    
    public DepartmentBuilder setName(ResultSet rs) throws SQLException{
        dept.setName(rs.getString(COL_DEPT_NAME));
        return this;
    }
    
    public DepartmentBuilder setDepartmentNumber(ResultSet rs) throws SQLException{
        dept.setNumber(rs.getString(COL_DEPT_NO));        
        return this;
    }
    
    public Department get(){
        return dept;
    }
}
