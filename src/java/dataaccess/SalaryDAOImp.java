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
import transferobjects.Salary;
import transferobjects.factory.DTOFactoryCreator;
import transferobjects.factory.Factory;

/**
 * the data access implementation for the salary table
 *
 * @author kyle, ketih
 */
public class SalaryDAOImp implements SalaryDAO {

    private static final String GET_ALL_SALARIES = "SELECT emp_no, salary, from_date, to_date FROM salaries ORDER BY emp_no DESC LIMIT " + ROW_LIMIT;
    private static final String GET_BY_ID = "SELECT emp_no, salary, from_date, to_date FROM salaries WHERE emp_no = ?";
    private static final String INSERT_SALARY = "INSERT INTO salary(emp_no, salary, from_date, to_date) VALUES(?,?,?,?)";
    private static final String UPDATE_SALARY = "UPDATE salary SET salary = ?, from_date = ?, to_date = ? WHERE emp_no = ?";

    private final Factory<Salary> factory;

    public SalaryDAOImp() {
        factory = DTOFactoryCreator.createBuilder(Salary.class);
    }

    @Override
    public List<Salary> getAll() {
        @SuppressWarnings("unchecked")
        List<Salary> salaries = Collections.EMPTY_LIST;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(GET_ALL_SALARIES);
            rs = pstmt.executeQuery();
            salaries = factory.createListFromResultSet(rs);
        } catch (SQLException ex) {
            Logger.getLogger(SalaryDAOImp.class.getName()).log(Level.SEVERE, null, ex);
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
        return salaries;
    }

    @Override
    public Salary getById(int empNo) {
        @SuppressWarnings("unchecked")
        Salary salary = new Salary();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(GET_BY_ID);
            pstmt.setInt(1, empNo);
            rs = pstmt.executeQuery();
            if (rs.next())
                salary = factory.createFromResultSet(rs);
        } catch (SQLException ex) {
            Logger.getLogger(SalaryDAOImp.class.getName()).log(Level.SEVERE, null, ex);
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
        return salary;
    }

    @Override
    public Salary insert(Salary salary, int id) {
        @SuppressWarnings("unchecked")
        Connection con = null;
        PreparedStatement pstmt = null;
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(INSERT_SALARY);
            pstmt.setInt(1, id);
            pstmt.setInt(2, salary.getSalary());
            pstmt.setDate(3, salary.getFromDate());
            pstmt.setDate(4, salary.getToDate());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SalaryDAOImp.class.getName()).log(Level.SEVERE, null, ex);
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
        return salary;
    }

    @Override
    public Salary update(Salary salary) {
        @SuppressWarnings("unchecked")
        Connection con = null;
        PreparedStatement pstmt = null;
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(UPDATE_SALARY);
            pstmt.setInt(1, salary.getSalary());
            pstmt.setDate(2, salary.getFromDate());
            pstmt.setDate(3, salary.getToDate());
            pstmt.setInt(4, salary.getEmployeeNumber());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SalaryDAOImp.class.getName()).log(Level.SEVERE, null, ex);
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
        return salary;
    }

}
