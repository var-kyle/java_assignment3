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
import transferobjects.Title;
import transferobjects.factory.DTOFactoryCreator;
import transferobjects.factory.Factory;

/**
 *
 * @author kylem
 */
public class TitleDAOImp implements TitleDAO {

    private static final String GET_ALL_TITLES = "SELECT emp_no, title, from_date, to_date FROM titles ORDER BY emp_no DESC LIMIT " + ROW_LIMIT;
    private static final String GET_BY_ID = "SELECT emp_no, title, from_date, to_date FROM titles WHERE emp_no = ?";
    private static final String INSERT_TITLE = "INSERT INTO titles(emp_no, title, from_date, to_date) VALUES(?,?,?,?)";
    private static final String UPDATE_TITLE = "UPDATE titles SET title = ?, from_date = ?, to_date = ? WHERE emp_no = ?";
    
    private final Factory<Title> factory;
    
    public TitleDAOImp() {
        factory = DTOFactoryCreator.createBuilder(Title.class);
    }
    
    @Override
    public List<Title> getAll() {
        @SuppressWarnings("unchecked")
        List<Title> titles = Collections.EMPTY_LIST;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(GET_ALL_TITLES);
            rs = pstmt.executeQuery();
            titles = factory.createListFromResultSet(rs);
        } catch (SQLException ex) {
            Logger.getLogger(TitleDAOImp.class.getName()).log(Level.SEVERE, null, ex);
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
    public Title getById(int empNo) {
        @SuppressWarnings("unchecked")
        Title title = new Title();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(GET_BY_ID);
            pstmt.setInt(1, empNo);
            rs = pstmt.executeQuery();
            if (rs.next())
                title = factory.createFromResultSet(rs);
        } catch (SQLException ex) {
            Logger.getLogger(TitleDAOImp.class.getName()).log(Level.SEVERE, null, ex);
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
        return title;
    }

    @Override
    public Title insert(Title title, int id) {
        @SuppressWarnings("unchecked")
        Connection con = null;
        PreparedStatement pstmt = null;
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(INSERT_TITLE);
            pstmt.setInt(1, id);
            pstmt.setString(2, title.getTitle());
            pstmt.setDate(3, title.getFromDate());
            pstmt.setDate(4, title.getToDate());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TitleDAOImp.class.getName()).log(Level.SEVERE, null, ex);
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
        return title;
    }

    @Override
    public Title update(Title title) {
        @SuppressWarnings("unchecked")
        Connection con = null;
        PreparedStatement pstmt = null;
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(UPDATE_TITLE);
            pstmt.setString(1, title.getTitle());
            pstmt.setDate(2, title.getFromDate());
            pstmt.setDate(3, title.getToDate());
            pstmt.setInt(4, title.getEmployeeNumber());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TitleDAOImp.class.getName()).log(Level.SEVERE, null, ex);
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
        return title;
    }

}
