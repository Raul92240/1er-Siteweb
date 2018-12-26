// ==========================================================================
// package divers
// --------------------------------------------------------------------------
// CLASSE Colonne : description des colonnes d'une table.
//                  Pour un affichage graphique, dans une JTable par exemple.
//                  Pour une lecture dans une BDD, en jdbc par exemple.
// ==========================================================================
package divers;

public class Colonne implements java.io.Serializable
{

// ==========================================================================
// PROPRIETES
// ==========================================================================
// Nom, longueur et type de la colonne
// --------------------------------------------------------------------------
    private String nom;
    private Integer longueur;
    private String type;

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEURS
// --------------------------------------------------------------------------
    public Colonne()
    {
    }

    public Colonne(String nom, Integer longueur, String type)
    {
        this.nom = nom;
        this.longueur = longueur;
        this.type = type;
    }

// --------------------------------------------------------------------------
// SETERS
// --------------------------------------------------------------------------
    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public void setLongueur(Integer longueur)
    {
        this.longueur = longueur;
    }

    public void setLongueur(int longueur)
    {
        this.longueur = new Integer(longueur);
    }

    public void setType(String type)
    {
        this.type = type;
    }

// --------------------------------------------------------------------------
// GETERS
// --------------------------------------------------------------------------
    public String getNom()
    {
        return nom;
    }

    public Integer getLongueur()
    {
        return longueur;
    }

    public String getType()
    {
        return type;
    }

// --------------------------------------------------------------------------
// AFFICHAGE DE LA COLONNE (POUR MISE AU POINT)
// --------------------------------------------------------------------------
    public String toString()
    {
        String retour;

        retour = "Nom                 : " + nom + "\n";
        retour += "Longueur            : " + longueur + "\n";
        retour += "Type                : " + type + "\n\n";

        return retour;
    }
}
