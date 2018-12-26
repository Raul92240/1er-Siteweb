
package metierMapping;

import java.util.*;


public class TypeCompte implements java.io.Serializable
{
    
// ==========================================================================
// PROPRIETES
// ==========================================================================
// Toutes les colonnes de la table y compris les clefs etrangeres
// --------------------------------------------------------------------------
    private Integer Type_id;             // Clef primaire
    private String Libelle;
    private Integer Membre_id;           // Clef etrangere vers MembreDuSite
    
// --------------------------------------------------------------------------
// Proprietes de mapping
// --------------------------------------------------------------------------
    private MembreDuSite membredusite;  
    
// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------
    public TypeCompte ()
    {
    }
    
// --------------------------------------------------------------------------
// SETTERS
// --------------------------------------------------------------------------     

    public void setType_id(Integer Type_id) {
        this.Type_id = Type_id;
    }

    public void setLibelle(String Libelle) {
        this.Libelle = Libelle;
    }

    public void setMembre_id(Integer Membre_id) {
        this.Membre_id = Membre_id;
    }

    public void setMembredusite(MembreDuSite membredusite) {
        this.membredusite = membredusite;
    }
    
// --------------------------------------------------------------------------
// GETTERS
// --------------------------------------------------------------------------   

    public Integer getType_id() {
        return Type_id;
    }

    public String getLibelle() {
        return Libelle;
    }

    public Integer getMembre_id() {
        return Membre_id;
    }

    public MembreDuSite getMembredusite() {
        return membredusite;
    }
   
// --------------------------------------------------------------------------
// AFFICHAGE DU CONTACT (POUR MISE AU POINT)
// --------------------------------------------------------------------------
    public String toString()
    {
        String retour;

        retour = "Type_id                     : " + Type_id + "\n";
        retour += "Libelle                    : " + Libelle + "\n";
       retour += "Membre_id                   : " + Membre_id + "\n";
     
        return retour;
    }    
    
    
}