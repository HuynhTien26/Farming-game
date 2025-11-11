/**
 * Lớp nhiệm vụ thu hoạch, kế thừa từ NhiemVu.
 * Dựa trên phần màu đỏ <extends> NhiemVuThuHoach. 
 */
public class NhiemVuThuHoach extends NhiemVu {

    // Các thuộc tính riêng của nhiệm vụ thu hoạch
    private String tenSanPhamYeuCau; 
    private int soLuongYeuCau; // 

    /**
     * Constructor cho Nhiệm Vụ Thu Hoạch.
     */
    public NhiemVuThuHoach(String moTa, double tienThuong, String tenSanPhamYeuCau, int soLuongYeuCau) {
        super(moTa, tienThuong); // Gọi constructor của lớp cha NhiemVu
        this.tenSanPhamYeuCau = tenSanPhamYeuCau;
        this.soLuongYeuCau = soLuongYeuCau;
    }

    /**
     * Ghi đè phương thức kiểm tra.
     * Logic: Kiểm tra số lượng sản phẩm trong Kho của NguoiChoi.
     */
    @Override
    public void kiemTraHoanThanh(NguoiChoi nguoiChoi) {
        if (this.hoanThanh) {
            return; // Nhiệm vụ đã hoàn thành, không kiểm tra nữa
        }

        // Truy cập vào Kho của người chơi
        Kho kho = nguoiChoi.getKho();
        
        // Lấy số lượng sản phẩm thực tế trong kho (Giả sử có hàm này)
        int soLuongHienCo = kho.getSoLuongSanPham(this.tenSanPhamYeuCau);

        // Nếu số lượng hiện có đạt yêu cầu
        if (soLuongHienCo >= this.soLuongYeuCau) {
            this.setHoanThanh(true);
            System.out.println("=> NHIEM VU HOAN THANH: " + this.getMoTa());
            // (Tùy chọn) Thưởng tiền và trừ sản phẩm trong kho
            // nguoiChoi.nhanThuong(this.tienThuong);
            // kho.giamSanPham(this.tenSanPhamYeuCau, this.soLuongYeuCau);
        }
    }
}