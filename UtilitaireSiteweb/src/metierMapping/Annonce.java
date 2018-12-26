
package metierMapping;

import java.util.*;

public class Annonce implements java.io.Serializable
{
    
// ==========================================================================
// PROPRIETES
// ==========================================================================
// Toutes les colonnes de la table y compris les clefs etrangeres
// --------------------------------------------------------------------------
    private Integer Annonce_id;             // Clef primaire
    private String Libelle;
    private Date Date;
    private String Description;
    private String Img;
    private String Region;
    private Integer Membre_id;             // Clef etrangere vers MembreDuSite
    private Integer Categorie_id;          // Clef etrangere vers Categorie
 // --------------------------------------------------------------------------
// Proprietes de mapping
// --------------------------------------------------------------------------
    private MembreDuSite membredusite;
    private Categorie categorie;
    
// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------
    public Annonce ()
    {
    }
    
// --------------------------------------------------------------------------
// SETTERS
// --------------------------------------------------------------------------    

    public void setAnnonce_id(Integer Annonce_id) {
        this.Annonce_id = Annonce_id;
    }

    public void setLibelle(String Libelle) {
        this.Libelle = Libelle;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setImg(String Img) {
        this.Img = Img;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public void setMembre_id(Integer Membre_id) {
        this.Membre_id = Membre_id;
    }

    public void setCategorie_id(Integer Categorie_id) {
        this.Categorie_id = Categorie_id;
    } 

    public void setMembredusite(MembreDuSite membredusite) {
        this.membredusite = membredusite;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
// --------------------------------------------------------------------------
// GETTERS
// --------------------------------------------------------------------------

    public Integer getAnnonce_id() {
        return Annonce_id;
    }

    public String getLibelle() {
        return Libelle;
    }

    public Date getDate() {
        return Date;
    }

    public String getDescription() {
        return Description;
    }

    public String getImg() {
        return Img;
    }

    public String getRegion() {
        return Region;
    }
    
    

    public Integer getMembre_id() {
        return Membre_id;
    }

    public Integer getCategorie_id() {
        return Categorie_id;
    } 

    public MembreDuSite getMembredusite() {
        return membredusite;
    }

    public Categorie getCategorie() {
        return categorie;
    }

// --------------------------------------------------------------------------
// AFFICHAGE DU CONTACT (POUR MISE AU POINT)
// --------------------------------------------------------------------------
    public String toString()
    {
        String retour;

        retour = "Annonce_id                     : " + Annonce_id + "\n";
        retour += "Libelle                       : " + Libelle + "\n";
        retour += "Date                          : " + Date + "\n";
        retour += "Description                   : " + Description + "\n";
        retour += "Img                           : " + Img + "\n";
        retour += "Region                        : " + Region + "\n";
        retour += "Membre_id                     : " + Membre_id + "\n";
        retour += "Categorie_id                  : " + Categorie_id + "\n";
        

        return retour;
    }     
    
    
    
    
    
    
}
   