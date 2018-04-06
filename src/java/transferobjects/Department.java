/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects;

/**
 *
 * @author kyle
 */
public class Department {
    private String name;
    private String departmentNumber;
    
    public Department() {}
    
    public Department (String name, String number){
        this.name = name;
        this.departmentNumber = number;
    }
    
    public String getName() { return name; }
    public String getNumber() { return departmentNumber; }
    
    public void setName(String name) { this.name = name; }
    public void setNumber(String number) { this.departmentNumber = number; }
}
