/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingsiteclient;

import java.util.ArrayList;
import java.util.List;
import webservice.DatingSiteWebServiceException_Exception;
import webservice.*;

/**
 *
 * @author MS-Laptop
 */
public class DatingController {
    
    static HttpManager hm = new HttpManager();
    
    private final String siteName;
    private List<Message> messagesReceived;
    private List<Message> messagesSend;
    private Preference myPreference;
    private ParticipantInfo myParticipantInfo;
    private Profile myProfile;
    private List<Profile> myMatches;
    private String sessionKey;
    
    public DatingController() throws DatingSiteWebServiceException_Exception{
                  
        siteName = hm.getDatingSiteName();
        messagesReceived = new ArrayList();
        messagesSend = new ArrayList();   
        myPreference = new Preference();
        myParticipantInfo = new ParticipantInfo();
        myProfile = new Profile();
        myMatches = new ArrayList();
        
    }
    
    public boolean Login(String email, String password){
        try{
        sessionKey = hm.login(email, password);
        }
        catch(DatingSiteWebServiceException_Exception e){
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
    
    
}
