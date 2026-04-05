public class GradeKit extends ModelKit {
    private String skala;
    private double bonusPoint;

    public GradeKit(String nama, String merek, int harga, int stok, String skala) {
        super(nama, merek, harga, stok);
        this.skala = skala;
        this.kategori = "Grade Kit";

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
        System.out.println("-------------------");
    }
}