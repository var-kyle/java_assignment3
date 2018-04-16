package dataaccess;

import java.util.List;

/**
 * All data access objects use these methods
 *  
 * @author kyle, keith
 */
public interface BasicDAO<T> {
    /**
     * the row limit to be returned from database calls
     */
    static final int ROW_LIMIT = 100;
    
    /**
     * will return all the results from a table (up to the row limit)
     * @return 
     */
    List<T> getAll();
    
    /**
     * inserts and item to it's corresonding table
     * @param item the dto to be inserted into the database
     * @param id the id of the newly inserted employee
     * @return 
     */
    T insert(T item, int id);
    
    /**
     * updates a row in the database from edits done in the view
     * @param item
     * @return 
     */
    T update(T item);
}
