/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dataaccess.DepartmentEmployeeDAO;
import dataaccess.DepartmentEmployeeDAOImp;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import transferobjects.DepartmentEmployee;
import transferobjects.factory.DTOFactoryCreator;
import transferobjects.factory.Factory;

/**
 * the delegate class for handling the employee/department relation
 *
 * @author kyle, keith
 */
public class DepartmentEmployeeLogic {
    private DepartmentEmployeeDAO departmentEmployeeDAO = null;
    private final Factory<DepartmentEmployee> factory;
    
    public DepartmentEmployeeLogic() {
        departmentEmployeeDAO = new DepartmentEmployeeDAOImp();
        factory = DTOFactoryCreator.createBuilder(DepartmentEmployee.class);
    }

    /**
     * gets all employee/department relations
     * @return 
     */
    public List<DepartmentEmployee> getAllDepartmentEmployees() {
        return departmentEmployeeDAO.getAll();
    }
    
    /**
     * gets a specific relation based on employee id
     * @param empNo
     * @return 
     */
    public DepartmentEmployee getDepartmentEmployeeById(int empNo) {
        return departmentEmployeeDAO.getById(empNo);
    }
        
    /**
     * inserts the department/employee relation to the database
     * @param map
     * @param id 
     */
    public void addDepartmentEmployee(Map<String, String[]> map, int id) {
        DepartmentEmployee deptEmp = factory.createFromMap(map);
        cleanDepartmentEmployee(deptEmp);
        validateDepartmentEmployee(deptEmp);
        departmentEmployeeDAO.insert(deptEmp, id);
    }
    
    /**
     * updates an existing relation
     * @param map 
     */
    public void updateDepartmentEmployee(Map<String, String[]> map) {
        DepartmentEmployee deptEmp = factory.createFromMap(map);
        cleanDepartmentEmployee(deptEmp);
        validateDepartmentEmployee(deptEmp);
        departmentEmployeeDAO.update(deptEmp);
    }
    
    /**
     * validates the fields found in the employee department table before adding them to the table
     * @param deptEmp 
     */
    public void validateDepartmentEmployee(DepartmentEmployee deptEmp) {
        Validation.validateInt(deptEmp.getEmployeeNumber(), "Employee Number", Integer.MAX_VALUE, Integer.MIN_VALUE);
        Validation.validateString(deptEmp.getDepartmentNumber(), "Department Number", 4, false);
        Validation.validateDate(deptEmp.getFromDate(), "From Date", false);
        Validation.validateDate(deptEmp.getToDate(), "To Date", false);
    }    

    /**
     * cleans the fields before sending them to the database
     * @param deptEmp 
     */
    private void cleanDepartmentEmployee(DepartmentEmployee deptEmp) {        
        if (deptEmp.getDepartmentNumber()!= null) {
            deptEmp.setDepartmentNumber(deptEmp.getDepartmentNumber().trim());
        }
        
        if (deptEmp.getFromDate() == null) {
            deptEmp.setFromDate(new Date(System.currentTimeMillis()));
        }
        
        if (deptEmp.getToDate() == null) {
            deptEmp.setToDate(new Date(System.currentTimeMillis() + 31556952000l)); //+1 year
        }
    }
}
