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
 * class to build a department object from a result set or a map
 *
 * @author kyle, keith
 */
public class DepartmentBuilder {
    private static final String COL_DEPT_NAME = "dept_name";
    private static final String COL_DEPT_NO = "dept_no";
    private Department dept = new Department();
    
    /**
     * sets the department name from a result set
     * @param rs
     * @return
     * @throws SQLException 
     */
    public DepartmentBuilder setName(ResultSet rs) throws SQLException{
        dept.setName(rs.getString(COL_DEPT_NAME));
        return this;
    }
    
    /**
     * sets the department number from a result set
     * @param rs
     * @return
     * @throws SQLException 
     */
    public DepartmentBuilder setDepartmentNumber(ResultSet rs) throws SQLException{
        dept.setNumber(rs.getString(COL_DEPT_NO));        
        return this;
    }
    
    /**
     * sets the department name from a map
     * @param map
     * @return 
     */
    public DepartmentBuilder setName(Map<String, String[]> map) {
        dept.setName(map.get(COL_DEPT_NAME)[0]);
        return this;
    }
    
    /**
     * sets the department name from a map
     * @param map
     * @return 
     */
    public DepartmentBuilder setDepartmentNumber(Map<String, String[]> map) {
        dept.setNumber(map.get(COL_DEPT_NO)[0]);        
        return this;
    }
    
    /**
     * gets the built department
     * @return 
     */
    public Department get(){
        return dept;
    }
}
