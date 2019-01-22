package GestionWeb;

import ClasseDao.*;
import divers.Colonne;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import jdbc.AccesBase;
import jdbc.BaseDeDonnees;
import metierMapping.*;


public class TraitementAccueil
{
    private BaseDeDonnees base;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public TraitementAccueil(BaseDeDonnees base)
    {
        this.base = base;
    }

// --------------------------------------------------------------------------
// Traitement d'affichage de la liste
// --------------------------------------------------------------------------
    public String traitementListeAnnonce(HttpServletRequest request)
    {
        String jspRetour;
        
        Vector<Annonce> listeAnnonce;
        Vector<Colonne> listeColonnes;
        HttpSession session = request.getSession();
        
        AccesBase accesBase;
        AnnonceDAO annonceDAO;

// --------------------------------------------------------------------------

        accesBase = new AccesBase(base);
        try
        {
            accesBase.getConnection();
            annonceDAO = new AnnonceDAO(accesBase);

            try
            {
                listeAnnonce = annonceDAO.lireListe();
                listeColonnes = annonceDAO.getListeColonnes();

                jspRetour = "/Les offres.jsp";
                session.setAttribute("listeAnnonces", listeAnnonce);
                session.setAttribute("listeColonnes", listeColonnes);
            }
            finally
            {
                accesBase.closeConnection();
            }
        }
        catch (SQLException e)
        {
            jspRetour = "/Accueil.jsp";
            session.setAttribute("message", e.getMessage());
            session.setAttribute("numeroContact", "");
            session.setAttribute("choixAction", "liste");
        }
        return jspRetour;
    }

// --------------------------------------------------------------------------
// Traitement d'affichage des annonces sur clique de la region Ile de France
// --------------------------------------------------------------------------
    public String traitementAnnonceIledefrance(HttpServletRequest request)
    {
        String jspRetour;

        Vector<Annonce> listeAnnonce;
        Vector<Colonne> listeColonnes;
        HttpSession session = request.getSession();
        
        AccesBase accesBase;
        AnnonceDAO annonceDAO;
    

         accesBase = new AccesBase(base);
        try
        {
            accesBase.getConnection();
            annonceDAO = new AnnonceDAO(accesBase);

            try
            {
                listeAnnonce = annonceDAO.lireListeRegion("IleDeFrance");
                listeColonnes = annonceDAO.getListeColonnes();

                jspRetour = "/Ile-De-France.jsp";
                session.setAttribute("listeAnnonces", listeAnnonce);
                session.setAttribute("listeColonnes", listeColonnes);
            }
            finally
            {
                accesBase.closeConnection();
            }
        }
        catch (SQLException e)
        {
            jspRetour = "/Accueil.jsp";
            session.setAttribute("message", e.getMessage());
            session.setAttribute("numeroContact", "");
            session.setAttribute("choixAction", "liste");
        }
        return jspRetour;
    }


// --------------------------------------------------------------------------
// Traitement d'affichage du message non realise sur l'ecran d'accueil
// --------------------------------------------------------------------------
    public String traitementNonRealise(HttpServletRequest request)
    {
        String jspRetour;
        HttpSession session = request.getSession();

        String choixAction = request.getParameter("choixAction");
        String chaineNumeroAnnonce = request.getParameter("Annonce_id");

        jspRetour = "/Accueil.jsp";
        session.setAttribute("message", 
                             "Ecran de " + choixAction + " non réalisé");
        session.setAttribute("choixAction", choixAction);
        session.setAttribute("Annonce_id", chaineNumeroAnnonce);

        return jspRetour;
    }
}
