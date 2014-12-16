/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aufzug1.model;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Andy
 */
public class EtageTest {
    
    public EtageTest() {
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
     * Test of get/setLabel method, of class Etage.
     */
    @Test
    public void testSetLabel() {
        System.out.println("setLabel");
        Etage instance = new Etage("0");
        instance.setLabel("1");
        assertEquals("1", instance.getLabel());
    }

    /**
     * Test of is/setAngefordert method, of class Etage.
     */
    @Test
    public void testSetAngefordert() {
        System.out.println("setAngefordert");
        boolean angefordert = true;
        Etage instance = new Etage("0");
        instance.setAngefordert(angefordert);
        boolean result = instance.isAngefordert();
        assertEquals(angefordert, result);
    }
}
