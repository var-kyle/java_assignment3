/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects;

import java.sql.Date;
import java.util.Objects;

/**
 * the department employee transfer object that maps to the department employee table
 *
 * @author kyle, keith
 */
public class DepartmentEmployee {
    private int employeeNumber;
    private String departmentNumber;
    private Date fromDate, toDate;
    
    public DepartmentEmployee() {}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.employeeNumber;
        hash = 41 * hash + Objects.hashCode(this.departmentNumber);
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
        final DepartmentEmployee other = (DepartmentEmployee) obj;
        if (this.employeeNumber != other.employeeNumber) {
            return false;
        }
        if (!Objects.equals(this.departmentNumber, other.departmentNumber)) {
            return false;
        }
        return true;
    }
    
    public DepartmentEmployee(int employeeNumber, String departmentNumber, Date fromDate, Date toDate){
        setEmployeeNumber(employeeNumber);
        setDepartmentNumber(departmentNumber);
        setFromDate(fromDate);
        setToDate(toDate);
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
