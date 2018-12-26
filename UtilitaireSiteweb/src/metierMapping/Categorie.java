
package metierMapping;

import java.util.*;

public class Categorie implements java.io.Serializable
{
    
// ==========================================================================
// PROPRIETES
// ==========================================================================
// Toutes les colonnes de la table y compris les clefs etrangeres
// --------------------------------------------------------------------------
    private Integer Categorie_id;             // Clef primaire
    private String Libelle;
    
// --------------------------------------------------------------------------
// Proprietes de mapping
// --------------------------------------------------------------------------
   private Vector<Annonce> listeAnnonce;
   
// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------
    public Categorie ()
    {
    }
    
// --------------------------------------------------------------------------
// SETTERS
// --------------------------------------------------------------------------     

    public void setCategorie_id(Integer Categorie_id) {
        this.Categorie_id = Categorie_id;
    }

    public void setLibelle(String Libelle) {
        this.Libelle = Libelle;
    }

    public void setListeAnnonce(Vector<Annonce> listeAnnonce) {
        this.listeAnnonce = listeAnnonce;
    }
   
// --------------------------------------------------------------------------
// GETTERS
// --------------------------------------------------------------------------   

    public Integer getCategorie_id() {
        return Categorie_id;
    }

    public String getLibelle() {
        return Libelle;
    }

    public Vector<Annonce> getListeAnnonce() {
        return listeAnnonce;
    }
   
// --------------------------------------------------------------------------
// AFFICHAGE DU CONTACT (POUR MISE AU POINT)
// --------------------------------------------------------------------------
    public String toString()
    {
        String retour;

        retour = "Categorie_id                     : " + Categorie_id + "\n";
        retour += "Libelle                       : " + Libelle + "\n";

        return retour;   
   
    }  
}
    