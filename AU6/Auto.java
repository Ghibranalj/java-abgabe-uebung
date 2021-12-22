public class Auto {
    
    int kmStand;
    double verbrauch;
    double tankVolumen;
    double kraftstoffVorrat;

    public Auto(int kmStand, double verbrauch, double tankVolumen, double kraftstoffVorrat) {
        this.kmStand = kmStand;
        this.tankVolumen = tankVolumen;
        this.verbrauch = verbrauch;
        this.kraftstoffVorrat = kraftstoffVorrat;
    }

    public String info(){
        return String.format("Kilometerstand: %d, Tankinhalt : %f ", kmStand, kraftstoffVorrat);
    }

    @Override
    public String toString() {
        return String.format("kmStand: %d, verbruch : %f, tankVolumen ; %f, kraftstoffVorrat : %f", kmStand, verbrauch, tankVolumen, kraftstoffVorrat);
    }

    public void fahren(int faehrt){

        var maxFaehrt = (int) (verbrauch * kraftstoffVorrat);
        
        if (faehrt >= maxFaehrt){
            faehrt = maxFaehrt;
        }
        
        // kraftstoff, das in der fahrt verbraucht wird
        var deltaKraftstoff = faehrt/verbrauch;

        kraftstoffVorrat -= deltaKraftstoff;
        kmStand += faehrt;
        
    }

    public void tanken (double liter){

        var nkraftstoffVorrat = this.kraftstoffVorrat + liter;

        if (nkraftstoffVorrat >= this.tankVolumen){
            this.kraftstoffVorrat = this.tankVolumen;
            return;
        }
    }

    public static void main(String[] args) {
        var gogoMobil = new Auto(0,100/5,50,30);
        gogoMobil.fahren(300);
        System.out.println("nach der Fährt");
        System.out.println(gogoMobil.info());

        gogoMobil.tanken(45);
        System.out.println("\nnach dem Tanken");
        System.out.println(gogoMobil.info());
        

    }


}
