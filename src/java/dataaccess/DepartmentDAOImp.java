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
import transferobjects.Department;
import transferobjects.factory.DTOFactoryCreator;

/**
 *
 * @author kyle
 */
public class DepartmentDAOImp implements DepartmentDAO {
    private static final String GET_ALL_DEPARTMENTS = "SELECT dept_no, dept_name FROM Departments ORDER BY dept_no LIMIT " + ROW_LIMIT;
    private static final String GET_DEPARTMENT_BY_ID = "SELECT dept_no, dept_name FROM Departments WHERE dept_no = '?'";
    private static final String INSERT_DEPARTMENT = "INSERT INTO Departments(dept_no, dept_name) VALUES(?,?)";
    
    @Override
    public List<Department> getAll() {
         @SuppressWarnings("unchecked")
        List<Department> departments = Collections.EMPTY_LIST;
        Department department;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement( GET_ALL_DEPARTMENTS);
            rs = pstmt.executeQuery();
            departments = DTOFactoryCreator.createBuilder(Department.class).createListFromResultSet(rs);
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
        return departments;
    }

    @Override
    public Department getById(int id) {
        throw new UnsupportedOperationException("This method is not needed here");
    }

    @Override
    public Department getById(String id) {
        Department department = new Department();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement( GET_DEPARTMENT_BY_ID);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            while( rs.next()){
                department = new Department();
                department.setNumber(rs.getString("dept_no"));
                department.setName( rs.getString("dept_name"));
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
        
        return department;
    }

    @Override
    public void insert(Department dept) {
        
    }
    
}
