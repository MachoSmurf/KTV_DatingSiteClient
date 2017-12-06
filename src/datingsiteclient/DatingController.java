/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingsiteclient;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import webservice.DatingSiteWebServiceException_Exception;
import webservice.*;

/**
 *
 * @author MS-Laptop
 */
public class DatingController {
    
    static HttpManager hm = new HttpManager();
    
    private String siteName;
    private List<Message> messagesReceived;
    private List<Message> messagesSend;
    private Preference myPreference;
    private ParticipantInfo myParticipantInfo;
    private Profile myProfile;
    private List<Profile> myMatches;
    private String sessionKey;
    
    public DatingController() throws DatingSiteWebServiceException_Exception{
                  
        try{            
            siteName = hm.getDatingSiteName();
        }
        catch(DatingSiteWebServiceException_Exception e)
        {
            siteName = "";
            System.out.println("Could not connect to DatingSiteServer");
        }
        messagesReceived = new ArrayList();
        messagesSend = new ArrayList();   
        myPreference = new Preference();
        myParticipantInfo = new ParticipantInfo();
        myProfile = new Profile();
        myMatches = new ArrayList();
        
        System.out.println("DatingController initiated");
        
    }
    
    public boolean Login(String email, String password){
        try{
            sessionKey = hm.login(email, password);
            if (sessionKey.length() != 10)
            {
                System.out.println("Invalid session key");
                return false;
            }
            else{
                //fetch users own profile
                myProfile = this.GetMyProfile();
            }
            System.out.println(sessionKey);
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        } 
        return true;
    }
    
    public boolean Logout(){
        try{
            return hm.logout(sessionKey);
        }
        catch(DatingSiteWebServiceException_Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    public String GetSiteName(){
        return siteName;
    }    
    
    public ParticipantInfo GetMyInfo(){
        if (sessionKey.length() == 10){
            try{
                this.myParticipantInfo = hm.getParticipantInfo(sessionKey);
                return this.myParticipantInfo;
            }
            catch(DatingSiteWebServiceException_Exception e){
                System.out.println(e);
                return null;
            }
        }
        return null;
    }
    
    public Profile GetMyProfile(){
        if (sessionKey.length() == 10){
            try{
                this.myProfile = hm.getProfile(sessionKey);
                //System.out.println(myProfile.getColorHair().toString());
                return this.myProfile;
            }
            catch(DatingSiteWebServiceException_Exception e){
                System.out.println(e);
                return null;
            }
        }
        System.out.println("Invalid session key");
        return null;
    }
    
    public Preference GetMyPreference(){
        if (sessionKey.length() == 10){
            try{
                this.myPreference = hm.getPreference(sessionKey);
                return this.myPreference;
            }
            catch(DatingSiteWebServiceException_Exception e){
                System.out.println(e);
                return null;
            }
        }
        return null;
    }
    
    public List<Profile> GetMatches(){
        ReloadMatches();
        return this.myMatches;
    }
    
    private void ReloadMatches(){
        if (sessionKey.length() == 10){
            try{
                List<Profile> rawMatches = hm.requestMatchingProfiles(sessionKey);
                //filter out double matches when using the exchange server
                for (Profile p : rawMatches){
                    boolean found = false;
                    for (Profile pCheck : this.myMatches){
                        if (pCheck.getProfileId().equals(p.getProfileId())){
                            found = true;
                        }                        
                    }    
                    if (!found){
                        this.myMatches.add(p);
                    }
                }
            }
            catch(DatingSiteWebServiceException_Exception e){
                System.out.println(e);
            }
        }
    }
    
    public List<Message> GetSendMessages(){
        if (sessionKey.length() == 10){
            try{
                this.messagesSend = hm.getMessagesSent(sessionKey);
                return this.messagesSend;
            }
            catch(DatingSiteWebServiceException_Exception e){
                System.out.println(e);
                return null;
            }
        }
        return null;
    }
    
    public List<Message> GetReceivedMessages(){
        if (sessionKey.length() == 10){
            try{
                this.messagesReceived = hm.getMessagesReceived(sessionKey);
                return this.messagesReceived;
            }
            catch(DatingSiteWebServiceException_Exception e){
                System.out.println(e);
                return null;
            }
        }
        return null;
    }
    
    public boolean SetMyProfile(int length, ColorHair hairColor, ColorEyes eyeColor, String hobbies, String description){
        
       if ((length>100)  && (length<250) && (hairColor != null) && (eyeColor != null) && (!hobbies.isEmpty()) && (!description.isEmpty())){
           try{
               this.myProfile = hm.setProfile(sessionKey, length, hairColor, eyeColor, hobbies, description);
               return true;
           }
           catch(DatingSiteWebServiceException_Exception e){
                System.out.println(e);
                return false;
            }
       }
       System.out.println("Use correct parameters when settings profile");
       return false;
    }
    
    public boolean SetMyPreferences(Gender gender, int minAge, int maxAge, int minLength, int maxLength, ColorHair hairColor, ColorEyes eyeColor){
        if ((gender != null) && (minAge>18)  && (maxAge<130) && (hairColor != null) && (eyeColor != null) && (minLength>100)  && (maxLength<250)){
           try{
               this.myPreference = hm.setPreference(sessionKey, gender, minAge, maxAge, minLength, maxLength, hairColor, eyeColor);
               return true;
           }
           catch(DatingSiteWebServiceException_Exception e){
                System.out.println(e);
                return false;
            }
       }
       System.out.println("Use correct parameters when settings profile");
       return false;
    }
       
    public boolean SendMessage(Profile receipient, String messageContent) throws DatingSiteWebServiceException_Exception{
        if ((receipient != null) && (!"".equals(messageContent))){            
            return hm.sendMessage(sessionKey, receipient, messageContent);
        }
        return false;
    }
    
    public boolean registerParticipant(String name, String address, String postalCode, String place, XMLGregorianCalendar birthDate, Gender gender, String bankAccount, String email, String password) throws DatingSiteWebServiceException_Exception{
        return hm.registerParticipant(name, address, postalCode, place, birthDate, gender, bankAccount, email, password);
    }
    
    public String GetMyProfileID(){
        return myProfile.getProfileId();
    }
    
}
