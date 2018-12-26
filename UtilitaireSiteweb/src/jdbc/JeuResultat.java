// ==========================================================================
// package utilitairesMG.jdbc
// --------------------------------------------------------------------------
// Classe JeuResultat
// --------------------------------------------------------------------------
// Utilisation pratique d'un ResultSet obtenu par un SELECT SQL
// ==========================================================================
package jdbc;

import divers.Colonne;
import java.sql.*;
import java.util.*;


public class JeuResultat implements java.io.Serializable
{

// ==========================================================================
// PROPRIETES
// ==========================================================================
    private static final long serialVersionUID = 1L;

// --------------------------------------------------------------------------
// Proprietes du jeu de resultats :
//    vecteur des colonnes (nom, taille, nom de la classe)
//    vecteur des lignes
// --------------------------------------------------------------------------
    private Vector<Colonne> colonnes;
    private Vector<Vector<Object>> lignes;

// ==========================================================================
// CONSTRUCTEURS
// ==========================================================================
    public JeuResultat()
    {
    }

    public JeuResultat(ResultSet rs) throws SQLException
    {
        ResultSetMetaData rsmd;
        Colonne colonne;
        Vector<Object> ligne;
        int i;

// --------------------------------------------------------------------------
// Renseignements sur les colonnes
// --------------------------------------------------------------------------
        rsmd = rs.getMetaData();

// --------------------------------------------------------------------------
// Creation du vecteur des colonnes
// --------------------------------------------------------------------------
        colonnes = new Vector<Colonne>();
        for (i = 1; i <= rsmd.getColumnCount(); i++)
        {
            colonne = new Colonne();
            colonne.setNom(rsmd.getColumnName(i));
            colonne.setLongueur(new Integer(rsmd.getColumnDisplaySize(i)));
            colonne.setType(rsmd.getColumnClassName(i));
            colonnes.addElement(colonne);
        }

// --------------------------------------------------------------------------
// Creation du vecteur des lignes de la table.
// Chaque ligne est un vecteur qui contient autant d'objets qu'il y a de
// colonnes.
// --------------------------------------------------------------------------
        lignes = new Vector<Vector<Object>>();

        while (rs.next())
        {
            ligne = new Vector<Object>();
            for (i = 1; i <= rsmd.getColumnCount(); i++)
            {
                ligne.addElement(rs.getObject(i));
            }
            lignes.addElement(ligne);
        }
    }

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// Colonnes selectionnees
// --------------------------------------------------------------------------
    public Vector<Colonne> getColonnes()
    {
        return colonnes;
    }

    public void setColonnes(Vector<Colonne> colonnes)
    {
        this.colonnes = colonnes;
    }

// --------------------------------------------------------------------------
// Lignes selectionnees
// --------------------------------------------------------------------------
    public Vector<Vector<Object>> getLignes()
    {
        return lignes;
    }

    public void setLignes(Vector<Vector<Object>> lignes)
    {
        this.lignes = lignes;
    }
}
