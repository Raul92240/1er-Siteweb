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

public class TypeCompteDAO
{

// ==========================================================================
// PROPRIETES
// ==========================================================================
// --------------------------------------------------------------------------
// Acces a la base de donnees liee a la table TypeCompte
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
    public TypeCompteDAO(AccesBase accesBase)
    {
        this.accesBase = accesBase;
    }

// --------------------------------------------------------------------------
// Lecture d'un objet TypeCompte (dont la clef est renseignee)
// --------------------------------------------------------------------------
    public void lire(TypeCompte typecompte) throws SQLException
    {
        int rowCount;

        String select;
        Vector<Object> ligne;

        select = "SELECT * FROM TYPE COMPTE WHERE NUMERO = " + typecompte.getType_id();

        jeuResultat = accesBase.executeQuery(select);

        rowCount = (jeuResultat.getLignes()).size();

// --------------------------------------------------------------------------
// Si le executeQuery retourne 0 ligne, il n'y a pas SQLException. C'est la
// raison de la creation d'une SQLException particuliere.
// --------------------------------------------------------------------------
        if (rowCount == 1)
        {
            ligne = (jeuResultat.getLignes()).elementAt(0);

            typecompte.setLibelle((String) ligne.elementAt(1));
            typecompte.setMembre_id((Integer) ligne.elementAt(2));


        }
        else 
        {
            if (rowCount == 0)
            {
                throw new SQLException(
                    "Type Compte " + typecompte.getType_id() + " inconnu");
            }
            else
            {
                throw new SQLException(
                    "Clef " + typecompte.getType_id() + " en double !");
            }
        }
    }

// --------------------------------------------------------------------------
// Creation (insert) d'un objet TypeCompte
// --------------------------------------------------------------------------
    public int creer(TypeCompte typecompte) throws SQLException
    {
        int rowCount;
        String insert;

        Integer Type_id = typecompte.getType_id();
        String Libelle = typecompte.getLibelle();
        Integer Membre_id = typecompte.getMembre_id();
       

        insert = "INSERT INTO TYPE COMPTE VALUES("
            + Type_id + ", "
            + Conversion.chaineSQL(Libelle) + ", "
            + Membre_id + " ";
        rowCount = accesBase.executeUpdate(insert);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Modification (update) d'un objet TypeCompte
// --------------------------------------------------------------------------
    public int modifier(TypeCompte typecompte) throws SQLException
    {
        int rowCount;
        String update;

        Integer Type_id = typecompte.getType_id();
        String Libelle = typecompte.getLibelle();
        Integer Membre_id = typecompte.getMembre_id();


        update = "UPDATE TYPE COMPTE SET "
            + "LIBELLE = " + Conversion.chaineSQL(Libelle) + ", "
            + "MEMBRE_ID = " + Membre_id + ", "
            + "TYPE_ID = " + Type_id + " ";

        rowCount = accesBase.executeUpdate(update);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Destruction (delete) d'un objet TypeCompte
// --------------------------------------------------------------------------
    public int detruire(TypeCompte typecompte) throws SQLException
    {
        int rowCount;
        String delete;

        Integer Type_id = typecompte.getType_id();

        delete = "DELETE FROM TYPE COMPTE WHERE NUMERO = " + Type_id;

        rowCount = accesBase.executeUpdate(delete);

        return rowCount;
    }


// --------------------------------------------------------------------------
// Liste des TypeCompte
// --------------------------------------------------------------------------
    public Vector<TypeCompte> lireListe() throws SQLException
    {
        Vector<TypeCompte> listeTypeCompte;
        TypeCompte typecompte;

        String select = "SELECT * FROM TYPE COMPTE";

        int nombreTypeCompte;
        Vector<Object> ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeTypeCompte = new Vector<TypeCompte>();
        nombreTypeCompte = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreTypeCompte; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);

            typecompte = new TypeCompte();
            typecompte.setType_id((Integer) ligne.elementAt(0));
            typecompte.setLibelle((String) ligne.elementAt(1));
            typecompte.setMembre_id((Integer) ligne.elementAt(2));
            

            listeTypeCompte.addElement(typecompte);
        }

        return listeTypeCompte;
    }

// --------------------------------------------------------------------------
// Liste des colonnes de la table TypeCompte
// --------------------------------------------------------------------------
    public Vector<Colonne> getListeColonnes()
    {
        return jeuResultat.getColonnes();
    }
}
