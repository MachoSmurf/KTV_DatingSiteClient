/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatingSiteClientUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adaline
 */
public class DatingSiteUILoginScreenControllerTest {
    
    @FXML private TextField tbEmail;
    @FXML private PasswordField tbPassword;
    @FXML private Label lblLoginDatingSiteName;
    
    public DatingSiteUILoginScreenControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of initialize method, of class DatingSiteUILoginScreenController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        DatingSiteUILoginScreenController instance = new DatingSiteUILoginScreenController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSiteName method, of class DatingSiteUILoginScreenController.
     */
    @Test
    public void testSetSiteName() {
        System.out.println("testSetSiteName");
        String siteName = "TestSite30Plus";
        
        DatingSiteUILoginScreenController instance = new DatingSiteUILoginScreenController();
        
        instance.setSiteName(siteName);
        String expResult = "TestSite30Plus";
        String result = lblLoginDatingSiteName.getText();
        
        assertEquals("TestSite30Plus", expResult, result);
    }

    /**
     * Test of showConnectionError method, of class DatingSiteUILoginScreenController.
     */
    @Test
    public void testShowConnectionError() {
        System.out.println("showConnectionError");
        DatingSiteUILoginScreenController instance = new DatingSiteUILoginScreenController();
        instance.showConnectionError();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
