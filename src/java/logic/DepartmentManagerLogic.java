/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dataaccess.DepartmentManagerDAO;
import dataaccess.DepartmentManagerDAOImp;
import java.util.List;
import transferobjects.DepartmentManager;

/**
 *
 * @author kylem
 */
public class DepartmentManagerLogic {
    private DepartmentManagerDAO departmentManagerDAO = null;
    
    public DepartmentManagerLogic() {
        departmentManagerDAO = new DepartmentManagerDAOImp();
    }

    public List<DepartmentManager> getAllDepartmentManagers() {
        return departmentManagerDAO.getAll();
    }
    
    public DepartmentManager getDepartmentManagerById(int empNo) {
        return departmentManagerDAO.getById(empNo);
    }
    
    public void insertDepartmentManager(DepartmentManager deptEmp) {
        //TODO: some validation stuff first
        departmentManagerDAO.insert(deptEmp);
    }
}
