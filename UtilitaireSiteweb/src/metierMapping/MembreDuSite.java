package metierMapping;

import java.util.*;


public class MembreDuSite implements java.io.Serializable
{
    
// ==========================================================================
// PROPRIETES
// ==========================================================================
// Toutes les colonnes de la table y compris les clefs etrangeres
// --------------------------------------------------------------------------
    private Integer Membre_id;             // Clef primaire
    private String Pseudo;
    private String Mdp;
    private Date DateInscription;
    private String Mail;
    private String Region;
    private String Type;
    
// --------------------------------------------------------------------------
// Proprietes de mapping
// --------------------------------------------------------------------------
   private Vector<Annonce> listeAnnonce;
   private Vector<Avis> listeAvis;
   private Vector<TypeCompte> listeTypeCompte;

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------
public MembreDuSite ()    
{
    
}

// --------------------------------------------------------------------------
// SETTERS
// --------------------------------------------------------------------------

    public void setMembre_id(Integer Membre_id) {
        this.Membre_id = Membre_id;
    }

    public void setPseudo(String Pseudo) {
        this.Pseudo = Pseudo;
    }

    public void setMdp(String Mdp) {
        this.Mdp = Mdp;
    }

    public void setDateInscription(Date DateInscription) {
        this.DateInscription = DateInscription;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setListeAnnonce(Vector<Annonce> listeAnnonce) {
        this.listeAnnonce = listeAnnonce;
    }

    public void setListeAvis(Vector<Avis> listeAvis) {
        this.listeAvis = listeAvis;
    }

    public void setListeTypeCompte(Vector<TypeCompte> listeTypeCompte) {
        this.listeTypeCompte = listeTypeCompte;
    }

    
// --------------------------------------------------------------------------
// GETTERS
// --------------------------------------------------------------------------

    public Integer getMembre_id() {
        return Membre_id;
    }

    public String getPseudo() {
        return Pseudo;
    }

    public String getMdp() {
        return Mdp;
    }

    public Date getDateInscription() {
        return DateInscription;
    }

    public String getMail() {
        return Mail;
    }

    public String getRegion() {
        return Region;
    }

    public String getType() {
        return Type;
    }

    public Vector<Annonce> getListeAnnonce() {
        return listeAnnonce;
    }

    public Vector<Avis> getListeAvis() {
        return listeAvis;
    }

    public Vector<TypeCompte> getListeTypeCompte() {
        return listeTypeCompte;
    }

    
    
// --------------------------------------------------------------------------
// AFFICHAGE DU CONTACT (POUR MISE AU POINT)
// --------------------------------------------------------------------------
    public String toString()
    {
        String retour;

        retour = "Membre_id                : " + Membre_id + "\n";
        retour += "Pseudo                  : " + Pseudo + "\n";
        retour += "Mdp                     : " + Mdp + "\n";
        retour += "DateInscription         : " + DateInscription + "\n";
        retour += "Mail                    : " + Mail + "\n";
        retour += "Region                  : " + Region + "\n";
        retour += "Type                    : " + Type + "\n";

        return retour;
    }
}