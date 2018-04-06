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
public class Employee {
    private int employeeNumber;
    private Date birthDate, hireDate;
    private String firstName, lastName, gender;
    
    public Employee() {}
    
    public Employee(int employeeNumber, Date birthDate, Date hireDate, String firstName, String lastName, String gender){
        this.employeeNumber = employeeNumber;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }
    
    public int getEmployeeNumber() { return employeeNumber; }
    public Date getBirthDate() { return birthDate; }
    public Date getHireDate() { return hireDate; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getGender() { return gender; }
    
    public void setEmployeeNumber(int employeeNumber) { this.employeeNumber = employeeNumber; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setGender(String gender) { this.gender = gender; }
}
