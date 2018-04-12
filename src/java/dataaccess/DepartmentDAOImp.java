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
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.Department;
import transferobjects.factory.DTOFactoryCreator;
import transferobjects.factory.Factory;

/**
 *
 * @author kyle
 */
public class DepartmentDAOImp implements DepartmentDAO {

    private static final String GET_ALL_DEPARTMENTS = "SELECT dept_no, dept_name FROM Departments ORDER BY dept_no LIMIT " + ROW_LIMIT;
    private static final String GET_BY_ID = "SELECT dept_no, dept_name FROM Departments WHERE dept_no = ?";
    private static final String INSERT_DEPARTMENT = "INSERT INTO Departments(dept_no, dept_name) VALUES(?,?)";
    private static final String UPDATE_DEPARTMENT = "UPDATE Departments SET dept_name = ? WHERE dept_no = ?";

    private final Factory<Department> factory;
    
    public DepartmentDAOImp(){
        factory = DTOFactoryCreator.createBuilder(Department.class);
    }
    
    @Override
    public List<Department> getAll() {
        @SuppressWarnings("unchecked")
        List<Department> departments = Collections.EMPTY_LIST;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(GET_ALL_DEPARTMENTS);
            rs = pstmt.executeQuery();
            departments = factory.createListFromResultSet(rs);
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
    public Department getById(String id) {
        Department department = new Department();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(GET_BY_ID);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next())
                department = factory.createFromResultSet(rs);
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
    public Department insert(Department dept) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(INSERT_DEPARTMENT);
            pstmt.setString(1, dept.getNumber());
            pstmt.setString(2, dept.getName());
            rs = pstmt.executeQuery();
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

        return dept;
    }

    @Override
    public Department update(Department dept) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(UPDATE_DEPARTMENT);
            pstmt.setString(1, dept.getName());
            pstmt.setString(2, dept.getNumber());
            rs = pstmt.executeQuery();
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

        return dept;
    }
}
