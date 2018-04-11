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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.employeeNumber;
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
        final Employee other = (Employee) obj;
        if (this.employeeNumber != other.employeeNumber) {
            return false;
        }
        return true;
    }
    
    public Employee(int employeeNumber, Date birthDate, Date hireDate, String firstName, String lastName, String gender){
        setEmployeeNumber(employeeNumber);
        setBirthDate(birthDate);
        setHireDate(hireDate);
        setFirstName(firstName);
        setLastName(lastName);
        setGender(gender);
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
