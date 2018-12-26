// ==========================================================================
// package utilitairesMG.divers
// --------------------------------------------------------------------------
// Classe DateFr
// ==========================================================================
package divers;

import java.util.*;
import java.text.*;

public class DateFr extends GregorianCalendar implements java.io.Serializable
{
    private SimpleDateFormat formatDateFr;

// --------------------------------------------------------------------------
// Constructeurs :
// --------------------------------------------------------------------------
// Ces constructeurs initialisent le format de dates par defaut a dd/MM/yyyy
// La date initiale transmise au second devra donc respecter ce format. A
// defaut, il y aura une exception ParseException.
// --------------------------------------------------------------------------
    public DateFr()
    {
        formatDateFr = new SimpleDateFormat("dd/MM/yyyy");
    }

    public DateFr(String dateInitiale) throws ParseException
    {
        int index;
        Date nouvelleDate;
        ParsePosition pos = new ParsePosition(0);

        formatDateFr = new SimpleDateFormat("dd/MM/yyyy");

// --------------------------------------------------------------------------
// Attention !!!
// --------------------------------------------------------------------------
// La methode parse() de DateFormat a un parametre de type String et peut
// emettre une ParseException.
// --------------------------------------------------------------------------
// La methode parse() de SimpleDateFormat prend deux parametres (String et
// ParsePosition) et peut emettre une NullPointerException si "dateInitiale"
// ou "pos" ne sont pas renseignes (null). Si la date n'est pas correcte,
// elle retourne null.
// --------------------------------------------------------------------------
        nouvelleDate = formatDateFr.parse(dateInitiale, pos);

// --------------------------------------------------------------------------
// Si la conversion se passe bien, pos.getIndex() indique la position du
// caractere qui suit le dernier caractere converti. Cette valeur doit etre
// egale a la longueur de la chaine pour que ce soit bon. Sinon, la chaine
// depasse.
// Exemple : une chaine telle que 01/11/20x12 serait acceptee et interpretee
// comme 01/11/0020 ! La conversion s'est arretee au x.
// --------------------------------------------------------------------------
// Si la conversion se passe mal, pos.getIndex() reste a sa valeur initiale,
// ici 0. pos.getErrorIndex() indique alors la position du caractere en
// erreur.
// --------------------------------------------------------------------------
        if (pos.getIndex() < dateInitiale.length())
        {
            index = pos.getErrorIndex();
            if (index == -1)
            {
                index = pos.getIndex();
            }
            throw new ParseException(
                "Date incorrecte position " + index, index);
        }

        setTime(nouvelleDate);
    }

// --------------------------------------------------------------------------
// Modification de la date contenue dans l'objet courant.
// --------------------------------------------------------------------------
// Cette methode s'ajoute a toutes les methodes set() contenues dans la
// classe Calendar.
// --------------------------------------------------------------------------
    public void set(String nouvelleChaineDate) throws ParseException
    {
        int index;
        Date nouvelleDate;
        ParsePosition pos = new ParsePosition(0);

        nouvelleDate = formatDateFr.parse(nouvelleChaineDate, pos);

        if (pos.getIndex() < nouvelleChaineDate.length())
        {
            index = pos.getErrorIndex();
            if (index == -1)
            {
                index = pos.getIndex();
            }
            throw new ParseException(
                "Date incorrecte position " + index, index);
        }

        setTime(nouvelleDate);
    }

// --------------------------------------------------------------------------
// Methodes liees au format :
// --------------------------------------------------------------------------
// setFormat : changement de format
// toFormat  : recuperation du format courant (pour affichage par exemple)
// --------------------------------------------------------------------------
    public void setFormat(String nouveauFormat)
    {
        formatDateFr.applyPattern(nouveauFormat);
    }

    public String toFormat()
    {
        return formatDateFr.toPattern();
    }

// --------------------------------------------------------------------------
// Methode de calcul.
// --------------------------------------------------------------------------
// Cette methode permet de calculer le nombre de jours entre deux dates.
// Elle s'ajoute aux methodes de GregorianCalendar (Par exemple : add())
// --------------------------------------------------------------------------
    public static long difDates(DateFr date1, DateFr date2)
    {
        long difference;

        difference = date2.getTimeInMillis() - date1.getTimeInMillis();
        difference = difference / (1000 * 3600 * 24);

        return difference;
    }

// --------------------------------------------------------------------------
// Methode toString().
// --------------------------------------------------------------------------
// Cette methode permet d'afficher la date avec le format courant.
// --------------------------------------------------------------------------
    public String toString()
    {
        return formatDateFr.format(getTime());
    }
}
