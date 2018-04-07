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
import transferobjects.Title;

/**
 *
 * @author kylem
 */
public class TitleDAOImp implements TitleDAO {
    private static final String GET_ALL_TITLES = "SELECT emp_no, title, from_date, to_date FROM titles ORDER BY emp_no LIMIT 20";

    @Override
    public List<Title> getAll() {
        @SuppressWarnings("unchecked")
        List<Title> titles = Collections.EMPTY_LIST;
        Title title;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement( GET_ALL_TITLES);
            rs = pstmt.executeQuery();
            titles = new ArrayList<>(100);
            while( rs.next()){
                title = new Title();
                title.setEmployeeNumber(rs.getInt("emp_no"));
                title.setTitle(rs.getString("title"));
                title.setFromDate(rs.getDate("from_date"));
                title.setToDate(rs.getDate("to_date"));
                titles.add(title);
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
        return titles;
    }

    @Override
    public Title getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Title getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Title item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
