/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import transferobjects.DepartmentEmployee;

/**
 *
 * @author kylem
 */
public interface DepartmentEmployeeDAO extends BasicDAO<DepartmentEmployee> {
    DepartmentEmployee getById(int empNo);
}
