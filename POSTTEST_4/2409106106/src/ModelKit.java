public class ModelKit {
    private int id;
    private String nama;
    private String merek;
    private int harga;
    private int stok;

    public static int totalModelKit = 0;
    protected String kategori;

    public ModelKit(String nama, String merek, int harga, int stok) {
        this.id = ++totalModelKit;
        this.nama = nama;
        this.merek = merek;
        this.harga = harga;
        this.stok = stok;
        this.kategori = "Reguler";
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        if(harga > 0) {
            this.harga = harga;
        }
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        if(stok >= 0) {
            this.stok = stok;
        }
    }

    public String getKategori() {
        return kategori;
    }

    public void tampil() {
        System.out.println("ID     : " + id);
        System.out.println("Nama   : " + nama);
        System.out.println("Merek  : " + merek);
        System.out.println("Harga  : Rp " + harga);
        System.out.println("Stok   : " + stok);
        System.out.println("Kategori: " + kategori);
        System.out.println("-------------------");
    }
}