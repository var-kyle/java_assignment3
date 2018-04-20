package AllTests;

import dataaccess.DepartmentEmployeeDAO;
import dataaccess.DepartmentEmployeeDAOImp;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import transferobjects.DepartmentEmployee;

public class DepartmentEmployeeDAOTest {
    
    DepartmentEmployeeDAO dao;
    
    @Before
    public void setUp() {
        dao = new DepartmentEmployeeDAOImp();
    }
    
    @After
    public void tearDown() {
        dao = null;
    }

    @Test
    public void getAllTest(){
        List<DepartmentEmployee> deptEmps = dao.getAll();
        
        assertNotNull(deptEmps);
        assertTrue(deptEmps.size() > 0);
    }
    
    @Test
    public void getByIdTest() {
        int id = dao.getAll().get(1).getEmployeeNumber();
        DepartmentEmployee deptEmp = dao.getById(id);
        
        assertNotNull(deptEmp);
    }
}
