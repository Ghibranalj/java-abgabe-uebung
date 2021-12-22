import utilities.TastaturEingabe;

/**
 * Aufgabe1
 */
public class Aufgabe1 {

    public static void main(String[] args) {

        int sum = 0;
        int counter = 0;
        // double mean = 0d;
        do {

            int inp = TastaturEingabe.readInt("");
            if (inp <0) {
                break;
            }

            counter++;
            sum += inp;
        } while (true);
        double mean = (double)sum / counter;
        System.out.println("mean = " + mean);
        System.out.println("summe = " + sum);
    }
}