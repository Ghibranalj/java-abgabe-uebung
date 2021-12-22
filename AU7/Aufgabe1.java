import java.io.PrintStream;

/**
 * Aufgabe1
 */
public class Aufgabe1 {

    public static void main(String[] args){
        PrintStream out = System.out;

        out.println(reveseInt(1234));
        out.println(reveseInt(17));
        out.println(reveseInt(454));    
    }

    public static long reveseInt(long number) {
        long rev = 0;
        while (number >0){
            long rest = number % 10;
            rev = rev * 10 + rest;
            number = number / 10;
        }
        return rev;
    }
}