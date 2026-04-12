public class PremiumKit extends ModelKit {
    private String tipe;
    private String sertifikat;
    private int edisiTerbatas;

    public PremiumKit(String nama, String merek, int harga, int stok, String tipe, int edisiTerbatas) {
        super(nama, merek, harga, stok);
        this.tipe = tipe;
        this.edisiTerbatas = edisiTerbatas;

        if(tipe.equalsIgnoreCase("Premium")) {
            this.kategori = "Premium Kit";
            this.sertifikat = "Tersedia";
        } else {
            this.kategori = "Reguler Kit";
            this.sertifikat = "Tidak Ada";
        }
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
        if(tipe.equalsIgnoreCase("Premium")) {
            this.kategori = "Premium Kit";
            this.sertifikat = "Tersedia";
        } else {
            this.kategori = "Reguler Kit";
            this.sertifikat = "Tidak Ada";
        }
    }

    public String getSertifikat() {
        return sertifikat;
    }

    public int getEdisiTerbatas() {
        return edisiTerbatas;
    }

    public void setEdisiTerbatas(int edisiTerbatas) {
        this.edisiTerbatas = edisiTerbatas;
    }

    @Override
    public void tampil() {
        super.tampil();
        System.out.println("Tipe    : " + tipe);
        System.out.println("Edisi Terbatas : " + edisiTerbatas);
        System.out.println("Sertifikat: " + sertifikat);
        System.out.println("-------------------");
    }
}