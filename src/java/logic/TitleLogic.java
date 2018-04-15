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
 *
 * @author kylem
 */
public class TitleLogic {
    private TitleDAO titleDAO = null;
    private final Factory<Title> factory;
    
    public TitleLogic() {
        titleDAO = new TitleDAOImp();
        factory = DTOFactoryCreator.createBuilder(Title.class);
    }

    public List<Title> getAllTitles() {
        return titleDAO.getAll();
    }
    
    public Title getTitleById(int empNo) {
        return titleDAO.getById(empNo);
    }
    
    public void addTitle(Map<String, String[]> map, int id) {
        Title title = factory.createFromMap(map);        
        cleanTitle(title);
        validateTitle(title);
        titleDAO.insert(title, id);
    }
    
    public void updateTitle(Map<String, String[]> map) {
        Title title = factory.createFromMap(map);        
        cleanTitle(title);
        validateTitle(title);
        titleDAO.update(title);
    }
    
    public void validateTitle(Title title) {
        Validation.validateInt(title.getEmployeeNumber(), "Employee Number", Integer.MAX_VALUE, Integer.MIN_VALUE);
        Validation.validateString(title.getTitle(), "Title", 50, false);
        Validation.validateDate(title.getFromDate(), "From Date", false);
        Validation.validateDate(title.getToDate(), "To Date", true);
    }
    
    public void cleanTitle(Title title) {
        if (title.getTitle()!= null) {
            title.setTitle(title.getTitle().trim());
        }
        
        if (title.getFromDate() == null) {
            title.setFromDate(new Date(System.currentTimeMillis()));
        }
    }
}
