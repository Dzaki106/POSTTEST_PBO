public class PremiumKit extends ModelKit implements Discountable {
    private boolean onSale;
    private int diskonSekarang;

    public PremiumKit(String nama, String merek, int harga, int stok) {
        super(nama, merek, harga, stok);
        this.onSale = false;
        this.diskonSekarang = 0;
        this.kategori = "Premium";
    }

    @Override
    public void tampil() {
        super.tampil();
        if(onSale) {
            System.out.println("SALE!!! Diskon " + diskonSekarang + "%");
        }
        System.out.println("-------------------");
    }

    @Override
    public void infoPromo() {
        System.out.println(getNama() + " adalah produk premium dengan kualitas terbaik!");
        System.out.println("Garansi 1 tahun untuk semua produk premium!");
    }

    @Override
    public String getLevel() {
        return "Premium Edition";
    }

    @Override
    public int hitungBonus() {
        return getHarga() / 100000;
    }

    @Override
    public void applyDiscount(int persen) {
        if(persen > 0 && persen <= 30) {
            int hargaBaru = getHarga() - (getHarga() * persen / 100);
            setHarga(hargaBaru);
            this.onSale = true;
            this.diskonSekarang = persen;
            System.out.println(getNama() + " mendapat diskon " + persen + "%");
            System.out.println("Harga baru: Rp " + getHarga());
        } else {
            System.out.println("Premium kit maksimal diskon 30%!");
        }
    }

    @Override
    public String getDiscountInfo() {
        if(onSale) {
            return getNama() + " sedang SALE " + diskonSekarang + "%!";
        } else {
            return getNama() + " belum ada diskon";
        }
    }

    @Override
    public boolean isOnSale() {
        return onSale;
    }
}