/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import hthurow.tomcatjndi.TomcatJNDI;
import java.io.File;

@RunWith(Suite.class)
@Suite.SuiteClasses({SalaryDAOTest.class})
public class AllTestsTestSuite {
    
    private static TomcatJNDI tomcatJNDI;

    @BeforeClass
    public static void setUpClass() throws Exception {
        tomcatJNDI = new TomcatJNDI();
        tomcatJNDI.processContextXml(new File("web\\META-INF\\context.xml"));
        tomcatJNDI.processWebXml(new File("web\\WEB-INF\\web.xml"));
        tomcatJNDI.start();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        tomcatJNDI.tearDown();
    }    
}
