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
 * the delegate class to handle data access for departments
 *
 * @author kyle, keith
 */
public class DepartmentLogic {
    private DepartmentDAO departmentDAO = null;
    private final Factory<Department> factory;
    
    public DepartmentLogic() {
        departmentDAO = new DepartmentDAOImp();
        factory = DTOFactoryCreator.createBuilder(Department.class);
    }

    /**
     * gets a list of all the departments
     * @return 
     */
    public List<Department> getAllDepartments() {
        return departmentDAO.getAll();
    }
    
    /**
     * gets a department from it's id
     * @param deptNo
     * @return 
     */
    public Department getDepartmentById(String deptNo) {
        return departmentDAO.getById(deptNo);
    }
    
    /**
     * inserts a department into the database
     * @param map
     * @param id 
     */
    public void addDepartment(Map<String, String[]> map, int id) {
        Department dept = factory.createFromMap(map);
        cleanDepartment(dept);
        validateDepartment(dept);
        departmentDAO.insert(dept, id);
    }
    
    /**
     * updates an existing department
     * @param map 
     */
    public void updateDepartment(Map<String, String[]> map) {
        Department dept = factory.createFromMap(map);
        cleanDepartment(dept);
        validateDepartment(dept);
        departmentDAO.update(dept);
    }
    
    /**
     * validates fields before sending them to the database
     * @param dept 
     */
    public void validateDepartment(Department dept) {
        Validation.validateString(dept.getNumber(), "Department Code", 4, false);
        Validation.validateString(dept.getName(), "Department Name", 40, false);
    }    

    /**
     * cleans the fields before sending them to the database
     * @param dept 
     */
    private void cleanDepartment(Department dept) {
        if (dept.getNumber()!= null) {
            dept.setNumber(dept.getNumber().trim());
        }
        if (dept.getName() != null) {
            dept.setName(dept.getName().trim());
        }
    }

    
}
