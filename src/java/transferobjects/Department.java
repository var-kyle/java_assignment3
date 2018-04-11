/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects;

import java.util.Objects;

/**
 *
 * @author kyle
 */
public class Department {
    private String name;
    private String departmentNumber;
    
    public Department() {}

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.departmentNumber);
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
        final Department other = (Department) obj;
        if (!Objects.equals(this.departmentNumber, other.departmentNumber)) {
            return false;
        }
        return true;
    }
    
    public Department (String name, String number){
        setName(name);
        setNumber(number);
    }
    
    public String getName() { return name; }
    public String getNumber() { return departmentNumber; }
    
    public void setName(String name) { this.name = name; }
    public void setNumber(String number) { this.departmentNumber = number; }
}
