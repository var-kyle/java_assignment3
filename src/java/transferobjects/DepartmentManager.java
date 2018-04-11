/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author kyle
 */
public class DepartmentManager {
    private int employeeNumber;
    private String departmentNumber;
    private Date fromDate, toDate;
    
    public DepartmentManager() {}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.employeeNumber;
        hash = 61 * hash + Objects.hashCode(this.departmentNumber);
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
        final DepartmentManager other = (DepartmentManager) obj;
        if (this.employeeNumber != other.employeeNumber) {
            return false;
        }
        if (!Objects.equals(this.departmentNumber, other.departmentNumber)) {
            return false;
        }
        return true;
    }
    
    public DepartmentManager(int employeeNumber, String departmentNumber, Date fromDate, Date toDate){
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
