/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.LoginService;

/**
 * FXML Controller class
 *
 * @author Elife-Beja-134
 */
public class Login2Controller implements Initializable {

    @FXML
    private TextField txtnom;
    @FXML
    private PasswordField txtpassword;
    @FXML
    private Button btnconnecter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    //Methode pour verifier la connexion et le role=Technicien
    @FXML
    private void connecter(ActionEvent event) throws IOException {
        LoginService ls=new LoginService();
        
        if(ls.test1().contains(txtnom.getText()+txtpassword.getText())){
            int a = ls.test1().indexOf(txtnom.getText()+txtpassword.getText());
            if (ls.role().get(a).equals("Technicien")){
                FXMLLoader fXMLLoader =new FXMLLoader(getClass().getResource("Commande.fxml"));
                Parent root1=(Parent) fXMLLoader.load();
                Stage stage=new Stage();
                stage.setTitle("Passer commandes");
                stage.setScene(new Scene(root1));
                stage.show();
            }else {
                JOptionPane.showMessageDialog(null, "Accès interdit!");
            }
        }else {
            JOptionPane.showMessageDialog(null, "username ou password incorrecte");
        }
    }
}
