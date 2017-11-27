/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatingSiteClientUI;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import webservice.ColorEyes;
import webservice.ColorHair;
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
    @FXML private ComboBox cbProfileHairColor;
    @FXML private ComboBox cbProfileEyesColor;
    @FXML private TextArea taProfileDescription;
    @FXML private TextArea taProfileHobbies;  
    @FXML private TextField tfProfileLength;
    @FXML private Button btnProfileCancel;
    @FXML private Label lblProfileAgePrefix;
    @FXML private Label lblProfileAge;
    
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
    private void onSaveProfile(ActionEvent event) throws IOException{
        int length = Integer.parseInt(tfProfileLength.getText());
        //TODO: fix the combobox content and parse to the enum
        ColorHair hairColor = ColorHair.BLOND;
        ColorEyes eyesColor = ColorEyes.BLAUW;
        String hobbies = taProfileHobbies.getText();
        String Description = taProfileDescription.getText();
        
        if (dc.SetMyProfile(length, hairColor, eyesColor, hobbies, Description))
        {
            //check if preferences are set, if not this is the first login and redirect user to preferences screen.
            if (dc.GetMyPreference() == null)
            {
                this.showSucces("Registratie Succesvol", "De registratie is voltooid. Voordat u verder kunt moet u eerst uw profiel invullen en voorkeuren opgeven");
                DatingSiteUIPreferencesScreenController c = (DatingSiteUIPreferencesScreenController)changeScreen("/DatingSiteClientUI/DatingSiteUIPreferencesScreen.fxml", event); 
                c.disableCancel();
            }
            else
            {
                changeScreen("/DatingSiteClientUI/DatingSiteUISearchScreen.fxml", event); 
            }
        }
                
    }
    
    public void setInitialGender(Gender gender){
        //initial setup, user shouldn't be able to cancel this step.
        btnProfileCancel.setDisable(true);
        //Age is loaded via profile, which we can't see yet so hide the age field.
        lblProfileAgePrefix.setVisible(false);
        lblProfileAge.setVisible(false);
        
        if (gender == Gender.MALE){
            rbProfileMale.setSelected(true);
            rbProfileFemale.setSelected(false);
        }
        else
        {
            rbProfileMale.setSelected(true);
            rbProfileFemale.setSelected(false);
        }
    }    
    
    public void loadProfile(){
        Profile myProfile = dc.GetMyProfile();
        if (myProfile != null)
        {
            btnProfileCancel.setDisable(false);
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
            
            lblProfileAge.setText(Integer.toString(myProfile.getAge()));
            taProfileHobbies.setText(myProfile.getHobbies());
            taProfileDescription.setText(myProfile.getDescription());
            tfProfileLength.setText(Integer.toString(myProfile.getLength()));
        } 
    }
}
