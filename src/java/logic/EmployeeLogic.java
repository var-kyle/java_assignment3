/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dataaccess.EmployeeDAO;
import dataaccess.EmployeeDAOImp;
import java.util.List;
import transferobjects.Employee;

/**
 *
 * @author kylem
 */
public class EmployeeLogic {
    private EmployeeDAO employeeDAO = null;
    
    public EmployeeLogic() {
        employeeDAO = new EmployeeDAOImp();
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAll();
    }
    
    public Employee getEmployeeById(int empNo) {
        return employeeDAO.getById(empNo);
    }
    
    public void insertEmployee(Employee emp) {
        //TODO: some validation stuff first
        employeeDAO.insert(emp);
    }
}
