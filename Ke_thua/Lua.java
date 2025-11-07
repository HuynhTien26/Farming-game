package Ke_thua;

public class Lua extends Thucvat implements Thuhoach{
	 public Lua(String ten, int tuoi) {
		 super(ten, tuoi);
		}
	 
	 @Override
	 public Sanpham chosanpham() {
		 return new Gao();
	 }
	 }