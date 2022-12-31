/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Elife-Beja-134
 */
public class ChoixController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    //Methode pour accédé a ListCommande
    @FXML
    private void SuivieCommande(MouseEvent event) {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("ListCommande.fxml"));
            Parent root2 = (Parent) fXMLLoader.load();
            Stage stage=new Stage();
            stage.setTitle("Suivie les commande");
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ChoixController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Methode pour accédé au ProduitController
    @FXML
    private void AjouterProduit(MouseEvent event) {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Produit.fxml"));
            Parent root3 = (Parent) fXMLLoader.load();
            Stage stage=new Stage();
            stage.setTitle("Ajouter produit");
            stage.setScene(new Scene(root3));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ChoixController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
