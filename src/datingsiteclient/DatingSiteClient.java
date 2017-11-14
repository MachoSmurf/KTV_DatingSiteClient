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

/**
 *
 * @author MS-Laptop
 */
public class DatingSiteClient extends Application {
    
    private DatingController datingController;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        datingController = new DatingController();
        
        Parent root = null;
        try{            
            root = FXMLLoader.load(getClass().getResource("/DatingSiteClientUI/DatingSiteUILoginScreen.fxml"));
        }
        catch(IOException e){
            System.out.println(e);
        }       
        
        Scene scene = new Scene(root, 600, 400);
        
        DatingSiteUILoginScreenController c = (DatingSiteUILoginScreenController)scene.getUserData();
        c.setDatingController(datingController);
        
        primaryStage.setTitle("DatingSite Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
