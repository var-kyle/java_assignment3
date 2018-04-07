/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dataaccess.SalaryDAO;
import dataaccess.SalaryDAOImp;
import java.util.List;
import transferobjects.Salary;

/**
 *
 * @author kylem
 */
public class SalaryLogic {    
    private SalaryDAO salaryDAO = null;
    
    public SalaryLogic() {
        salaryDAO = new SalaryDAOImp();
    }

    public List<Salary> getAllSalaries() {
        return salaryDAO.getAll();
    }
    
    public Salary getSalaryById(int empNo) {
        return salaryDAO.getById(empNo);
    }
    
    public void insertSalary(Salary salary) {
        //TODO: some validation stuff first
        salaryDAO.insert(salary);
    }
}
