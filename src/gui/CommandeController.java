/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Commande;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import service.CommandeService;
import service.LoginService;
import service.ProduitService;

/**
 * FXML Controller class
 *
 * @author Seif
 */
public class CommandeController implements Initializable {

    @FXML
    private ComboBox<String> listproduit1;
    @FXML
    private ComboBox<String> listproduit2;
    @FXML
    private ComboBox<String> listproduit3;
    @FXML
    private ComboBox<String> listproduit4;
    @FXML
    private ComboBox<String> listproduit5;
    @FXML
    private TextField txtquantite1;
    @FXML
    private TextField txtquantite2;
    @FXML
    private TextField txtquantite3;
    @FXML
    private TextField txtquantite4;
    @FXML
    private TextField txtquantite5;
    @FXML
    private Button btnPasserCommande;
    @FXML
    private Button btnAnnuler;
    @FXML
    private TextField txtIdAgent;
    @FXML
    private Label wrongmsg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ProduitService ps=new ProduitService();
        listproduit1.getItems().addAll(ps.showList());
        listproduit2.getItems().addAll(ps.showList());
        listproduit3.getItems().addAll(ps.showList());
        listproduit4.getItems().addAll(ps.showList());
        listproduit5.getItems().addAll(ps.showList());
        txtquantite1.setText("0");
        txtquantite2.setText("0");
        txtquantite3.setText("0");
        txtquantite4.setText("0");
        txtquantite5.setText("0");
        listproduit2.getSelectionModel().selectLast();
        listproduit3.getSelectionModel().selectLast();
        listproduit4.getSelectionModel().selectLast();
        listproduit5.getSelectionModel().selectLast();
    }    
    
    //Boutton pour passer commande
    @FXML
    private void PasserCommande(ActionEvent event) {
        CommandeService cs=new CommandeService();
        //Controle de saisie sur les champs
        if(txtIdAgent.getText().isEmpty()){
            wrongmsg.setText("Il faut saisi votre id");
        }else if(listproduit1.getSelectionModel().getSelectedItem() == null){
            wrongmsg.setText("choisir ou moins un produit");
        }else{
            Commande c=new Commande(0 ,Integer.parseInt(txtIdAgent.getText()), listproduit1.getSelectionModel().getSelectedItem(), Float.parseFloat(txtquantite1.getText()), listproduit2.getSelectionModel().getSelectedItem(), Float.parseFloat(txtquantite2.getText()), listproduit3.getSelectionModel().getSelectedItem(), Float.parseFloat(txtquantite3.getText()), listproduit4.getSelectionModel().getSelectedItem(), Float.parseFloat(txtquantite4.getText()), listproduit5.getSelectionModel().getSelectedItem(), Float.parseFloat(txtquantite5.getText()));
            cs.add(c);
            
            if(listproduit1.getSelectionModel().getSelectedItem() != null){
                ProduitService ps=new ProduitService();
                float OldQuantite = ps.readBy(listproduit1.getSelectionModel().getSelectedItem());
                float NewQuantite = OldQuantite - Float.parseFloat(txtquantite1.getText());
                
                ps.updateQuantite(listproduit1.getSelectionModel().getSelectedItem(), NewQuantite);
            }
            
            if(!(listproduit2.getSelectionModel().getSelectedItem().equals("00000000"))){
                ProduitService ps=new ProduitService();
                float OldQuantite = ps.readBy(listproduit2.getSelectionModel().getSelectedItem());
                float NewQuantite = OldQuantite - Float.parseFloat(txtquantite2.getText());
                
                ps.updateQuantite(listproduit2.getSelectionModel().getSelectedItem(), NewQuantite);
            }
            
            if(!(listproduit3.getSelectionModel().getSelectedItem().equals("00000000"))){
                ProduitService ps=new ProduitService();
                float OldQuantite = ps.readBy(listproduit3.getSelectionModel().getSelectedItem());
                float NewQuantite = OldQuantite - Float.parseFloat(txtquantite3.getText());
                
                ps.updateQuantite(listproduit3.getSelectionModel().getSelectedItem(), NewQuantite);
            }
            
            if(!(listproduit4.getSelectionModel().getSelectedItem().equals("00000000"))){
                ProduitService ps=new ProduitService();
                float OldQuantite = ps.readBy(listproduit4.getSelectionModel().getSelectedItem());
                float NewQuantite = OldQuantite - Float.parseFloat(txtquantite4.getText());
                
                ps.updateQuantite(listproduit4.getSelectionModel().getSelectedItem(), NewQuantite);
            }
            
            if(!(listproduit5.getSelectionModel().getSelectedItem().equals("00000000"))){
                ProduitService ps=new ProduitService();
                float OldQuantite = ps.readBy(listproduit5.getSelectionModel().getSelectedItem());
                float NewQuantite = OldQuantite - Float.parseFloat(txtquantite5.getText());
                
                ps.updateQuantite(listproduit5.getSelectionModel().getSelectedItem(), NewQuantite);
            }
            
            clear();
        }
    }
    
    
    //Boutton pour annuler le saisie
    @FXML
    private void Annuler(ActionEvent event) {
        clear();
        txtquantite1.setText("0");
        txtquantite2.setText("0");
        txtquantite3.setText("0");
        txtquantite4.setText("0");
        txtquantite5.setText("0");
    }
    
    //Methode pour mis a niveau
    public void clear(){
        txtquantite1.setText(null);
        txtquantite2.setText(null);
        txtquantite3.setText(null);
        txtquantite4.setText(null);
        txtquantite5.setText(null);
    }
}
