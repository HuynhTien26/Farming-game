package ke_thua;

public class Trung extends Sanpham {
  public Trung() {
    super("Trứng");
    this.giaban = 8000;
  }

  @Override
  public void hienthithongtin() {
    System.out.println("Sản phẩm: " + tenSP + "\nGiá bán: " + giaban);
  }
}
