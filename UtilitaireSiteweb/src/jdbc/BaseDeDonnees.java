// ==========================================================================
// package utilitairesMG.jdbc
// --------------------------------------------------------------------------
// Classe BaseDeDonnees
// --------------------------------------------------------------------------
// Un objet BaseDeDonnees contient un nom de base de donnees (nomBase).
// Il possede une Connection et une seule (connexion).
// ==========================================================================
package jdbc;

public class BaseDeDonnees
{

// ==========================================================================
// PROPRIETES
// --------------------------------------------------------------------------
// nomBase : nom de la base (adresse de connexion).
// Exemple : "jdbc:mysql://localhost/gnmi?user=util_bip&password=x"
//    
// url : URL du serveur BDD. Exemple : "jdbc:mysql://localhost/gnmi"
// user : nom d'utilisateur de la BDD. Exemple : "util_bip"
// password : mot de passe utilisateur; Exemple : "x" 
//
// formatDate : format utilisé pour insérer des dates dans la BDD.  
// ==========================================================================
    private String nomBase;
    private String url;
    private String user;
    private String password;

    private String formatDate = "yyyy/MM/dd";

// ==========================================================================
// Constructeurs
// ==========================================================================
    public BaseDeDonnees(String nomBase)
    {
        this.nomBase = nomBase;
    }

    public BaseDeDonnees(String url, String user, String password)
    {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public BaseDeDonnees()
    {
    }

    public String getNomBase()
    {
        return nomBase;
    }

    public String getUrl()
    {
        return url;
    }

    public String getUser()
    {
        return user;
    }

    public String getPassword()
    {
        return password;
    }

    public void setFormatDate(String formatDate)
    {
        this.formatDate = formatDate;
    }

    public String getFormatDate()
    {
        return formatDate;
    }
}
