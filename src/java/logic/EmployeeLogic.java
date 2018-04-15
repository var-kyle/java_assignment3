/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dataaccess.EmployeeDAO;
import dataaccess.EmployeeDAOImp;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import transferobjects.Employee;
import transferobjects.factory.DTOFactoryCreator;
import transferobjects.factory.Factory;

/**
 *
 * @author kylem
 */
public class EmployeeLogic {
    private EmployeeDAO employeeDAO = null;
    private final Factory<Employee> factory;
    
    public EmployeeLogic() {
        employeeDAO = new EmployeeDAOImp();
        factory = DTOFactoryCreator.createBuilder(Employee.class);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAll();
    }
    
    public Employee getEmployeeById(int empNo) {
        return employeeDAO.getById(empNo);
    }
    
    public void updateEmployee(Map<String, String[]> map) {
        Employee emp = factory.createFromMap(map);
        cleanEmployee(emp);
        validateEmployee(emp);        
        employeeDAO.update(emp);
    }
    
    public void addEmployee(Map<String, String[]> map){
        Employee emp = factory.createFromMap(map);
        cleanEmployee(emp);
        validateEmployee(emp);        
        employeeDAO.insert(emp);
    }
    
    public void validateEmployee(Employee emp) {
        Validation.validateInt(emp.getEmployeeNumber(), "Employee Number", Integer.MAX_VALUE, Integer.MIN_VALUE);
        Validation.validateString(emp.getFirstName(), "First Name", 14, false);
        Validation.validateString(emp.getLastName(), "Last Name", 16, false);
        Validation.validateString(emp.getGender(), "Gender", 1, false);
        Validation.validateDate(emp.getBirthDate(), "Birth Date", false);
        Validation.validateDate(emp.getHireDate(), "Hire Date", false);
    }    

    private void cleanEmployee(Employee emp) {
        if (emp.getFirstName()!= null) {
            emp.setFirstName(emp.getFirstName().trim());
        }
        
        if (emp.getLastName()!= null) {
            emp.setLastName(emp.getLastName().trim());
        }
                
        if (emp.getGender()!= null) {
            emp.setGender(emp.getGender().trim());
        }
        
        if (emp.getBirthDate() == null) {
            emp.setBirthDate(new Date(System.currentTimeMillis()));
        }
        
        if (emp.getHireDate() == null) {
            emp.setHireDate(new Date(System.currentTimeMillis()));
        }
    }
}
