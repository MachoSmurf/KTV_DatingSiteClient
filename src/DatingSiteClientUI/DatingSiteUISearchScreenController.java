/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatingSiteClientUI;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import webservice.Profile;

/**
 * FXML Controller class
 *
 * @author MS-Laptop
 */
public class DatingSiteUISearchScreenController extends DatingSiteUIController implements Initializable {

    @FXML private ListView lvMatchesResult;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    public void zoekMatchesClick(ActionEvent event){
        List<Profile> matches = dc.GetMatches();
        if (matches.size() == 0)
        {
            showWarning("Geen Matches", "Helaas, ons matching algoritme geeft geen gebruikers gevonden die aan uw voorkeuren voldoen.");
        }
        else
        {
            lvMatchesResult.setItems(null);
            ObservableList l = FXCollections.observableArrayList();
            for (Profile p : matches){
                l.add(p);
            }
            lvMatchesResult.setItems(l);
            //lvMatchesResult.refresh();
            System.out.println(matches.size() + " matches gevonden.");
        }
    }
    
    @FXML
    private void onListViewClicked() throws IOException{
        Profile p = (Profile)lvMatchesResult.getSelectionModel().getSelectedItem();
        //this.showSucces("test", "Item clicked: " + p.getProfileId());
        DatingSiteUIViewUserProfileScreenController c = (DatingSiteUIViewUserProfileScreenController)changeScreen("/DatingSiteClientUI/DatingSiteUIViewUserProfileScreen.fxml", null);
        c.setProfile(p);
    }
    
    @FXML
    private void onMyPreferences(ActionEvent event) throws IOException{
        DatingSiteUIPreferencesScreenController c = (DatingSiteUIPreferencesScreenController)changeScreen("/DatingSiteClientUI/DatingSiteUIPreferencesScreen.fxml", event);
        c.loadPreferences();
    }
    
    @FXML
    private void onMyProfile(ActionEvent event) throws IOException{
        DatingSiteUIProfileScreenController c = (DatingSiteUIProfileScreenController)changeScreen("/DatingSiteClientUI/DatingSiteUIProfileScreen.fxml", event);
        c.loadProfile();
    }
    
}
