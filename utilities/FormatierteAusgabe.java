package utilities;

/**
 * Klasse zur formatierten Ausgabe einfacher Datentypen
 */

public class FormatierteAusgabe
{
   private static int zehn_hoch(int potenz)
   {  int erg=1;
      for (int i=0;i<potenz;i++)
         erg=10*erg;
      return erg;
   }

/**
*  Formatierte Ausgabe ganzer Zahlen.
*  Es wird ausser der auszugebenden Zahl auch die Ausgabebreite
*  angegeben.
*  Die Zahl wird rechtsbündig in der angegebenen Breite ausgegeben.
*  Bei negativen Zahlen kommt das Minuszeichen unmittelbar vor
*  der ersten Ziffer.
*  Ist die Zahl zu groß, wird sie unformatiert ausgegeben,
*  eingeleitet durch "|"
*  @param zahl auszugebende Zahl
*  @param breite Ausgabebreite (Anzahl auszugebender Zeichen)
*  @param fuell Füllzeichen
*/
   public static String format(int zahl,int breite,char fuell)
   {  boolean neg=false;
      String erg="";
      int lbreite=breite;
      if (zahl<0)
      {  neg=true;
         zahl=-zahl;
         lbreite--;
      }
      if (zahl>=zehn_hoch(lbreite))
      {  erg="|"+zahl;
         return erg;
      }
      for (int i=lbreite-1;i>0;i--)
         if (zahl<zehn_hoch(i))
            erg+=fuell; //System.out.print(" ");
         else
            break;
      if (neg)
         erg+="-";
      return erg+zahl;
   }

/**
*  Formatierte Ausgabe ganzer long-Zahlen.
*  Es wird ausser der auszugebenden Zahl auch die Ausgabebreite
*  angegeben.
*  Die Zahl wird rechtsbündig in der angegebenen Breite ausgegeben.
*  Bei negativen Zahlen kommt das Minuszeichen unmittelbar vor
*  der ersten Ziffer.
*  Ist die Zahl zu groß, wird sie unformatiert ausgegeben,
*  eingeleitet durch "|"
*  @param zahl auszugebende Zahl
*  @param breite Ausgabebreite (Anzahl auszugebender Zeichen)
*  @param fuell Füllzeichen
*/
   public static String format(long zahl,int breite,char fuell)
   {  boolean neg=false;
      String erg="";
      int lbreite=breite;
      if (zahl<0)
      {  neg=true;
         zahl=-zahl;
         lbreite--;
      }
      if (zahl>=zehn_hoch(lbreite))
      {  erg="|"+zahl;
         return erg;
      }
      for (int i=lbreite-1;i>0;i--)
         if (zahl<zehn_hoch(i))
            erg+=fuell;
         else
            break;
      if (neg)
         erg+="-";
      return erg+zahl;
   }

/**
*  Formatierte Ausgabe ganzer int-Zahlen.
*  Es wird außer der auszugebenden Zahl auch die Ausgabebreite
*  angegeben.
*  Die Zahl wird rechtsbündig in der angegebenen Breite ausgegeben.
*  Bei negativen Zahlen kommt das Minuszeichen unmittelbar vor
*  der ersten Ziffer.
*  Ist die Zahl zu groß, wird sie unformatiert ausgegeben,
*  eingeleitet durch "|"
*  @param zahl auszugebende Zahl
*  @param breite Ausgabebreite (Anzahl auszugebender Zeichen)
*/
   public static void ausgabeInt(int zahl,int breite)
   {  System.out.print(format(zahl,breite,' ')); }

/**
*  Formatierte Ausgabe eines Strings.
*  Es wird ausser dem auszugebenden String auch die Ausgabebreite
*  angegeben.
*  Der String wird rechtsbündig ausgegeben und links mit einem
*  angebbaren Zeichen aufgefüllt.
*  @param s auszugebender String
*  @param breite Ausgabebreite (Anzahl auszugebender Zeichen)
*  @param fuell Füllzeichen
*/
   public static String format(String s,int breite,char fuell)
   {  int lg=s.length(),i;
      String erg=new String();
      if (s.length()>breite)
         return s.substring(s.length()-breite);
      for (i=0;i<breite-lg;i++)
         erg+=fuell;
      erg+=s;
      return erg;
   }



   final static long EINS = 1L;

   /**
   *  gibt eine long-Zahl als Binärzahl aus.
   *  nach jeweils 4 Bitstellen wird ein Zwischenraum ausgegeben;
   *  die Anzahl der ausgegebenen Bit ist angebbar
   *  @param zahl auszugebende long-Zahl
   *  @param breite Stellenanzahl für Binärzahl
   */
   public static void binaer(long zahl, int breite)
   {
      for (int i = breite-1; i>=0; i--)
      {  if ((zahl & (EINS<<i)) != 0)   //  Bitstelle berechnen
            System.out.print('1');
         else
            System.out.print('0');
         if (i%4 == 0)
            System.out.print(' ');      // Zwischenraum
      }
      System.out.flush();
   }

   public static void binaerAusgabe(long zahl, int breite)
   {
      binaer(zahl, breite);
   }


}
