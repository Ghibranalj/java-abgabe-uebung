import utilities.*;

public class Aufgabe2 {
    public static void main(String[] args) {

        // die Anzahl von Punkte die inerhalb des Kreises sind
        int yes = 0;
        int total = TastaturEingabe.readInt("Geben Sie die Nummer der Iteration ein: ");
        

        for (int i = 0; i < total; i++) {
            Point p = new Point();
            if( p.isWithinCircle()){
                yes++;
            }
        }

         double pi = ((double) yes/total) * 4;

         System.out.println("pi ~= " + pi);
    }

}

class Point{
    double x;
    double y;
    public Point(){
        x = Math.random();
        y = Math.random();
    }
    boolean isWithinCircle(){
        return x*x + y*y  <= 1d;
    }
    public String toString(){
        return "{x : " + x + " ,y : " + y + "}";
    }
}