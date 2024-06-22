public class Stroberi extends Tanaman implements Perawatan {

    public Stroberi() {
        super(60, 150, 35.0);
    }

    @Override
    public void berkembang() {
        if (status().equals("Hidup")) {
            lamaHidup++;
            prosesBerbuah += perkembangan;
            if (prosesBerbuah >= berbuah) {
                buah++;
                prosesBerbuah = prosesBerbuah - berbuah;
            }
        }
    }

    @Override
    public void treatment() {
        perkembangan += 5.0;
    }

    @Override
    public String toString() {
        return "Stroberi " + super.toString();
    }
}
