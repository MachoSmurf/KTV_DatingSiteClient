/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingsiteclient;

import DatingSiteClientUI.DatingSiteUILoginScreenController;
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
import webservice.DatingSiteWebServiceException_Exception;

/**
 *
 * @author MS-Laptop
 */
public class DatingSiteClient extends Application {
    
    private static DatingController datingController;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        try{           
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/DatingSiteClientUI/DatingSiteUILoginScreen.fxml"));     

            Parent root = (Parent)fxmlLoader.load();          
            DatingSiteUILoginScreenController controller = (DatingSiteUILoginScreenController)fxmlLoader.getController();
            if (datingController != null)
            {
                controller.setDatingController(datingController);
                controller.setSiteName(datingController.GetSiteName());            
            }

            Scene scene = new Scene(root); 

            primaryStage.setScene(scene);    

            primaryStage.show();

            controller.setStage(primaryStage);
            if (datingController == null){
                controller.showConnectionError();            
            }        
        }
        catch(Exception e){
            System.out.println(e);
        }       
    }

    /**
     * @param args the command line arguments
     * @throws webservice.DatingSiteWebServiceException_Exception
     */
    public static void main(String[] args) throws DatingSiteWebServiceException_Exception {
        datingController = new DatingController();
        launch(args);        
    }
    
}
