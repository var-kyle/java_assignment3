/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllTests;

import dataaccess.DepartmentManagerDAO;
import dataaccess.DepartmentManagerDAOImp;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import transferobjects.DepartmentManager;

/**
 *
 * @author kylem
 */
public class DepartmentManagerDAOTest {
    
    DepartmentManagerDAO dao;
    
    @Before
    public void setUp() {
        dao = new DepartmentManagerDAOImp();
    }
    
    @After
    public void tearDown() {
        dao = null;
    }
    
    @Test
    public void getAllTest(){
        List<DepartmentManager> deptMngrs = dao.getAll();
        
        assertNotNull(deptMngrs);
        assertTrue(deptMngrs.size() > 0);
    }
    
    @Test
    public void getByIdTest() {
        DepartmentManager temp = dao.getAll().get(1);
        DepartmentManager deptMngr = dao.getById(temp.getEmployeeNumber(), temp.getDepartmentNumber());
        
        assertNotNull(deptMngr);
    }
}
