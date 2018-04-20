package AllTests;

import dataaccess.DepartmentDAO;
import dataaccess.DepartmentDAOImp;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import transferobjects.Department;

public class DepartmentDAOTest {
    
    DepartmentDAO dao;
    
    @Before
    public void setUp() {
        dao = new DepartmentDAOImp();
    }
    
    @After
    public void tearDown() {
        dao = null;
    }

    @Test
    public void getAllTest(){
        List<Department> depts = dao.getAll();
        
        assertNotNull(depts);
        assertTrue(depts.size() > 0);
    }
    
    @Test
    public void getByIdTest() {
        String id = dao.getAll().get(1).getNumber();
        Department dept = dao.getById(id);
        
        assertNotNull(dept);
    }
}
