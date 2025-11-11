/**
 * Lớp trừu tượng (abstract class) cơ sở cho các loại nhiệm vụ.
 * Dựa trên phần màu đỏ <abstracted> NhiemVu trong sơ đồ. 
 */
public abstract class NhiemVu {
    
    // Các thuộc tính được bảo vệ (protected) như trong sơ đồ
    protected String moTa; 
    protected boolean hoanThanh; 
    protected double tienThuong; 

    /**
     * Constructor để khởi tạo một nhiệm vụ mới.
     * Mặc định khi mới tạo, nhiệm vụ chưa hoàn thành.
     */
    public NhiemVu(String moTa, double tienThuong) {
        this.moTa = moTa;
        this.tienThuong = tienThuong;
        this.hoanThanh = false; 
    }

    /**
     * Phương thức trừu tượng để kiểm tra xem nhiệm vụ đã hoàn thành chưa.
     * Các lớp con sẽ phải định nghĩa logic cụ thể cho việc này. 
     * Cần truyền vào đối tượng NguoiChoi để kiểm tra kho, cấp độ chuồng, v.v.
     */
    public abstract void kiemTraHoanThanh(NguoiChoi nguoiChoi);

    // --- Getters và Setters ---

    public String getMoTa() {
        return moTa;
    }

    public boolean isHoanThanh() {
        return hoanThanh;
    }

    public double getTienThuong() {
        return tienThuong;
    }
    
    // Phương thức này được gọi khi logic kiểm tra xác nhận hoàn thành
    public void setHoanThanh(boolean hoanThanh) {
        this.hoanThanh = hoanThanh;
    }
}
