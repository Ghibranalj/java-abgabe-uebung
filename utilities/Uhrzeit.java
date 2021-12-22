package utilities;

class Uhrzeit implements Comparable
{
   private int std;      // 0 bis 23
   private int min, sek; // 0 bis 59
   private int zone;     // Zeitzone in Werten von -11 bis +12

   private static int stdNormal;
   private static int minNormal;

   static void setzeNormalzeit (int std, int min)
   {
      stdNormal = std;
      minNormal = min;
   }

   Uhrzeit ()
   {
      std = stdNormal;
      min = minNormal;
      // weitere Angaben nicht nötig (Standardvorbelegung)
   }

   Uhrzeit (int std, int min)
   {
      setzeStdMin (std, min);
   }

   Uhrzeit (int std, int min, int sek)
   {
      setzeUhrzeit (std, min, sek);
   }

   Uhrzeit (int std, int min, int sek, int zone)
   {
      setzeUhrzeit (std, min, sek, zone);
   }

   private void setzeStdMin (int std, int min)
   {
      if (min<0)
         throw new IllegalArgumentException
                   ("Minuten müssen >= 0 sein.");
      else
         while (min>=60)
            min = min - 60;
      this.min = min;
      if (std<0)
         throw new IllegalArgumentException
                   ("Stunden müssen >= 0 sein.");
      else
         while (std>=24)
            std = std - 24;
      this.std = std;
   }

   void setzeUhrzeit (int std, int min)
   {
      setzeStdMin (std, min);
      this.sek = 0;
   }

   void setzeUhrzeit (int std, int min, int sek)
   {
      setzeStdMin (std, min);
      if (sek<0 | sek>59)
         throw new IllegalArgumentException
            ("Sekunden müssen zwischen 0 und 59 liegen.");
      this.sek = sek;
      zone = 1;
   }

   void setzeUhrzeit (int std, int min, int sek, int zone)
   {
      setzeStdMin (std, min);
      if (sek<0 | sek>59)
         throw new IllegalArgumentException
            ("Sekunden müssen zwischen 0 und 59 liegen.");
      this.sek = sek;
      if (zone<-11 | zone>12)
         throw new IllegalArgumentException
            ("Zeitzone muss zwischen -11 und +12 liegen.");
      this.zone = zone;
   }

   String differenz(Uhrzeit bis)
   {
      int dStd = bis.std + bis.zone - std - zone;
      int dMin = bis.min - min;
      if (dMin < 0)
      {
         dMin = dMin + 60;
         dStd--;
      }
      int dSek = bis.sek - sek;
      if (dSek < 0)
      {
         dSek = dSek + 60;
         dMin--;
      }
      return dStd + " Std " + dMin + " Min " + dSek + " Sek";
   }

   public String toString ()
   {
      String zeit = ((std<10)?"0"+std:""+std) + ":";
      zeit = zeit + ((min<10)?"0"+min:""+min) + ":";
      zeit = zeit + ((sek<10)?"0"+sek:""+sek) + " GMT";
      zeit = zeit + ((zone<0)?"-":"+") + Math.abs(zone);
      return zeit;
   }

   public boolean equals(Object einObject)
   {
      Uhrzeit eineZeit = (Uhrzeit)einObject;
      return this.std - this.zone == eineZeit.std - eineZeit.zone
           & this.min == eineZeit.min;
   }

   public int compareTo(Object einObject)
   {
      Uhrzeit z = (Uhrzeit)einObject;
      return
         (((this.std-this.zone)*60)+this.min)*60+this.sek
        -((((z.std-z.zone)*60)+z.min)*60+z.sek);
   }

   int gibStunde ()
   {
      return std;
   }

   int gibMinute()
   {
      return min;
   }

}
