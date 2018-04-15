/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects.builder;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;
import transferobjects.Title;

/**
 *
 * @author kyle
 */
public class TitleBuilder {
    
    private static final String COL_EMP_NO = "emp_no";
    private static final String COL_TITLE = "title";
    private static final String COL_FROM_DATE = "from_date";
    private static final String COL_TO_DATE = "to_date";
    private static final String MAP_FROM_DATE = "title_from_date";
    private static final String MAP_TO_DATE = "title_to_date";
    private Title title = new Title();
    
    public TitleBuilder setEmployeeNumber(ResultSet rs) throws SQLException{
        title.setEmployeeNumber(rs.getInt(COL_EMP_NO));
        return this;
    }
    
    public TitleBuilder setTitle(ResultSet rs) throws SQLException{
        title.setTitle(rs.getString(COL_TITLE));        
        return this;
    }
    
    public TitleBuilder setFromDate(ResultSet rs) throws SQLException {
        title.setFromDate(rs.getDate(COL_FROM_DATE));
        return this;
    }
    
    public TitleBuilder setToDate(ResultSet rs) throws SQLException {
        title.setToDate(rs.getDate(COL_TO_DATE));
        return this;
    }
    
    public TitleBuilder setEmployeeNumber(Map<String, String[]> map) {
        if (map.containsKey(COL_EMP_NO))
            title.setEmployeeNumber(Integer.parseInt(map.get(COL_EMP_NO)[0]));
        return this;
    }
    
    public TitleBuilder setTitle(Map<String, String[]> map) {
        title.setTitle(map.get(COL_TITLE)[0]);        
        return this;
    }
    
    public TitleBuilder setFromDate(Map<String, String[]> map) {
        title.setFromDate(Date.valueOf(map.get(MAP_FROM_DATE)[0]));
        return this;
    }
    
    public TitleBuilder setToDate(Map<String, String[]> map) {
        title.setToDate(Date.valueOf(map.get(MAP_TO_DATE)[0]));
        return this;
    }
    
    public Title get(){
        return title;
    }
}
