/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import transferobjects.Department;
import transferobjects.DepartmentEmployee;
import transferobjects.DepartmentManager;
import transferobjects.Employee;
import transferobjects.Salary;
import transferobjects.Title;

/**
 *
 * @author kyle
 */
public class AddEditEmployeeLogic {
    
    private final EmployeeLogic empLogic = new EmployeeLogic();
    private final SalaryLogic salaryLogic = new SalaryLogic();
    private final TitleLogic titleLogic = new TitleLogic();
    private final DepartmentLogic deptLogic = new DepartmentLogic();
    private final DepartmentManagerLogic deptMngrLogic = new DepartmentManagerLogic();
    private final DepartmentEmployeeLogic deptEmpLogic = new DepartmentEmployeeLogic();
    
    public Employee getEmployeeById(int id){
        return empLogic.getEmployeeById(id);
    }
    
    public Salary getEmployeeSalary(int id){
        return salaryLogic.getSalaryById(id);
    }
    
    public Title getEmployeeTitle(int id){
        return titleLogic.getTitleById(id);
    }
    
    public Department getEmployeeDepartment(int id) {
        DepartmentEmployee deptEmp = deptEmpLogic.getDepartmentEmployeeById(id);
        
        return deptLogic.getDepartmentById(deptEmp.getDepartmentNumber());
    } 
    
    public boolean isEmployeeManager(int id, String deptNo) {
        DepartmentManager deptMngr = deptMngrLogic.getDepartmentManagerById(id, deptNo);
        
        return deptMngr != null;
    }
    
    public DepartmentEmployee getDepartmentEmployee(int id){
        return deptEmpLogic.getDepartmentEmployeeById(id);
    }
    
    public List<Department> getDepartments(){
        return deptLogic.getAllDepartments();
    }
}
