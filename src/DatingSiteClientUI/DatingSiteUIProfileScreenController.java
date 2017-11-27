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
import javafx.scene.control.*;
import webservice.Gender;
import webservice.Profile;


/**
 * FXML Controller class
 *
 * @author MS-Laptop
 */
public class DatingSiteUIProfileScreenController extends DatingSiteUIController implements Initializable {

    @FXML private RadioButton rbProfileMale;
    @FXML private RadioButton rbProfileFemale;
    @FXML private DatePicker dpProfileBirthDate;
    @FXML private ComboBox cbProfileHairColor;
    @FXML private ComboBox cbProfileEyesColor;
    @FXML private TextArea taProfileDescription;
    @FXML private ListView lvProfileHobbies;    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void onCancel(ActionEvent event) throws IOException{
        changeScreen("/DatingSiteClientUI/DatingSiteUISearchScreen.fxml", event);
    }
    
    @FXML 
    public void loadProfile(){
        Profile myProfile = dc.GetMyProfile();
        if (myProfile.getGender() == Gender.MALE)
        {
            rbProfileMale.setSelected(true);
            rbProfileFemale.setSelected(false);
        }
        else
        {
            rbProfileFemale.setSelected(true);
            rbProfileMale.setSelected(false);
        }        
    }
}
