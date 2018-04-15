/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dataaccess.DepartmentDAO;
import dataaccess.DepartmentDAOImp;
import java.util.List;
import transferobjects.Department;
import transferobjects.factory.DTOFactoryCreator;
import transferobjects.factory.Factory;
import java.util.Map;

/**
 *
 * @author kyle
 */
public class DepartmentLogic {
    private DepartmentDAO departmentDAO = null;
    private final Factory<Department> factory;
    
    public DepartmentLogic() {
        departmentDAO = new DepartmentDAOImp();
        factory = DTOFactoryCreator.createBuilder(Department.class);
    }

    public List<Department> getAllDepartments() {
        return departmentDAO.getAll();
    }
    
    public Department getDepartmentById(String deptNo) {
        return departmentDAO.getById(deptNo);
    }
    
    public void insertDepartment(Department dept) {
        departmentDAO.insert(dept);
    }    
    
    public void addDepartment(Map<String, String[]> map) {
        Department dept = factory.createFromMap(map);
        cleanDepartment(dept);
        validateDepartment(dept);
        departmentDAO.insert(dept);
    }
    
    public void updateDepartment(Map<String, String[]> map) {
        Department dept = factory.createFromMap(map);
        cleanDepartment(dept);
        validateDepartment(dept);
        departmentDAO.update(dept);
    }
    
    public void validateDepartment(Department dept) {
        Validation.validateString(dept.getNumber(), "Department Code", 4, false);
        Validation.validateString(dept.getName(), "Department Name", 40, false);
    }    

    private void cleanDepartment(Department dept) {
        if (dept.getNumber()!= null) {
            dept.setNumber(dept.getNumber().trim());
        }
        if (dept.getName() != null) {
            dept.setName(dept.getName().trim());
        }
    }

    
}
