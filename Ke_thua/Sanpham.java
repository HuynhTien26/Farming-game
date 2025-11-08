package Ke_thua;

public abstract class Sanpham {
	protected String tenSP;
	protected double giaban;
	protected int soluong;
	
	public Sanpham(String tenSP) {
		this.tenSP=tenSP;
		this.soluong=1;
	}
	 
	public String getTenSP() { return tenSP;}
	public int getSoluong() {return soluong;}
	public double getGiaban() {return giaban;}
	
	public void tangsoluong(int n) {
		this.soluong+=n;
	}
	//lớp con định nghĩa cách hiển thị thông tin
	public abstract void hienthithongtin();
}
