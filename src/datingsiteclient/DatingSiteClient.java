/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingsiteclient;

import DatingSiteClientUI.DatingSiteUIController;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author MS-Laptop
 */
public class DatingSiteClient extends Application {
    
    private DatingController datingController;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        try{
            datingController = new DatingController();
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/DatingSiteClientUI/DatingSiteUILoginScreen.fxml"));     

        Parent root = (Parent)fxmlLoader.load();          
        DatingSiteUIController controller = (DatingSiteUIController)fxmlLoader.getController();
        controller.setDatingController(datingController);
        controller.setUIStage(primaryStage);
                
        Scene scene = new Scene(root); 

        primaryStage.setScene(scene);    

        primaryStage.show();     
        
        }
        catch(Exception e){
            System.out.println(e);
        }       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
