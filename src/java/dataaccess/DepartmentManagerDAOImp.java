package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.DepartmentManager;
import transferobjects.factory.DTOFactoryCreator;
import transferobjects.factory.Factory;

/**
 * the implementation for data access to the department manager table
 *
 * @author kyle, keith
 */
public class DepartmentManagerDAOImp implements DepartmentManagerDAO {
    private static final String GET_ALL_DEPARTMENT_MANAGERS = "SELECT emp_no, dept_no, from_date, to_date FROM dept_manager ORDER BY emp_no DESC LIMIT " + ROW_LIMIT;
    private static final String GET_BY_ID = "SELECT emp_no, dept_no, from_date, to_date FROM dept_manager WHERE emp_no = ? AND dept_no = ?";
    private static final String INSERT_DEPARTMENT_MANAGER = "INSERT INTO dept_manager(emp_no, dept_no, from_date, to_date) VALUES(?,?,?,?)";
    private static final String UPDATE_DEPARTMENT_MANAGER = "UPDATE dept_manager SET from_date = ?, to_date = ? WHERE emp_no = ? AND dept_no = ?";
    
    private final Factory<DepartmentManager> factory;
    
    public DepartmentManagerDAOImp() {
        factory = DTOFactoryCreator.createBuilder(DepartmentManager.class);
    }
    
    @Override
    public List<DepartmentManager> getAll() {
        @SuppressWarnings("unchecked")
        List<DepartmentManager> deptManagers = Collections.EMPTY_LIST;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement( GET_ALL_DEPARTMENT_MANAGERS);
            rs = pstmt.executeQuery();
            deptManagers = DTOFactoryCreator.createBuilder(DepartmentManager.class).createListFromResultSet(rs);
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentManagerDAOImp.class.getName()).log(Level.SEVERE, null, ex);
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
    public DepartmentManager getById(int empNo, String deptNo) {
        @SuppressWarnings("unchecked")
        DepartmentManager deptMngr = new DepartmentManager();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(GET_BY_ID);
            pstmt.setInt(1, empNo);
            pstmt.setString(2, deptNo);
            rs = pstmt.executeQuery();
            if (rs.next())
                deptMngr = factory.createFromResultSet(rs);
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentManagerDAOImp.class.getName()).log(Level.SEVERE, null, ex);
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
        return deptMngr;
    }

    @Override
    public DepartmentManager insert(DepartmentManager deptMngr, int id) {
        @SuppressWarnings("unchecked")
        Connection con = null;
        PreparedStatement pstmt = null;
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(INSERT_DEPARTMENT_MANAGER);
            pstmt.setInt(1, id);
            pstmt.setString(2, deptMngr.getDepartmentNumber());
            pstmt.setDate(3, deptMngr.getFromDate());
            pstmt.setDate(4, deptMngr.getToDate());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentManagerDAOImp.class.getName()).log(Level.SEVERE, null, ex);
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
        return deptMngr;
    }

    @Override
    public DepartmentManager update(DepartmentManager deptMngr) {
        @SuppressWarnings("unchecked")
        Connection con = null;
        PreparedStatement pstmt = null;
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(UPDATE_DEPARTMENT_MANAGER);
            pstmt.setDate(1, deptMngr.getFromDate());
            pstmt.setDate(2, deptMngr.getToDate());
            pstmt.setInt(3, deptMngr.getEmployeeNumber());
            pstmt.setString(4, deptMngr.getDepartmentNumber());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentManagerDAOImp.class.getName()).log(Level.SEVERE, null, ex);
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
        return deptMngr;
    }
    
}
