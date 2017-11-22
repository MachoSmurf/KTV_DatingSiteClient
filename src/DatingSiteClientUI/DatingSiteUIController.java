/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatingSiteClientUI;

import datingsiteclient.DatingController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MS-Laptop
 */
public class DatingSiteUIController implements Initializable {

    private DatingController dc;
    private Stage uIStage;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Controller initiated");
        // TODO
    }        
    
    public void setDatingController(DatingController dc)    {
        this.dc = dc;
    }
    
    public void setUIStage(Stage uIStage){
        this.uIStage = uIStage;
    }

    @FXML
    private void onLoginClick(ActionEvent event) {
        
    }

    @FXML
    private void onRegisterClick(ActionEvent event) throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/DatingSiteUIRegisterScreen.fxml"));     
        Parent root = (Parent)fxmlLoader.load();
        uIStage.setScene(new Scene(root));*/
        
        Parent homepage_parent = FXMLLoader.load(getClass().getResource("/DatingSiteClientUI/DatingSiteUIRegisterScreen.fxml"));
        Scene homepage_scene = new Scene(homepage_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(homepage_scene);
        app_stage.show();
    }
    
}
