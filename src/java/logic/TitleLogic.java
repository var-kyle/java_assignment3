/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dataaccess.TitleDAO;
import dataaccess.TitleDAOImp;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import transferobjects.Title;
import transferobjects.factory.DTOFactoryCreator;
import transferobjects.factory.Factory;

/**
 * delegate class that handles data access to the title table
 *
 * @author kyle, keith
 */
public class TitleLogic {
    private TitleDAO titleDAO = null;
    private final Factory<Title> factory;
    
    public TitleLogic() {
        titleDAO = new TitleDAOImp();
        factory = DTOFactoryCreator.createBuilder(Title.class);
    }

    /**
     * gets all the titles from the database
     * @return 
     */
    public List<Title> getAllTitles() {
        return titleDAO.getAll();
    }
    
    /**
     * gets an employees title
     * @param empNo
     * @return 
     */
    public Title getTitleById(int empNo) {
        return titleDAO.getById(empNo);
    }
    
    /**
     * inserts a new title for an employee into the database
     * @param map
     * @param id 
     */
    public void addTitle(Map<String, String[]> map, int id) {
        Title title = factory.createFromMap(map);        
        cleanTitle(title);
        validateTitle(title);
        titleDAO.insert(title, id);
    }
    
    /**
     * updates an existing title for an employee
     * @param map 
     */
    public void updateTitle(Map<String, String[]> map) {
        Title title = factory.createFromMap(map);        
        cleanTitle(title);
        validateTitle(title);
        titleDAO.update(title);
    }
    
    /**
     * validates title information before saving it
     * @param title 
     */
    public void validateTitle(Title title) {
        Validation.validateInt(title.getEmployeeNumber(), "Employee Number", Integer.MAX_VALUE, Integer.MIN_VALUE);
        Validation.validateString(title.getTitle(), "Title", 50, false);
        Validation.validateDate(title.getFromDate(), "From Date", false);
        Validation.validateDate(title.getToDate(), "To Date", true);
    }
    
    /**
     * cleans title information before validating it
     * @param title 
     */
    public void cleanTitle(Title title) {
        if (title.getTitle()!= null) {
            title.setTitle(title.getTitle().trim());
        }
        
        if (title.getFromDate() == null) {
            title.setFromDate(new Date(System.currentTimeMillis()));
        }
    }
}
