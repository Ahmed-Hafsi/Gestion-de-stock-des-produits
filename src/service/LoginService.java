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
 * @author Elife-Beja-130
 */
public class LoginService {
    
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public LoginService() {
        cnx = DataSource.getInstance().getConnection();
    }
    
    public ArrayList<String> test1(){
        ArrayList<String> list=new ArrayList<>();
        String requete = "select * from utilisateur";
        
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()){
                Utilisateur u=new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(rs.getString(2)+rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<String> role (){
        ArrayList<String> list=new ArrayList<>();
        String requete = "select * from utilisateur";
        
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()){
                Utilisateur u=new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<Integer> identifiant (){
        ArrayList<Integer> list=new ArrayList<>();
        String requete = "select * from utilisateur";
        
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()){
                Utilisateur u=new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
