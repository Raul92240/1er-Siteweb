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

public class MembreDuSiteDAO
{

// ==========================================================================
// PROPRIETES
// ==========================================================================
// --------------------------------------------------------------------------
// Acces a la base de donnees liee a la table MEMBREDUSITE
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
    public MembreDuSiteDAO(AccesBase accesBase)
    {
        this.accesBase = accesBase;
    }

// --------------------------------------------------------------------------
// Lecture d'un objet membredusite (dont la clef est renseignee)
// --------------------------------------------------------------------------
    public void lire(MembreDuSite membredusite) throws SQLException
    {
        int rowCount;

        String select;
        Vector<Object> ligne;

        select = "SELECT * FROM MEMBRE DU SITE WHERE NUMERO = " + membredusite.getMembre_id();

        jeuResultat = accesBase.executeQuery(select);

        rowCount = (jeuResultat.getLignes()).size();

// --------------------------------------------------------------------------
// Si le executeQuery retourne 0 ligne, il n'y a pas SQLException. C'est la
// raison de la creation d'une SQLException particuliere.
// --------------------------------------------------------------------------
        if (rowCount == 1)
        {
            ligne = (jeuResultat.getLignes()).elementAt(0);

            membredusite.setPseudo((String) ligne.elementAt(1));
            membredusite.setMdp((String) ligne.elementAt(2));
            membredusite.setDateInscription((Date) ligne.elementAt(3));
            membredusite.setMail((String) ligne.elementAt(4));
            membredusite.setRegion((String) ligne.elementAt(5));
            membredusite.setType((String) ligne.elementAt(6));

        }
        else 
        {
            if (rowCount == 0)
            {
                throw new SQLException(
                    "Annonce " + membredusite.getMembre_id() + " inconnu");
            }
            else
            {
                throw new SQLException(
                    "Clef " + membredusite.getMembre_id() + " en double !");
            }
        }
    }

// --------------------------------------------------------------------------
// Creation (insert) d'un objet membredusite
// --------------------------------------------------------------------------
    public int creer(MembreDuSite membredusite) throws SQLException
    {
        int rowCount;
        String insert;

        Integer Membre_id = membredusite.getMembre_id();
        String Pseudo = membredusite.getPseudo();
        String Mdp = membredusite.getMdp();
        Date DateInscription = membredusite.getDateInscription();
        String Mail = membredusite.getMail();
        String Region = membredusite.getRegion();
       

        insert = "INSERT INTO MEMBRE DU SITE VALUES("
            + Membre_id + ", "
            + Conversion.chaineSQL(Pseudo) + ", "
                + Conversion.chaineSQL(Mdp) + ", "
            + DateInscription + ", "
            + Conversion.chaineSQL(Mail) + ", "
            + Conversion.chaineSQL(Region) + ", ";

        rowCount = accesBase.executeUpdate(insert);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Modification (update) d'un objet membredusite
// --------------------------------------------------------------------------
    public int modifier(MembreDuSite membredusite) throws SQLException
    {
        int rowCount;
        String update;

        Integer Membre_id = membredusite.getMembre_id();
        String Pseudo = membredusite.getPseudo();
        String Mdp = membredusite.getMdp();
        Date DateInscription = membredusite.getDateInscription();
        String Mail = membredusite.getMail();
        String Region = membredusite.getRegion();

        update = "UPDATE MEMBRE DU SITE SET "
            + "PSEUDO = " + Conversion.chaineSQL(Pseudo) + ", "
            + "MDP = " + Conversion.chaineSQL(Mdp) + ", "
            + "DATEINSCRIPTION = " + DateInscription + ", "
            + "MAIL = " + Conversion.chaineSQL(Mail) + ", "
            + "REGION = " + Conversion.chaineSQL(Region) + ", "
            + "MEMBRE_ID = " + Membre_id + " ";

        rowCount = accesBase.executeUpdate(update);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Destruction (delete) d'un objet membredusite
// --------------------------------------------------------------------------
    public int detruire(MembreDuSite membredusite) throws SQLException
    {
        int rowCount;
        String delete;

        Integer Membre_id = membredusite.getMembre_id();

        delete = "DELETE FROM MEMBRE DU SITE WHERE NUMERO = " + Membre_id;

        rowCount = accesBase.executeUpdate(delete);

        return rowCount;
    }


// --------------------------------------------------------------------------
// Liste des membredusite
// --------------------------------------------------------------------------
    public Vector<MembreDuSite> lireListe() throws SQLException
    {
        Vector<MembreDuSite> listeMembreDuSite;
        MembreDuSite membredusite;

        String select = "SELECT * FROM MEMBRE DU SITE";

        int nombreMembreDuSite;
        Vector<Object> ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeMembreDuSite = new Vector<MembreDuSite>();
        nombreMembreDuSite = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreMembreDuSite; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);

            membredusite = new MembreDuSite();
            membredusite.setMembre_id((Integer) ligne.elementAt(0));
            membredusite.setPseudo((String) ligne.elementAt(1));
            membredusite.setMdp((String) ligne.elementAt(2));
            membredusite.setDateInscription((Date) ligne.elementAt(3));
            membredusite.setMail((String) ligne.elementAt(4));
            membredusite.setRegion((String) ligne.elementAt(5));
            

            listeMembreDuSite.addElement(membredusite);
        }

        return listeMembreDuSite;
    }

// --------------------------------------------------------------------------
// Liste des colonnes de la table membredusite
// --------------------------------------------------------------------------
    public Vector<Colonne> getListeColonnes()
    {
        return jeuResultat.getColonnes();
    }
}
