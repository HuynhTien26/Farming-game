package ke_thua;

public class Heo extends DongVat implements Thuhoach {
    public Heo(String ten, int tuoi) {
        super(ten, tuoi, "Cám");
    }

    @Override
    public void keu() {
        System.out.println(ten + " kêu: Ụt ịt");
    }

    @Override
    public void an() {
        System.out.println(ten + " đang ăn " + Loaithucan);
    }

    @Override
    public Sanpham chosanpham() {
        return new Thit();
    }
}
