public abstract class SinhVat {
	protected String maSo;
	protected String ten;
	protected int tuoi;
	protected String trangThai;
	
	//static: tự động hóa mã
	private static int dem = 0;
	
	public SinhVat (String ten, int tuoi) {
		this.maSo = "SV" + (++dem);
		this.ten = ten;
		this.tuoi = tuoi;
		this.trangThai = "KHỎE";
	}
	
	public abstract void phatTrien();
	public abstract void hienThiTrangThai();
	
	public String getMaSo() { return maSo;	}
	public String getTen() { return ten; }
}
