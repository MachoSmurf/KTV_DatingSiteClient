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
public class DataSet30 {
    
    IDatingSite ds;
    
    
    public DataSet30(IDatingSite ds){
        this.ds = ds;
    }
    
    public void registerUsers() throws DatingSiteWebServiceException_Exception{
        //registerResult = ds.registerParticipant("Joost Kuijpers", "Hoofdstraat 73", "Groningen", "4183 KS", calendarMale, Gender.MALE, "NL 21 RABO 0123456789", "test@test.nl", "testpass");
        ds.registerParticipant("Test1", "Teststraat 1", "Testcity", "1234AB", generateDate("1987/01/01"), Gender.MALE, "0123451", "test1@30plusdatingtest.nl", "Dating301");
        String sesID = ds.login("test1@30plusdatingtest.nl", "Dating301");
        ds.setProfile(sesID, 170, ColorHair.BLOND, ColorEyes.BLAUW, "Vissen", "Visser");
        ds.setPreference(sesID, Gender.FEMALE, 30, 35, 150, 175, ColorHair.ROOD, ColorEyes.BLAUW);
        ds.logout(sesID);        
        
        ds.registerParticipant("Test2", "Teststraat 2", "Testcity", "1234AC", generateDate("1985/03/01"), Gender.MALE, "0123452", "test2@30plusdatingtest.nl", "Dating302");
        sesID = ds.login("test2@30plusdatingtest.nl", "Dating302");
        ds.setProfile(sesID, 175, ColorHair.BLOND, ColorEyes.BLAUW, "Sporten", "Sportief");
        ds.setPreference(sesID, Gender.FEMALE, 30, 35, 155, 170, ColorHair.ROOD, ColorEyes.BLAUW);
        ds.logout(sesID);  
        
        ds.registerParticipant("Test3", "Teststraat 3", "Testcity", "1234AD", generateDate("1983/05/01"), Gender.MALE, "0123453", "test3@30plusdatingtest.nl", "Dating303");
        sesID = ds.login("test3@30plusdatingtest.nl", "Dating303");
        ds.setProfile(sesID, 175, ColorHair.ROOD, ColorEyes.BLAUW, "Sporten", "Sportief");
        ds.setPreference(sesID, Gender.FEMALE, 30, 35, 160, 170, ColorHair.BLOND, ColorEyes.BLAUW);
        ds.logout(sesID);  
        
        ds.registerParticipant("Test4", "Teststraat 4", "Testcity", "1234AE", generateDate("1981/07/01"), Gender.MALE, "0123454", "test4@30plusdatingtest.nl", "Dating304");
        sesID = ds.login("test4@30plusdatingtest.nl", "Dating304");
        ds.setProfile(sesID, 175, ColorHair.ROOD, ColorEyes.BLAUW, "Motorrijden", "Motorrijder");
        ds.setPreference(sesID, Gender.FEMALE, 35, 40, 160, 165, ColorHair.BRUIN, ColorEyes.BLAUW);
        ds.logout(sesID);  
        
        ds.registerParticipant("Test5", "Teststraat 5", "Testcity", "1234AF", generateDate("1979/09/01"), Gender.MALE, "0123455", "test5@30plusdatingtest.nl", "Dating305");
        sesID = ds.login("test5@30plusdatingtest.nl", "Dating305");
        ds.setProfile(sesID, 180, ColorHair.BRUIN, ColorEyes.BLAUW, "Motorrijden", "Motorrijder");
        ds.setPreference(sesID, Gender.FEMALE, 40, 40, 165, 165, ColorHair.BRUIN, ColorEyes.BLAUW);
        ds.logout(sesID);  
        
        ds.registerParticipant("Test6", "Teststraat 6", "Testcity", "1234AG", generateDate("1977/11/01"), Gender.MALE, "0123456", "test6@30plusdatingtest.nl", "Dating306");
        sesID = ds.login("test6@30plusdatingtest.nl", "Dating306");
        ds.setProfile(sesID, 180, ColorHair.BRUIN, ColorEyes.BRUIN, "Vissen", "Visser");
        ds.setPreference(sesID, Gender.FEMALE, 35, 40, 165, 165, ColorHair.BRUIN, ColorEyes.BRUIN);
        ds.logout(sesID);  
        
        ds.registerParticipant("Test7", "Teststraat 7", "Testcity", "1234AH", generateDate("1975/03/01"), Gender.MALE, "0123457", "test7@30plusdatingtest.nl", "Dating307");
        sesID = ds.login("test7@30plusdatingtest.nl", "Dating307");
        ds.setProfile(sesID, 180, ColorHair.ZWART, ColorEyes.BRUIN, "Tennis", "Sportief");
        ds.setPreference(sesID, Gender.FEMALE, 35, 45, 160, 170, ColorHair.ZWART, ColorEyes.BRUIN);
        ds.logout(sesID);  
        
        ds.registerParticipant("Test8", "Teststraat 8", "Testcity", "1234AI", generateDate("1973/05/01"), Gender.MALE, "0123458", "test8@30plusdatingtest.nl", "Dating308");
        sesID = ds.login("test8@30plusdatingtest.nl", "Dating308");
        ds.setProfile(sesID, 190, ColorHair.ZWART, ColorEyes.BRUIN, "Tennis", "Sportief");
        ds.setPreference(sesID, Gender.FEMALE, 40, 49, 155, 160, ColorHair.ZWART, ColorEyes.BRUIN);
        ds.logout(sesID);  
        
        ds.registerParticipant("Test9", "Teststraat 9", "Testcity", "1234AJ", generateDate("1971/07/01"), Gender.MALE, "0123459", "test9@30plusdatingtest.nl", "Dating309");
        sesID = ds.login("test9@30plusdatingtest.nl", "Dating309");
        ds.setProfile(sesID, 190, ColorHair.GRIJS, ColorEyes.BRUIN, "Golf", "Graag buiten");
        ds.setPreference(sesID, Gender.FEMALE, 45, 55, 170, 170, ColorHair.BLOND, ColorEyes.BRUIN);
        ds.logout(sesID);  
        
        ds.registerParticipant("Test10", "Teststraat 10", "Testcity", "1234AK", generateDate("1969/09/01"), Gender.MALE, "0123450", "test10@30plusdatingtest.nl", "Dating310");
        sesID = ds.login("test10@30plusdatingtest.nl", "Dating310");
        ds.setProfile(sesID, 200, ColorHair.GRIJS, ColorEyes.BRUIN, "Golf", "Graag buiten");
        ds.setPreference(sesID, Gender.FEMALE, 45, 60, 160, 175, ColorHair.BLOND, ColorEyes.BRUIN);
        ds.logout(sesID);  
        
        ds.registerParticipant("Test11", "Teststraat 11", "Testcity", "1234AL", generateDate("1987/01/01"), Gender.FEMALE, "1123456", "test11@30plusdatingtest.nl", "Dating311");
        sesID = ds.login("test11@30plusdatingtest.nl", "Dating311");
        ds.setProfile(sesID, 150, ColorHair.ROOD, ColorEyes.BLAUW, "Festivals", "Houd van feestjes");
        ds.setPreference(sesID, Gender.MALE, 30, 35, 170, 180, ColorHair.BLOND, ColorEyes.BLAUW);
        ds.logout(sesID);  
        
        ds.registerParticipant("Test12", "Teststraat 12", "Testcity", "1234AM", generateDate("1985/03/01"), Gender.FEMALE, "2123456", "test12@30plusdatingtest.nl", "Dating312");
        sesID = ds.login("test12@30plusdatingtest.nl", "Dating312");
        ds.setProfile(sesID, 155, ColorHair.ROOD, ColorEyes.BLAUW, "Shoppen", "Shopt graag");
        ds.setPreference(sesID, Gender.MALE, 30, 35, 175, 180, ColorHair.BLOND, ColorEyes.BLAUW);
        ds.logout(sesID); 
        
        ds.registerParticipant("Test13", "Teststraat 13", "Testcity", "1234AN", generateDate("1983/05/01"), Gender.FEMALE, "3123456", "test13@30plusdatingtest.nl", "Dating313");
        sesID = ds.login("test13@30plusdatingtest.nl", "Dating313");
        ds.setProfile(sesID, 160, ColorHair.BLOND, ColorEyes.BLAUW, "Lezen", "Leest graag boeken");
        ds.setPreference(sesID, Gender.MALE, 30, 35, 175, 180, ColorHair.ROOD, ColorEyes.BLAUW);
        ds.logout(sesID); 
        
        ds.registerParticipant("Test14", "Teststraat 14", "Testcity", "1234AO", generateDate("1981/07/01"), Gender.FEMALE, "4123456", "test14@30plusdatingtest.nl", "Dating314");
        sesID = ds.login("test14@30plusdatingtest.nl", "Dating314");
        ds.setProfile(sesID, 160, ColorHair.BRUIN, ColorEyes.BLAUW, "Shoppen", "Shopt graag");
        ds.setPreference(sesID, Gender.MALE, 35, 40, 175, 190, ColorHair.ROOD, ColorEyes.BLAUW);
        ds.logout(sesID);
        
        ds.registerParticipant("Test15", "Teststraat 15", "Testcity", "1234AP", generateDate("1979/09/01"), Gender.FEMALE, "5123456", "test15@30plusdatingtest.nl", "Dating315");
        sesID = ds.login("test15@30plusdatingtest.nl", "Dating315");
        ds.setProfile(sesID, 165, ColorHair.BRUIN, ColorEyes.BRUIN, "Shoppen", "Shopt graag");
        ds.setPreference(sesID, Gender.MALE, 40, 40, 180, 190, ColorHair.BRUIN, ColorEyes.BLAUW);
        ds.logout(sesID);
        
        ds.registerParticipant("Test16", "Teststraat 16", "Testcity", "1234AQ", generateDate("1977/11/01"), Gender.FEMALE, "6123456", "test16@30plusdatingtest.nl", "Dating316");
        sesID = ds.login("test16@30plusdatingtest.nl", "Dating316");
        ds.setProfile(sesID, 165, ColorHair.BRUIN, ColorEyes.BLAUW, "Lezen", "Leest graag boeken");
        ds.setPreference(sesID, Gender.MALE, 35, 40, 180, 200, ColorHair.BRUIN, ColorEyes.BRUIN);
        ds.logout(sesID); 
        
        ds.registerParticipant("Test17", "Teststraat 17", "Testcity", "1234AR", generateDate("1975/03/01"), Gender.FEMALE, "7123456", "test17@30plusdatingtest.nl", "Dating317");
        sesID = ds.login("test17@30plusdatingtest.nl", "Dating317");
        ds.setProfile(sesID, 165, ColorHair.ZWART, ColorEyes.BRUIN, "Puzzelen", "Houd van raadsels");
        ds.setPreference(sesID, Gender.MALE, 35, 45, 175, 180, ColorHair.ZWART, ColorEyes.BRUIN);
        ds.logout(sesID); 
        
        ds.registerParticipant("Test18", "Teststraat 18", "Testcity", "1234AS", generateDate("1973/05/01"), Gender.FEMALE, "8123456", "test18@30plusdatingtest.nl", "Dating318");
        sesID = ds.login("test18@30plusdatingtest.nl", "Dating318");
        ds.setProfile(sesID, 170, ColorHair.ZWART, ColorEyes.BRUIN, "Puzzelen", "Houd van raadsels");
        ds.setPreference(sesID, Gender.MALE, 40, 49, 175, 190, ColorHair.ZWART, ColorEyes.BRUIN);
        ds.logout(sesID); 
        
        ds.registerParticipant("Test19", "Teststraat 19", "Testcity", "1234AT", generateDate("1971/07/01"), Gender.FEMALE, "9123456", "test19@30plusdatingtest.nl", "Dating319");
        sesID = ds.login("test19@30plusdatingtest.nl", "Dating319");
        ds.setProfile(sesID, 170, ColorHair.BLOND, ColorEyes.BRUIN, "Breien", "Is graag thuis");
        ds.setPreference(sesID, Gender.MALE, 45, 55, 180, 190, ColorHair.GRIJS, ColorEyes.BRUIN);
        ds.logout(sesID); 
        
        ds.registerParticipant("Test20", "Teststraat 20", "Testcity", "1234AU", generateDate("1969/09/01"), Gender.FEMALE, "0123457", "test20@30plusdatingtest.nl", "Dating320");
        sesID = ds.login("test20@30plusdatingtest.nl", "Dating320");
        ds.setProfile(sesID, 175, ColorHair.BLOND, ColorEyes.BRUIN, "Breien", "Is graag thuis");
        ds.setPreference(sesID, Gender.MALE, 45, 60, 180, 200, ColorHair.GRIJS, ColorEyes.BRUIN);
        ds.logout(sesID); 
        
        System.out.println("Dataset 30+ added");
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
