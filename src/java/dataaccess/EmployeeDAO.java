package dataaccess;

import transferobjects.Employee;

/**
 * the interface for data access to the employee table
 *
 * @author kyle, keith
 */
public interface EmployeeDAO extends BasicDAO<Employee> {
    /**
     * gets the specifc row from the employee table
     * @param empNo
     * @return 
     */
    Employee getById(int empNo);
    /**
     * gets the next available id from the employee table
     * @return 
     */
    int getNextAvailableId();
}
