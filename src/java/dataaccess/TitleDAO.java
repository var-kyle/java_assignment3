package dataaccess;

import transferobjects.Title;

/**
 * the interface for data access to the title table
 *
 * @author kyle, keith
 */
public interface TitleDAO extends BasicDAO<Title> {
    /**
     * gets the most current row from the title table
     * @param empNo
     * @return 
     */
    Title getById(int empNo);
}
