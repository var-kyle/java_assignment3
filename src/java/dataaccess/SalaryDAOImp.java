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
import transferobjects.Salary;

/**
 *
 * @author kylem
 */
public class SalaryDAOImp implements SalaryDAO {
    private static final String GET_ALL_SALARIES = "SELECT emp_no, salary, from_date, to_date FROM salaries ORDER BY emp_no LIMIT 20";

    @Override
    public List<Salary> getAll() {
        @SuppressWarnings("unchecked")
        List<Salary> salaries = Collections.EMPTY_LIST;
        Salary salary;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement( GET_ALL_SALARIES);
            rs = pstmt.executeQuery();
            salaries = new ArrayList<>(100);
            while( rs.next()){
                salary = new Salary();
                salary.setEmployeeNumber(rs.getInt("emp_no"));
                salary.setSalary(rs.getInt("salary"));
                salary.setFromDate(rs.getDate("from_date"));
                salary.setToDate(rs.getDate("to_date"));
                salaries.add(salary);
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
        return salaries;
    }

    @Override
    public Salary getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Salary getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Salary item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
