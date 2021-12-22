package utilities;

import java.util.GregorianCalendar;

public class Datum
{
   private int tag, monat, jahr;

   // aktuelles Datum (d.h., heute) erzeugen
   public Datum()
   {
      GregorianCalendar gc = new GregorianCalendar();
      tag = gc.get(GregorianCalendar.DAY_OF_MONTH);
      // In der Klasse GregorianCalendar werden die Monate von 0 bis 11
      // durchnummeriert; daher muessen wir den Wert 1 addieren.
      monat = gc.get(GregorianCalendar.MONTH) + 1;
      jahr = gc.get(GregorianCalendar.YEAR);
   }

   public Datum(int t, int m, int j)
   {
      tag = t;
      monat = m;
      jahr = j;
   }

   public String toString()
   {
      return tag + "." + monat + "." + jahr;
   }

   public boolean equals(Object obj)
   {
      if (obj instanceof Datum)
      {
         Datum d = (Datum)obj;

         return jahr == d.jahr
             && monat == d.monat
             && tag == d.tag;
      }
      else
         return false;
   }

   public boolean frueherAls(Datum d)
   {
      if(jahr < d.jahr)
         return true;
      if(jahr == d.jahr)
      {
         if(monat < d.monat)
            return true;
         if(monat == d.monat)
            return tag < d.tag;
      }
      return false;
   }

   public boolean vor(Datum d)
   {
      return frueherAls(d);
   }

   public boolean nach(Datum d)
   {
      return !vor(d) && !equals(d);
   }


   public static void main(String[] args)
   {
      Datum d = new Datum();
      System.out.println(d);
      Datum e = new Datum(6, 4, 2002);
      System.out.println(e);
      System.out.println(d.vor(e));
      System.out.println(d.nach(e));
   }
}
