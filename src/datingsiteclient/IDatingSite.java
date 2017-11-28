/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingsiteclient;

import javax.xml.datatype.XMLGregorianCalendar;
import webservice.ColorEyes;
import webservice.ColorHair;
import webservice.DatingSiteWebServiceException_Exception;
import webservice.Gender;
import webservice.ParticipantInfo;
import webservice.Preference;
import webservice.Profile;

/**
 *
 * @author MS-Laptop
 */
public interface IDatingSite {

    public boolean registerParticipant(String test1, String teststraat_1, String testcity, String ab, XMLGregorianCalendar generateDate, Gender gender, String string, String test130plusdatingtestnl, String dating301) throws DatingSiteWebServiceException_Exception;

    public String login(String test130plusdatingtestnl, String dating301) throws DatingSiteWebServiceException_Exception;

    public Profile setProfile(String sesID, int i, ColorHair colorHair, ColorEyes colorEyes, String vissen, String visser) throws DatingSiteWebServiceException_Exception;

    public Preference setPreference(String sesID, Gender gender, int i, int i0, int i1, int i2, ColorHair colorHair, ColorEyes colorEyes) throws DatingSiteWebServiceException_Exception;

    public boolean logout(String sesID) throws DatingSiteWebServiceException_Exception;
    
    public String getDatingSiteName() throws DatingSiteWebServiceException_Exception;
    
    public java.util.List<webservice.Message> getMessagesReceived(java.lang.String arg0) throws DatingSiteWebServiceException_Exception;
    
    public java.util.List<webservice.Message> getMessagesSent(java.lang.String arg0) throws DatingSiteWebServiceException_Exception;
    
    public ParticipantInfo getParticipantInfo(java.lang.String arg0) throws DatingSiteWebServiceException_Exception;
    
    public Preference getPreference(java.lang.String arg0) throws DatingSiteWebServiceException_Exception;
    
    public Profile getProfile(java.lang.String arg0) throws DatingSiteWebServiceException_Exception;
    
    public java.util.List<webservice.Profile> requestMatchingProfiles(java.lang.String arg0) throws DatingSiteWebServiceException_Exception;
    
    public boolean sendMessage(java.lang.String arg0, webservice.Profile arg1, java.lang.String arg2) throws DatingSiteWebServiceException_Exception;
    
    public boolean unregisterParticipant(java.lang.String arg0) throws DatingSiteWebServiceException_Exception;
    
}
