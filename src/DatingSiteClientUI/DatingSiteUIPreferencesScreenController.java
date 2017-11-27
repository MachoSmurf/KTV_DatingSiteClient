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
import webservice.ColorEyes;
import webservice.ColorHair;
import webservice.Gender;

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
        ColorHair hairColor = ColorHair.BLOND;
        ColorEyes eyesColor = ColorEyes.BLAUW;
        
        if ((minAge > 0) && (maxAge > 0) && (minLength > 0) && (maxLength > 0) && (hairColor != null) && (eyesColor != null))  
        {
            //Gender gender, int minAge, int maxAge, int minLength, int maxLength, ColorHair hairColor, ColorEyes eyeColor
            if (dc.SetMyPreferences(Gender.MALE, minAge, maxAge, minLength, maxLength, hairColor, eyesColor))
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
    
}
