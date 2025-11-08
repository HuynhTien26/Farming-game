package Ke_thua;

public class Traimamxoi extends Sanpham {
	public Traimamxoi() {
		super ("Trái mâm xôi");
		this.giaban=25000;
	}

	@Override
	public void hienthithongtin() {
		System.out.println("Sản phẩm: " + tenSP + "\nGiá bán: " + giaban);
	}
}
