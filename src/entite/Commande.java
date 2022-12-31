/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author Seif
 */
public class Commande {
    
    private int id;
    private int idAgent;
     private String idProduit1;
    private Float quantite1;
     private String idProduit2;
    private Float quantite2;
     private String idProduit3;
    private Float quantite3;
     private String idProduit4;
    private Float quantite4;
     private String idProduit5;
    private Float quantite5;

    public Commande() {
    }
    
    public Commande(int id, int idAgent, String idProduit1, Float quantite1, String idProduit2, Float quantite2, String idProduit3, Float quantite3, String idProduit4, Float quantite4, String idProduit5, Float quantite5) {
        this.id = id;
        this.idAgent = idAgent;
        this.idProduit1 = idProduit1;
        this.quantite1 = quantite1;
        this.idProduit2 = idProduit2;
        this.quantite2 = quantite2;
        this.idProduit3 = idProduit3;
        this.quantite3 = quantite3;
        this.idProduit4 = idProduit4;
        this.quantite4 = quantite4;
        this.idProduit5 = idProduit5;
        this.quantite5 = quantite5;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public int getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
    }

    public String getIdProduit1() {
        return idProduit1;
    }

    public void setIdProduit1(String idProduit1) {
        this.idProduit1 = idProduit1;
    }

    public Float getQuantite1() {
        return quantite1;
    }

    public void setQuantite1(Float quantite1) {
        this.quantite1 = quantite1;
    }

    public String getIdProduit2() {
        return idProduit2;
    }

    public void setIdProduit2(String idProduit2) {
        this.idProduit2 = idProduit2;
    }

    public Float getQuantite2() {
        return quantite2;
    }

    public void setQuantite2(Float quantite2) {
        this.quantite2 = quantite2;
    }

    public String getIdProduit3() {
        return idProduit3;
    }

    public void setIdProduit3(String idProduit3) {
        this.idProduit3 = idProduit3;
    }

    public Float getQuantite3() {
        return quantite3;
    }

    public void setQuantite3(Float quantite3) {
        this.quantite3 = quantite3;
    }

    public String getIdProduit4() {
        return idProduit4;
    }

    public void setIdProduit4(String idProduit4) {
        this.idProduit4 = idProduit4;
    }

    public Float getQuantite4() {
        return quantite4;
    }

    public void setQuantite4(Float quantite4) {
        this.quantite4 = quantite4;
    }

    public String getIdProduit5() {
        return idProduit5;
    }

    public void setIdProduit5(String idProduit5) {
        this.idProduit5 = idProduit5;
    }

    public Float getQuantite5() {
        return quantite5;
    }

    public void setQuantite5(Float quantite5) {
        this.quantite5 = quantite5;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", idAgent=" + idAgent + ", idProduit1=" + idProduit1 + ", quantite1=" + quantite1 + ", idProduit2=" + idProduit2 + ", quantite2=" + quantite2 + ", idProduit3=" + idProduit3 + ", quantite3=" + quantite3 + ", idProduit4=" + idProduit4 + ", quantite4=" + quantite4 + ", idProduit5=" + idProduit5 + ", quantite5=" + quantite5 + '}';
    }

    
    
    
}
