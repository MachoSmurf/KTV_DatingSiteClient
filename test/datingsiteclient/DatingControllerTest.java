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
import org.junit.Assert;
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
        System.out.println("testLoginTrue");
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
    public void testLoginPwLong() throws DatingSiteWebServiceException_Exception {
        System.out.println("testLoginPwLong");
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
    public void testLoginPwShort() throws DatingSiteWebServiceException_Exception {
        System.out.println("testLoginPwShort");
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
        System.out.println("testSetMyProfileTrue");
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
        System.out.println("testSetMyProfileFalse");
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
        System.out.println("testSetMyProfileLength");
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
        System.out.println("testSetMyProfileHairColor");
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
        System.out.println("testSetMyProfileEyeColor");
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
        System.out.println("testSetMyProfileHobbies");
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
        System.out.println("testSetMyProfileDescription");
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
        System.out.println("testSetMyPreferencesTrue");        
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
        System.out.println("testSetMyPreferencesFalse");        
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
        System.out.println("testSetMyPreferencesGender");        
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
        System.out.println("testSetMyPreferencesMinAge");        
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
        System.out.println("testSetMyPreferencesMaxAge");        
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
        System.out.println("testSetMyPreferencesMinLength");        
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
        System.out.println("testSetMyPreferencesMaxLength");        
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
        System.out.println("testSetMyPreferencesHairColor");        
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
        System.out.println("testSetMyPreferencesEyeColor");        
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
    public void testRegisterParticipantTrue() throws DatingSiteWebServiceException_Exception, ParseException, DatatypeConfigurationException{
        System.out.println("testRegisterParticipantTrue");
        
        // BEGIN TEST, test voldoet aan wensen/ eisen 
        String name = "Test42";
        String address = "Teststraat 45";
        String postalCode = "1234AK";
        String place = "Testcity";
        Gender gender = Gender.MALE;
        String bankAccount = "0123451";
        String email = "Test42@30plusdatingtest.nl";
        String password = "Dating342";

        DatingController testController = new DatingController();
        boolean expResult = true;
        boolean result = testController.registerParticipant(name, address, postalCode, place, generateDate("1969/01/09"), gender, bankAccount, email, password);

        assertEquals(expResult, result);
    }
  
    /**
     * Test of registerParticipant method, of class DatingController.
     */
    
    @Test
    public void testRegisterParticipantName() throws DatingSiteWebServiceException_Exception, ParseException, DatatypeConfigurationException{
        System.out.println("testRegisterParticipantName");
        
        // BEGIN TEST, name voldoet aan wensen/ eisen 
        String name = " ";
        String address = "Teststraat 43";
        String postalCode = "1234AK";
        String place = "Testcity";
        Gender gender = Gender.MALE;
        String bankAccount = "0123451";
        String email = "Test43@30plusdatingtest.nl";
        String password = "Dating343";

        DatingController testController = new DatingController();
        boolean expResult = false;
        boolean result = testController.registerParticipant(name, address, postalCode, place, generateDate("1969/02/09"), gender, bankAccount, email, password);

        assertEquals(expResult, result);
    }
    
     /**
     * Test of registerParticipant method, of class DatingController.
     */
    
    @Test
    public void testRegisterParticipantAdress() throws DatingSiteWebServiceException_Exception, ParseException, DatatypeConfigurationException{
        System.out.println("testRegisterParticipantAdress");
        
        // BEGIN TEST, adress voldoet aan wensen/ eisen 
        String name = "Test43";
        String address = " ";
        String postalCode = "1234AK";
        String place = "Testcity";
        Gender gender = Gender.MALE;
        String bankAccount = "0123451";
        String email = "Test43@30plusdatingtest.nl";
        String password = "Dating343";

        DatingController testController = new DatingController();
        boolean expResult = false;
        boolean result = testController.registerParticipant(name, address, postalCode, place, generateDate("1969/02/09"), gender, bankAccount, email, password);

        assertEquals(expResult, result);
    }
    
     /**
     * Test of registerParticipant method, of class DatingController.
     */
    
    @Test
    public void testRegisterParticipantPostalCode() throws DatingSiteWebServiceException_Exception, ParseException, DatatypeConfigurationException{
        System.out.println("testRegisterParticipant");
        
        // BEGIN TEST, postalCode voldoet aan wensen/ eisen 
        String name = "Test43";
        String address = "Teststraat 43";
        String postalCode = " ";
        String place = "Testcity";
        Gender gender = Gender.MALE;
        String bankAccount = "0123451";
        String email = "Test43@30plusdatingtest.nl";
        String password = "Dating343";

        DatingController testController = new DatingController();
        boolean expResult = false;
        boolean result = testController.registerParticipant(name, address, postalCode, place, generateDate("1969/02/09"), gender, bankAccount, email, password);

        assertEquals(expResult, result);
    }
    
     /**
     * Test of registerParticipant method, of class DatingController.
     */
    
    @Test
    public void testRegisterParticipantPlace() throws DatingSiteWebServiceException_Exception, ParseException, DatatypeConfigurationException{
        System.out.println("testRegisterParticipantPlace");
        
        // BEGIN TEST, place voldoet aan wensen/ eisen 
        String name = "Test43";
        String address = "Teststraat 43";
        String postalCode = "1234AK";
        String place = " ";
        Gender gender = Gender.MALE;
        String bankAccount = "0123451";
        String email = "Test43@30plusdatingtest.nl";
        String password = "Dating343";

        DatingController testController = new DatingController();
        boolean expResult = false;
        boolean result = testController.registerParticipant(name, address, postalCode, place, generateDate("1969/02/09"), gender, bankAccount, email, password);

        assertEquals(expResult, result);
    }
    
     /**
     * Test of registerParticipant method, of class DatingController.
     */
    
       @Test
    public void testRegisterParticipantBa() throws DatingSiteWebServiceException_Exception, ParseException, DatatypeConfigurationException{
        System.out.println("testRegisterParticipantBa");
        
        // BEGIN TEST, bankAccount voldoet aan wensen/ eisen 
        String name = "Test43";
        String address = "Teststraat 43";
        String postalCode = "1234AK";
        String place = "Testcity ";
        Gender gender = Gender.MALE;
        String bankAccount = " ";
        String email = "Test43@30plusdatingtest.nl";
        String password = "Dating343";

        DatingController testController = new DatingController();
        boolean expResult = false;
        boolean result = testController.registerParticipant(name, address, postalCode, place, generateDate("1969/02/09"), gender, bankAccount, email, password);

        assertEquals(expResult, result);
    }
    
    /**
     * Test of registerParticipant method, of class DatingController.
     */
    
       @Test
    public void testRegisterParticipantEmail() throws DatingSiteWebServiceException_Exception, ParseException, DatatypeConfigurationException{
        System.out.println("testRegisterParticipantEmail");
        
        // BEGIN TEST, email voldoet aan wensen/ eisen 
        String name = "Test43";
        String address = "Teststraat 43";
        String postalCode = "1234AK";
        String place = "Testcity ";
        Gender gender = Gender.MALE;
        String bankAccount = "0123451";
        String email = " ";
        String password = "Dating343";

        DatingController testController = new DatingController();
        boolean expResult = false;
        boolean result = testController.registerParticipant(name, address, postalCode, place, generateDate("1969/02/09"), gender, bankAccount, email, password);

        assertEquals(expResult, result);
    }
    
     /**
     * Test of registerParticipant method, of class DatingController.
     */
    
       @Test
    public void testRegisterParticipantPassword() throws DatingSiteWebServiceException_Exception, ParseException, DatatypeConfigurationException{
        System.out.println("testRegisterParticipantPassword");
        
        // BEGIN TEST, password voldoet aan wensen/ eisen 
        String name = "Test43";
        String address = "Teststraat 43";
        String postalCode = "1234AK";
        String place = "Testcity ";
        Gender gender = Gender.MALE;
        String bankAccount = "0123451";
        String email = "Test43@30plusdatingtest.nl";
        String password = "123 ";

        DatingController testController = new DatingController();
        boolean expResult = false;
        boolean result = testController.registerParticipant(name, address, postalCode, place, generateDate("1969/02/09"), gender, bankAccount, email, password);
        
        assertEquals(expResult, result);
    }
    
     /**
     * Test of registerParticipant method, of class DatingController.
     */
    
       @Test
    public void testRegisterParticipantBirthdate() throws DatingSiteWebServiceException_Exception, ParseException, DatatypeConfigurationException{
        System.out.println("testRegisterParticipantBirthdate");
        
        // BEGIN TEST, password voldoet aan wensen/ eisen 
        String name = "Test43";
        String address = "Teststraat 43";
        String postalCode = "1234AK";
        String place = "Testcity ";
        Gender gender = Gender.MALE;
        String bankAccount = "0123451";
        String email = "Test43@30plusdatingtest.nl";
        String password = "Dating343 ";

        DatingController testController = new DatingController();
        boolean expResult = false;
        boolean result = testController.registerParticipant(name, address, postalCode, place, generateDate("1900/01/01"), gender, bankAccount, email, password);
        
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
