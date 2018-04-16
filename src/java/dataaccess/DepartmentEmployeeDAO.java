package dataaccess;

import transferobjects.DepartmentEmployee;

/**
 * the interface for data access to the department employee table
 *
 * @author kyle, keith
 */
public interface DepartmentEmployeeDAO extends BasicDAO<DepartmentEmployee> {
    /**
     * gets the most current record of the employee's department
     * @param empNo
     * @return 
     */
    DepartmentEmployee getById(int empNo);
}
