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

public class AvisDAO
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
    public AvisDAO(AccesBase accesBase)
    {
        this.accesBase = accesBase;
    }

// --------------------------------------------------------------------------
// Lecture d'un objet Contact (dont la clef est renseignee)
// --------------------------------------------------------------------------
    public void lire(Avis avis) throws SQLException
    {
        int rowCount;

        String select;
        Vector<Object> ligne;

        select = "SELECT * FROM AVIS WHERE NUMERO = " + avis.getAvis_id();

        jeuResultat = accesBase.executeQuery(select);

        rowCount = (jeuResultat.getLignes()).size();

// --------------------------------------------------------------------------
// Si le executeQuery retourne 0 ligne, il n'y a pas SQLException. C'est la
// raison de la creation d'une SQLException particuliere.
// --------------------------------------------------------------------------
        if (rowCount == 1)
        {
            ligne = (jeuResultat.getLignes()).elementAt(0);

            avis.setAvis_id((Integer) ligne.elementAt(1));
            avis.setNote((String) ligne.elementAt(2));
            avis.setCommentaire((String) ligne.elementAt(3));
            avis.setDate((Date) ligne.elementAt(4));
            avis.setMembre_id((Integer) ligne.elementAt(5));
           

        }
        else 
        {
            if (rowCount == 0)
            {
                throw new SQLException(
                    "Avis " + avis.getAvis_id() + " inconnu");
            }
            else
            {
                throw new SQLException(
                    "Clef " + avis.getAvis_id() + " en double !");
            }
        }
    }

// --------------------------------------------------------------------------
// Creation (insert) d'un objet Contact
// --------------------------------------------------------------------------
    public int creer(Avis avis) throws SQLException
    {
        int rowCount;
        String insert;

        Integer Avis_id = avis.getAvis_id();
        String Note = avis.getNote();
        String Commentaire = avis.getCommentaire();
        Date Date = avis.getDate();
        Integer Membre_id = avis.getMembre_id();
        
       

        insert = "INSERT INTO AVIS VALUES("
            + Avis_id + ", "
            + Conversion.chaineSQL(Note) + ", "
                + Conversion.chaineSQL(Commentaire) + ", "
            + Date + ", "
            + Membre_id + ", ";

        rowCount = accesBase.executeUpdate(insert);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Modification (update) d'un objet Contact
// --------------------------------------------------------------------------
    public int modifier(Avis avis) throws SQLException
    {
        int rowCount;
        String update;

        Integer Avis_id = avis.getAvis_id();
        String Note = avis.getNote();
        String Commentaire = avis.getCommentaire();
        Date Date = avis.getDate();
        Integer Membre_id = avis.getMembre_id();

        update = "UPDATE AVIS SET "
            + "NOTE = " + Conversion.chaineSQL(Note) + ", "
            + "COMMENTAIRE = " + Conversion.chaineSQL(Commentaire) + ", "
            + "DATE = " + Date + ", "
            + "MEMBRE_ID = " + Membre_id + ", "    
            + "AVIS_ID = " + Avis_id + " ";

        rowCount = accesBase.executeUpdate(update);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Destruction (delete) d'un objet Contact
// --------------------------------------------------------------------------
    public int detruire(Avis avis) throws SQLException
    {
        int rowCount;
        String delete;

        Integer Avis_id = avis.getAvis_id();

        delete = "DELETE FROM AVIS WHERE NUMERO = " + Avis_id;

        rowCount = accesBase.executeUpdate(delete);

        return rowCount;
    }


// --------------------------------------------------------------------------
// Liste des contacts
// --------------------------------------------------------------------------
    public Vector<Avis> lireListe() throws SQLException
    {
        Vector<Avis> listeAvis;
        Avis avis;

        String select = "SELECT * FROM AVIS";

        int nombreAvis;
        Vector<Object> ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeAvis = new Vector<Avis>();
        nombreAvis = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreAvis; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);

            avis = new Avis();
            avis.setAvis_id((Integer) ligne.elementAt(0));
            avis.setNote((String) ligne.elementAt(1));
            avis.setCommentaire((String) ligne.elementAt(2));
            avis.setDate((Date) ligne.elementAt(3));
            avis.setMembre_id((Integer) ligne.elementAt(4));
            
            

            listeAvis.addElement(avis);
        }

        return listeAvis;
    }

// --------------------------------------------------------------------------
// Liste des colonnes de la table CONTACT
// --------------------------------------------------------------------------
    public Vector<Colonne> getListeColonnes()
    {
        return jeuResultat.getColonnes();
    }
}
