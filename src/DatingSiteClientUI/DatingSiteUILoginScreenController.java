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

/**
 * FXML Controller class
 *
 * @author MS-Laptop
 */
public class DatingSiteUILoginScreenController extends DatingSiteUIController implements Initializable {
    
    @FXML private TextField tbEmail;
    @FXML private PasswordField tbPassword;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }        
    
    
    @FXML
    private void onLoginClick(ActionEvent event) {
        String email = tbEmail.getText();
        String password = tbPassword.getText();
        
        if ((email.equals("")) || (password.equals("")))
        {
            showWarning("Inlogfout", "Niet alle vereist velden zijn ingevuld.");
        }
        else
        {
            boolean loginResult = dc.Login(tbEmail.getText(), tbPassword.getText());
            if(loginResult == true)
            {
                showWarning("Login complete", "Login succesfull");
            }
            else
            {
                showWarning("Inlogfout", "De inloggegens zijn niet juist. Probeer het opnieuw.");
            }
        }        
    }

    @FXML
    private void onRegisterClick(ActionEvent event) throws IOException {
        changeScreen("/DatingSiteClientUI/DatingSiteUIRegisterScreen.fxml", event);
    }    
    
}
