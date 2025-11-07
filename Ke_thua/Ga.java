package Ke_thua;

public class Ga extends DongVat implements Thuhoach {
    public Ga(String ten, int tuoi) {
        super(ten, tuoi);
    }

    @Override
    public void keu() {
        System.out.println(ten + " kêu: Cluck cluck");
    }

    @Override
    public Sanpham chosanpham() {
        return new Trung();
    }
}
