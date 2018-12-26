// ==========================================================================
// package utilitairesMG.jdbc
// --------------------------------------------------------------------------
// Classe AccesBase
// --------------------------------------------------------------------------
// Un objet AccesBase permet d'obtenir un accès (une connection) a une base
// et d'y effectuer des requetes.
// ==========================================================================
package jdbc;

import java.util.*;
import java.sql.*;

public class AccesBase
{
    private BaseDeDonnees base;
    private Connection connexion;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public AccesBase(BaseDeDonnees base)
    {
        this.base = base;
    }
    
    public BaseDeDonnees getBase()
    {
        return base;
    }

// --------------------------------------------------------------------------
// Methode d'ouverture d'une connexion
// --------------------------------------------------------------------------
    public Connection getConnection() throws SQLException
    {
        DriverManager.setLoginTimeout(10);
        
        if(base.getNomBase() != null)
        {
            connexion = DriverManager.getConnection(base.getNomBase());
        }
        else
        {
            connexion = DriverManager.getConnection(base.getUrl(), 
                                                    base.getUser(), 
                                                    base.getPassword());
        }
        return connexion;
    }

    public void setConnection(Connection connexion)
    {
        this.connexion = connexion;
    }

// --------------------------------------------------------------------------
// Methode de fermeture de la connexion
// --------------------------------------------------------------------------
    public void closeConnection() throws SQLException
    {
        if ((connexion != null) && (!connexion.isClosed()))
        {
            connexion.close();
        }
    }

// --------------------------------------------------------------------------
// executeQuery (SELECT)
// --------------------------------------------------------------------------
// Cette methode retourne le jeu de resultats obtenu par le Select
// --------------------------------------------------------------------------
// Principe de traitement d'une requete SQL :
//
//     creation du Statement,
//     execution de la requete,
//     fermeture du ResultSet (si Select)
//     fermeture du Statement,
//
// Les objets Connection, Statement, ResultSet sont perdus quand on les
// ferme... Le resultat d'une requete SELECT doit donc etre tranfere du
// ResultSet dans un objet de type JeuResultat.
// --------------------------------------------------------------------------
    public JeuResultat executeQuery(String select) throws SQLException
    {
        Statement traitement;
        ResultSet resultats;
        JeuResultat jeuResultat;

// --------------------------------------------------------------------------
// Cas de la requete vide.
// --------------------------------------------------------------------------
        if (select.compareTo("") == 0)
        {
            throw new SQLException("Requete vide");
        }

// --------------------------------------------------------------------------
// Creer le Statement, executer le SELECT.
// --------------------------------------------------------------------------
// Les try imbriques sont necessaires pour fermer correctement toutes les
// ressources qui ont ete ouvertes, meme en cas d'erreur (SQLException).
// Les exceptions sont renvoyees au programme appelant pour qu'il puisse a
// son tour les traiter.
// --------------------------------------------------------------------------
        traitement = connexion.createStatement();

        try
        {
            resultats = traitement.executeQuery(select);

            try
            {
                jeuResultat = new JeuResultat(resultats);
                return jeuResultat;
            }
            catch (SQLException e)
            {
                throw new SQLException("Erreur creation JeuResultat : "
                    + e.getMessage());
            }
            finally
            {
                resultats.close();
            }
        }
        finally
        {
            traitement.close();
        }
    }

// --------------------------------------------------------------------------
// executeUpdate (INSERT, DELETE, UPDATE)
// --------------------------------------------------------------------------
// Cette methode retourne le nombre de lignes concernees par la requete
// --------------------------------------------------------------------------
    public int executeUpdate(String requete) throws SQLException
    {
        Statement traitement;
        int rowCount = 0;

// --------------------------------------------------------------------------
// Cas de la requete vide.
// --------------------------------------------------------------------------
        if (requete.compareTo("") == 0)
        {
            throw new SQLException("Requete vide");
        }

// --------------------------------------------------------------------------
// Creer le Statement, executer la requete.
// --------------------------------------------------------------------------
        traitement = connexion.createStatement();

        try
        {
            rowCount = traitement.executeUpdate(requete);
        }
        finally
        {
            traitement.close();
        }

        return rowCount;
    }

// --------------------------------------------------------------------------
// getTables
// --------------------------------------------------------------------------
// Cette methode retourne la liste des tables de la base stockee dans un
// vecteur.
// --------------------------------------------------------------------------
    public Vector<String> getTables() throws SQLException
    {
        DatabaseMetaData meta;
        ResultSet rs;
        Vector<String> lTables = null;

// --------------------------------------------------------------------------
// Recuperer les MetaData de la base, remplir un ResultSet contenant les noms
// des tables, transferer dans un modele de liste (qui servira a initialiser
// une JList)
// --------------------------------------------------------------------------
        meta = connexion.getMetaData();

        rs = meta.getTables(null, null, null, new String[]
        {
            "TABLE"
        });
        lTables = new Vector<String>();

        try
        {
            while (rs.next())
            {
                lTables.addElement(rs.getString(3));
            }
        }
        finally
        {
            rs.close();
        }

        return lTables;
    }

}
