/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author karam
 */
public class Fournisseur {
    private int id;
    private String nom;
    private String adresse;
    private int tel;

    public Fournisseur() {
    }

    public Fournisseur(int id, String nom, String adresse, int tel) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Fournisseur{" + "id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", tel=" + tel + '}';
    }

    
    
    
}
