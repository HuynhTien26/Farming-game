package Ke_thua;

public class Heo extends DongVat implements Thuhoach {
    public Heo(String ten, int tuoi) {
        super(ten, tuoi);
    }

    @Override
    public void keu() {
        System.out.println(ten + " kêu: Ụt ịt");
    }

    @Override
    public Sanpham chosanpham() {
        return new Thit();
    }
}