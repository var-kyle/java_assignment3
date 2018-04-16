package dataaccess;

import transferobjects.Department;

/**
 * department specific interface . adds the ability to get by id
 * 
 * @author kyle, keith
 */
public interface DepartmentDAO extends BasicDAO<Department> {
    /**
     * gets an individual row based on the id from the database
     * @param id
     * @return 
     */
    Department getById(String id);
}
