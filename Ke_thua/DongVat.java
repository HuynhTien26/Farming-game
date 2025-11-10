package ke_thua;

public abstract class DongVat extends SinhVat{
  protected String Loaithucan;
  public DongVat(String ten, int tuoi, String Loaithucan) {
	  super(ten, tuoi);
	  this.Loaithucan = Loaithucan;
  }
  
  //mỗi loài có tiếng khác nhau
  public abstract void keu();

  //mỗi loài ăn khác nhau
  public abstract void an();
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

