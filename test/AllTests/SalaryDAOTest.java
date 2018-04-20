/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllTests;

import dataaccess.SalaryDAO;
import dataaccess.SalaryDAOImp;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import transferobjects.Salary;

/**
 *
 * @author kyle
 */
public class SalaryDAOTest {

    private SalaryDAO dao;
    
    @Before
    public void setUp() {
        dao = new SalaryDAOImp();
    }
    
    @After
    public void tearDown() {
        
    }

    @Test
    public void getAllTest() {
        List<Salary> salaries = dao.getAll();
        assertNotNull(salaries);
        assertTrue(salaries.size() > 0);
    }
}
