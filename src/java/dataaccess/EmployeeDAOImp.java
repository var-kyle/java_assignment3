package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.Employee;
import transferobjects.factory.DTOFactoryCreator;
import transferobjects.factory.Factory;

/**
 * the implementation for data access to the employee table
 *
 * @author kyle, keith
 */
public class EmployeeDAOImp implements EmployeeDAO {

    private static final String GET_ALL_EMPLOYEES = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees ORDER BY emp_no DESC LIMIT " + ROW_LIMIT;
    private static final String GET_BY_ID = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees WHERE emp_no = ?";
    private static final String INSERT_EMPLOYEE = "INSERT INTO employees(emp_no, birth_date, first_name, last_name, gender, hire_date) VALUES(?,?,?,?,?,?)";
    private static final String UPDATE_EMPLOYEE = "UPDATE employees SET birth_date = ?, first_name = ?, last_name = ?, gender = ?, hire_date = ? WHERE emp_no = ?";
    private static final String GET_NEXT_AVAILABLE_ID = "SELECT max(emp_no)+1 AS next_id FROM employees";
    
    private final Factory<Employee> factory;

    public EmployeeDAOImp() {
        factory = DTOFactoryCreator.createBuilder(Employee.class);
    }

    @Override
    public List<Employee> getAll() {
        @SuppressWarnings("unchecked")
        List<Employee> employees = Collections.EMPTY_LIST;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(GET_ALL_EMPLOYEES);
            rs = pstmt.executeQuery();
            employees = factory.createListFromResultSet(rs);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImp.class.getName()).log(Level.SEVERE, null, ex);
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
        return employees;
    }

    @Override
    public Employee getById(int empNo) {
        @SuppressWarnings("unchecked")
        Employee emp = new Employee();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(GET_BY_ID);
            pstmt.setInt(1, empNo);
            rs = pstmt.executeQuery();
            if (rs.next())
                emp = factory.createFromResultSet(rs);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImp.class.getName()).log(Level.SEVERE, null, ex);
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
        return emp;
    }

    @Override
    public Employee insert(Employee emp, int id) {
        @SuppressWarnings("unchecked")
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(INSERT_EMPLOYEE);
            pstmt.setInt(1, id);
            pstmt.setDate(2, emp.getBirthDate());
            pstmt.setString(3, emp.getFirstName());
            pstmt.setString(4, emp.getLastName());
            pstmt.setString(5, emp.getGender());
            pstmt.setDate(6, emp.getHireDate());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImp.class.getName()).log(Level.SEVERE, null, ex);
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
        return emp;
    }

    @Override
    public Employee update(Employee emp) {
        @SuppressWarnings("unchecked")
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(UPDATE_EMPLOYEE);
            pstmt.setDate(1, emp.getBirthDate());
            pstmt.setString(2, emp.getFirstName());
            pstmt.setString(3, emp.getLastName());
            pstmt.setString(4, emp.getGender());
            pstmt.setDate(5, emp.getHireDate());
            pstmt.setInt(6, emp.getEmployeeNumber());
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImp.class.getName()).log(Level.SEVERE, null, ex);
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
        return emp;
    }    

    @Override
    public int getNextAvailableId() {
        @SuppressWarnings("unchecked")
        int nextId = 0;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(GET_NEXT_AVAILABLE_ID);
            rs = pstmt.executeQuery();
            if (rs.next())
                nextId = rs.getInt("next_id");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImp.class.getName()).log(Level.SEVERE, null, ex);
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
        return nextId;
    }
}
