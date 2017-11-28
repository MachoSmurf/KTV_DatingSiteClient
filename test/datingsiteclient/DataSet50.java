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
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import webservice.ColorEyes;
import webservice.ColorHair;
import webservice.DatingSiteWebServiceException_Exception;
import webservice.Gender;

/**
 *
 * @author MS-Laptop
 */
public class DataSet50 {
    
    IDatingSite ds;
    
    public DataSet50(IDatingSite ds){
        this.ds = ds;
    }
    
    public void registerUsers() throws DatingSiteWebServiceException_Exception{
        //registerResult = ds.registerParticipant("Joost Kuijpers", "Hoofdstraat 73", "Groningen", "4183 KS", calendarMale, Gender.MALE, "NL 21 RABO 0123456789", "test@test.nl", "testpass");
        ds.registerParticipant("Test21", "Teststraat 21", "Testcity", "2345AB", generateDate("1967/01/01"), Gender.MALE, "1234561", "test21@50plusdatingtest.nl", "Dating521");
        String sesID = ds.login("test21@50plusdatingtest.nl", "Dating521");
        ds.setProfile(sesID, 170, ColorHair.BLOND, ColorEyes.BLAUW, "Vissen", "Visser");
        ds.setPreference(sesID, Gender.FEMALE, 50, 55, 150, 175, ColorHair.ROOD, ColorEyes.BLAUW);
        ds.logout(sesID);        
        
        ds.registerParticipant("Test22", "Teststraat 22", "Testcity", "2345AC", generateDate("1965/03/01"), Gender.MALE, "1234562", "test22@50plusdatingtest.nl", "Dating522");
        sesID = ds.login("test22@50plusdatingtest.nl", "Dating522");
        ds.setProfile(sesID, 175, ColorHair.BLOND, ColorEyes.BLAUW, "Sporten", "Sportief");
        ds.setPreference(sesID, Gender.FEMALE, 50, 55, 155, 170, ColorHair.ROOD, ColorEyes.BLAUW);
        ds.logout(sesID);  
        
        ds.registerParticipant("Test23", "Teststraat 23", "Testcity", "2345AD", generateDate("1963/05/01"), Gender.MALE, "1234563", "test23@50plusdatingtest.nl", "Dating523");
        sesID = ds.login("test23@50plusdatingtest.nl", "Dating523");
        ds.setProfile(sesID, 175, ColorHair.ROOD, ColorEyes.BLAUW, "Sporten", "Sportief");
        ds.setPreference(sesID, Gender.FEMALE, 30, 35, 160, 170, ColorHair.BLOND, ColorEyes.BLAUW);
        ds.logout(sesID);  
        
        ds.registerParticipant("Test24", "Teststraat 24", "Testcity", "2345AE", generateDate("1961/07/01"), Gender.MALE, "1234564", "test24@50plusdatingtest.nl", "Dating524");
        sesID = ds.login("test24@50plusdatingtest.nl", "Dating524");
        ds.setProfile(sesID, 175, ColorHair.ROOD, ColorEyes.BLAUW, "Motorrijden", "Motorrijder");
        ds.setPreference(sesID, Gender.FEMALE, 55, 60, 160, 165, ColorHair.BRUIN, ColorEyes.BLAUW);
        ds.logout(sesID);  
        
        ds.registerParticipant("Test25", "Teststraat 25", "Testcity", "2345AF", generateDate("1969/09/01"), Gender.MALE, "1234565", "test25@50plusdatingtest.nl", "Dating525");
        sesID = ds.login("test25@50plusdatingtest.nl", "Dating525");
        ds.setProfile(sesID, 180, ColorHair.BRUIN, ColorEyes.BLAUW, "Motorrijden", "Motorrijder");
        ds.setPreference(sesID, Gender.FEMALE, 60, 60, 165, 165, ColorHair.BLOND, ColorEyes.BRUIN);
        ds.logout(sesID);  
        
        ds.registerParticipant("Test26", "Teststraat 26", "Testcity", "2345AG", generateDate("1957/11/01"), Gender.MALE, "1234566", "test26@50plusdatingtest.nl", "Dating526");
        sesID = ds.login("test26@50plusdatingtest.nl", "Dating526");
        ds.setProfile(sesID, 180, ColorHair.GRIJS, ColorEyes.BRUIN, "Vissen", "Visser");
        ds.setPreference(sesID, Gender.FEMALE, 45, 60, 165, 165, ColorHair.BLOND, ColorEyes.BRUIN);
        ds.logout(sesID);  
        
        ds.registerParticipant("Test27", "Teststraat 27", "Testcity", "2345AH", generateDate("1955/03/01"), Gender.MALE, "1234567", "test27@50plusdatingtest.nl", "Dating527");
        sesID = ds.login("test27@50plusdatingtest.nl", "Dating527");
        ds.setProfile(sesID, 180, ColorHair.ZWART, ColorEyes.BRUIN, "Tennis", "Sportief");
        ds.setPreference(sesID, Gender.FEMALE, 55, 65, 160, 170, ColorHair.ZWART, ColorEyes.BRUIN);
        ds.logout(sesID);  
        
        ds.registerParticipant("Test28", "Teststraat 28", "Testcity", "2345AI", generateDate("1953/05/01"), Gender.MALE, "1234568", "test28@50plusdatingtest.nl", "Dating528");
        sesID = ds.login("test28@50plusdatingtest.nl", "Dating528");
        ds.setProfile(sesID, 190, ColorHair.ZWART, ColorEyes.BRUIN, "Tennis", "Sportief");
        ds.setPreference(sesID, Gender.FEMALE, 40, 49, 155, 160, ColorHair.ZWART, ColorEyes.BRUIN);
        ds.logout(sesID);  
        
        ds.registerParticipant("Test29", "Teststraat 29", "Testcity", "2345AJ", generateDate("1951/07/01"), Gender.MALE, "1234569", "test29@50plusdatingtest.nl", "Dating529");
        sesID = ds.login("test29@50plusdatingtest.nl", "Dating529");
        ds.setProfile(sesID, 190, ColorHair.GRIJS, ColorEyes.BRUIN, "Golf", "Graag buiten");
        ds.setPreference(sesID, Gender.FEMALE, 65, 69, 170, 170, ColorHair.BLOND, ColorEyes.BRUIN);
        ds.logout(sesID);  
        
        ds.registerParticipant("Test30", "Teststraat 30", "Testcity", "2345AK", generateDate("1949/09/01"), Gender.MALE, "1234560", "test30@50plusdatingtest.nl", "Dating530");
        sesID = ds.login("test30@50plusdatingtest.nl", "Dating530");
        ds.setProfile(sesID, 200, ColorHair.GRIJS, ColorEyes.BRUIN, "Golf", "Graag buiten");
        ds.setPreference(sesID, Gender.FEMALE, 65, 69, 160, 175, ColorHair.BLOND, ColorEyes.BRUIN);
        ds.logout(sesID);  
        
        ds.registerParticipant("Test31", "Teststraat 31", "Testcity", "2345AL", generateDate("1967/01/01"), Gender.FEMALE, "1234570", "test31@50plusdatingtest.nl", "Dating531");
        sesID = ds.login("test31@50plusdatingtest.nl", "Dating531");
        ds.setProfile(sesID, 150, ColorHair.ROOD, ColorEyes.BLAUW, "Festivals", "Houd van feestjes");
        ds.setPreference(sesID, Gender.MALE, 50, 55, 170, 180, ColorHair.BLOND, ColorEyes.BLAUW);
        ds.logout(sesID);  
        
        ds.registerParticipant("Test32", "Teststraat 32", "Testcity", "2345AM", generateDate("1965/03/01"), Gender.FEMALE, "2234567", "test32@50plusdatingtest.nl", "Dating532");
        sesID = ds.login("test32@50plusdatingtest.nl", "Dating532");
        ds.setProfile(sesID, 155, ColorHair.ROOD, ColorEyes.BLAUW, "Shoppen", "Shopt graag");
        ds.setPreference(sesID, Gender.MALE, 50, 55, 175, 180, ColorHair.BLOND, ColorEyes.BLAUW);
        ds.logout(sesID); 
        
        ds.registerParticipant("Test33", "Teststraat 33", "Testcity", "2345AN", generateDate("1963/05/01"), Gender.FEMALE, "3234567", "test33@50plusdatingtest.nl", "Dating533");
        sesID = ds.login("test33@50plusdatingtest.nl", "Dating533");
        ds.setProfile(sesID, 160, ColorHair.BLOND, ColorEyes.BLAUW, "Lezen", "Leest graag boeken");
        ds.setPreference(sesID, Gender.MALE, 50, 55, 175, 180, ColorHair.ROOD, ColorEyes.BLAUW);
        ds.logout(sesID); 
        
        ds.registerParticipant("Test34", "Teststraat 34", "Testcity", "2345AO", generateDate("1961/07/01"), Gender.FEMALE, "4234567", "test34@50plusdatingtest.nl", "Dating534");
        sesID = ds.login("test34@50plusdatingtest.nl", "Dating534");
        ds.setProfile(sesID, 160, ColorHair.BRUIN, ColorEyes.BLAUW, "Shoppen", "Shopt graag");
        ds.setPreference(sesID, Gender.MALE, 55, 60, 175, 190, ColorHair.ROOD, ColorEyes.BLAUW);
        ds.logout(sesID);
        
        ds.registerParticipant("Test35", "Teststraat 35", "Testcity", "2345AP", generateDate("1959/09/01"), Gender.FEMALE, "5234567", "test35@50plusdatingtest.nl", "Dating535");
        sesID = ds.login("test35@50plusdatingtest.nl", "Dating535");
        ds.setProfile(sesID, 165, ColorHair.BLOND, ColorEyes.BRUIN, "Shoppen", "Shopt graag");
        ds.setPreference(sesID, Gender.MALE, 60, 60, 180, 190, ColorHair.BRUIN, ColorEyes.BLAUW);
        ds.logout(sesID);
        
        ds.registerParticipant("Test36", "Teststraat 36", "Testcity", "2345AQ", generateDate("1957/11/01"), Gender.FEMALE, "6234567", "test36@50plusdatingtest.nl", "Dating536");
        sesID = ds.login("test36@50plusdatingtest.nl", "Dating536");
        ds.setProfile(sesID, 165, ColorHair.BLOND, ColorEyes.BRUIN, "Lezen", "Leest graag boeken");
        ds.setPreference(sesID, Gender.MALE, 45, 60, 180, 200, ColorHair.GRIJS, ColorEyes.BRUIN);
        ds.logout(sesID); 
        
        ds.registerParticipant("Test37", "Teststraat 37", "Testcity", "2345AR", generateDate("1955/03/01"), Gender.FEMALE, "7234567", "test37@50plusdatingtest.nl", "Dating537");
        sesID = ds.login("test37@50plusdatingtest.nl", "Dating537");
        ds.setProfile(sesID, 165, ColorHair.ZWART, ColorEyes.BRUIN, "Puzzelen", "Houd van raadsels");
        ds.setPreference(sesID, Gender.MALE, 55, 65, 175, 180, ColorHair.ZWART, ColorEyes.BRUIN);
        ds.logout(sesID); 
        
        ds.registerParticipant("Test38", "Teststraat 38", "Testcity", "2345AS", generateDate("1953/05/01"), Gender.FEMALE, "8234567", "test38@50plusdatingtest.nl", "Dating538");
        sesID = ds.login("test38@50plusdatingtest.nl", "Dating538");
        ds.setProfile(sesID, 170, ColorHair.ZWART, ColorEyes.BRUIN, "Puzzelen", "Houd van raadsels");
        ds.setPreference(sesID, Gender.MALE, 60, 69, 175, 190, ColorHair.ZWART, ColorEyes.BRUIN);
        ds.logout(sesID); 
        
        ds.registerParticipant("Test39", "Teststraat 39", "Testcity", "2345AT", generateDate("1951/07/01"), Gender.FEMALE, "9234567", "test39@50plusdatingtest.nl", "Dating539");
        sesID = ds.login("test39@50plusdatingtest.nl", "Dating539");
        ds.setProfile(sesID, 170, ColorHair.BLOND, ColorEyes.BRUIN, "Breien", "Is graag thuis");
        ds.setPreference(sesID, Gender.MALE, 65, 66, 180, 190, ColorHair.GRIJS, ColorEyes.BRUIN);
        ds.logout(sesID); 
        
        ds.registerParticipant("Test40", "Teststraat 40", "Testcity", "2345AU", generateDate("1949/09/01"), Gender.FEMALE, "0234567", "test40@50plusdatingtest.nl", "Dating540");
        sesID = ds.login("test40@50plusdatingtest.nl", "Dating540");
        ds.setProfile(sesID, 175, ColorHair.BLOND, ColorEyes.BRUIN, "Breien", "Is graag thuis");
        ds.setPreference(sesID, Gender.MALE, 65, 69, 180, 200, ColorHair.GRIJS, ColorEyes.BRUIN);
        ds.logout(sesID); 
        
        System.out.println("Dataset 50+ added");
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
    
    private String Login(String email, String passwd) throws DatingSiteWebServiceException_Exception{
        return ds.login(email, passwd);
    }
}
