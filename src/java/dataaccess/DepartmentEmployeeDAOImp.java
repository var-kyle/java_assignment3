package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.DepartmentEmployee;
import transferobjects.factory.DTOFactoryCreator;
import transferobjects.factory.Factory;

/**
 * the implementation for data access to the department employee table
 *
 * @author kyle, keith
 */
public class DepartmentEmployeeDAOImp implements DepartmentEmployeeDAO {
    private static final String GET_ALL_DEPARTMENT_EMPLOYEES = "SELECT emp_no, dept_no, from_date, to_date FROM dept_emp ORDER BY emp_no DESC LIMIT " + ROW_LIMIT;
    private static final String GET_BY_ID = "SELECT emp_no, dept_no, from_date, to_date FROM dept_emp WHERE emp_no = ?";
    private static final String INSERT_DEPARTMENT_EMPLOYEE = "INSERT INTO dept_emp(emp_no, dept_no, from_date, to_date) VALUES(?,?,?,?)";
    private static final String UPDATE_DEPARTMENT_EMPLOYEE = "UPDATE dept_emp SET from_date = ?, to_date = ? WHERE emp_no = ? AND dept_no = ?";
    
    private final Factory<DepartmentEmployee> factory;
    
    public DepartmentEmployeeDAOImp() {
        factory = DTOFactoryCreator.createBuilder(DepartmentEmployee.class);
    }
    
    @Override
    public List<DepartmentEmployee> getAll() {
        @SuppressWarnings("unchecked")
        List<DepartmentEmployee> deptEmps = Collections.EMPTY_LIST;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement( GET_ALL_DEPARTMENT_EMPLOYEES);
            rs = pstmt.executeQuery();
            deptEmps = factory.createListFromResultSet(rs);
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentEmployeeDAOImp.class.getName()).log(Level.SEVERE, null, ex);
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
    public DepartmentEmployee getById(int empNo) {
        @SuppressWarnings("unchecked")
        DepartmentEmployee deptEmp = new DepartmentEmployee();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(GET_BY_ID);
            pstmt.setInt(1, empNo);
            rs = pstmt.executeQuery();
            if (rs.next())
                deptEmp = factory.createFromResultSet(rs);
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentEmployeeDAOImp.class.getName()).log(Level.SEVERE, null, ex);
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
        return deptEmp;
    }

    @Override
    public DepartmentEmployee insert(DepartmentEmployee deptEmp, int id) {
        @SuppressWarnings("unchecked")
        Connection con = null;
        PreparedStatement pstmt = null;
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(INSERT_DEPARTMENT_EMPLOYEE);
            pstmt.setInt(1, id);
            pstmt.setString(2, deptEmp.getDepartmentNumber());
            pstmt.setDate(3, deptEmp.getFromDate());
            pstmt.setDate(4, deptEmp.getToDate());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentEmployeeDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
        return deptEmp;
    }

    @Override
    public DepartmentEmployee update(DepartmentEmployee deptEmp) {
        @SuppressWarnings("unchecked")
        Connection con = null;
        PreparedStatement pstmt = null;
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(UPDATE_DEPARTMENT_EMPLOYEE);
            pstmt.setDate(1, deptEmp.getFromDate());
            pstmt.setDate(2, deptEmp.getToDate());
            pstmt.setInt(3, deptEmp.getEmployeeNumber());
            pstmt.setString(4, deptEmp.getDepartmentNumber());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentEmployeeDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
        return deptEmp;
    }
    
}
