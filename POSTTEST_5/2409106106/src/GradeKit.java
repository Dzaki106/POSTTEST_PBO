public class GradeKit extends ModelKit implements Discountable {
    private String skala;
    private double bonusPoint;
    private boolean onSale;
    private int diskonSekarang;

    public GradeKit(String nama, String merek, int harga, int stok, String skala) {
        super(nama, merek, harga, stok);
        this.skala = skala;
        this.kategori = "Reguler";
        this.onSale = false;
        this.diskonSekarang = 0;

        if(skala.equals("1/60")) {
            this.bonusPoint = harga * 0.15;
        } else if(skala.equals("1/72")) {
            this.bonusPoint = harga * 0.10;
        } else if(skala.equals("1/100")) {
            this.bonusPoint = harga * 0.08;
        } else {
            this.bonusPoint = harga * 0.05;
        }
    }

    public String getSkala() {
        return skala;
    }

    public void setSkala(String skala) {
        this.skala = skala;
        if(skala.equals("1/60")) {
            this.bonusPoint = getHarga() * 0.15;
        } else if(skala.equals("1/72")) {
            this.bonusPoint = getHarga() * 0.10;
        } else if(skala.equals("1/100")) {
            this.bonusPoint = getHarga() * 0.08;
        } else {
            this.bonusPoint = getHarga() * 0.05;
        }
    }

    public double getBonusPoint() {
        return bonusPoint;
    }

    @Override
    public void tampil() {
        super.tampil();
        System.out.println("Skala   : " + skala);
        System.out.println("Bonus Point : " + bonusPoint);
        if(onSale) {
            System.out.println("SALE!!! Diskon " + diskonSekarang + "%");
        }
        System.out.println("-------------------");
    }

    @Override
    public void infoPromo() {
        System.out.println(getNama() + " dapat bonus point " + bonusPoint + " untuk setiap pembelian!");
        if(skala.equals("1/60")) {
            System.out.println("Bonus: FREE shipping untuk skala 1/60!");
        }
    }

    @Override
    public String getLevel() {
        if(skala.equals("1/60")) {
            return "Master Grade";
        } else if(skala.equals("1/72")) {
            return "High Grade";
        } else {
            return "Entry Grade";
        }
    }

    @Override
    public int hitungBonus() {
        return (int)(bonusPoint / 1000);
    }

    @Override
    public void applyDiscount(int persen) {
        if(persen > 0 && persen <= 50) {
            int hargaBaru = getHarga() - (getHarga() * persen / 100);
            setHarga(hargaBaru);
            this.onSale = true;
            this.diskonSekarang = persen;
            System.out.println(getNama() + " mendapat diskon " + persen + "%");
            System.out.println("Harga baru: Rp " + getHarga());
        } else {
            System.out.println("Diskon tidak valid! Maksimal 50%");
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