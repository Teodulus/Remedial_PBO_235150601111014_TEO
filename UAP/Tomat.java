public class Tomat extends Tanaman implements Perawatan {

    public Tomat() {
        super(100, 100, 25.0);
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
        return "Tomat " + super.toString();
    }
}
