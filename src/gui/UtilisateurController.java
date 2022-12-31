/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Utilisateur;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import service.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author ahmed h
 */
public class UtilisateurController implements Initializable {

    @FXML
    private TextField txtid;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txtadresse;
    @FXML
    private ComboBox<String> listrole;
    @FXML
    private TextField txtpassword;
    @FXML
    private TableView<Utilisateur> tab;
    @FXML
    private TableColumn<Utilisateur, Integer> col_id;
    @FXML
    private TableColumn<Utilisateur, String> col_nom;
    @FXML
    private TableColumn<Utilisateur, String> col_prenom;
    @FXML
    private TableColumn<Utilisateur, String> col_adresse;
    @FXML
    private TableColumn<Utilisateur, String> col_role;
    @FXML
    private TableColumn<Utilisateur, Integer> col_password;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
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
    @FXML
    private Label wrongmsg6;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showUtilisateur();
        listrole.getItems().addAll(role);
    }    
    
    private String[] role={"RH","Technicien","Responsable"};
    
    //Methode pour afficher la list des utilisateurs
    public void showUtilisateur(){
        UtilisateurService us=new UtilisateurService();
        ArrayList<Utilisateur> list = us.readAll();
        ObservableList<Utilisateur> utilisateurList = FXCollections.observableArrayList(list);
        
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        col_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        col_role.setCellValueFactory(new PropertyValueFactory<>("role"));
        col_password.setCellValueFactory(new PropertyValueFactory<>("password"));
        
        tab.setItems(utilisateurList);
    }
    
    //Methode pour ajouter les utilisateurs avec controle de saisie
    @FXML
    private void Ajouter(ActionEvent event) {
        if (txtid.getText().isEmpty()){
            wrongmsg1.setText("SVP entrer l'identifiant");
        }else if(!(txtid.getText().matches("([0-9]+(\\.[0-9]+)?)+"))){
            wrongmsg1.setText("SVP entrer des chiffres");
        }else if(txtid.getText().length()!=8){
            wrongmsg1.setText("Minimum 8 chiffres");
        }else if (txtnom.getText().isEmpty()){
            wrongmsg2.setText("SVP entrer le nom");
        }else if (txtprenom.getText().isEmpty()){
            wrongmsg3.setText("SVP entrer le prenom");
        }else if (txtadresse.getText().isEmpty()){
            wrongmsg4.setText("SVP entrer  l'adresse");
        }else if ((listrole.getSelectionModel().getSelectedItem()) == null){
            wrongmsg5.setText("SVP choisir un role");
        }else if (txtpassword.getText().length()<6){
            wrongmsg6.setText("SVP saisie un password plus de 6 caractères");
        }else{
            Utilisateur u=new Utilisateur(Integer.parseInt(txtid.getText()), txtnom.getText(), txtprenom.getText(), txtadresse.getText(), listrole.getSelectionModel().getSelectedItem(), txtpassword.getText());
            UtilisateurService us=new UtilisateurService();
            us.add(u);
            showUtilisateur();
            clear();
        } 
    }
    
    //Methode pour Mettre a jour les utilisateurs by id
    @FXML
    private void Modifier(ActionEvent event) {
        if (txtid.getText().isEmpty()){
            wrongmsg1.setText("SVP entrer l'identifiant");
        }else if(!(txtid.getText().matches("([0-9]+(\\.[0-9]+)?)+"))){
            wrongmsg1.setText("SVP entrer des chiffres");
        }else if(txtid.getText().length()!=8){
            wrongmsg1.setText("Minimum 8 chiffres");
        }else if (txtnom.getText().isEmpty()){
            wrongmsg2.setText("SVP entrer le nom");
        }else if (txtprenom.getText().isEmpty()){
            wrongmsg3.setText("SVP entrer le prenom");
        }else if (txtadresse.getText().isEmpty()){
            wrongmsg4.setText("SVP entrer  l'adresse");
        }else if ((listrole.getSelectionModel().getSelectedItem()) == null){
            wrongmsg5.setText("SVP choisir un role");
        }else if (txtpassword.getText().length()<6){
            wrongmsg6.setText("SVP saisie un password plus de 6 caractères");
        }else{
            UtilisateurService us=new UtilisateurService();
            us.updateUtilisateur(Integer.parseInt(txtid.getText()), txtnom.getText(), txtprenom.getText(), txtadresse.getText(), listrole.getSelectionModel().getSelectedItem(), txtpassword.getText());
            showUtilisateur();
            clear();
        }
    }

    //Methode pour Supprimer les utilisateurs by id
    @FXML
    private void Supprimer(ActionEvent event) {
        if (txtid.getText().isEmpty()){
            wrongmsg1.setText("SVP entrer l'identifiant");
        }else if(!(txtid.getText().matches("([0-9]+(\\.[0-9]+)?)+"))){
            wrongmsg1.setText("SVP entrer des chiffres");
        }else if(txtid.getText().length()!=8){
            wrongmsg1.setText("Minimum 8 chiffres");
        }else{
            UtilisateurService us=new UtilisateurService();
            us.delete(Integer.parseInt(txtid.getText()));
            showUtilisateur();
            clear();
        }
    }
    
    //Methode pour mis a niveau
    public void clear(){
        txtid.setText(null);
        txtnom.setText(null);
        txtprenom.setText(null);
        txtadresse.setText(null);
        txtpassword.setText(null);
        wrongmsg1.setText(null);
        wrongmsg2.setText(null);
        wrongmsg3.setText(null);
        wrongmsg4.setText(null);
        wrongmsg5.setText(null);
        wrongmsg6.setText(null);
    }

    //Methode pour afficher le contenu dans les textfield
    @FXML
    private void handleMouseAction(MouseEvent event) {
        Utilisateur u = tab.getSelectionModel().getSelectedItem();
        txtid.setText(""+u.getId());
        txtnom.setText(u.getNom());
        txtprenom.setText(u.getPrenom());
        txtadresse.setText(u.getAdresse());
        txtpassword.setText(u.getPassword());
    }
}
