package ke_thua;

public class Ga extends DongVat implements Thuhoach {
    public Ga(String ten, int tuoi) {
        super(ten, tuoi, "Thóc");
    }

    @Override
    public void keu() {
        System.out.println(ten + " kêu: Cluck cluck");
    }

    // Triển khai phương thức an()
    @Override
    public void an() {
        System.out.println(ten + " đang mổ " + Loaithucan);
    }

    @Override
    public Sanpham chosanpham() {
        return new Trung();
    }
}
