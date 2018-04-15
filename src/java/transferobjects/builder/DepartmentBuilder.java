/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects.builder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
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
    
    public DepartmentBuilder setName(Map<String, String[]> map) {
        dept.setName(map.get(COL_DEPT_NAME)[0]);
        return this;
    }
    
    public DepartmentBuilder setDepartmentNumber(Map<String, String[]> map) {
        dept.setNumber(map.get(COL_DEPT_NO)[0]);        
        return this;
    }
    
    public Department get(){
        return dept;
    }
}
