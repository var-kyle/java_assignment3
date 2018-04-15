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
import transferobjects.DepartmentManager;

/**
 *
 * @author kyle
 */
public class DepartmentManagerBuilder {
    private static final String COL_EMP_NO = "emp_no";
    private static final String COL_DEPT_NO = "dept_no";
    private static final String COL_FROM_DATE = "from_date";
    private static final String COL_TO_DATE = "to_date";
    private static final String MAP_FROM_DATE = "dept_from_date";
    private static final String MAP_TO_DATE = "dept_to_date";
    private DepartmentManager deptMngr = new DepartmentManager();
    
    public DepartmentManagerBuilder setEmployeeNumber(ResultSet rs) throws SQLException{
        deptMngr.setEmployeeNumber(rs.getInt(COL_EMP_NO));
        return this;
    }
    
    public DepartmentManagerBuilder setDepartmentNumber(ResultSet rs) throws SQLException{
        deptMngr.setDepartmentNumber(rs.getString(COL_DEPT_NO));        
        return this;
    }
    
    public DepartmentManagerBuilder setFromDate(ResultSet rs) throws SQLException {
        deptMngr.setFromDate(rs.getDate(COL_FROM_DATE));
        return this;
    }
    
    public DepartmentManagerBuilder setToDate(ResultSet rs) throws SQLException {
        deptMngr.setToDate(rs.getDate(COL_TO_DATE));
        return this;
    }
    
    public DepartmentManagerBuilder setEmployeeNumber(Map<String, String[]> map) {
        if (map.containsKey(COL_EMP_NO))
            deptMngr.setEmployeeNumber(Integer.parseInt(map.get(COL_EMP_NO)[0]));
        return this;
    }
    
    public DepartmentManagerBuilder setDepartmentNumber(Map<String, String[]> map) {
        deptMngr.setDepartmentNumber(map.get(COL_DEPT_NO)[0]);        
        return this;
    }
    
    public DepartmentManagerBuilder setFromDate(Map<String, String[]> map) {
        deptMngr.setFromDate(Date.valueOf(map.get(MAP_FROM_DATE)[0]));
        return this;
    }
    
    public DepartmentManagerBuilder setToDate(Map<String, String[]> map) {
        deptMngr.setToDate(Date.valueOf(map.get(MAP_TO_DATE)[0]));
        return this;
    }
    
    public DepartmentManager get() {
        return deptMngr;
    }
}
