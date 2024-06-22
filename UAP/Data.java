import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    private static ArrayList<Tanaman> tanamans = new ArrayList<>();
    private static ArrayList<Integer> lokasi = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void mulai() {
        System.out.print("Masukkan lama masa tanam (dalam bulan): ");
        int masaTanamBulan = input.nextInt();
        int masaTanamHari = masaTanamBulan * 30;

        menanam();
        menanam();
        menanam();

        for (int hari = 1; hari <= masaTanamHari; hari++) {
            lokasi.clear();
            for (int i = 0; i < tanamans.size(); i++) {
                Tanaman t = tanamans.get(i);
                if (t.status().equals("Hidup")) {
                    t.berkembang();
                } else {
                    lokasi.add(i);
                    tanamans.set(i, menanam());
                }
            }

            if (hari % 90 == 0) {
                for (int i = 0; i < tanamans.size(); i++) {
                    if (!lokasi.contains(i)) {
                        ((Perawatan) tanamans.get(i)).treatment();
                    }
                }
            }
        }
    }

    private static Tanaman menanam() {
        System.out.println("Pilih tanaman yang akan ditanam:");
        System.out.println("1. Tomat");
        System.out.println("2. Stroberi");
        System.out.println("3. Persik");
        int pilihan = input.nextInt();
        Tanaman t = null;

        switch (pilihan) {
            case 1:
                t = new Tomat();
                break;
            case 2:
                t = new Stroberi();
                break;
            case 3:
                t = new Persik();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }

        tanamans.add(t);
        System.out.println("Berhasil menanam " + t.getClass().getSimpleName());
        return t;
    }

    public static void info() {
        System.out.println("Laporan hasil masa tanam:");
        for (int i = 0; i < tanamans.size(); i++) {
            System.out.println("Tanaman ke-" + (i + 1) + ": " + tanamans.get(i).toString());
        }
    }
}
