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
public class Title {
    private int employeeNumber;
    private String title;
    private Date fromDate, toDate;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.employeeNumber;
        hash = 13 * hash + Objects.hashCode(this.title);
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
        final Title other = (Title) obj;
        if (this.employeeNumber != other.employeeNumber) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.fromDate, other.fromDate)) {
            return false;
        }
        return true;
    }
    
    public Title() {}
    
    public Title(int employeeNumber, String title, Date fromDate, Date toDate) {
        setEmployeeNumber(employeeNumber);
        setTitle(title);
        setFromDate(fromDate);
        setToDate(toDate);
    }    
    
    public int getEmployeeNumber() { return employeeNumber; }
    public String getTitle() { return title; }
    public Date getFromDate() { return fromDate; }
    public Date getToDate() { return toDate; }
    
    
    public void setEmployeeNumber(int employeeNumber) { this.employeeNumber = employeeNumber; }
    public void setTitle(String title) { this.title = title; }
    public void setFromDate(Date fromDate) { this.fromDate = fromDate; }
    public void setToDate(Date toDate) { this.toDate = toDate; }
}
