/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dataaccess.TitleDAO;
import dataaccess.TitleDAOImp;
import java.util.List;
import transferobjects.Title;

/**
 *
 * @author kylem
 */
public class TitleLogic {
    private TitleDAO titleDAO = null;
    
    public TitleLogic() {
        titleDAO = new TitleDAOImp();
    }

    public List<Title> getAllTitles() {
        return titleDAO.getAll();
    }
    
    public Title getTitleById(int empNo) {
        return titleDAO.getById(empNo);
    }
    
    public void insertTitle(Title title) {
        //TODO: some validation stuff first
        titleDAO.insert(title);
    }
}
