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
public class Title {
    private int employeeNumber;
    private String title;
    private Date fromDate, toDate;
    
    public Title() {}
    
    public Title(int employeeNumber, String title, Date fromDate, Date toDate) {
        this.employeeNumber = employeeNumber;
        this.title = title;
        this.fromDate = fromDate;
        this.toDate = toDate;
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
