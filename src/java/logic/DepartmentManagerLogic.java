/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dataaccess.DepartmentManagerDAO;
import dataaccess.DepartmentManagerDAOImp;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import transferobjects.DepartmentManager;
import transferobjects.factory.DTOFactoryCreator;
import transferobjects.factory.Factory;

/**
 *
 * @author kylem
 */
public class DepartmentManagerLogic {
    private DepartmentManagerDAO departmentManagerDAO = null;
    private final Factory<DepartmentManager> factory;
    
    public DepartmentManagerLogic() {
        departmentManagerDAO = new DepartmentManagerDAOImp();
        factory = DTOFactoryCreator.createBuilder(DepartmentManager.class);
    }

    public List<DepartmentManager> getAllDepartmentManagers() {
        return departmentManagerDAO.getAll();
    }
    
    public DepartmentManager getDepartmentManagerById(int empNo, String deptNo) {
        return departmentManagerDAO.getById(empNo, deptNo);
    }
        
    public void addDepartmentManager(Map<String, String[]> map) {
        DepartmentManager deptMngr = factory.createFromMap(map);
        cleanDepartmentEmployee(deptMngr);
        validateDepartmentEmployee(deptMngr);
        departmentManagerDAO.insert(deptMngr);
    }
    
    public void updateDepartmentManager(Map<String, String[]> map) {
        DepartmentManager deptMngr = factory.createFromMap(map);
        cleanDepartmentEmployee(deptMngr);
        validateDepartmentEmployee(deptMngr);
        departmentManagerDAO.update(deptMngr);
    }
    
    public void validateDepartmentEmployee(DepartmentManager deptMngr) {
        Validation.validateInt(deptMngr.getEmployeeNumber(), "Employee Number", Integer.MAX_VALUE, Integer.MIN_VALUE);
        Validation.validateString(deptMngr.getDepartmentNumber(), "Department Number", 4, false);
        Validation.validateDate(deptMngr.getFromDate(), "From Date", false);
        Validation.validateDate(deptMngr.getToDate(), "To Date", false);
    }    

    private void cleanDepartmentEmployee(DepartmentManager deptMngr) {        
        if (deptMngr.getDepartmentNumber()!= null) {
            deptMngr.setDepartmentNumber(deptMngr.getDepartmentNumber().trim());
        }
        
        if (deptMngr.getFromDate() == null) {
            deptMngr.setFromDate(new Date(System.currentTimeMillis()));
        }
        
        if (deptMngr.getToDate() == null) {
            deptMngr.setToDate(new Date(System.currentTimeMillis() + 31556952000l)); //+1 year
        }
    }
}
