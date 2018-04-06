/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects;

import java.sql.Date;

/**
 *
 * @author kyle
 */
public class DepartmentEmployee {
    private int employeeNumber;
    private String departmentNumber;
    private Date fromDate, toDate;
    
    public DepartmentEmployee() {}
    
    public DepartmentEmployee(int employeeNumber, String departmentNumber, Date fromDate, Date toDate){
        this.employeeNumber = employeeNumber;
        this.departmentNumber = departmentNumber;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
    
    public int getEmployeeNumber() { return employeeNumber; }
    public String getDepartmentNumber() { return departmentNumber; }
    public Date getFromDate() { return fromDate; }
    public Date getToDate() { return toDate; }
    
    public void setEmployeeNumber(int employeeNumber) { this.employeeNumber = employeeNumber; }
    public void setDepartmentNumber(String departmentNumber) { this.departmentNumber = departmentNumber; }
    public void setFromDate(Date fromDate) { this.fromDate = fromDate; }
    public void setToDate(Date toDate) { this.toDate = toDate; }
}
