package Ke_thua;

public class Gao extends Sanpham {
	public Gao() {
		super ("Gạo");
		this.giaban=22000;
	}

	@Override
	public void hienthithongtin() {
		System.out.println("Sản phẩm: " + tenSP + "\nGiá bán: " + giaban);
	}
}

