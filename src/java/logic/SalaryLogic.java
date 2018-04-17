/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dataaccess.SalaryDAO;
import dataaccess.SalaryDAOImp;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import transferobjects.Salary;
import transferobjects.factory.DTOFactoryCreator;
import transferobjects.factory.Factory;

/**
 * delegate class that handles data access to the salary table
 *
 * @author kyle, keith
 */
public class SalaryLogic {    
    private SalaryDAO salaryDAO = null;
    private final Factory<Salary> factory;
    
    public SalaryLogic() {
        salaryDAO = new SalaryDAOImp();
        factory = DTOFactoryCreator.createBuilder(Salary.class);
    }

    /**
     * gets all salary entries in the salary table
     * @return 
     */
    public List<Salary> getAllSalaries() {
        return salaryDAO.getAll();
    }
    
    /**
     * gets an employees salary information from the database
     * @param empNo
     * @return 
     */
    public Salary getSalaryById(int empNo) {
        return salaryDAO.getById(empNo);
    }
    
    /**
     * inserts a new salary into the database
     * @param map
     * @param id 
     */
    public void addSalary(Map<String, String[]> map, int id) {
        Salary salary = factory.createFromMap(map);        
        cleanSalary(salary);
        validateSalary(salary);
        salaryDAO.insert(salary, id);
    }
    
    /**
     * updates an existing salary in the database
     * @param map 
     */
    public void updateSalary(Map<String, String[]> map) {
        Salary salary = factory.createFromMap(map);        
        cleanSalary(salary);
        validateSalary(salary);
        salaryDAO.update(salary);
    }
    
    /**
     * validates salary information before saving it in the database
     * @param salary 
     */
    public void validateSalary(Salary salary) {
        Validation.validateInt(salary.getEmployeeNumber(), "Employee Number", Integer.MAX_VALUE, Integer.MIN_VALUE);
        Validation.validateInt(salary.getSalary(), "Salary", Integer.MAX_VALUE, Integer.MIN_VALUE);
        Validation.validateDate(salary.getFromDate(), "From Date", false);
        Validation.validateDate(salary.getToDate(), "To Date", false);
    }
    
    /**
     * cleans the salary information before validating it
     * @param salary 
     */
    public void cleanSalary(Salary salary) {
        if (salary.getFromDate() == null) {
            salary.setFromDate(new Date(System.currentTimeMillis()));
        }
        
        if (salary.getToDate() == null) {
            salary.setToDate(new Date(System.currentTimeMillis() + 31556952000l)); //+1 year
        }
    }
}
