package Ke_thua;

public class BapNgo extends Sanpham {
	public BapNgo() {
		super ("Bắp Ngô");
		this.giaban=21000;
	}

	@Override
	public void hienthithongtin() {
		System.out.println("Sản phẩm: " + tenSP + "\nGiá bán: " + giaban);
	}
}
