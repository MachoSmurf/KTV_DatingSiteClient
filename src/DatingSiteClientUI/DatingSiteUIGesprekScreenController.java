/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatingSiteClientUI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import webservice.DatingSiteWebServiceException_Exception;
import webservice.Gender;
import webservice.Message;
import webservice.Profile;

/**
 * FXML Controller class
 *
 * @author MS-Laptop
 */
public class DatingSiteUIGesprekScreenController extends DatingSiteUIController implements Initializable {

    @FXML
    private Label lblConversationsAge;
    @FXML 
    private TextArea taGesprekBox;
    @FXML
    private Button btnReturnToSearch;
    @FXML 
    private ListView lvMessagePartners;
    @FXML
    private TextArea tbMessageContent;
    
    private Profile currentMessagePartner;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    @FXML
    private void onCancel(ActionEvent event) throws IOException{
        DatingSiteUISearchScreenController c = (DatingSiteUISearchScreenController)changeScreen("/DatingSiteClientUI/DatingSiteUISearchScreen.fxml", event);
        c.zoekMatchesClick(null); 
    }
    
    public void setInfo(int age, Gender gender){
        lblConversationsAge.setText(gender.toString() + ", " + Integer.toString(age));
    }
    
    public void setCurrentMessagePartner(Profile partnerProfile){
        this.currentMessagePartner = partnerProfile;
        loadMessagesFormProfile();
    }
    
    private void refreshSidebar(){
        ObservableList<Profile> persons = FXCollections.observableArrayList();
        String myProfileID = dc.GetMyProfileID();
        //ArrayList<Profile> persons = new ArrayList<>();
        
        for (Message m : dc.GetReceivedMessages()){
            if (m.getSender().getProfileId().equals(myProfileID)){
                continue;
            }
            boolean found = false;
            for (Profile p : persons){
                if (p.getProfileId().equals(m.getSender().getProfileId())){
                    found = true;
                }
            }
            if (!found){
                persons.add(m.getSender());                
            }
        }
        for (Message m : dc.GetSendMessages()){
            if (m.getSender().getProfileId().equals(myProfileID)){
                continue;
            }
            boolean found = false;
            for (Profile p : persons){
                if (!p.getProfileId().equals(m.getReceiver().getProfileId())){
                    found = true;                   
                }
            }
            if (!found){
                persons.add(m.getReceiver());
            }
        }
        lvMessagePartners.setItems((ObservableList)persons);        
    }
    
    private void loadMessagesFormProfile() {
        //Load conversations
        taGesprekBox.clear();
        
        ArrayList<SimpleMessage> messageList = new ArrayList<>();
        
        String genderTitle = "Hij: ";
        if (currentMessagePartner.getGender() == Gender.FEMALE ) {
            genderTitle = "Zij: ";
        }
        for (Message m : dc.GetReceivedMessages()){
            
            if (m.getSender().getProfileId().equals(currentMessagePartner.getProfileId())){                
                //taGesprekBox.appendText("\n" + genderTitle + m.getContent());
                
                try{
                    GregorianCalendar gc;
                    XMLGregorianCalendar xc = m.getTimeStamp();
                    gc = xc.toGregorianCalendar();
                    //xc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);

                    messageList.add(new SimpleMessage(m.getContent(), gc, genderTitle));
                }
                catch(Exception e){
                    System.out.println("XML Conversion failed");
                }
                
            }
        }  
        genderTitle = "U: ";
        for (Message m : dc.GetSendMessages()){
            if (m.getReceiver().getProfileId().equals(currentMessagePartner.getProfileId())){
                //taGesprekBox.appendText("\n" + "U: " + m.getContent());  
                try{
                    GregorianCalendar gc;
                    XMLGregorianCalendar xc = m.getTimeStamp();
                    gc = xc.toGregorianCalendar();
                    //xc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);

                    messageList.add(new SimpleMessage(m.getContent(), gc, genderTitle));
                }
                catch(Exception e){
                    System.out.println("XML Conversion failed");
                }
            }
        }
        
        Collections.sort(messageList);
        for(SimpleMessage m : messageList){
            taGesprekBox.appendText("\n" + m.toString()); 
        }
        
        refreshSidebar();
    }
    
    @FXML
    private void onListViewClicked() throws IOException, DatatypeConfigurationException{
        Profile p = (Profile)lvMessagePartners.getSelectionModel().getSelectedItem();
        this.setCurrentMessagePartner(p);
        loadMessagesFormProfile();
    }
    
    @FXML
    private void sendMessageClick() throws DatingSiteWebServiceException_Exception, DatatypeConfigurationException{
        if ((!tbMessageContent.getText().equals("")) && (currentMessagePartner != null) ){
            dc.SendMessage(currentMessagePartner, tbMessageContent.getText());
            tbMessageContent.clear();
            loadMessagesFormProfile();
        }
        else{
            this.showWarning("Message Send Error", "Er ging iets fout bij het verzenden van het bericht. Controleer of er een ontvanger is geselecteerd en het bericht lang genoeg was en probeer het dan opnieuw");
        }        
    }
    
    private class SimpleMessage implements Comparable{
        
        String messageContent;
        GregorianCalendar timeStamp;
        String prepend;
        
        public SimpleMessage(String messageContent, GregorianCalendar timeStamp, String prepend){
            this.messageContent = messageContent;
            this.timeStamp = timeStamp;
            this.prepend = prepend;
        }

        @Override
        public int compareTo(Object o) {
            SimpleMessage other = (SimpleMessage)o;
            return this.timeStamp.compareTo(other.timeStamp);
        }
        
        @Override
        public String toString(){
            return prepend + " " + messageContent;
        }
    }
}