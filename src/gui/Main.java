/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author karam
 */
public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("Produit.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("Utilisateur.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("Fournisseur.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("Commande.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("ListCommande.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("Choix.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Gestion de stock");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        launch(args);
    }
}
