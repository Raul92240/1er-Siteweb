
// ==========================================================================
// package utilitairesMG.divers
// --------------------------------------------------------------------------
// Classe Conversion
// ==========================================================================

package divers;

public class Conversion
{

// --------------------------------------------------------------------------
// Conversion d'un entier long en chaine de longueur fixe (ex : 1 --> 001)
// --------------------------------------------------------------------------
   public static String longChaineLongueurFixe(int n, int longueur)
   {
      StringBuffer chaine = new StringBuffer("");

      char chif[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

      int chiffre;
      int nombreCaracteresRemplis = 0;

// --------------------------------------------------------------------------
// Conversion
// --------------------------------------------------------------------------
      do
      {
         chiffre = n % 10;                             // Chiffre des unites
         chaine.insert(0, chif[chiffre]);
         nombreCaracteresRemplis++;
         n = n / 10;
      }
      while (n >= 1);

      for (int i = nombreCaracteresRemplis; i < longueur; i++)
      {
         chaine.insert(0, '0');
      }

      return chaine.toString();
   }

// --------------------------------------------------------------------------
// Conversion d'un entier (long) en chaine
// --------------------------------------------------------------------------
// Parametres : n (Exemple : 1258)
//              separ : separateur des milliers
//                      0 ('\0') si on ne veut pas de separateur
// --------------------------------------------------------------------------
   public static String longChaine(long n, char separ)
   {
      StringBuffer chaine = new StringBuffer("");

      char chif[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

      long chiffre;         // Chiffre converti
      int nSepar;           // Nombre de chiffres convertis depuis le dernier
                            // separateur

      long nsauv;

// --------------------------------------------------------------------------
// Sauvegarde de n et initialisations
// --------------------------------------------------------------------------
      nsauv = n;
      if (n < 0) n *= -1;
      nSepar = 0;

// --------------------------------------------------------------------------
// Conversion
// --------------------------------------------------------------------------
      do
      {
         if((nSepar == 3) && (separ != 0))
         {
            chaine.insert(0, separ);
            nSepar = 0;
         }

         chiffre = n % 10;                             // Chiffre des unites
         chaine.insert(0, chif[(int)chiffre]);
         nSepar++;
         n = n / 10;
      }
      while (n >= 1);

      if (nsauv < 0)
      {
         chaine.insert(0, '-');
      }

      return chaine.toString();
   }

// --------------------------------------------------------------------------
// Conversion d'un double float en chaine (virgule decimale)
// --------------------------------------------------------------------------
   public static String doubleChaine(double r,
                                     int ndec,
                                     int zero,
                                     char separ)
   {
      StringBuffer chaine = new StringBuffer("");

      char chif[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

      long chiffre;          // Chiffre converti
      long pe;               // Partie entiere
      long pd;               // Partie decimale

      double rsauv;
      int i;

// --------------------------------------------------------------------------
// Sauvegarde de r et initialisations
// --------------------------------------------------------------------------
      rsauv = r;
      if (r < 0) r *= -1;

// --------------------------------------------------------------------------
// Arrondi en fonction du nombre de decimales voulu
// --------------------------------------------------------------------------
      r += 5 * Math.pow(0.1, ndec + 1);

// --------------------------------------------------------------------------
// Partie entiere
// --------------------------------------------------------------------------
      pe = (long)r;
      r -= pe;
      if (rsauv < 0)
      {
         chaine.insert(0, "-");
         chaine.insert(1, longChaine(pe, separ));
      }
      else
      {
         chaine.insert(0, longChaine(pe, separ));
      }

// --------------------------------------------------------------------------
// Partie decimale
// --------------------------------------------------------------------------
      if (ndec > 0)
      {
         pd = (long)(r * Math.pow(10, ndec));

         chaine.append(',');

         i = ndec - 1;
         do
         {
            chiffre = pd / (long)Math.pow(10, i);
            chaine.append(chif[(int)chiffre]);
            pd = pd % (long)Math.pow(10, i);
            i--;
         }
         while (i >= 0);

// --------------------------------------------------------------------------
// Eventuellement (zero == 0), enlever les zeros non significatifs
// --------------------------------------------------------------------------
         if (zero == 0)
         {
            i = chaine.length() - 1;
            while (chaine.charAt(i) == '0')
            {
               chaine.deleteCharAt(i);
               i--;
            }
            if (chaine.charAt(i) == ',')
            {
               chaine.deleteCharAt(i);
            }
         }
      }
      return chaine.toString();
   }

// --------------------------------------------------------------------------
// Conversion d'un double float en chaine (notation standard)
// --------------------------------------------------------------------------
   public static String doubleChaineStandard(double r,
                                             int ndec,
                                             int zero)
   {
      StringBuffer chaine = new StringBuffer("");

      char chif[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

      long chiffre;         // Chiffre converti
      long pe;              // Partie entiere
      long pd;              // Partie decimale

      double rsauv;
      int i;

// --------------------------------------------------------------------------
// Sauvegarde de r et initialisations
// --------------------------------------------------------------------------
      rsauv = r;
      if (r < 0) r *= -1;

// --------------------------------------------------------------------------
// Arrondi en fonction du nombre de decimales voulu
// --------------------------------------------------------------------------
      r += 5 * Math.pow(0.1, ndec + 1);

// --------------------------------------------------------------------------
// Partie entiere
// --------------------------------------------------------------------------
      pe = (long)r;
      r -= pe;
      if (rsauv < 0)
      {
         chaine.insert(0, "-");
         chaine.insert(1, longChaine(pe, '\0'));
      }
      else
      {
         chaine.insert(0, longChaine(pe, '\0'));
      }

// --------------------------------------------------------------------------
// Partie decimale
// --------------------------------------------------------------------------
      if (ndec > 0)
      {
         pd = (long)(r * Math.pow(10, ndec));

         chaine.append('.');

         i = ndec - 1;
         do
         {
            chiffre = pd / (long)Math.pow(10, i);
            chaine.append(chif[(int)chiffre]);
            pd = pd % (int)Math.pow(10, i);
            i--;
         }
         while (i >= 0);

// --------------------------------------------------------------------------
// Eventuellement (zero == 0), enlever les zeros non significatifs
// --------------------------------------------------------------------------
         if (zero == 0)
         {
            i = chaine.length() - 1;
            while (chaine.charAt(i) == '0')
            {
               chaine.deleteCharAt(i);
               i--;
            }
            if (chaine.charAt(i) == '.')
            {
               chaine.deleteCharAt(i);
            }
         }
      }
      return chaine.toString();
   }

// ==========================================================================
// Conversion d'une chaine de caracteres en entier long
// --------------------------------------------------------------------------
// Parametre d'entree   : chaine   ==> chaine a convertir
// Valeur retournee     : nombre entier (long)
// Exception            : NumberFormatException si chaine incorrecte
// ==========================================================================

   public static long chaineLong(String chaine)
   {
      long n;

      char chif[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
      int signe;
      int  i, j, k;
      String chaineTravail;

// --------------------------------------------------------------------------
// Initialisation de la chaine de travail
// --------------------------------------------------------------------------
      chaineTravail = chaine;

// --------------------------------------------------------------------------
// Initialisations
// --------------------------------------------------------------------------
      n = 0;

// --------------------------------------------------------------------------
// Cadrage de la chaine et NumberFormatException si elle est vide
// --------------------------------------------------------------------------
      chaineTravail.trim();
      if (chaineTravail.length() == 0)
      {
         throw new NumberFormatException("Chaine vide");
      }
      else

// --------------------------------------------------------------------------
// Extraction du signe eventuel
// --------------------------------------------------------------------------
      {
         signe = 1;
         if (chaineTravail.charAt(0) == '-')
         {
            signe = -1;
   	      chaineTravail = chaineTravail.substring(1);
         }
         else
         {
            if (chaineTravail.charAt(0) == '+')
            {
               chaineTravail = chaineTravail.substring(1);
            }
         }

// --------------------------------------------------------------------------
// Boucle de conversion
// --------------------------------------------------------------------------
         i = 0;

         do
         {

// --------------------------------------------------------------------------
// Les blancs et les points ne comptent pas
// --------------------------------------------------------------------------
            if((chaineTravail.charAt(i) != '.') && 
               (chaineTravail.charAt(i) != ' '))
            {

// --------------------------------------------------------------------------
// Recherche du chiffre dans le tableau chif
// --------------------------------------------------------------------------
               k = -1;
               for (j = 0; j < 10; j++)
               {
                  if (chaineTravail.charAt(i) == chif[j]) k = j;
               }
               if (k == -1)
               {
                  throw new NumberFormatException(
                      "Caractere incorrect dans " + chaine);
               }
               else

// --------------------------------------------------------------------------
// Le chiffre est trouve ==> calcul
// --------------------------------------------------------------------------
               {
                  n = n * 10 + k;
               }
            }
            i++;
         }
         while (i < chaineTravail.length());
      }


// --------------------------------------------------------------------------
// Calcul final
// --------------------------------------------------------------------------
      n *= signe;
      return n;
   }

// ==========================================================================
// Conversion d'une chaine de caracteres en reel
// --------------------------------------------------------------------------
// Parametre d'entree   : chaine   ==> chaine a convertir
// Valeur retournee     : nombre reel (double)
// Exception            : NumberFormatException si chaine incorrecte
// ==========================================================================

   public static double chaineDouble(String chaine)
   {
      double r;

      char chif[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
      int ndec, signe;
      int  i, j, k;
      String chaineTravail;

// --------------------------------------------------------------------------
// Initialisation de la chaine de travail
// --------------------------------------------------------------------------
      chaineTravail = chaine;

// --------------------------------------------------------------------------
// Initialisations
// --------------------------------------------------------------------------
      r = 0;
      ndec = -1;

// --------------------------------------------------------------------------
// Cadrage de la chaine et NumberFormatException si elle est vide
// --------------------------------------------------------------------------
      chaineTravail.trim();
      if (chaineTravail.length() == 0)
      {
         throw new NumberFormatException("Chaine vide");
      }
      else

// --------------------------------------------------------------------------
// Extraction du signe eventuel
// --------------------------------------------------------------------------
      {
         signe = 1;
         if (chaineTravail.charAt(0) == '-')
         {
            signe = -1;
   	      chaineTravail = chaineTravail.substring(1);
         }
         else
         {
            if (chaineTravail.charAt(0) == '+')
            {
               chaineTravail = chaineTravail.substring(1);
            }
         }

// --------------------------------------------------------------------------
// Boucle de conversion
// --------------------------------------------------------------------------
         i = 0;

         do
         {

// --------------------------------------------------------------------------
// Les blancs et les points ne comptent pas
// --------------------------------------------------------------------------
            if((chaineTravail.charAt(i) != '.') && 
               (chaineTravail.charAt(i) != ' '))
            {

// --------------------------------------------------------------------------
// Virgule decimale
// --------------------------------------------------------------------------
               if (chaineTravail.charAt(i) == ',')
               {
                  if (ndec == -1)
                  {
                     ndec = 0;
                  }
                  else
                  {
                     throw new NumberFormatException(
                         "Plus d'une virgule dans " + chaine);
                  }
               }
               else

// --------------------------------------------------------------------------
// Recherche du chiffre dans le tableau chif
// --------------------------------------------------------------------------
               {
                  k = -1;
                  for (j = 0; j < 10; j++)
                  {
                     if (chaineTravail.charAt(i) == chif[j]) k = j;
                  }
                  if (k == -1)
                  {
                     throw new NumberFormatException(
                         "Caractere incorrect dans " + chaine);
                  }
                  else

// --------------------------------------------------------------------------
// Le chiffre est trouve ==> calcul
// --------------------------------------------------------------------------
                  {
                     r = r * 10 + k;
                     if (ndec >= 0) ndec++;
                  }
               }
            }
            i++;
         }
         while (i < chaineTravail.length());
      }


// --------------------------------------------------------------------------
// Calcul final
// --------------------------------------------------------------------------
      if (ndec > 0) r = r / Math.pow(10, ndec);
      r *= signe;
      return r;
   }

// --------------------------------------------------------------------------
// Transformation d'une chaine pour son utilisation en constante SQL.
// --------------------------------------------------------------------------
// Entourer la chaine de quotes (').
// Doubler les quotes qui servent d'apostrophe.
// --------------------------------------------------------------------------
   public static String chaineSQL(String chaine)
   {
      String chaineTravail;
      char c;
      int i;

      if (chaine == null)
      {
         chaineTravail = null;
      }
      else
      {
         chaineTravail = "";
         for(i = 0; i < chaine.length(); i++)
         {
            c = chaine.charAt(i);
            if ((c == '\'') || (c == '\\'))
            {
               chaineTravail+= c;
               chaineTravail+= c;
            }
            else
            {
               chaineTravail+= c;
            }
         }

         if (chaineTravail.length() == 0)
         {
            chaineTravail = null;
         }
         else
         {
            chaineTravail = '\'' + chaineTravail + '\'';
         }
      }

      return chaineTravail;
   }

// --------------------------------------------------------------------------
// Transformation d'une date Date pour son utilisation en constante SQL.
// --------------------------------------------------------------------------
// Entourer la chaine de quotes (').
// --------------------------------------------------------------------------
   public static String dateSQL(java.util.Date date, String formatDate)
   {
      String chaineTravail;
      char c;
      int i;

      if (date == null)
      {
         chaineTravail = null;
      }
      else
      {
         DateFr dateFr = new DateFr();
         dateFr.setTime(date);
         dateFr.setFormat(formatDate);

         chaineTravail = "'" + dateFr + "'";
      }

      return chaineTravail;
   }
   
// --------------------------------------------------------------------------   
// Creation d'une chaine binaire correspondant a un caractere (recu sous
// forme d'entier).    
// --------------------------------------------------------------------------   
// Exemple :          c == '<'  ==>  retour == "0011 1100"                                           
// --------------------------------------------------------------------------   
// Attention : l'entier doit etre non signe.
// --------------------------------------------------------------------------   
    public static String intBinaire(int c)
    {
        String retour = "";
        int binaire[] = new int[8];
        int i;

        for (i = 7; i >= 0; i--)
        {
            binaire[i] = c % 2;
            c = c / 2;
        }

        for (i = 0; i <= 3; i++)
        {
            retour += binaire[i];
        }

        retour += " ";

        for (i = 4; i <= 7; i++)
        {
            retour += binaire[i];
        }

        return retour;
    }
}