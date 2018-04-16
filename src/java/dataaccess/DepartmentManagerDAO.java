/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import transferobjects.DepartmentManager;

/**
 * the interface for data access to the department manager table
 *
 * @author kyle, keith
 */
public interface DepartmentManagerDAO extends BasicDAO<DepartmentManager> {
    /**
     * gets the most curret row tied to the employee number and department number
     * @param empNo
     * @param deptNo
     * @return 
     */
    DepartmentManager getById(int empNo, String deptNo);
}
