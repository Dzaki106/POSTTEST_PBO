public class ModelKit {
    String nama;
    String merek;
    int harga;
    int stok;

    ModelKit(String nama, String merek, int harga, int stok) {
        this.nama = nama;
        this.merek = merek;
        this.harga = harga;
        this.stok = stok;
    }

    void tampil() {
        System.out.println("Nama  : " + nama);
        System.out.println("Merek : " + merek);
        System.out.println("Harga : Rp " + harga);
        System.out.println("Stok  : " + stok);
        System.out.println("-------------------");
    }
}