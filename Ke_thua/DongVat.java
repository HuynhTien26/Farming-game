package Ke_thua;

public abstract class DongVat extends SinhVat{
  public DongVat(String ten, int tuoi) {
	  super(ten, tuoi);
  }
  
  //mỗi loài có tiếng khác nhau
  public abstract void keu();
  
  @Override
  public void phattrien() {
	  tuoi++;
	  System.out.println(ten + " hiện "+ tuoi + " tuổi");
  }
  
  @Override
  public void hienthitrangthai() {
	  System.out.println("Mã số: " + maso+ "\nTên: " + ten +"\nTuổi: "+ tuoi + "\nTrạng thái: "+ trangthai);
  }
}
