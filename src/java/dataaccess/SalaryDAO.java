/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import transferobjects.Salary;

/**
 *
 * @author kylem
 */
public interface SalaryDAO extends BasicDAO<Salary> {
    Salary getById(int empNo);
}
