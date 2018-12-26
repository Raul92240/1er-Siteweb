// ==========================================================================
// package daoJdbcMapping                                      Projet Mapping
// --------------------------------------------------------------------------
// CLASSE ContactDAO
// ==========================================================================
package ClasseDao;

import divers.Conversion;
import divers.Colonne;
import java.sql.SQLException;
import java.util.*;
import jdbc.AccesBase;
import jdbc.JeuResultat;
import metierMapping.*;

public class AnnonceDAO
{

// ==========================================================================
// PROPRIETES
// ==========================================================================
// --------------------------------------------------------------------------
// Acces a la base de donnees liee a la table CONTACT
// --------------------------------------------------------------------------
    private AccesBase accesBase;

// --------------------------------------------------------------------------
// Jeu de resultats lu par l'un des "executeQuery"
// Il contient toutes les donnees des lignes lues dans la table contact et
// les donnees relatives aux colonnes.
// --------------------------------------------------------------------------
    private JeuResultat jeuResultat;

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public AnnonceDAO(AccesBase accesBase)
    {
        this.accesBase = accesBase;
    }

// --------------------------------------------------------------------------
// Lecture d'un objet Contact (dont la clef est renseignee)
// --------------------------------------------------------------------------
    public void lire(Annonce annonce) throws SQLException
    {
        int rowCount;

        String select;
        Vector<Object> ligne;

        select = "SELECT * FROM ANNONCE WHERE NUMERO = " + annonce.getAnnonce_id();

        jeuResultat = accesBase.executeQuery(select);

        rowCount = (jeuResultat.getLignes()).size();

// --------------------------------------------------------------------------
// Si le executeQuery retourne 0 ligne, il n'y a pas SQLException. C'est la
// raison de la creation d'une SQLException particuliere.
// --------------------------------------------------------------------------
        if (rowCount == 1)
        {
            ligne = (jeuResultat.getLignes()).elementAt(0);

            annonce.setLibelle((String) ligne.elementAt(1));
            annonce.setDate((Date) ligne.elementAt(2));
            annonce.setDescription((String) ligne.elementAt(3));
            annonce.setImg((String) ligne.elementAt(4));
            annonce.setRegion((String) ligne.elementAt(5));
            annonce.setMembre_id((Integer) ligne.elementAt(6));
            annonce.setCategorie_id((Integer) ligne.elementAt(7));

        }
        else 
        {
            if (rowCount == 0)
            {
                throw new SQLException(
                    "Annonce " + annonce.getAnnonce_id() + " inconnu");
            }
            else
            {
                throw new SQLException(
                    "Clef " + annonce.getAnnonce_id() + " en double !");
            }
        }
    }

// --------------------------------------------------------------------------
// Creation (insert) d'un objet Contact
// --------------------------------------------------------------------------
    public int creer(Annonce annonce) throws SQLException
    {
        int rowCount;
        String insert;

        Integer Annonce_id = annonce.getAnnonce_id();
        String Libelle = annonce.getLibelle();
        Date Date = annonce.getDate();
        String Description = annonce.getDescription();
        String Img = annonce.getImg();
        String Region = annonce.getRegion();
        Integer Membre_id = annonce.getMembre_id();
        Integer Categorie_id  = annonce.getCategorie_id();

        insert = "INSERT INTO ANNONCE VALUES("
            + Annonce_id + ", "
            + Conversion.chaineSQL(Libelle) + ", "
            + Date + ", "
            + Conversion.chaineSQL(Description) + ", "
            + Conversion.chaineSQL(Img) + ", "
            + Conversion.chaineSQL(Region) + ", "    
            + Membre_id + ", "
            + Categorie_id + " ";

        rowCount = accesBase.executeUpdate(insert);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Modification (update) d'un objet Contact
// --------------------------------------------------------------------------
    public int modifier(Annonce annonce) throws SQLException
    {
        int rowCount;
        String update;

        Integer Annonce_id = annonce.getAnnonce_id();
        String Libelle = annonce.getLibelle();
        Date Date = annonce.getDate();
        String Description = annonce.getDescription();
        String Img = annonce.getImg();
        String Region = annonce.getRegion();
        Integer Membre_id = annonce.getMembre_id();
        Integer Categorie_id = annonce.getCategorie_id();

        update = "UPDATE ANNONCE SET "
            + "LIBELLE = " + Conversion.chaineSQL(Libelle) + ", "
            + "DATE = " + Date + ", "
            + "DESCRIPTION = " + Conversion.chaineSQL(Description) + ", "
            + "IMG = " + Conversion.chaineSQL(Img) + ", "
            + "REGION = " + Conversion.chaineSQL(Region) + ", "
            + "MEMBRE_ID = " + Membre_id + ", "
            + "CATEGORIE_ID = " + Categorie_id + ", "
            + "ANNONCE_ID = " + Annonce_id + " ";

        rowCount = accesBase.executeUpdate(update);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Destruction (delete) d'un objet Contact
// --------------------------------------------------------------------------
    public int detruire(Annonce annonce) throws SQLException
    {
        int rowCount;
        String delete;

        Integer Annonce_id = annonce.getAnnonce_id();

        delete = "DELETE FROM ANNONCE WHERE NUMERO = " + Annonce_id;

        rowCount = accesBase.executeUpdate(delete);

        return rowCount;
    }


// --------------------------------------------------------------------------
// Liste des contacts
// --------------------------------------------------------------------------
    public Vector<Annonce> lireListe() throws SQLException
    {
        Vector<Annonce> listeAnnonce;
        Annonce annonce;

        String select = "SELECT * FROM ANNONCE";

        int nombreAnnonce;
        Vector<Object> ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeAnnonce = new Vector<Annonce>();
        nombreAnnonce = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreAnnonce; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);

            annonce = new Annonce();
            annonce.setAnnonce_id((Integer) ligne.elementAt(0));
            annonce.setLibelle((String) ligne.elementAt(1));
            annonce.setDate((Date) ligne.elementAt(2));
            annonce.setDescription((String) ligne.elementAt(3));
            annonce.setImg((String) ligne.elementAt(4));
            annonce.setRegion((String) ligne.elementAt(5));
            annonce.setMembre_id((Integer) ligne.elementAt(6));
            annonce.setCategorie_id((Integer) ligne.elementAt(7));

            listeAnnonce.addElement(annonce);
        }

        return listeAnnonce;
    }
// --------------------------------------------------------------------------
// Liste des contacts par region
// --------------------------------------------------------------------------
    
