package Ke_thua;

public class Bo extends DongVat implements Thuhoach {

    public Bo(String ten, int tuoi) {
        super(ten, tuoi);
    }

    @Override
    public void keu() {
        System.out.println(ten + " kêu: Moooo");
    }

    @Override
    public Sanpham chosanpham() {
        return new Sua();
    }
}
