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
    public void setUp() throws DatingSiteWebServiceException_Exception {
       
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
     * Test of SetMyProfile method, of class DatingController.
     */
    @Test
    public void testSetMyProfileTrue() throws DatingSiteWebServiceException_Exception{
        System.out.println("SetMyProfile");
        DatingController testController = new DatingController();
        testController.Login("test10@30plusdatingtest.nl", "Dating310");
        
        // BEGIN TEST, test voldoet aan eisen/wensen
        // (length>100)  && (length<250) && (hairColor != null) && (eyeColor != null) && (!hobbies.isEmpty()) && (!description.isEmpty()
        int length = 200;
        ColorHair hairColor = ColorHair.GRIJS;
        ColorEyes eyeColor = ColorEyes.BRUIN;
        String hobbies = "Golf";
        String description = "Graag buiten";
        
     
        boolean expResult = true;
        boolean result = testController.SetMyProfile(length, hairColor, eyeColor, hobbies, description);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of SetMyProfile method, of class DatingController.
     */
    @Test
    public void testSetMyProfileFalse() throws DatingSiteWebServiceException_Exception{
        System.out.println("SetMyProfile");
        DatingController testController = new DatingController();
        testController.Login("test10@30plusdatingtest.nl", "Dating310");
        
        // BEGIN TEST, test voldoet totaal niet aan de eisen/wensen 
        // (length>100)  && (length<250) && (hairColor != null) && (eyeColor != null) && (!hobbies.isEmpty()) && (!description.isEmpty()
        int length = 90;
        ColorHair hairColor = null;
        ColorEyes eyeColor = null;
        String hobbies = "";
        String description = "";
        
     
        boolean expResult = false;
        boolean result = testController.SetMyProfile(length, hairColor, eyeColor, hobbies, description);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetMyProfileLength() throws DatingSiteWebServiceException_Exception{
        System.out.println("SetMyProfile");
        DatingController testController = new DatingController();
        testController.Login("test10@30plusdatingtest.nl", "Dating310");
        
        // BEGIN TEST, length voldoet niet aan de eisen/wensen 
        // (length>100)  && (length<250) && (hairColor != null) && (eyeColor != null) && (!hobbies.isEmpty()) && (!description.isEmpty()
        int length = 90;
        ColorHair hairColor = ColorHair.GRIJS;
        ColorEyes eyeColor = ColorEyes.BRUIN;
        String hobbies = "Golf";
        String description = "Graag buiten";
        
     
        boolean expResult = false;
        boolean result = testController.SetMyProfile(length, hairColor, eyeColor, hobbies, description);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetMyProfileHairColor() throws DatingSiteWebServiceException_Exception{
        System.out.println("SetMyProfile");
        DatingController testController = new DatingController();
        testController.Login("test10@30plusdatingtest.nl", "Dating310");
        
        // BEGIN TEST, hairCOlor voldoet niet aan de eisen/wensen 
        // (length>100)  && (length<250) && (hairColor != null) && (eyeColor != null) && (!hobbies.isEmpty()) && (!description.isEmpty()
        int length = 200;
        ColorHair hairColor = null;
        ColorEyes eyeColor = ColorEyes.BRUIN;
        String hobbies = "Golf";
        String description = "Graag buiten";
        
     
        boolean expResult = false;
        boolean result = testController.SetMyProfile(length, hairColor, eyeColor, hobbies, description);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetMyProfileEyeColor() throws DatingSiteWebServiceException_Exception{
        System.out.println("SetMyProfile");
        DatingController testController = new DatingController();
        testController.Login("test10@30plusdatingtest.nl", "Dating310");
        
        // BEGIN TEST, eyeColor voldoet niet aan de eisen/wensen 
        // (length>100)  && (length<250) && (hairColor != null) && (eyeColor != null) && (!hobbies.isEmpty()) && (!description.isEmpty()
        int length = 200;
        ColorHair hairColor = ColorHair.GRIJS;
        ColorEyes eyeColor = null;
        String hobbies = "Golf";
        String description = "Graag buiten";
        
     
        boolean expResult = false;
        boolean result = testController.SetMyProfile(length, hairColor, eyeColor, hobbies, description);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetMyProfileHobbies() throws DatingSiteWebServiceException_Exception{
        System.out.println("SetMyProfile");
        DatingController testController = new DatingController();
        testController.Login("test10@30plusdatingtest.nl", "Dating310");
        
        // BEGIN TEST, hobbies voldoet niet aan de eisen/wensen 
        // (length>100)  && (length<250) && (hairColor != null) && (eyeColor != null) && (!hobbies.isEmpty()) && (!description.isEmpty()
        int length = 200;
        ColorHair hairColor = ColorHair.GRIJS;
        ColorEyes eyeColor = ColorEyes.BRUIN;
        String hobbies = "";
        String description = "Graag buiten";
        
     
        boolean expResult = false;
        boolean result = testController.SetMyProfile(length, hairColor, eyeColor, hobbies, description);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetMyProfileDescription() throws DatingSiteWebServiceException_Exception{
        System.out.println("SetMyProfile");
        DatingController testController = new DatingController();
        testController.Login("test10@30plusdatingtest.nl", "Dating310");
        
        // BEGIN TEST, description voldoet niet aan de eisen/wensen 
        // (length>100)  && (length<250) && (hairColor != null) && (eyeColor != null) && (!hobbies.isEmpty()) && (!description.isEmpty()
        int length = 200;
        ColorHair hairColor = ColorHair.GRIJS;
        ColorEyes eyeColor = ColorEyes.BRUIN;
        String hobbies = "Golf";
        String description = "";
        
     
        boolean expResult = false;
        boolean result = testController.SetMyProfile(length, hairColor, eyeColor, hobbies, description);
        assertEquals(expResult, result);
    }


    /**
     * Test of SetMyPreferences method, of class DatingController.
     */
    @Test
    public void testSetMyPreferences() throws DatingSiteWebServiceException_Exception{
        System.out.println("testSetMyPreferences");
       
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
