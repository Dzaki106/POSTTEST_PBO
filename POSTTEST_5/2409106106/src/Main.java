import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<ModelKit> listModel = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int pilih;

        System.out.println("\n========== SELAMAT DATANG DI TOKO MODEL KIT ==========\n");

        do {
            System.out.println("\n=== MENU TOKO MODEL KIT ===");
            System.out.println("1. Tambah Model Kit Reguler");
            System.out.println("2. Tambah Premium Kit");
            System.out.println("3. Lihat");
            System.out.println("4. Update");
            System.out.println("5. Hapus");
            System.out.println("6. Beri Diskon");
            System.out.println("7. Info Promo");
            System.out.println("8. Exit");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
            scan.nextLine();

            if(pilih == 1) tambahReguler();
            else if(pilih == 2) tambahPremium();
            else if(pilih == 3) lihat();
            else if(pilih == 4) update();
            else if(pilih == 5) hapus();
            else if(pilih == 6) beriDiskon();
            else if(pilih == 7) infoPromoAll();
            else if(pilih == 8) System.out.println("Terima Kasih!");
            else System.out.println("Pilihan salah!");

        } while(pilih != 8);
    }

    static void tambahReguler() {
        System.out.println("\n-- TAMBAH MODEL KIT REGULER --");
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
        System.out.println("\n-- TAMBAH PREMIUM KIT --");
        System.out.print("Nama  : ");
        String nama = scan.nextLine();
        System.out.print("Merek : ");
        String merek = scan.nextLine();
        System.out.print("Harga : ");
        int harga = scan.nextInt();
        System.out.print("Stok  : ");
        int stok = scan.nextInt();
        scan.nextLine();

        PremiumKit p = new PremiumKit(nama, merek, harga, stok);
        listModel.add(p);
        System.out.println("Berhasil ditambah");
    }

    static void lihat() {
        System.out.println("\n-- DAFTAR MODEL KIT --");
        if(listModel.isEmpty()) {
            System.out.println("Kosong");
            return;
        }

        System.out.println("Total: " + listModel.size() + " item\n");
        for(int i = 0; i < listModel.size(); i++) {
            System.out.println("Model ke-" + i);
            System.out.println("Level: " + listModel.get(i).getLevel());
            listModel.get(i).tampil();
        }
    }

    static void update() {
        System.out.println("\n-- UPDATE DATA --");
        System.out.print("Model ke : ");
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

        System.out.println("Berhasil diupdate");
    }

    static void hapus() {
        System.out.println("\n-- HAPUS DATA --");
        System.out.print("Model ke : ");
        int idx = scan.nextInt();
        scan.nextLine();

        if(idx < 0 || idx >= listModel.size()) {
            System.out.println("Input salah!");
            return;
        }

        listModel.remove(idx);
        System.out.println("Berhasil dihapus");
    }

    static void beriDiskon() {
        System.out.println("\n-- BERI DISKON --");
        System.out.print("Model ke : ");
        int idx = scan.nextInt();
        System.out.print("Diskon (%): ");
        int persen = scan.nextInt();
        scan.nextLine();

        if(idx < 0 || idx >= listModel.size()) {
            System.out.println("Input salah!");
            return;
        }

        ModelKit m = listModel.get(idx);
        if(m instanceof Discountable) {
            ((Discountable) m).applyDiscount(persen);
        } else {
            System.out.println("Tidak bisa diberi diskon!");
        }
    }

    static void infoPromoAll() {
        System.out.println("\n-- INFO PROMO --");
        if(listModel.isEmpty()) {
            System.out.println("Kosong");
            return;
        }

        for(int i = 0; i < listModel.size(); i++) {
            System.out.println("\nModel ke-" + i);
            listModel.get(i).infoPromo();
            System.out.println("Bonus Poin: " + listModel.get(i).hitungBonus());

            if(listModel.get(i) instanceof Discountable) {
                System.out.println(((Discountable) listModel.get(i)).getDiscountInfo());
            }
        }
    }
}