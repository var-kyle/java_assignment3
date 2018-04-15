/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import transferobjects.Employee;

/**
 *
 * @author kylem
 */
public interface EmployeeDAO extends BasicDAO<Employee> {
    Employee getById(int empNo);
    int getNextAvailableId();
}
