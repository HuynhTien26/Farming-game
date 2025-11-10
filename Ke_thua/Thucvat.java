package ke_thua;

public abstract class Thucvat extends SinhVat {
	protected int giaiDoanPhatTrien;
	protected boolean daTuoiNuoc;
	
	public Thucvat(String ten, int tuoi) {
		super(ten, tuoi);
		this.giaiDoanPhatTrien = 1; // Khởi tạo giai đoạn 1
        this.daTuoiNuoc = false;    // Ban đầu chưa tưới nước
	}
	
	public abstract void tuoiNuoc();
	@Override
	  public void phattrien() {
		  tuoi++;
		  System.out.println(ten + "hiện "+ tuoi + "tuổi");
	  }
	
	  @Override
	  public void hienthitrangthai() {
		  System.out.println("Mã số: " + maso+ "\nTên: " + ten +"\nTuổi: "+ tuoi + "\nTrạng thái: "+ trangthai);
	  }
}
