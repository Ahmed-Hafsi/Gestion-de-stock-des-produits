/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Commande;
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
 * @author Seif
 */
public class CommandeService implements Iservice<Commande>{
    
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public CommandeService() {
        cnx = DataSource.getInstance().getConnection();
    }

    @Override
    public void add(Commande c) {
        String requete = "insert into commande (idAgent,idProduit1,quantite1,idProduit2,quantite2,idProduit3,quantite3,idProduit4,quantite4,idProduit5,quantite5) values ('" + c.getIdAgent()+ "','" + c.getIdProduit1()+ "','" + c.getQuantite1() + "','" + c.getIdProduit2()+ "','" + c.getQuantite2() + "','" + c.getIdProduit3()+ "','" + c.getQuantite3() +"','" + c.getIdProduit4()+ "','" + c.getQuantite4() + "','" + c.getIdProduit5()+ "','" + c.getQuantite5() + "')";
        Statement ste;
        
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
            JOptionPane.showMessageDialog(null, "Ajouter avec succés!");
        } catch (SQLException ex) {
            Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        String requete = "delete from commande where id='"+id+"'";
        Statement ste;
        
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
            JOptionPane.showMessageDialog(null, "Supprimer avec succés!");
        } catch (SQLException ex) {
            Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Commande> readAll() {
        ArrayList<Commande> list=new ArrayList<>();
        try {
            String requete ="select * from commande";
            ste = cnx.createStatement();
            rs = ste.executeQuery(requete);
            
            while (rs.next()){
                Commande c=new Commande(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4), rs.getString(5), rs.getFloat(6), rs.getString(7), rs.getFloat(8), rs.getString(9), rs.getFloat(10), rs.getString(11), rs.getFloat(12));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
