/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatingSiteClientUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import webservice.Gender;
import webservice.Profile;

/**
 * FXML Controller class
 *
 * @author MS-Laptop
 */
public class DatingSiteUIViewUserProfileScreenController extends DatingSiteUIController implements Initializable {

    @FXML
    private TextArea taViewProfileHobbies;
    @FXML
    private Label lblViewProfileAge;
    @FXML
    private TextArea taViewProfileDescriptions;
    @FXML
    private Label lblViewProfileHair;
    @FXML
    private Label lblViewProfileEyes;
    @FXML
    private Label lblViewProfileGender;
    
    private Profile userProfile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setProfile(Profile userProfile){
        this.userProfile = userProfile;
        taViewProfileHobbies.setText(userProfile.getHobbies());
        taViewProfileDescriptions.setText(userProfile.getDescription());
        lblViewProfileHair.setText(userProfile.getColorHair().toString());
        lblViewProfileEyes.setText(userProfile.getColorEyes().toString());
        lblViewProfileGender.setText(userProfile.getGender().toString());
        lblViewProfileAge.setText(Integer.toString(userProfile.getAge()));
    }
    
    public void onSendMessage(ActionEvent event) throws IOException
    {
        try{
            DatingSiteUIGesprekScreenController c = (DatingSiteUIGesprekScreenController)changeScreen("/DatingSiteClientUI/DatingSiteUIGesprekScreen.fxml", null);
            //changeScreen("/DatingSiteClientUI/DatingSiteUIGesprekScreen.fxml", event);
            c.setInfo(userProfile.getAge(), userProfile.getGender());
            c.setCurrentMessagePartner(userProfile);
        }
        catch (Exception e){
            System.out.print(e);
        }
        
    }
    
    public void onCancel(ActionEvent event) throws IOException
    {
        changeScreen("/DatingSiteClientUI/DatingSiteUISearchScreen.fxml", null);   
    }    
}
