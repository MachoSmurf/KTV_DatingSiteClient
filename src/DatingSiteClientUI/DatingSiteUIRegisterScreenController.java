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
import javax.xml.datatype.XMLGregorianCalendar;
import webservice.DatingSiteWebServiceException_Exception;
import webservice.Gender;

/**
 * FXML Controller class
 *
 * @author MS-Laptop
 */
public class DatingSiteUIRegisterScreenController extends DatingSiteUIController implements Initializable {

    @FXML TextField tbRegisterName;
    @FXML PasswordField tbRegisterPassword;
    @FXML TextField tbRegisterEmail;
    @FXML TextField tbRegisterAdress; 
    @FXML TextField tbRegisterPostalCode;
    @FXML TextField tbRegisterPlace;
    @FXML TextField tbRegisterBankAccount;
    @FXML DatePicker dpRegisterBirthDate;
    @FXML RadioButton rbRegisterGenderMale;
    @FXML RadioButton rbRegisterGenderFemale;
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onSubmitRegistration(ActionEvent event) throws DatingSiteWebServiceException_Exception, IOException {
        String name = tbRegisterName.getText();
        String password = tbRegisterPassword.getText();
        String email = tbRegisterEmail.getText();
        String adress = tbRegisterAdress.getText();
        String postalCode = tbRegisterPostalCode.getText();
        String place = tbRegisterPlace.getText();
        String bankAccount = tbRegisterBankAccount.getText();        
        LocalDate birthDate = dpRegisterBirthDate.getValue();
        Gender registerGender = Gender.MALE;
        if (!rbRegisterGenderMale.isSelected())
        {
            registerGender = Gender.FEMALE;
        }
        
        
        if ((!name.isEmpty()) && (!password.isEmpty()) && (!email.isEmpty()) && (!adress.isEmpty()) && (!postalCode.isEmpty()) && (!place.isEmpty()) && (!bankAccount.isEmpty()) && (birthDate != null))
        {
            XMLGregorianCalendar bDate = generateDate(birthDate.toString());       
            boolean registerResult = dc.registerParticipant(name, adress, postalCode, place, bDate, registerGender, bankAccount, email, password);
            
            if (registerResult){
                this.showSucces("Registratie Succesvol", "De registratie is voltooid. U kunt inloggen met het email adres: " + email);
                
                if (dc.Login(email, password))
                {                    
                    //profile has not been filled out yet. Make sure the user does.
                    DatingSiteUIProfileScreenController c = (DatingSiteUIProfileScreenController)changeScreen("/DatingSiteClientUI/DatingSiteUIProfileScreen.fxml", event);
                    c.setInitalBirthDate(birthDate);
                    c.setInitialGender(registerGender);                    
                }                    
            }
            else
            {
                this.showWarning("Fout Bij Registratie", "U kon niet worden geregistreerd. Controleer uw input");
            }
        }
        else
        {
            showWarning("Registratiefout", "Niet alle velden zijn ingevuld.");
        }
    }

    @FXML
    private void onCancelRegistration(ActionEvent event) throws IOException {
        changeScreen("/DatingSiteClientUI/DatingSiteUILoginScreen.fxml", event);
    }
    
}
