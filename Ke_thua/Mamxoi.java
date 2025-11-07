package Ke_thua;

public class Mamxoi extends Thucvat implements Thuhoach{
	
	 public Mamxoi (String ten, int tuoi) {
	 super(ten, tuoi);
	}

	 @Override
	 public Sanpham chosanpham() {
		 return new Traimamxoi();
	 }
	 }
