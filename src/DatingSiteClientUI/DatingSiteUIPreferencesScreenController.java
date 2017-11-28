/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatingSiteClientUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import webservice.ColorEyes;
import webservice.ColorHair;
import webservice.Gender;
import webservice.Preference;

/**
 * FXML Controller class
 *
 * @author MS-Laptop
 */
public class DatingSiteUIPreferencesScreenController extends DatingSiteUIController implements Initializable {
    
    @FXML private Button btnPreferencesCancel;
    @FXML private TextField tbPreferencesMinAge;
    @FXML private TextField tbPreferencesMaxAge;
    @FXML private TextField tbPreferencesMinLength;
    @FXML private TextField tbPreferencesMaxLength;
    @FXML private ComboBox cbPreferencesColorHair;
    @FXML private ComboBox cbPreferencesColorEyes;
    @FXML private RadioButton rbPreferencesGenderMale;
    @FXML private RadioButton rbPreferencesGenderFemale;    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbPreferencesColorHair.setItems(FXCollections.observableArrayList(ColorHair.values()));
        cbPreferencesColorEyes.setItems(FXCollections.observableArrayList(ColorEyes.values()));
    } 
    
    @FXML
    private void onCancel(ActionEvent event) throws IOException{
        changeScreen("/DatingSiteClientUI/DatingSiteUISearchScreen.fxml", event);
    }
    
    @FXML
    private void onPreferencesSave(ActionEvent event) throws IOException{
        int minAge = Integer.parseInt(tbPreferencesMinAge.getText());
        int maxAge = Integer.parseInt(tbPreferencesMaxAge.getText());
        int minLength = Integer.parseInt(tbPreferencesMinLength.getText());
        int maxLength = Integer.parseInt(tbPreferencesMaxLength.getText());
        ColorHair hairColor = (ColorHair)cbPreferencesColorHair.getSelectionModel().getSelectedItem();
        ColorEyes eyesColor = (ColorEyes)cbPreferencesColorEyes.getSelectionModel().getSelectedItem();
        
        Gender genderPreference = Gender.MALE;
        if (rbPreferencesGenderFemale.isSelected())
        {
            genderPreference = Gender.FEMALE;
        }
        
        if ((minAge > 0) && (maxAge > 0) && (minLength > 0) && (maxLength > 0) && (hairColor != null) && (eyesColor != null))  
        {
            //Gender gender, int minAge, int maxAge, int minLength, int maxLength, ColorHair hairColor, ColorEyes eyeColor
            if (dc.SetMyPreferences(genderPreference, minAge, maxAge, minLength, maxLength, hairColor, eyesColor))
            {
                changeScreen("/DatingSiteClientUI/DatingSiteUISearchScreen.fxml", event);                        
            }
        }
        else
        {
            this.showWarning("Invulfout", "Niet alle vereiste velden zijn (juist) ingevuld.");
        }
    }
    
    public void disableCancel(){
        btnPreferencesCancel.setDisable(true);
    }
    
    public void loadPreferences(){
        Preference myPreference = dc.GetMyPreference();
        if (myPreference != null)
        {
            //btnProfileCancel.setDisable(false);
            if (myPreference.getGender() == Gender.MALE)
            {
                rbPreferencesGenderMale.setSelected(true);
                rbPreferencesGenderFemale.setSelected(false);
            }
            else
            {
                rbPreferencesGenderFemale.setSelected(true);
                rbPreferencesGenderMale.setSelected(false);
            }  
            
            tbPreferencesMinAge.setText(Integer.toString(myPreference.getMinAge()));
            tbPreferencesMaxAge.setText(Integer.toString(myPreference.getMaxAge()));
            tbPreferencesMinLength.setText(Integer.toString(myPreference.getMinLength()));
            tbPreferencesMaxLength.setText(Integer.toString(myPreference.getMaxLength()));
            cbPreferencesColorHair.setValue(myPreference.getColorHair());
            cbPreferencesColorEyes.setValue(myPreference.getColorEyes());
        } 
    }
    
}
