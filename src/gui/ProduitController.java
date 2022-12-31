/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Fournisseur;
import entite.Produit;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.FournisseurService;
import service.ProduitService;

/**
 * FXML Controller class
 *
 * @author karam
 */
public class ProduitController implements Initializable {

    @FXML
    private TextField txtid;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtquantite;
    @FXML
    private TextField txtprix;
    @FXML
    private ComboBox<String> listPrix;
    @FXML
    private ComboBox<String> listFournisseur;
    @FXML
    private Button btnfournisseur;
    @FXML
    private TableView<Produit> tab;
    @FXML
    private TableColumn<Produit, Integer> col_id;
    @FXML
    private TableColumn<Produit, String> col_nom;
    @FXML
    private TableColumn<Produit, Float> col_quantite;
    @FXML
    private TableColumn<Produit, Float> col_prix;
    @FXML
    private TableColumn<Fournisseur, String> col_fournisseur;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmaj;
    @FXML
    private Button btnsupprimer;
    @FXML
    private Button btnrefresh;
    @FXML
    private Label wrongmsg1;
    @FXML
    private Label wrongmsg2;
    @FXML
    private Label wrongmsg3;
    @FXML
    private Label wrongmsg4;
    @FXML
    private Label wrongmsg5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showProduit();
        listPrix.getItems().addAll(type);
        FournisseurService fs=new FournisseurService();
        listFournisseur.getItems().addAll(fs.showList());
        listFournisseur.setPromptText("Fournisseur");
    }    
    
    private String[] type={"TND","EUR"};
    
    //Methode pour afficher la list des Produit
    public void showProduit(){
        ProduitService ps=new ProduitService();
        ArrayList<Produit> list=ps.readAll();
        ObservableList<Produit> produitList=FXCollections.observableArrayList(list);
        
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        col_fournisseur.setCellValueFactory(new PropertyValueFactory<>("fournisseur"));
        
        tab.setItems(produitList);
    }
    
    //Methode accédé au FournisseurController
    @FXML
    private void Fournisseur(ActionEvent event) {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Fournisseur.fxml"));
            Parent root1 = (Parent) fXMLLoader.load();
            Stage stage=new Stage();
            stage.setTitle("Ajouter fournisseur");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Methode pour ajouter les produits avec controle de saisie
    @FXML
    private void ajouter(ActionEvent event) {
        if(txtid.getText().isEmpty()){
            wrongmsg1.setText("SVP entrer le reference");
        }else if(txtnom.getText().isEmpty()){
            wrongmsg2.setText("SVP entrer le nom");
        }else if(txtquantite.getText().isEmpty()){
            wrongmsg3.setText("SVP entrer la quantite");
        }else if (!(txtquantite.getText().matches("([0-9]+(\\.[0-9]+)?)+"))){
            wrongmsg3.setText("SVP entrer des chiffres");
        }else if(txtprix.getText().isEmpty()){
            wrongmsg4.setText("SVP entrer le prix");
        }else if(!(txtprix.getText().matches("([0-9]+(\\.[0-9]+)?)+"))){
            wrongmsg4.setText("SVP entrer des chiffres");
        }else if((listFournisseur.getSelectionModel().getSelectedItem()) == null){
            wrongmsg5.setText("SVP choisir un fournisseur");
        }else{
            ProduitService ps=new ProduitService();
            Produit p=new Produit(txtid.getText(), txtnom.getText(), Float.parseFloat(txtquantite.getText()), Float.parseFloat(txtprix.getText()), listFournisseur.getSelectionModel().getSelectedItem());
            ps.add(p);
            showProduit();
            clear();
        }
    }
    
    //Methode pour Mettre a jour les produits by id
    @FXML
    private void Modifier(ActionEvent event) {
        if(txtid.getText().isEmpty()){
            wrongmsg1.setText("SVP entrer le reference");
        }else if(txtnom.getText().isEmpty()){
            wrongmsg2.setText("SVP entrer le nom");
        }else if(txtquantite.getText().isEmpty()){
            wrongmsg3.setText("SVP entrer la quantite");
        }else if (!(txtquantite.getText().matches("([0-9]+(\\.[0-9]+)?)+"))){
            wrongmsg3.setText("SVP entrer des chiffres");
        }else if(txtprix.getText().isEmpty()){
            wrongmsg4.setText("SVP entrer le prix");
        }else if(!(txtprix.getText().matches("([0-9]+(\\.[0-9]+)?)+"))){
            wrongmsg4.setText("SVP entrer des chiffres");
        }else if((listFournisseur.getSelectionModel().getSelectedItem()) == null){
            wrongmsg5.setText("SVP choisir un fournisseur");
        }else{
            ProduitService ps=new ProduitService();
            ps.updateProduit(txtid.getText(), txtnom.getText(), Float.parseFloat(txtquantite.getText()), Float.parseFloat(txtprix.getText()), listFournisseur.getSelectionModel().getSelectedItem());
            showProduit();
            clear();
        }
    }
    
    //Methode pour Supprimer les produits by id
    @FXML
    private void supprimer(ActionEvent event) {
        if(txtid.getText().isEmpty()){
            wrongmsg1.setText("SVP entrer le reference");
        }else {
            ProduitService ps=new ProduitService();
            ps.delete(txtid.getText());
            showProduit();
            clear();
        }
    }
    
    //Methode pour actualiser la list fournisseur
    @FXML
    private void refresh(ActionEvent event) {
        listFournisseur.getItems().clear();
        FournisseurService fs=new FournisseurService();
        listFournisseur.getItems().addAll(fs.showList());
    }
    
    //Methode pour mis a niveau
    public void clear(){
        txtid.setText(null);
        txtnom.setText(null);
        txtprix.setText(null);
        txtquantite.setText(null);
        wrongmsg1.setText(null);
        wrongmsg2.setText(null);
        wrongmsg3.setText(null);
        wrongmsg4.setText(null);
        wrongmsg5.setText(null);
    }
    
    //Methode pour afficher le contenu dans les textfield
    @FXML
    private void handleMouseAction(MouseEvent event) {
        Produit p = tab.getSelectionModel().getSelectedItem();
        txtid.setText(""+p.getId());
        txtnom.setText(p.getNom());
        txtquantite.setText(""+p.getQuantite());
        txtprix.setText(""+p.getPrix());
    }
}
