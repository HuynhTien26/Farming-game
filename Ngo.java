package Ke_thua;

public class Ngo extends Thucvat implements Thuhoach{
	
 public Ngo(String ten, int tuoi) {
 super(ten, tuoi);
}

 @Override
 public Sanpham chosanpham() {
	 return new BapNgo();
 }
 
 @Override
 public void tuoiNuoc() {
     this.daTuoiNuoc = true;
     System.out.println(ten + " đã được tưới nước. Sẵn sàng phát triển.");
 }
}