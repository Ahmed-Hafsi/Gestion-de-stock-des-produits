/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Produit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import util.DataSource;

/**
 *
 * @author karam
 */
public class ProduitService implements Iservice<Produit>{
    
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public ProduitService() {
        cnx = DataSource.getInstance().getConnection();
    }
    
    public void AddProduitPst(Produit p) throws SQLException{
        String requete = "insert into produit (id,nom,quantite,prix,fournisseur) values (?,?,?,?,?)";
        
        pst = cnx.prepareStatement(requete);
        
        pst.setString(1, p.getId());
        pst.setString(2, p.getNom());
        pst.setFloat(3, p.getPrix());
        pst.setFloat(4, p.getPrix());
        pst.setString(5, p.getFournisseur());
        
        pst.executeUpdate();
    }
    
    @Override
    public ArrayList<Produit> readAll() {
        ArrayList<Produit> list = new ArrayList<>();
        try {
            String requete = "select * from produit";
            
            ste = cnx.createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()) {
                Produit p=new Produit(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getString(5));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    @Override
    public void add(Produit p) {
        String requete = "insert into produit (id,nom,quantite,prix,fournisseur) values('" + p.getId() + "','" + p.getNom() + "','" + p.getQuantite() +"','" + p.getPrix() +"','" + p.getFournisseur() + "')";
        Statement ste;
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
            JOptionPane.showMessageDialog(null, "Ajouter avec succés!");
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void delete(String id) {
        String requete ="delete from produit where id='"+id+"'";
        Statement ste;
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
            JOptionPane.showMessageDialog(null, "Supprimer avec succés!");
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void updateProduit(String id, String nom, float prix, float quantite, String fournisseur) {
        String requete ="update produit set nom ='"+nom+"',prix ='"+prix+"',quantite ='"+quantite+"',fournisseur ='"+fournisseur+"' where id = '"+id+"'";
        Statement ste;
        
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
            JOptionPane.showMessageDialog(null, "MAJ avec succés!");
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateFournisseur(int id, String nom, String adresse, int tel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<String> showList(){
        ArrayList<String> list=new ArrayList<>();
        String requete = "select * from produit";
        
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()){
                Produit f=new Produit(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getString(5));
                list.add(rs.getString(1));
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
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Float readBy (String id){
        String requete = "select * from produit";
        float q=0;
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()){
                Produit f=new Produit(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getString(5));
                q = rs.getFloat(3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return q;
    }
    
    public void updateQuantite(String id, float quantite) {
        String requete ="update produit set quantite ='"+quantite+"' where id = '"+id+"'";
        Statement ste;
        
        try {
            ste = cnx.createStatement();
            ste.executeQuery(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
