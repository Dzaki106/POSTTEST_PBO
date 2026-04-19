public abstract class ModelKit {
    private String nama;
    private String merek;
    private int harga;
    private int stok;

    protected String kategori;

    public ModelKit(String nama, String merek, int harga, int stok) {
        this.nama = nama;
        this.merek = merek;
        this.harga = harga;
        this.stok = stok;
        this.kategori = "Reguler";
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

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void tampil() {
        System.out.println("Nama   : " + nama);
        System.out.println("Merek  : " + merek);
        System.out.println("Harga  : Rp " + harga);
        System.out.println("Stok   : " + stok);
        System.out.println("Kategori: " + kategori);
        System.out.println("-------------------");
    }

    public abstract void infoPromo();
    public abstract String getLevel();
    public abstract int hitungBonus();
}