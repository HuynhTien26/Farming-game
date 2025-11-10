package ke_thua;

public abstract class SinhVat {
 protected String maso, ten, trangthai;
 protected int tuoi;

 //đếm số sinh vật đã tạo
 private static int dem=0;
 
 //constructor: gọi khi tạo sinh vật mới
 public SinhVat(String ten, int tuoi) {
	    this.maso = "SV" + (++dem);
	    this.ten = ten;
	    this.tuoi = tuoi;
	    this.trangthai = "khoe";
	}
 //phương thức trừu tượng
  public abstract void phattrien();
  public abstract void hienthitrangthai();
  
  //phương thức getter
  public String getMaso() {return maso;}
  public String getTen() {return ten;}
  public int getTuoi() {return tuoi;}
  public String getTrangthai() {return trangthai;}
}
