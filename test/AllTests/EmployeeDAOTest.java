/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllTests;

import dataaccess.EmployeeDAO;
import dataaccess.EmployeeDAOImp;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import transferobjects.Employee;

/**
 *
 * @author kylem
 */
public class EmployeeDAOTest {
    
    private EmployeeDAO dao;
        
    @Before
    public void setUp() {
        dao = new EmployeeDAOImp();
    }
    
    @After
    public void tearDown() {
        dao = null;
    }
    
    @Test
    public void getAllTest(){
        List<Employee> employees = dao.getAll();
        assertNotNull(employees);
        assertTrue(employees.size() > 0);
    }
    
    @Test
    public void getByIdTest() {
        int nextId = dao.getNextAvailableId();
        Employee lastEmp = dao.getById(nextId - 1);
        Employee nextEmp = dao.getById(nextId);
        
        assertNotNull(lastEmp);
        assertTrue(nextEmp.getEmployeeNumber() == 0);
    }
    
    @Test
    public void getNextAvailableIdTest() {
        int nextId = dao.getNextAvailableId();
        
        assertTrue(nextId > 0);
    }
}
