import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<ModelKit> listModel = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int pilih;

        do {
            System.out.println("\n=== MENU TOKO MODEL KIT ===");
            System.out.println("1. Tambah Reguler");
            System.out.println("2. Tambah Grade Kit (by Skala)");
            System.out.println("3. Tambah Premium/Reguler Kit");
            System.out.println("4. Lihat");
            System.out.println("5. Update");
            System.out.println("6. Hapus");
            System.out.println("7. Exit");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
            scan.nextLine();

            if(pilih == 1) tambahReguler();
            else if(pilih == 2) tambahGrade();
            else if(pilih == 3) tambahPremium();
            else if(pilih == 4) lihat();
            else if(pilih == 5) update();
            else if(pilih == 6) hapus();
            else if(pilih == 7) System.out.println("Selesai");
            else System.out.println("Pilihan salah!");

        } while(pilih != 7);
    }

    static void tambahReguler() {
        System.out.println("\n-- Tambah Reguler --");
        System.out.print("Nama  : ");
        String nama = scan.nextLine();
        System.out.print("Merek : ");
        String merek = scan.nextLine();
        System.out.print("Harga : ");
        int harga = scan.nextInt();
        System.out.print("Stok  : ");
        int stok = scan.nextInt();
        scan.nextLine();

        ModelKit m = new ModelKit(nama, merek, harga, stok);
        listModel.add(m);
        System.out.println("Berhasil ditambah");
    }

    static void tambahGrade() {
        System.out.println("\n-- Tambah Grade Kit (by Skala) --");
        System.out.print("Nama  : ");
        String nama = scan.nextLine();
        System.out.print("Merek : ");
        String merek = scan.nextLine();
        System.out.print("Harga : ");
        int harga = scan.nextInt();
        System.out.print("Stok  : ");
        int stok = scan.nextInt();
        scan.nextLine();
        System.out.print("Skala (1/144, 1/100, 1/72, 1/60): ");
        String skala = scan.nextLine();

        GradeKit g = new GradeKit(nama, merek, harga, stok, skala);
        listModel.add(g);
        System.out.println("Berhasil ditambah");
    }

    static void tambahPremium() {
        System.out.println("\n-- Tambah Premium/Reguler Kit --");
        System.out.print("Nama  : ");
        String nama = scan.nextLine();
        System.out.print("Merek : ");
        String merek = scan.nextLine();
        System.out.print("Harga : ");
        int harga = scan.nextInt();
        System.out.print("Stok  : ");
        int stok = scan.nextInt();
        scan.nextLine();
        System.out.print("Tipe (Reguler/Premium): ");
        String tipe = scan.nextLine();
        System.out.print("Edisi Terbatas ke : ");
        int edisi = scan.nextInt();
        scan.nextLine();

        PremiumKit p = new PremiumKit(nama, merek, harga, stok, tipe, edisi);
        listModel.add(p);
        System.out.println("Berhasil ditambah");
    }

    static void lihat() {
        System.out.println("\n-- Lihat Semua Model Kit --");
        if(listModel.isEmpty()) {
            System.out.println("Kosong");
            return;
        }

        System.out.println("Total Model Kit: " + listModel.size() + "\n");
        for(int i = 0; i < listModel.size(); i++) {
            System.out.println("Model Kits ke-" + i);
            listModel.get(i).tampil();
        }
    }

    static void update() {
        System.out.println("\n-- Update Data --");
        System.out.print("Model Kits ke : ");
        int idx = scan.nextInt();
        scan.nextLine();

        if(idx < 0 || idx >= listModel.size()) {
            System.out.println("Input salah!");
            return;
        }

        ModelKit m = listModel.get(idx);

        System.out.println("Data lama:");
        m.tampil();

        System.out.println("Data baru:");
        System.out.print("Nama (" + m.getNama() + "): ");
        String nama = scan.nextLine();
        if(!nama.isEmpty()) m.setNama(nama);

        System.out.print("Merek (" + m.getMerek() + "): ");
        String merek = scan.nextLine();
        if(!merek.isEmpty()) m.setMerek(merek);

        System.out.print("Harga (" + m.getHarga() + "): ");
        String harga = scan.nextLine();
        if(!harga.isEmpty()) m.setHarga(Integer.parseInt(harga));

        System.out.print("Stok (" + m.getStok() + "): ");
        String stok = scan.nextLine();
        if(!stok.isEmpty()) m.setStok(Integer.parseInt(stok));

        if(m instanceof GradeKit) {
            System.out.print("Skala (" + ((GradeKit)m).getSkala() + "): ");
            String skala = scan.nextLine();
            if(!skala.isEmpty()) ((GradeKit)m).setSkala(skala);
        }

        if(m instanceof PremiumKit) {
            System.out.print("Tipe (" + ((PremiumKit)m).getTipe() + "): ");
            String tipe = scan.nextLine();
            if(!tipe.isEmpty()) ((PremiumKit)m).setTipe(tipe);

            System.out.print("Edisi (" + ((PremiumKit)m).getEdisiTerbatas() + "): ");
            String edisi = scan.nextLine();
            if(!edisi.isEmpty()) ((PremiumKit)m).setEdisiTerbatas(Integer.parseInt(edisi));
        }

        System.out.println("Berhasil diupdate");
    }

    static void hapus() {
        System.out.println("\n-- Hapus Data --");
        System.out.print("Model Kits ke : ");
        int idx = scan.nextInt();
        scan.nextLine();

        if(idx < 0 || idx >= listModel.size()) {
            System.out.println("Input salah!");
            return;
        }

        listModel.remove(idx);
        System.out.println("Berhasil dihapus");
    }
}