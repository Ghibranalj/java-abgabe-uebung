public class Omnibus extends Auto {

    private int anzahlSitze; 

    public Omnibus(int kmStand, double verbrauch, double tankVolumen, double kraftstoffVorrat, int anzahlSitze) {
        super(kmStand, verbrauch, tankVolumen, kraftstoffVorrat);
        this.anzahlSitze = anzahlSitze;
    }

    @Override
    public String toString() {
        return String.format(super.toString()+", anzahlSitze: %d", this.anzahlSitze);
    }
}
