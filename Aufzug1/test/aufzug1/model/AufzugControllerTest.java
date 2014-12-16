package aufzug1.model;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Andy
 */
public class AufzugControllerTest {

    AufzugData data = new AufzugData(3);
    AufzugController instance = new AufzugController(data);
    
    public AufzugControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getData method, of class AufzugController.
     */
    /*
    @Test
    public void testGetData() {
        System.out.println("getData");
        AufzugController instance = null;
        AufzugData expResult = null;
        AufzugData result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /**
     * Test of fordereAufzugAnFuerEtage method, of class AufzugController.
     */
    /*
    @Test
    public void testFordereAufzugAnFuerEtage() {
        System.out.println("fordereAufzugAnFuerEtage");
        int etagenNr = 0;
        AufzugController instance = null;
        instance.fordereAufzugAnFuerEtage(etagenNr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * 
    */

    /**
     * Test of tuereOeffnen method, of class AufzugController.
     */
    @Test
    public void testTuereOeffnen() {
        System.out.println("tuereOeffnen");
        data.setTuereZu(true);
        instance.tuereOeffnen();
        assertEquals(false, data.isTuereZu());
    }

    /**
     * Test of tuereSchliessen method, of class AufzugController.
     */
    @Test
    public void testTuereSchliessen() {
        System.out.println("tuereSchliessen");
        data.setTuereZu(false);
        instance.tuereSchliessen();
        assertEquals(true, data.isTuereZu());
    }

    /**
     * Test of fahre method, of class AufzugController.
     */
    @Test
    public void testFahre() {
        System.out.println("fahre");
        instance.fahre();
    }
}
