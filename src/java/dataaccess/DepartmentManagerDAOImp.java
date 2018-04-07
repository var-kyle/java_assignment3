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
import transferobjects.DepartmentManager;

/**
 *
 * @author kylem
 */
public class DepartmentManagerDAOImp implements DepartmentManagerDAO {
    private static final String GET_ALL_DEPARTMENT_MANAGERS = "SELECT emp_no, dept_no, from_date, to_date FROM dept_manager ORDER BY emp_no LIMIT 20";

    @Override
    public List<DepartmentManager> getAll() {
        @SuppressWarnings("unchecked")
        List<DepartmentManager> deptManagers = Collections.EMPTY_LIST;
        DepartmentManager deptManager;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement( GET_ALL_DEPARTMENT_MANAGERS);
            rs = pstmt.executeQuery();
            deptManagers = new ArrayList<>(100);
            while( rs.next()){
                deptManager = new DepartmentManager();
                deptManager.setEmployeeNumber(rs.getInt("emp_no"));
                deptManager.setDepartmentNumber(rs.getString("dept_no"));
                deptManager.setFromDate(rs.getDate("from_date"));
                deptManager.setToDate(rs.getDate("to_date"));
                deptManagers.add(deptManager);
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
        return deptManagers;
    }

    @Override
    public DepartmentManager getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DepartmentManager getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(DepartmentManager item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
