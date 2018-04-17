/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects;

import java.sql.Date;
import java.util.Objects;

/**
 * the salary transfer object that maps to the salary table
 *
 * @author kyle, keith
 */
public class Salary {
    private int employeeNumber, salary;
    private Date fromDate, toDate;
    
    public Salary() {}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.employeeNumber;
        hash = 13 * hash + Objects.hashCode(this.fromDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Salary other = (Salary) obj;
        if (this.employeeNumber != other.employeeNumber) {
            return false;
        }
        if (!Objects.equals(this.fromDate, other.fromDate)) {
            return false;
        }
        return true;
    }
    
    public Salary(int employeeNumber, int salary, Date fromDate, Date toDate) {
        setEmployeeNumber(employeeNumber);
        setSalary(salary);
        setFromDate(fromDate);
        setToDate(toDate);
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
