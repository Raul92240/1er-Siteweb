// ==========================================================================
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

public class CategorieDAO
{

// ==========================================================================
// PROPRIETES
// ==========================================================================
// --------------------------------------------------------------------------
// Acces a la base de donnees liee a la table CATEGORIE
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
    public CategorieDAO(AccesBase accesBase)
    {
        this.accesBase = accesBase;
    }

// --------------------------------------------------------------------------
// Lecture d'un objet Contact (dont la clef est renseignee)
// --------------------------------------------------------------------------
    public void lire(Categorie categorie) throws SQLException
    {
        int rowCount;

        String select;
        Vector<Object> ligne;

        select = "SELECT * FROM CATEGORIE WHERE NUMERO = " + categorie.getCategorie_id();

        jeuResultat = accesBase.executeQuery(select);

        rowCount = (jeuResultat.getLignes()).size();

// --------------------------------------------------------------------------
// Si le executeQuery retourne 0 ligne, il n'y a pas SQLException. C'est la
// raison de la creation d'une SQLException particuliere.
// --------------------------------------------------------------------------
        if (rowCount == 1)
        {
            ligne = (jeuResultat.getLignes()).elementAt(0);

            categorie.setLibelle((String) ligne.elementAt(1));


        }
        else 
        {
            if (rowCount == 0)
            {
                throw new SQLException(
                    "Categorie " + categorie.getCategorie_id() + " inconnu");
            }
            else
            {
                throw new SQLException(
                    "Clef " + categorie.getCategorie_id() + " en double !");
            }
        }
    }

// --------------------------------------------------------------------------
// Creation (insert) d'un objet Categorie
// --------------------------------------------------------------------------
    public int creer(Categorie categorie) throws SQLException
    {
        int rowCount;
        String insert;

        Integer Categorie_id = categorie.getCategorie_id();
        String Libelle = categorie.getLibelle();

       

        insert = "INSERT INTO CATEGORIE VALUES("
            + Categorie_id + ", "
            + Conversion.chaineSQL(Libelle) + ", " ;

        rowCount = accesBase.executeUpdate(insert);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Modification (update) d'un objet Categorie
// --------------------------------------------------------------------------
    public int modifier(Categorie categorie) throws SQLException
    {
        int rowCount;
        String update;

        Integer Categorie_id = categorie.getCategorie_id();
        String Libelle = categorie.getLibelle();
       

        update = "UPDATE CATEGORIE SET "
            + "LIBELLE = " + Conversion.chaineSQL(Libelle) + ", "
            + "CATEGORIE_ID = " + Categorie_id + " ";

        rowCount = accesBase.executeUpdate(update);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Destruction (delete) d'un objet Categorie
// --------------------------------------------------------------------------
    public int detruire(Categorie categorie) throws SQLException
    {
        int rowCount;
        String delete;

        Integer Categorie_id = categorie.getCategorie_id();

        delete = "DELETE FROM CATEGORIE WHERE NUMERO = " + Categorie_id;

        rowCount = accesBase.executeUpdate(delete);

        return rowCount;
    }


// --------------------------------------------------------------------------
// Liste des categories
// --------------------------------------------------------------------------
    public Vector<Categorie> lireListe() throws SQLException
    {
        Vector<Categorie> listeCategorie;
        Categorie categorie;

        String select = "SELECT * FROM CATEGORIE";

        int nombreCategorie;
        Vector<Object> ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeCategorie = new Vector<Categorie>();
        nombreCategorie = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreCategorie; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);

            categorie = new Categorie();
            categorie.setCategorie_id((Integer) ligne.elementAt(0));
            categorie.setLibelle((String) ligne.elementAt(1));
            
            

            listeCategorie.addElement(categorie);
        }

        return listeCategorie;
    }

// --------------------------------------------------------------------------
// Liste des colonnes de la table CATEGORIE
// --------------------------------------------------------------------------
    public Vector<Colonne> getListeColonnes()
    {
        return jeuResultat.getColonnes();
    }
}
