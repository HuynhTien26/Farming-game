/**
 * Lớp nhiệm vụ nâng cấp, kế thừa từ NhiemVu.
 * Dựa trên phần màu đỏ <extends> NhiemVuNangCap. 
 */
public class NhiemVuNangCap extends NhiemVu {

    // Thuộc tính riêng của nhiệm vụ nâng cấp 
    private int capDoYeuCau; 
    
    // Thuộc tính logic (không có trong sơ đồ) để biết cần
    // kiểm tra công trình nào (ví dụ: "VUON" hoặc "CHUONG")
    private String loaiCongTrinh; 

    /**
     * Constructor cho Nhiệm Vụ Nâng Cấp.
     */
    public NhiemVuNangCap(String moTa, double tienThuong, int capDoYeuCau, String loaiCongTrinh) {
        super(moTa, tienThuong); // Gọi constructor của lớp cha NhiemVu
        this.capDoYeuCau = capDoYeuCau;
        this.loaiCongTrinh = loaiCongTrinh;
    }

    /**
     * Ghi đè phương thức kiểm tra.
     * Logic: Kiểm tra cấp độ của công trình tương ứng (Chuồng hoặc Vườn)
     * từ đối tượng NguoiChoi.
     */
    @Override
    public void kiemTraHoanThanh(NguoiChoi nguoiChoi) {
        if (this.hoanThanh) {
            return; // Nhiệm vụ đã hoàn thành, không kiểm tra nữa
        }

        int capDoHienTai = 0;

        // Sơ đồ chỉ ra "kiểm tra" đến cả Chuồng và Vườn
        if ("VUON".equals(this.loaiCongTrinh) && nguoiChoi.getVuon() != null) {
            capDoHienTai = nguoiChoi.getVuon().getCapDo();
        } else if ("CHUONG".equals(this.loaiCongTrinh) && nguoiChoi.getChuong() != null) {
            capDoHienTai = nguoiChoi.getChuong().getCapDo();
        }

        // Nếu cấp độ hiện tại đạt yêu cầu
        if (capDoHienTai >= this.capDoYeuCau) {
            this.setHoanThanh(true);
            System.out.println("=> NHIEM VU HOAN THANH: " + this.getMoTa());
            // (Tùy chọn) Thưởng tiền cho người chơi
            // nguoiChoi.nhanThuong(this.tienThuong);
        }
    }
}