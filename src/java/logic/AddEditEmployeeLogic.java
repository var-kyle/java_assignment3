/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import java.util.Map;
import transferobjects.Department;
import transferobjects.DepartmentEmployee;
import transferobjects.DepartmentManager;
import transferobjects.Employee;
import transferobjects.Salary;
import transferobjects.Title;
import transferobjects.factory.DTOFactoryCreator;
import transferobjects.factory.Factory;

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
    
    private final Factory<Employee> factory = DTOFactoryCreator.createBuilder(Employee.class);
    
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
    
    public void addEmployee(Map<String, String[]> map) {
        empLogic.addEmployee(map);
        String[] s = new String[1];
        salaryLogic.addSalary(map);
        titleLogic.addTitle(map);
        //deptLogic.addDepartment(map);
        deptEmpLogic.addDepartmentEmployee(map);
        deptMngrLogic.addDepartmentManager(map);
    }
    
    public void updateEmployee(Map<String, String[]> map) {
        empLogic.updateEmployee(map);
        salaryLogic.updateSalary(map);
        titleLogic.updateTitle(map);
        //deptLogic.updateDepartment(map);
        deptEmpLogic.updateDepartmentEmployee(map);
        deptMngrLogic.updateDepartmentManager(map);
    }
}
