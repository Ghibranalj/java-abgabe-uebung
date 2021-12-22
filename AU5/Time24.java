
/**
 * Time24
 */
import java.io.PrintStream;

import utilities.*;

public class Time24 {

    private int hour;
    private int minute;

    public Time24(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
        normalizeTime();
    }

    public Time24() {
        this(0, 0);
    }

    public Time24(Time24 other) {
        this(other.hour, other.minute);
    }

    public void redtime() {
        this.hour = TastaturEingabe.readInt("Hour: ");
        TastaturEingabe.readInt("Minute: ");
        normalizeTime();
    }

    public void writeTime() {
        System.out.println(this);
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setHour(int hour) {
        this.hour = hour;
        normalizeTime();

    }

    public void setMinute(int minute) {
        this.minute = minute;
        normalizeTime();

    }

    public void addTime(int minute) {
        this.minute += minute;
        normalizeTime();
    }

    public String toString() {
        return String.format("%02d:%02d", this.hour, this.minute);
    }

    private void normalizeTime() {
        int addH = this.minute / 60;
        this.hour += addH;
        this.hour %= 24;

        this.minute %= 60;
    }

    public static void main(String[] args) {
        PrintStream out = System.out;
        out.println("Beispiel");
        new Time24(14,80).writeTime();
        new Time24(27,15).writeTime();
        new Time24(22,150).writeTime();

        out.println("Timezone");

        Time24 sanfran = new Time24();
        out.println("Geben Sie die Zeit in Sanfrancisco ein");
        sanfran.redtime();

        Time24 frankfurt = new Time24(sanfran.hour+9, sanfran.minute);
        Time24 melbourne = new Time24(sanfran.hour+17, sanfran.minute);

        out.println("SanFrancisco");
        sanfran.writeTime();

        out.println("Frankfurt");
        frankfurt.writeTime();

        out.println("Melbourne");
        melbourne.writeTime();
    }
}