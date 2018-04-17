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
 * a bundled logic class comprising of all the other logic classes. provides everything needed to add an employee
 *
 * @author kyle, keith
 */
public class AddEditEmployeeLogic {
    
    private final EmployeeLogic empLogic = new EmployeeLogic();
    private final SalaryLogic salaryLogic = new SalaryLogic();
    private final TitleLogic titleLogic = new TitleLogic();
    private final DepartmentLogic deptLogic = new DepartmentLogic();
    private final DepartmentManagerLogic deptMngrLogic = new DepartmentManagerLogic();
    private final DepartmentEmployeeLogic deptEmpLogic = new DepartmentEmployeeLogic();
    
    private final Factory<Employee> factory = DTOFactoryCreator.createBuilder(Employee.class);
    
    /**
     * gets an employee record by the employee id.
     * @param id
     * @return 
     */
    public Employee getEmployeeById(int id){
        return empLogic.getEmployeeById(id);
    }
    
    /**
     * gets the employees salary from the employee id
     * @param id
     * @return 
     */
    public Salary getEmployeeSalary(int id){
        return salaryLogic.getSalaryById(id);
    }
    
    /**
     * gets the employee title from the employee id
     * @param id
     * @return 
     */
    public Title getEmployeeTitle(int id){
        return titleLogic.getTitleById(id);
    }
    
    /**
     * gets the department object from the employee department table
     * @param id
     * @return 
     */
    public Department getEmployeeDepartment(int id) {
        DepartmentEmployee deptEmp = deptEmpLogic.getDepartmentEmployeeById(id);
        
        return deptLogic.getDepartmentById(deptEmp.getDepartmentNumber());
    }
    
    /**
     * checks to see if the employee is a manager for the given department
     * @param id
     * @param deptNo
     * @return 
     */
    public boolean isEmployeeManager(int id, String deptNo) {
        DepartmentManager deptMngr = deptMngrLogic.getDepartmentManagerById(id, deptNo);
        
        return deptMngr != null;
    }
    
    /**
     * gets the employee/department relation based on the employee id
     * @param id
     * @return 
     */
    public DepartmentEmployee getDepartmentEmployee(int id){
        return deptEmpLogic.getDepartmentEmployeeById(id);
    }
    
    /**
     * gets a list of all the departments
     * @return 
     */
    public List<Department> getDepartments(){
        return deptLogic.getAllDepartments();
    }
    
    /**
     * inserts an employee with all the employees information from the view
     * @param map 
     */
    public void addEmployee(Map<String, String[]> map) {
        int id = empLogic.getNextAvailableId();
        empLogic.addEmployee(map, id);
        salaryLogic.addSalary(map, id);
        titleLogic.addTitle(map, id);
        deptEmpLogic.addDepartmentEmployee(map, id);
        deptMngrLogic.addDepartmentManager(map, id);
    }
    
    /**
     * updates an existing employees information from the view
     * @param map 
     */
    public void updateEmployee(Map<String, String[]> map) {
        empLogic.updateEmployee(map);
        salaryLogic.updateSalary(map);
        titleLogic.updateTitle(map);
        deptEmpLogic.updateDepartmentEmployee(map);
        deptMngrLogic.updateDepartmentManager(map);
    }
}
