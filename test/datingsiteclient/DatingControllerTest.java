/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingsiteclient;

import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import webservice.ColorEyes;
import webservice.ColorHair;
import webservice.DatingSiteWebServiceException_Exception;
import webservice.Gender;
import webservice.Message;
import webservice.Profile;

/**
 *
 * @author Adaline
 */
public class DatingControllerTest {
    
 
    
    public DatingControllerTest() {
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
     * Test of Login method, of class DatingController.
     */
    @Test
    public void testLogin1() throws DatingSiteWebServiceException_Exception {
        System.out.println("testLogin");
        // voldoet aan eisen/wensen
        DatingController testController = new DatingController();
        String email = "test10@30plusdatingtest.nl";
        String password = "Dating310";
        
        testController.Login(email, password);
       
        boolean expResult = true;
        boolean result = testController.Login(email, password);
        assertEquals(expResult, result);
 
    }
    
    @Test
    public void testLogin2() throws DatingSiteWebServiceException_Exception {
        System.out.println("testLogin");
        // voldoet niet aan de eisen/wensen wachtwoord te lang
        DatingController testController = new DatingController();
        String email = "test10@30plusdatingtest.nl";
        String password = "Testgebruiker10Dating310";
        
        testController.Login(email, password);
       
        boolean expResult = false;
        boolean result = testController.Login(email, password);
        assertEquals(expResult, result);
 
    }
    
        @Test
    public void testLogin3() throws DatingSiteWebServiceException_Exception {
        System.out.println("testLogin");
        // voldoet niet aan de eisen/wensen wachtwoord te kort
        DatingController testController = new DatingController();
        String email = "test10@30plusdatingtest.nl";
        String password = "Dating";
        
        testController.Login(email, password);
       
        boolean expResult = false;
        boolean result = testController.Login(email, password);
        assertEquals(expResult, result);
 
    }

    /**
     * Test of Logout method, of class DatingController.
     */
    @Test
    public void testLogout() throws DatingSiteWebServiceException_Exception{
        System.out.println("Logout");
        DatingController instance = new DatingController();
        boolean expResult = false;
        boolean result = instance.Logout();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetSiteName method, of class DatingController.
     */
    @Test
    public void testGetSiteName() throws DatingSiteWebServiceException_Exception{
        System.out.println("GetSiteName");
        DatingController instance = new DatingController();
        String expResult = "";
        String result = instance.GetSiteName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetMyInfo method, of class DatingController.
     */
    @Test
    public void testGetMyInfo() throws DatingSiteWebServiceException_Exception{
        System.out.println("GetMyInfo");
        DatingController instance = new DatingController();
        instance.GetMyInfo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetMyProfile method, of class DatingController.
     */
    @Test
    public void testGetMyProfile() throws DatingSiteWebServiceException_Exception{
        System.out.println("GetMyProfile");
        DatingController instance = new DatingController();
        instance.GetMyProfile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetMyPreference method, of class DatingController.
     */
    @Test
    public void testGetMyPreference() throws DatingSiteWebServiceException_Exception{
        System.out.println("GetMyPreference");
        DatingController instance = new DatingController();
        instance.GetMyPreference();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetMatches method, of class DatingController.
     */
    @Test
    public void testGetMatches() throws DatingSiteWebServiceException_Exception{
        System.out.println("GetMatches");
        DatingController instance = new DatingController();
        List<Profile> expResult = null;
        List<Profile> result = instance.GetMatches();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetSendMessages method, of class DatingController.
     */
    @Test
    public void testGetSendMessages() throws DatingSiteWebServiceException_Exception{
        System.out.println("GetSendMessages");
        DatingController instance = new DatingController();
        List<Message> expResult = null;
        List<Message> result = instance.GetSendMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetReceivedMessages method, of class DatingController.
     */
    @Test
    public void testGetReceivedMessages() throws DatingSiteWebServiceException_Exception{
        System.out.println("GetReceivedMessages");
        DatingController instance = new DatingController();
        List<Message> expResult = null;
        List<Message> result = instance.GetReceivedMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetMyProfile method, of class DatingController.
     */
    @Test
    public void testSetMyProfile() throws DatingSiteWebServiceException_Exception{
        System.out.println("SetMyProfile");
        int length = 0;
        ColorHair hairColor = null;
        ColorEyes eyeColor = null;
        String hobbies = "";
        String description = "";
        DatingController instance = new DatingController();
        boolean expResult = false;
        boolean result = instance.SetMyProfile(length, hairColor, eyeColor, hobbies, description);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetMyPreferences method, of class DatingController.
     */
    @Test
    public void testSetMyPreferences() throws DatingSiteWebServiceException_Exception{
        System.out.println("SetMyPreferences");
        Gender gender = null;
        int minAge = 0;
        int maxAge = 0;
        int minLength = 0;
        int maxLength = 0;
        ColorHair hairColor = null;
        ColorEyes eyeColor = null;
        DatingController instance = new DatingController();
        boolean expResult = false;
        boolean result = instance.SetMyPreferences(gender, minAge, maxAge, minLength, maxLength, hairColor, eyeColor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SendMessage method, of class DatingController.
     */
    @Test
    public void testSendMessage() throws DatingSiteWebServiceException_Exception{
        System.out.println("SendMessage");
        DatingController instance = new DatingController();
        boolean expResult = false;
        boolean result = instance.SendMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerParticipant method, of class DatingController.
     */
    @Test
    public void testRegisterParticipant() throws DatingSiteWebServiceException_Exception{
        System.out.println("registerParticipant");
        String name = "";
        String address = "";
        String postalCode = "";
        String place = "";
        XMLGregorianCalendar birthDate = null;
        Gender gender = null;
        String bankAccount = "";
        String email = "";
        String password = "";
        DatingController instance = new DatingController();
        boolean expResult = false;
        boolean result = instance.registerParticipant(name, address, postalCode, place, birthDate, gender, bankAccount, email, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
