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
 *
 * @author kylem
 */
public class DepartmentEmployeeLogic {
    private DepartmentEmployeeDAO departmentEmployeeDAO = null;
    private final Factory<DepartmentEmployee> factory;
    
    public DepartmentEmployeeLogic() {
        departmentEmployeeDAO = new DepartmentEmployeeDAOImp();
        factory = DTOFactoryCreator.createBuilder(DepartmentEmployee.class);
    }

    public List<DepartmentEmployee> getAllDepartmentEmployees() {
        return departmentEmployeeDAO.getAll();
    }
    
    public DepartmentEmployee getDepartmentEmployeeById(int empNo) {
        return departmentEmployeeDAO.getById(empNo);
    }
        
    public void addDepartmentEmployee(Map<String, String[]> map, int id) {
        DepartmentEmployee deptEmp = factory.createFromMap(map);
        cleanDepartmentEmployee(deptEmp);
        validateDepartmentEmployee(deptEmp);
        departmentEmployeeDAO.insert(deptEmp, id);
    }
    
    public void updateDepartmentEmployee(Map<String, String[]> map) {
        DepartmentEmployee deptEmp = factory.createFromMap(map);
        cleanDepartmentEmployee(deptEmp);
        validateDepartmentEmployee(deptEmp);
        departmentEmployeeDAO.update(deptEmp);
    }
    
    public void validateDepartmentEmployee(DepartmentEmployee deptEmp) {
        Validation.validateInt(deptEmp.getEmployeeNumber(), "Employee Number", Integer.MAX_VALUE, Integer.MIN_VALUE);
        Validation.validateString(deptEmp.getDepartmentNumber(), "Department Number", 4, false);
        Validation.validateDate(deptEmp.getFromDate(), "From Date", false);
        Validation.validateDate(deptEmp.getToDate(), "To Date", false);
    }    

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
