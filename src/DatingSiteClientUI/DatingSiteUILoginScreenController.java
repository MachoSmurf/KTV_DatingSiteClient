/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatingSiteClientUI;

import datingsiteclient.DatingController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MS-Laptop
 */
public class DatingSiteUILoginScreenController implements Initializable {
    
    private TextField tbEmail;
    private PasswordField tbPassword;
    
    private DatingController dc;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      // TODO
    }
    
    public void setDatingController(DatingController dc){
        this.dc = dc;
    }
    
    public void onLoginClick(){
        dc.Login(tbEmail.getText(), tbPassword.getText());
    }
    
    public void onRegisterClick(){
        
    }
    
}