    public Vector<Annonce> lireListeRegion(String nom) throws SQLException
    {
        Vector<Annonce> listeAnnonce;
        Annonce annonce;

        String select = "SELECT * FROM ANNONCE WHERE ANNONCE_REGION LIKE ('"+ nom +"')";

        int nombreAnnonce;
        Vector<Object> ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeAnnonce = new Vector<Annonce>();
        nombreAnnonce = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreAnnonce; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);

            annonce = new Annonce();
            annonce.setAnnonce_id((Integer) ligne.elementAt(0));
            annonce.setLibelle((String) ligne.elementAt(1));
            annonce.setDate((Date) ligne.elementAt(2));
            annonce.setDescription((String) ligne.elementAt(3));
            annonce.setImg((String) ligne.elementAt(4));
            annonce.setRegion((String) ligne.elementAt(5));
            annonce.setMembre_id((Integer) ligne.elementAt(6));
            annonce.setCategorie_id((Integer) ligne.elementAt(7));

            listeAnnonce.addElement(annonce);
        }

        return listeAnnonce;
    }
// --------------------------------------------------------------------------
// Liste des colonnes de la table CONTACT
// --------------------------------------------------------------------------
    public Vector<Colonne> getListeColonnes()
    {
        return jeuResultat.getColonnes();
    }
}
