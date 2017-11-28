/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingsiteclient;

import webservice.DatingSiteWebServiceException_Exception;
import webservice.ParticipantInfo;
import webservice.Preference;
import webservice.Profile;

/**
 *
 * @author MS-Laptop
 */
public class HttpManager implements IDatingSite {

    public String getDatingSiteName() throws DatingSiteWebServiceException_Exception {
        webservice.DatingSiteForClientService service = new webservice.DatingSiteForClientService();
        webservice.IDatingSiteForClient port = service.getDatingSiteForClientPort();
        return port.getDatingSiteName();
    }

    public java.util.List<webservice.Message> getMessagesReceived(java.lang.String arg0) throws DatingSiteWebServiceException_Exception {
        webservice.DatingSiteForClientService service = new webservice.DatingSiteForClientService();
        webservice.IDatingSiteForClient port = service.getDatingSiteForClientPort();
        return port.getMessagesReceived(arg0);
    }

    public java.util.List<webservice.Message> getMessagesSent(java.lang.String arg0) throws DatingSiteWebServiceException_Exception {
        webservice.DatingSiteForClientService service = new webservice.DatingSiteForClientService();
        webservice.IDatingSiteForClient port = service.getDatingSiteForClientPort();
        return port.getMessagesSent(arg0);
    }

    public ParticipantInfo getParticipantInfo(java.lang.String arg0) throws DatingSiteWebServiceException_Exception {
        webservice.DatingSiteForClientService service = new webservice.DatingSiteForClientService();
        webservice.IDatingSiteForClient port = service.getDatingSiteForClientPort();
        return port.getParticipantInfo(arg0);
    }

    public Preference getPreference(java.lang.String arg0) throws DatingSiteWebServiceException_Exception {
        webservice.DatingSiteForClientService service = new webservice.DatingSiteForClientService();
        webservice.IDatingSiteForClient port = service.getDatingSiteForClientPort();
        return port.getPreference(arg0);
    }

    public Profile getProfile(java.lang.String arg0) throws DatingSiteWebServiceException_Exception {
        webservice.DatingSiteForClientService service = new webservice.DatingSiteForClientService();
        webservice.IDatingSiteForClient port = service.getDatingSiteForClientPort();
        return port.getProfile(arg0);
    }

    public String login(java.lang.String arg0, java.lang.String arg1) throws DatingSiteWebServiceException_Exception {
        webservice.DatingSiteForClientService service = new webservice.DatingSiteForClientService();
        webservice.IDatingSiteForClient port = service.getDatingSiteForClientPort();
        return port.login(arg0, arg1);
    }

    public boolean logout(java.lang.String arg0) throws DatingSiteWebServiceException_Exception {
        webservice.DatingSiteForClientService service = new webservice.DatingSiteForClientService();
        webservice.IDatingSiteForClient port = service.getDatingSiteForClientPort();
        return port.logout(arg0);
    }

    public boolean registerParticipant(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, javax.xml.datatype.XMLGregorianCalendar arg4, webservice.Gender arg5, java.lang.String arg6, java.lang.String arg7, java.lang.String arg8) throws DatingSiteWebServiceException_Exception {
        webservice.DatingSiteForClientService service = new webservice.DatingSiteForClientService();
        webservice.IDatingSiteForClient port = service.getDatingSiteForClientPort();
        return port.registerParticipant(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public java.util.List<webservice.Profile> requestMatchingProfiles(java.lang.String arg0) throws DatingSiteWebServiceException_Exception {
        webservice.DatingSiteForClientService service = new webservice.DatingSiteForClientService();
        webservice.IDatingSiteForClient port = service.getDatingSiteForClientPort();
        return port.requestMatchingProfiles(arg0);
    }

    public boolean sendMessage(java.lang.String arg0, webservice.Profile arg1, java.lang.String arg2) throws DatingSiteWebServiceException_Exception {
        webservice.DatingSiteForClientService service = new webservice.DatingSiteForClientService();
        webservice.IDatingSiteForClient port = service.getDatingSiteForClientPort();
        return port.sendMessage(arg0, arg1, arg2);
    }

    public Preference setPreference(java.lang.String arg0, webservice.Gender arg1, int arg2, int arg3, int arg4, int arg5, webservice.ColorHair arg6, webservice.ColorEyes arg7) throws DatingSiteWebServiceException_Exception {
        webservice.DatingSiteForClientService service = new webservice.DatingSiteForClientService();
        webservice.IDatingSiteForClient port = service.getDatingSiteForClientPort();
        return port.setPreference(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public Profile setProfile(java.lang.String arg0, int arg1, webservice.ColorHair arg2, webservice.ColorEyes arg3, java.lang.String arg4, java.lang.String arg5) throws DatingSiteWebServiceException_Exception {
        webservice.DatingSiteForClientService service = new webservice.DatingSiteForClientService();
        webservice.IDatingSiteForClient port = service.getDatingSiteForClientPort();
        return port.setProfile(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public boolean unregisterParticipant(java.lang.String arg0) throws DatingSiteWebServiceException_Exception {
        webservice.DatingSiteForClientService service = new webservice.DatingSiteForClientService();
        webservice.IDatingSiteForClient port = service.getDatingSiteForClientPort();
        return port.unregisterParticipant(arg0);
    }
    
}
