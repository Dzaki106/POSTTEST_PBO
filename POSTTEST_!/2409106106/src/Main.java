import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<ModelKit> listModel = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int pilih;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Tambah");
            System.out.println("2. Lihat");
            System.out.println("3. Update");
            System.out.println("4. Hapus");
            System.out.println("5. Exit");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
            scan.nextLine();

            if(pilih == 1) tambah();
            else if(pilih == 2) lihat();
            else if(pilih == 3) update();
            else if(pilih == 4) hapus();
            else if(pilih == 5) System.out.println("Selesai");
            else System.out.println("Salah");

        } while(pilih != 5);
    }

    static void tambah() {
        System.out.println("\n-- Tambah --");
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

    static void lihat() {
        System.out.println("\n-- Lihat --");
        if(listModel.isEmpty()) {
            System.out.println("Kosong");
            return;
        }

        for(int i = 0; i < listModel.size(); i++) {
            System.out.println("Model Kits ke-" + i);
            listModel.get(i).tampil();
        }
    }

    static void update() {
        System.out.println("\n-- Update --");
        System.out.print("Model Kits ke : ");
        int idx = scan.nextInt();
        scan.nextLine();

        if(idx < 0 || idx >= listModel.size()) {
            System.out.println("input salah");
            return;
        }

        System.out.println("Data lama:");
        listModel.get(idx).tampil();

        System.out.println("Data baru:");
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
        listModel.set(idx, m);
        System.out.println("Berhasil diupdate");
    }

    static void hapus() {
        System.out.println("\n-- Hapus --");
        System.out.print("Model Kits ke : ");
        int idx = scan.nextInt();
        scan.nextLine();

        if(idx < 0 || idx >= listModel.size()) {
            System.out.println("input salah");
            return;
        }

        listModel.remove(idx);
        System.out.println("Berhasil dihapus");
    }
}