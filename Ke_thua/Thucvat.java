package Ke_thua;

public abstract class Thucvat extends SinhVat {
	public Thucvat(String ten, int tuoi) {
		super(ten, tuoi);
	}
	
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
