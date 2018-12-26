
package metierMapping;

import java.util.*;

public class Avis implements java.io.Serializable
{
    
// ==========================================================================
// PROPRIETES
// ==========================================================================
// Toutes les colonnes de la table y compris les clefs etrangeres
// --------------------------------------------------------------------------
    private Integer Avis_id;             // Clef primaire
    private String Note;
    private String Commentaire;
    private Date Date;
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
    public Avis()
    {
    }
    
// --------------------------------------------------------------------------
// SETTERS
// -------------------------------------------------------------------------- 

    public void setAvis_id(Integer Avis_id) {
        this.Avis_id = Avis_id;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public void setCommentaire(String Commentaire) {
        this.Commentaire = Commentaire;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public void setMembre_id(Integer Membre_id) {
        this.Membre_id = Membre_id;
    }

    public void setMembreDuSite(MembreDuSite MembreDuSite) {
        this.membredusite = MembreDuSite;
    }
    
// --------------------------------------------------------------------------
// GETTERS
// --------------------------------------------------------------------------

    public Integer getAvis_id() {
        return Avis_id;
    }

    public String getNote() {
        return Note;
    }

    public String getCommentaire() {
        return Commentaire;
    }

    public Date getDate() {
        return Date;
    }

    public Integer getMembre_id() {
        return Membre_id;
    }

    public MembreDuSite getMembreDuSite() {
        return membredusite;
    }
    
// --------------------------------------------------------------------------
// AFFICHAGE DU CONTACT (POUR MISE AU POINT)
// --------------------------------------------------------------------------
    public String toString()
    {
        String retour;

        retour = "Avis_id                     : " + Avis_id + "\n";
        retour += "Note                       : " + Note + "\n";
        retour += "Commentaire                : " + Commentaire + "\n";
        retour += "Date                       : " + Date + "\n";
        retour += "Membre_id                  : " + Membre_id + "\n";
 
        

        return retour;
    } 
}