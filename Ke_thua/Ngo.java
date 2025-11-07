package Ke_thua;

public class Ngo extends Thucvat implements Thuhoach{
	
 public Ngo(String ten, int tuoi) {
 super(ten, tuoi);
}

 @Override
 public Sanpham chosanpham() {
	 return new BapNgo();
 }
 }