/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingsiteclient;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
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
    public void testLoginTrue() throws DatingSiteWebServiceException_Exception {
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
    public void testLoginPwShort() throws DatingSiteWebServiceException_Exception {
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
    public void testLoginPwLong() throws DatingSiteWebServiceException_Exception {
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
        // voor deze test is het een vereiste dat de gebruiker is ingelogd op de datingsite
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
        // voor deze test is het een vereiste dat de gebruiker is ingelogd op de datingsite
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
        // voor deze test is het een vereiste dat de gebruiker is ingelogd op de datingsite
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
        // voor deze test is het een vereiste dat de gebruiker is ingelogd op de datingsite
        DatingController testController = new DatingController();
        testController.Login("test10@30plusdatingtest.nl", "Dating310");
        
        // BEGIN TEST, hairColor voldoet niet aan de eisen/wensen 
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
        // voor deze test is het een vereiste dat de gebruiker is ingelogd op de datingsite
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
        // voor deze test is het een vereiste dat de gebruiker is ingelogd op de datingsite
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
        // voor deze test is het een vereiste dat de gebruiker is ingelogd op de datingsite
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
    public void testSetMyPreferencesTrue() throws DatingSiteWebServiceException_Exception{
        System.out.println("testSetMyPreferences");        
        // voor deze test is het een vereiste dat de gebruiker is ingelogd op de datingsite
        DatingController testController = new DatingController();
        testController.Login("test10@30plusdatingtest.nl", "Dating310");
       
        // BEGIN TEST, test voldoet aan eisen/wensen
        // (gender != null) && (minAge>18)  && (maxAge<130) && (hairColor != null) && (eyeColor != null) && (minLength>100)  && (maxLength<250)
        Gender gender = Gender.FEMALE;
        int minAge = 45;
        int maxAge = 60;
        int minLength = 160;
        int maxLength = 175;
        ColorHair hairColor = ColorHair.BLOND;
        ColorEyes eyeColor = ColorEyes.BRUIN;
        
        boolean expResult = true;
        boolean result = testController.SetMyPreferences(gender, minAge, maxAge, minLength, maxLength, hairColor, eyeColor);
        assertEquals(expResult, result);
    }
    
       /**
     * Test of SetMyPreferences method, of class DatingController.
     */
    @Test
    public void testSetMyPreferencesFalse() throws DatingSiteWebServiceException_Exception{
        System.out.println("testSetMyPreferences");        
        // voor deze test is het een vereiste dat de gebruiker is ingelogd op de datingsite
        DatingController testController = new DatingController();
        testController.Login("test10@30plusdatingtest.nl", "Dating310");
       
        // BEGIN TEST, test voldoet totaal niet aan eisen/wensen
        // (gender != null) && (minAge>18)  && (maxAge<130) && (hairColor != null) && (eyeColor != null) && (minLength>100)  && (maxLength<250)
        Gender gender = null;
        int minAge = 17;
        int maxAge = 131;
        int minLength = 99;
        int maxLength = 251;
        ColorHair hairColor = null;
        ColorEyes eyeColor = null;
        
        boolean expResult = false;
        boolean result = testController.SetMyPreferences(gender, minAge, maxAge, minLength, maxLength, hairColor, eyeColor);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of SetMyPreferences method, of class DatingController.
     */
    @Test
    public void testSetMyPreferencesGender() throws DatingSiteWebServiceException_Exception{
        System.out.println("testSetMyPreferences");        
        // voor deze test is het een vereiste dat de gebruiker is ingelogd op de datingsite
        DatingController testController = new DatingController();
        testController.Login("test10@30plusdatingtest.nl", "Dating310");
       
        // BEGIN TEST, gender voldoet niet aan eisen/wensen
        // (gender != null) && (minAge>18)  && (maxAge<130) && (hairColor != null) && (eyeColor != null) && (minLength>100)  && (maxLength<250)
        Gender gender = null;
        int minAge = 45;
        int maxAge = 60;
        int minLength = 160;
        int maxLength = 175;
        ColorHair hairColor = ColorHair.BLOND;
        ColorEyes eyeColor = ColorEyes.BRUIN;
        
        boolean expResult = false;
        boolean result = testController.SetMyPreferences(gender, minAge, maxAge, minLength, maxLength, hairColor, eyeColor);
        assertEquals(expResult, result);
    }
    
         /**
     * Test of SetMyPreferences method, of class DatingController.
     */
    @Test
    public void testSetMyPreferencesMinAge() throws DatingSiteWebServiceException_Exception{
        System.out.println("testSetMyPreferences");        
        // voor deze test is het een vereiste dat de gebruiker is ingelogd op de datingsite
        DatingController testController = new DatingController();
        testController.Login("test10@30plusdatingtest.nl", "Dating310");
       
        // BEGIN TEST, minAge voldoet niet aan eisen/wensen
        // (gender != null) && (minAge>18)  && (maxAge<130) && (hairColor != null) && (eyeColor != null) && (minLength>100)  && (maxLength<250)
        Gender gender = Gender.FEMALE;
        int minAge = 17;
        int maxAge = 60;
        int minLength = 160;
        int maxLength = 175;
        ColorHair hairColor = ColorHair.BLOND;
        ColorEyes eyeColor = ColorEyes.BRUIN;
        
        boolean expResult = false;
        boolean result = testController.SetMyPreferences(gender, minAge, maxAge, minLength, maxLength, hairColor, eyeColor);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetMyPreferencesMaxAge() throws DatingSiteWebServiceException_Exception{
        System.out.println("testSetMyPreferences");        
        // voor deze test is het een vereiste dat de gebruiker is ingelogd op de datingsite
        DatingController testController = new DatingController();
        testController.Login("test10@30plusdatingtest.nl", "Dating310");
       
        // BEGIN TEST, maxAge voldoet niet aan eisen/wensen
        // (gender != null) && (minAge>18)  && (maxAge<130) && (hairColor != null) && (eyeColor != null) && (minLength>100)  && (maxLength<250)
        Gender gender = Gender.FEMALE;
        int minAge = 45;
        int maxAge = 131;
        int minLength = 160;
        int maxLength = 175;
        ColorHair hairColor = ColorHair.BLOND;
        ColorEyes eyeColor = ColorEyes.BRUIN;
        
        boolean expResult = false;
        boolean result = testController.SetMyPreferences(gender, minAge, maxAge, minLength, maxLength, hairColor, eyeColor);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetMyPreferencesMinLength() throws DatingSiteWebServiceException_Exception{
        System.out.println("testSetMyPreferences");        
        // voor deze test is het een vereiste dat de gebruiker is ingelogd op de datingsite
        DatingController testController = new DatingController();
        testController.Login("test10@30plusdatingtest.nl", "Dating310");
       
        // BEGIN TEST, minLength voldoet niet aan eisen/wensen
        // (gender != null) && (minAge>18)  && (maxAge<130) && (hairColor != null) && (eyeColor != null) && (minLength>100)  && (maxLength<250)
        Gender gender = Gender.FEMALE;
        int minAge = 17;
        int maxAge = 60;
        int minLength = 99;
        int maxLength = 175;
        ColorHair hairColor = ColorHair.BLOND;
        ColorEyes eyeColor = ColorEyes.BRUIN;
        
        boolean expResult = false;
        boolean result = testController.SetMyPreferences(gender, minAge, maxAge, minLength, maxLength, hairColor, eyeColor);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetMyPreferencesMaxLength() throws DatingSiteWebServiceException_Exception{
        System.out.println("testSetMyPreferences");        
        // voor deze test is het een vereiste dat de gebruiker is ingelogd op de datingsite
        DatingController testController = new DatingController();
        testController.Login("test10@30plusdatingtest.nl", "Dating310");
       
        // BEGIN TEST, mazLength voldoet niet aan eisen/wensen
        // (gender != null) && (minAge>18)  && (maxAge<130) && (hairColor != null) && (eyeColor != null) && (minLength>100)  && (maxLength<250)
        Gender gender = Gender.FEMALE;
        int minAge = 17;
        int maxAge = 60;
        int minLength = 160;
        int maxLength = 251;
        ColorHair hairColor = ColorHair.BLOND;
        ColorEyes eyeColor = ColorEyes.BRUIN;
        
        boolean expResult = false;
        boolean result = testController.SetMyPreferences(gender, minAge, maxAge, minLength, maxLength, hairColor, eyeColor);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetMyPreferencesHairColor() throws DatingSiteWebServiceException_Exception{
        System.out.println("testSetMyPreferences");        
        // voor deze test is het een vereiste dat de gebruiker is ingelogd op de datingsite
        DatingController testController = new DatingController();
        testController.Login("test10@30plusdatingtest.nl", "Dating310");
       
        // BEGIN TEST, hairColor voldoet niet aan eisen/wensen
        // (gender != null) && (minAge>18)  && (maxAge<130) && (hairColor != null) && (eyeColor != null) && (minLength>100)  && (maxLength<250)
        Gender gender = Gender.FEMALE;
        int minAge = 17;
        int maxAge = 60;
        int minLength = 160;
        int maxLength = 175;
        ColorHair hairColor = null;
        ColorEyes eyeColor = ColorEyes.BRUIN;
        
        boolean expResult = false;
        boolean result = testController.SetMyPreferences(gender, minAge, maxAge, minLength, maxLength, hairColor, eyeColor);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetMyPreferencesEyeColor() throws DatingSiteWebServiceException_Exception{
        System.out.println("testSetMyPreferences");        
        // voor deze test is het een vereiste dat de gebruiker is ingelogd op de datingsite
        DatingController testController = new DatingController();
        testController.Login("test10@30plusdatingtest.nl", "Dating310");
       
        // BEGIN TEST, minAge voldoet niet aan eisen/wensen
        // (gender != null) && (minAge>18)  && (maxAge<130) && (hairColor != null) && (eyeColor != null) && (minLength>100)  && (maxLength<250)
        Gender gender = Gender.FEMALE;
        int minAge = 17;
        int maxAge = 60;
        int minLength = 160;
        int maxLength = 175;
        ColorHair hairColor = ColorHair.BLOND;
        ColorEyes eyeColor = null;
        
        boolean expResult = false;
        boolean result = testController.SetMyPreferences(gender, minAge, maxAge, minLength, maxLength, hairColor, eyeColor);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerParticipant method, of class DatingController.
     */
    @Test
    public void testRegisterParticipant() throws DatingSiteWebServiceException_Exception, ParseException, DatatypeConfigurationException{
        System.out.println("testRegisterParticipant");
        
        GregorianCalendar gregory = new GregorianCalendar(1969, 0, 9);

        // BEGIN TEST, 
        String name = "Test41";
        String address = "Teststraat 41";
        String postalCode = "1234AK";
        String place = "Testcity";
        /*XMLGregorianCalendar birthDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
        birthDate.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
        birthDate.setTime(DatatypeConstants.FIELD_UNDEFINED,
                DatatypeConstants.FIELD_UNDEFINED,
                DatatypeConstants.FIELD_UNDEFINED, 
                DatatypeConstants.FIELD_UNDEFINED);*/
        Gender gender = Gender.MALE;
        String bankAccount = "0123450";
        String email = "Test41@30plusdatingtest.nl";
        String password = "Dating341";

        DatingController testController = new DatingController();
        boolean expResult = true;
        boolean result = testController.registerParticipant(name, address, postalCode, place, generateDate("1949/09/01"), gender, bankAccount, email, password);

        assertEquals(expResult, result);

    }
    
    private XMLGregorianCalendar generateDate(String dateString){
        try{
            DateFormat format = new SimpleDateFormat("Y/M/d");
            Date d = format.parse(dateString);
            GregorianCalendar gregory = new GregorianCalendar();
            gregory.setTime(d);
            XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
            return calendar;
        }
        catch(ParseException | DatatypeConfigurationException e)
        {
            System.out.println("Failed to generate date when populating testDataset: " + e.getMessage());
        }
        return null;
    }
    
}
