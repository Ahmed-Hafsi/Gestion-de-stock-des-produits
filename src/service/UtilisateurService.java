/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.DataSource;

/**
 *
 * @author ahmed h
 */
public class UtilisateurService implements Iservice<Utilisateur>{
    
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public UtilisateurService(){
        cnx = DataSource.getInstance().getConnection();
    }

    @Override
    public void add(Utilisateur u) {
        String requete = "insert into utilisateur (id,nom,prenom,adresse,role,password) values ('" + u.getId() + "','" + u.getNom() + "','" + u.getPrenom() + "','" + u.getAdresse() + "','" + u.getRole() + "','" + u.getPassword() + "')";
        Statement ste;
        
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
            JOptionPane.showMessageDialog(null, "Ajouter avec succés!");
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        String requete ="delete from utilisateur where id='"+id+"'";
        Statement ste;
        
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
            JOptionPane.showMessageDialog(null, "Supprimer avec succés!");
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Utilisateur> readAll() {
        ArrayList<Utilisateur> list = new ArrayList<>();
        
        try {
            String requete = "select * from utilisateur";
            ste = cnx.createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()){
                Utilisateur u=new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void updateProduit(String id, String nom, float prix, float quantite, String fournisseur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateFournisseur(int id, String nom, String adresse, int tel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUtilisateur(int id, String nom, String prenom, String adresse, String role, String password) {
        String requete ="update utilisateur set nom ='"+nom+"',prenom ='"+prenom+"',adresse ='"+adresse+"',role ='"+role+"',password ='"+password+"' where id = '"+id+"'";
        Statement ste;
        
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
            JOptionPane.showMessageDialog(null, "MAJ avec succés!");
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
