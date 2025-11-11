public abstract class SanPham {
	protected String tenSP;
	protected double giaBan;
	
	public SanPham(String tenSP, double giaBan) {
		this.tenSP = tenSP;
		this.giaBan = giaBan;
	}
	
	public String getTenSP() { return tenSP; }
	public double getGiaBan() { return giaBan; }
}
