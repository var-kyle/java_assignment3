/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllTests;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import logic.AddEditEmployeeLogic;
import logic.EmployeeLogic;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import transferobjects.Employee;

/**
 *
 * @author kylem
 */
public class AddEmployeeTest {
    
    private AddEditEmployeeLogic logic;
    Map<String, String[]> map;
    
    private final String fname = "first",
            lname = "last",
            birthdate = "1980-04-20",
            hiredate = "2018-04-20",
            gender = "F",
            title = "title",
            titlefromdate = "2018-04-20",
            titletodate = "2018-11-20",
            salary = "75000",
            salaryfromdate = "2018-04-20",
            salarytodate = "2018-11-20",
            ismanager = "false",
            deptno = "d006", //quality management
            deptfromdate = "2018-04-20",
            depttodate = "2018-11-20";
    
    @Before
    public void setUp() {
        logic = new AddEditEmployeeLogic();
        map = new HashMap<>();
        //map.put("emp_no",  new String[]{}); //(modify only)
        map.put("first_name",  new String[]{fname});
        map.put("last_name",  new String[]{lname});
        map.put("birth_date",  new String[]{birthdate});
        map.put("hire_date",  new String[]{hiredate});
        map.put("gender",  new String[]{gender});
        map.put("title",  new String[]{title});
        map.put("title_from_date",  new String[]{titlefromdate});
        map.put("title_to_date",  new String[]{titletodate});
        map.put("salary",  new String[]{salary});
        map.put("salary_from_date",  new String[]{salaryfromdate});
        map.put("salary_to_date",  new String[]{salarytodate});
        map.put("is_manager",  new String[]{ismanager});
        map.put("dept_no", new String[]{deptno}); 
        map.put("dept_from_date",  new String[]{deptfromdate});
        map.put("dept_to_date",  new String[]{depttodate});
    }
    
    @After
    public void tearDown() {
        logic = null;
        map = null;
    }
    
    @Test
    public void AddEmployeeTest() {
        EmployeeLogic empLogic = new EmployeeLogic();
        int id = empLogic.getNextAvailableId();
        
        logic.addEmployee(map);
        
        Employee emp = logic.getEmployeeById(id);
        
        assertNotNull(emp);
        assertTrue(emp.getEmployeeNumber() == id);
        assertTrue(emp.getFirstName().equals(fname));
        assertTrue(emp.getLastName().equals(lname));
        assertTrue(emp.getHireDate().equals(Date.valueOf(hiredate)));
        assertTrue(emp.getBirthDate().equals(Date.valueOf(birthdate)));
        assertTrue(emp.getGender().equals(gender));
    }
}
