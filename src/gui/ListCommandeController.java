/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Commande;
import java.awt.print.PrinterJob;
import java.net.URL;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.text.Document;
import service.CommandeService;

/**
 * FXML Controller class
 *
 * @author Elife-Beja-134
 */
public class ListCommandeController implements Initializable {

    @FXML
    private TableColumn<Commande, Integer> col_id;
    @FXML
    private TableColumn<Commande, Integer> col_id_agent;
    @FXML
    private TableColumn<Commande, Integer> col_id_produit1;
    @FXML
    private TableColumn<Commande, Integer> col_id_produit2;
    @FXML
    private TableColumn<Commande, Integer> col_id_produit3;
    @FXML
    private TableColumn<Commande, Integer> col_id_produit4;
    @FXML
    private TableColumn<Commande, Integer> col_id_produit5;
    @FXML
    private TableView<Commande> tab;
    @FXML
    private TextField txtid;
    @FXML
    private Button btnSupprimer;
    @FXML
    private TableColumn<Commande, Float> col_quantite1;
    @FXML
    private TableColumn<Commande, Float> col_quantite2;
    @FXML
    private TableColumn<Commande, Float> col_quantite3;
    @FXML
    private TableColumn<Commande, Float> col_quantite4;
    @FXML
    private TableColumn<Commande, Float> col_quantite5;
    @FXML
    private Label wrongmsg;
    @FXML
    private TextField txtsearch;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showCommande();
    }    
    //Methode pour afficher la list des Commande
    public void showCommande(){
        CommandeService cs=new CommandeService();
        ArrayList<Commande> list=cs.readAll();
        ObservableList<Commande> commandeList=FXCollections.observableArrayList(list);
        
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_id_agent.setCellValueFactory(new PropertyValueFactory<>("idAgent"));
        col_id_produit1.setCellValueFactory(new PropertyValueFactory<>("idProduit1"));
        col_quantite1.setCellValueFactory(new PropertyValueFactory<>("quantite1"));
        col_id_produit2.setCellValueFactory(new PropertyValueFactory<>("idProduit2"));
        col_quantite2.setCellValueFactory(new PropertyValueFactory<>("quantite2"));
        col_id_produit3.setCellValueFactory(new PropertyValueFactory<>("idProduit3"));
        col_quantite3.setCellValueFactory(new PropertyValueFactory<>("quantite3"));
        col_id_produit4.setCellValueFactory(new PropertyValueFactory<>("idProduit4"));
        col_quantite4.setCellValueFactory(new PropertyValueFactory<>("quantite4"));
        col_id_produit5.setCellValueFactory(new PropertyValueFactory<>("idProduit5"));
        col_quantite5.setCellValueFactory(new PropertyValueFactory<>("quantite5"));
        
        tab.setItems(commandeList);
        
        //chercher dans la list commande by id ou by idAgent
        try{
            FilteredList<Commande> filteredData = new FilteredList<>(commandeList, b -> true);
        
        txtsearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Commande -> {
                if (newValue == null || newValue.isEmpty()){
                    return true;
                }
                
                String lowerCaseFilter = newValue.toLowerCase();
                
                if(String.valueOf(Commande.getIdAgent()).indexOf(lowerCaseFilter)!=-1){
                    return true;
                }else if(String.valueOf(Commande.getId()).indexOf(lowerCaseFilter)!=-1){
                    return true;
                }else if(String.valueOf(Commande.getIdProduit1()).indexOf(lowerCaseFilter)!=-1){
                    return true;
                }else if(String.valueOf(Commande.getIdProduit2()).indexOf(lowerCaseFilter)!=-1){
                    return true;
                }else if(String.valueOf(Commande.getIdProduit3()).indexOf(lowerCaseFilter)!=-1){
                    return true;
                }else if(String.valueOf(Commande.getIdProduit4()).indexOf(lowerCaseFilter)!=-1){
                    return true;
                }else if(String.valueOf(Commande.getIdProduit5()).indexOf(lowerCaseFilter)!=-1){
                    return true;
                }
                else{
                    return false;
                }
            });
        });
        
        SortedList<Commande> sortedData=new SortedList<>(filteredData);
        
        sortedData.comparatorProperty().bind(tab.comparatorProperty());
        
        tab.setItems(sortedData);
        }catch(Exception ex){
            Logger.getLogger(ListCommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Methode pour Supprimer les Commande by id
    @FXML
    private void supprimer(ActionEvent event) {
        if (txtid.getText().isEmpty()){
            wrongmsg.setText("SVP entrer l'identifiant");
        }else if(!(txtid.getText().matches("([0-9]+(\\.[0-9]+)?)+"))){
            wrongmsg.setText("SVP entrer des chiffres");
        }else{
            CommandeService cs=new CommandeService();
            cs.delete(Integer.parseInt(txtid.getText()));
            showCommande();
            txtid.setText(null);
        }
    }

    //Methode pour afficher le contenu dans les textfield
    @FXML
    private void handleMouseAction(MouseEvent event) {
        Commande c = tab.getSelectionModel().getSelectedItem();
        txtid.setText(""+c.getId());
    }
    
}
