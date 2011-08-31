/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package qlock.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andy
 */
public class WortFactoryTest {

    public WortFactoryTest() {
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
     * Test of getWorte method, of class WortFactory.
     */
    @Test
    public void testGetWorte() {
        System.out.print("getWorte: ");
        WortFactory instance = new WortFactory("de");
        //Wort[] expResult = null;
        Wort[] result = instance.getWorte();
        System.out.println(result);
        assertEquals("uhr", result[22]);
    }

    /**
     * Test of getBuchstaben method, of class WortFactory.
     */
    @Test
    public void testGetBuchstaben() {
        System.out.print("getBuchstaben: ");
        WortFactory instance = new WortFactory("de");
        //Buchstabe[][] expResult = null;
        Buchstabe[][] result = instance.getBuchstaben();
        System.out.println(result);
        assertEquals("r", result[11][10]);
    }

}