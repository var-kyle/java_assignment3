package AllTests;

import dataaccess.TitleDAO;
import dataaccess.TitleDAOImp;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import transferobjects.Title;

public class TitleDAOTest {
    
    private TitleDAO dao;
    
    @Before
    public void setUp() {
        dao = new TitleDAOImp();
    }
    
    @After
    public void tearDown() {
        dao = null;
    }

    @Test
    public void getAllTest(){
        List<Title> titles = dao.getAll();
        
        assertNotNull(titles);
        assertTrue(titles.size() > 0);
    }
    
    @Test
    public void getByIdTest() {
        int id = dao.getAll().get(1).getEmployeeNumber();
        Title title = dao.getById(id);
        
        assertNotNull(title);
    }
}
