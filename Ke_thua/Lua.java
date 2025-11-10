package ke_thua;

public class Lua extends Thucvat implements Thuhoach{
	 public Lua(String ten, int tuoi) {
		 super(ten, tuoi);
		}
	 
	 @Override
     public void tuoiNuoc() {
         this.daTuoiNuoc = true;
         System.out.println(ten + " đã được tưới nước. Sẵn sàng cho mùa vụ.");
     }
	 
	 @Override
	 public Sanpham chosanpham() {
		 return new Gao();
	 }
	 }
