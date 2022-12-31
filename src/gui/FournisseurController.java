/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Fournisseur;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import service.FournisseurService;

/**
 * FXML Controller class
 *
 * @author karam
 */
public class FournisseurController implements Initializable {

    @FXML
    private TextField txtid;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtadresse;
    @FXML
    private TextField txttel;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmaj;
    @FXML
    private Button btnsupprimer;
    @FXML
    private TableView<Fournisseur> tab;
    @FXML
    private TableColumn<Fournisseur, Integer> col_id;
    @FXML
    private TableColumn<Fournisseur, String> col_nom;
    @FXML
    private TableColumn<Fournisseur, String> col_adresse;
    @FXML
    private TableColumn<Fournisseur, Integer> col_tel;
    @FXML
    private Label wrongmsg1;
    @FXML
    private Label wrongmsg2;
    @FXML
    private Label wrongmsg3;
    @FXML
    private Label wrongmsg4;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showFournisseur();
    }    
    //Methode pour afficher la list des fournisseur
    public void showFournisseur(){
        FournisseurService fs=new FournisseurService();
        ArrayList<Fournisseur> list = fs.readAll();
        ObservableList<Fournisseur> fournisseurList = FXCollections.observableArrayList(list);
        
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        col_tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        
        tab.setItems(fournisseurList);
    }
    
    //Methode pour ajouter les fournissuers avec controle de saisie
    @FXML
    private void Ajouter(ActionEvent event) {
        if(!(txtid.getText().matches("([0-9]+(\\.[0-9]+)?)+"))){
            wrongmsg1.setText("SVP entrer des chiffres");
        }else if(txtnom.getText().isEmpty()){
            wrongmsg2.setText("SVP entrer le nom");
        }else if(txtadresse.getText().isEmpty()){
            wrongmsg3.setText("SVP entrer l'adresse");
        }else if(!(txttel.getText().matches("([0-9]+(\\.[0-9]+)?)+"))){
            wrongmsg4.setText("SVP entrer des chiffres");
        }else{
            Fournisseur f=new Fournisseur(Integer.parseInt(txtid.getText()), txtnom.getText(), txtadresse.getText(), Integer.parseInt(txttel.getText()));
            FournisseurService fs=new FournisseurService();
            fs.add(f);
            showFournisseur();
            clear();
        }
    }
    
    //Methode pour Mettre a jour les fournisseurs by id
    @FXML
    private void modifier(ActionEvent event) {
        if (txtid.getText().isEmpty()){
            wrongmsg1.setText("SVP entrer l'identifiant");
        }else if(!(txtid.getText().matches("([0-9]+(\\.[0-9]+)?)+"))){
            wrongmsg1.setText("SVP entrer des chiffres");
        }else if(txtnom.getText().isEmpty()){
            wrongmsg2.setText("SVP entrer le nom");
        }else if(txtadresse.getText().isEmpty()){
            wrongmsg3.setText("SVP entrer l'adresse");
        }else if(!(txttel.getText().matches("([0-9]+(\\.[0-9]+)?)+"))){
            wrongmsg4.setText("SVP entrer des chiffres");
        }else{
            FournisseurService fs=new FournisseurService();
            fs.updateFournisseur(Integer.parseInt(txtid.getText()), txtnom.getText(), txtadresse.getText(), Integer.parseInt(txttel.getText()));
            showFournisseur();
            clear();
        }
    }
    
    //Methode pour Supprimer les fournisseurs by id
    @FXML
    private void supprimer(ActionEvent event) {
        if (txtid.getText().isEmpty()){
            wrongmsg1.setText("SVP entrer l'identifiant");
        }else if(!(txtid.getText().matches("([0-9]+(\\.[0-9]+)?)+"))){
            wrongmsg1.setText("SVP entrer des chiffres");
        }else{
            FournisseurService fs=new FournisseurService();
            fs.delete(Integer.parseInt(txtid.getText()));
            showFournisseur();
            clear();
        }
    }
    
    //Methode pour mis a niveau
    public void clear(){
        txtid.setText(null);
        txtnom.setText(null);
        txtadresse.setText(null);
        txttel.setText(null);
        wrongmsg1.setText(null);
        wrongmsg2.setText(null);
        wrongmsg3.setText(null);
        wrongmsg4.setText(null);
    }
    
    //Methode pour afficher le contenu dans les textfield
    @FXML
    private void handleMouseAction(MouseEvent event) {
        Fournisseur f = tab.getSelectionModel().getSelectedItem();
        txtid.setText(""+f.getId());
        txtnom.setText(f.getNom());
        txtadresse.setText(f.getAdresse());
        txttel.setText(""+f.getTel());
    }
}
