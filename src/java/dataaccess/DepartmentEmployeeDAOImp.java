/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.DepartmentEmployee;

/**
 *
 * @author kylem
 */
public class DepartmentEmployeeDAOImp implements DepartmentEmployeeDAO {
    private static final String GET_ALL_DEPARTMENT_EMPLOYEES = "SELECT emp_no, dept_no, from_date, to_date FROM dept_emp ORDER BY emp_no LIMIT 20";
    
    @Override
    public List<DepartmentEmployee> getAll() {
        @SuppressWarnings("unchecked")
        List<DepartmentEmployee> deptEmps = Collections.EMPTY_LIST;
        DepartmentEmployee deptEmp;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement( GET_ALL_DEPARTMENT_EMPLOYEES);
            rs = pstmt.executeQuery();
            deptEmps = new ArrayList<>(100);
            while( rs.next()){
                deptEmp = new DepartmentEmployee();
                deptEmp.setEmployeeNumber(rs.getInt("emp_no"));
                deptEmp.setDepartmentNumber(rs.getString("dept_no"));
                deptEmp.setFromDate(rs.getDate("from_date"));
                deptEmp.setToDate(rs.getDate("to_date"));
                deptEmps.add(deptEmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return deptEmps;
    }

    @Override
    public DepartmentEmployee getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DepartmentEmployee getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(DepartmentEmployee item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
