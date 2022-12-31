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
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Elife-Beja-134
 */
public class AcceuilController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    //Methode pour accédé a l'UtlisateurControler
    @FXML
    private void AddPersonel(MouseEvent event) {
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Login0.fxml"));
        Parent root1;
        try {
            root1 = (Parent) fXMLLoader.load();
            Stage stage=new Stage();
            stage.setTitle("Connexion");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Methode pour accédé au ChoixController
    @FXML
    private void Stock(MouseEvent event) {
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Login1.fxml"));
        Parent root1;
        try {
            root1 = (Parent) fXMLLoader.load();
            Stage stage=new Stage();
            stage.setTitle("Connexion");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Methode pour accédé au CommandeController
    @FXML
    private void PasserCommande(MouseEvent event) {
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Login2.fxml"));
        Parent root1;
        try {
            root1 = (Parent) fXMLLoader.load();
            Stage stage=new Stage();
            stage.setTitle("Connexion");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
