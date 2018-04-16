package dataaccess;

import transferobjects.Salary;

/**
 * the interface for data access to the salary table
 *
 * @author kyle, keith
 */
public interface SalaryDAO extends BasicDAO<Salary> {
    /**
     * gets the most current row from the salary table
     * @param empNo
     * @return 
     */
    Salary getById(int empNo);
}
