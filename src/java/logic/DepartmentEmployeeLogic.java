/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dataaccess.DepartmentEmployeeDAO;
import dataaccess.DepartmentEmployeeDAOImp;
import java.util.List;
import transferobjects.DepartmentEmployee;

/**
 *
 * @author kylem
 */
public class DepartmentEmployeeLogic {
    private DepartmentEmployeeDAO departmentEmployeeDAO = null;
    
    public DepartmentEmployeeLogic() {
        departmentEmployeeDAO = new DepartmentEmployeeDAOImp();
    }

    public List<DepartmentEmployee> getAllDepartmentEmployees() {
        return departmentEmployeeDAO.getAll();
    }
    
    public DepartmentEmployee getDepartmentEmployeeById(int empNo) {
        return departmentEmployeeDAO.getById(empNo);
    }
    
    public void insertDepartmentEmployee(DepartmentEmployee deptEmp) {
        //TODO: some validation stuff first
        departmentEmployeeDAO.insert(deptEmp);
    }
}
