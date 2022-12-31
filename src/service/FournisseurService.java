/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Fournisseur;
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
 * @author karam
 */
public class FournisseurService implements Iservice<Fournisseur>{
    
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public FournisseurService(){
        cnx = DataSource.getInstance().getConnection();
    }
    
    public void AddFournisseurPst (Fournisseur f) throws SQLException{
        String requete = "insert into fournisseur (id,nom,adresse,tel) values (?,?,?,?)";
        
        pst = cnx.prepareStatement(requete);
        
        pst.setInt(1, f.getId());
        pst.setString(2, f.getNom());
        pst.setString(3, f.getAdresse());
        pst.setInt(4, f.getTel());
        
        pst.executeUpdate();
    }
    
    
    @Override
    public void add(Fournisseur f) {
        String requete = "insert into fournisseur (id,nom,adresse,tel) values ('"+f.getId()+"','"+f.getNom()+"','"+f.getAdresse()+"','"+f.getTel()+"')";
        Statement ste;
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
            JOptionPane.showMessageDialog(null, "Ajouter avec succés!");
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        String requete ="delete from fournisseur where id='"+id+"'";
        Statement ste;
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
            JOptionPane.showMessageDialog(null, "Supprimer avec succés!");
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Fournisseur> readAll() {
        ArrayList<Fournisseur> list = new ArrayList<>();
        try {
            String requete = "select * from fournisseur";
            
            ste = cnx.createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()) {
                Fournisseur f=new Fournisseur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                list.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void updateFournisseur(int id, String nom, String adresse, int tel) {
        String requete ="update fournisseur set nom ='"+nom+"',adresse ='"+adresse+"',tel ='"+tel+"' where id = '"+id+"'";
        Statement ste;
        
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
            JOptionPane.showMessageDialog(null, "MAJ avec succés!");
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void updateProduit(String id, String nom, float prix, float quantite, String fournisseur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<String> showList(){
        ArrayList<String> list=new ArrayList<>();
        String requete = "select * from fournisseur";
        
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()){
                Fournisseur f=new Fournisseur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                list.add(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void updateUtilisateur(int id, String nom, String prenom, String adresse, String role, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
