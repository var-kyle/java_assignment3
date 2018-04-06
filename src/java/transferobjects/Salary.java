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
public class Salary {
    private int employeeNumber, salary;
    private Date fromDate, toDate;
    
    public Salary() {}
    
    public Salary(int employeeNumber, int salary, Date fromDate, Date toDate) {
        this.employeeNumber = employeeNumber;
        this.salary = salary;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }    
    
    public int getEmployeeNumber() { return employeeNumber; }
    public int getSalary() { return salary; }
    public Date getFromDate() { return fromDate; }
    public Date getToDate() { return toDate; }
    
    
    public void setEmployeeNumber(int employeeNumber) { this.employeeNumber = employeeNumber; }
    public void setSalary(int salary) { this.salary = salary; }
    public void setFromDate(Date fromDate) { this.fromDate = fromDate; }
    public void setToDate(Date toDate) { this.toDate = toDate; }
}
