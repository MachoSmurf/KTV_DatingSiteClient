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

/**
 * FXML Controller class
 *
 * @author MS-Laptop
 */
public class DatingSiteUISearchScreenController extends DatingSiteUIController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void onMyPreferences(ActionEvent event) throws IOException{
        changeScreen("/DatingSiteClientUI/DatingSiteUIPreferencesScreen.fxml", event);
    }
    
    @FXML
    private void onMyProfile(ActionEvent event) throws IOException{
        changeScreen("/DatingSiteClientUI/DatingSiteUIProfileScreen.fxml", event);
    }
    
}
