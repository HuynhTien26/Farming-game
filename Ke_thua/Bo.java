package ke_thua;

public class Bo extends DongVat implements Thuhoach {

    public Bo(String ten, int tuoi) {
        super(ten, tuoi, "Cỏ");
    }

    @Override
    public void keu() {
        System.out.println(ten + " kêu: Moooo");
    }

    @Override
    public void an() {
        System.out.println(ten + " đang ăn " + Loaithucan);
    }
    
    @Override
    public Sanpham chosanpham() {
        return new Sua();
    }
}
