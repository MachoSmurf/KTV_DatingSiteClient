/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatingSiteClientUI;

import datingsiteclient.DatingController;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author MS-Laptop
 */
public abstract class DatingSiteUIController {
    
    protected DatingController dc;    
    
    public void setDatingController(DatingController dc){
        this.dc = dc;
    }
    
    protected void changeScreen(String fxmlPath, ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));     
                
        Parent root = (Parent)fxmlLoader.load();   
                
        Scene homepage_scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        DatingSiteUIController controller = (DatingSiteUIController)fxmlLoader.getController();
        controller.setDatingController(dc);
        
        app_stage.hide();
        app_stage.setScene(homepage_scene);
        app_stage.show();
    }
    
    protected void showWarning(String title, String text){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.show();
    }
}
