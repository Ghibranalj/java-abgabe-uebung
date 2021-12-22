public class Aufgabe2 {
    public static void main(String[] args) {
        DemoKlasse a = new DemoKlasse(1);
        DemoKlasse b = new DemoKlasse(2);

        DemoKlasse c = a.addieren(b);

        System.out.println(c.getWert());
    }
}

class DemoKlasse {
    private int wert;
    DemoKlasse (int wert){
        this.wert = wert;
    }

    public int getWert() {
        return wert;
    }
    public void setWert(int wert) {
        this.wert = wert;
    }

    public DemoKlasse addieren(DemoKlasse other){
        return new DemoKlasse(this.wert + other.getWert());
    }
}
