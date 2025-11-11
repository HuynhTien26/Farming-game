package ke_thua;

public class Mamxoi extends Thucvat implements Thuhoach {

	public Mamxoi(String ten, int tuoi) {
		super(ten, tuoi);
	}

	@Override
	public void tuoiNuoc() {
		this.daTuoiNuoc = true;
		System.out.println(ten + " đã được tưới nước. Sẵn sàng phát triển.");
	}

	@Override
	public Sanpham chosanpham() {
		return new Traimamxoi();
	}

}
