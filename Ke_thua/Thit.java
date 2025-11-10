package ke_thua;

public class Thit extends Sanpham {
   public Thit() {
	   super("Thịt");
	   this.giaban=25000;
   }
   
   @Override
   public void hienthithongtin() {
   System.out.println("Sản phẩm: " + tenSP + "\nGiá bán: " + giaban);
}
}
