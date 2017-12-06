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
import webservice.Gender;

/**
 * FXML Controller class
 *
 * @author MS-Laptop
 */
public class DatingSiteUIGesprekScreenController extends DatingSiteUIController implements Initializable {

    @FXML
    private Label lblConversationsAge;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Load conversations
    }    
    
    @FXML
    private void onCancel(ActionEvent event) throws IOException{
        DatingSiteUISearchScreenController c = (DatingSiteUISearchScreenController)changeScreen("/DatingSiteClientUI/DatingSiteUISearchScreen.fxml", event);
        c.zoekMatchesClick(null); 
    }
    
    public void setInfo(int age, Gender gender){
        lblConversationsAge.setText(gender.toString() + ", " + Integer.toString(age));
    }
    
}
