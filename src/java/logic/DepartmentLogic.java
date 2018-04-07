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

/**
 *
 * @author kyle
 */
public class DepartmentLogic {
    private DepartmentDAO departmentDAO = null;

    public DepartmentLogic() {
        departmentDAO = new DepartmentDAOImp();
    }

    public List<Department> getAllDepartments() {
        return departmentDAO.getAll();
    }
    
    public Department getDepartmentById(String deptNo) {
        return departmentDAO.getById(deptNo);
    }
    
    public void insertDepartment(Department dept) {
        //TODO: some validation stuff first
        departmentDAO.insert(dept);
    }
}
