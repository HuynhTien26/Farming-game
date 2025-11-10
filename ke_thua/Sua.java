package ke_thua;

public class Sua extends Sanpham {

    public Sua() {
        super("Sữa");
        this.giaban = 15000;
    }

    @Override
    public void hienthithongtin() {
        System.out.println("Sản phẩm: " + tenSP + "\nGiá bán: " + giaban);
    }
}
