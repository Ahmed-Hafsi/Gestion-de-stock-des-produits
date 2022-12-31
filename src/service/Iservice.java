/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author karam
 */
public interface Iservice <T>{
    
    void add(T t);
    void delete(int id);
    void delete(String id);
    ArrayList<T>readAll();
    void updateProduit(String id, String nom, float prix, float quantite, String fournisseur);
    void updateFournisseur(int id, String nom, String adresse, int tel);
    void updateUtilisateur(int id, String nom, String prenom, String adresse, String role, String password);
}
