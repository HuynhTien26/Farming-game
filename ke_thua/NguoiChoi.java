package ke_thua;

import java.util.ArrayList;
import java.util.List;

public class NguoiChoi {

    private String tenNguoiChoi;
    private double tien;
    private Chuong chuong;
    private Vuon vuon;
    private Kho kho;
    
    private List<NhiemVu> danhSachNhiemVu;
    
    // CONSTRUCTOR 1: Khởi tạo mới game (dùng trong GameMenu)
    public NguoiChoi(String tenNguoiChoi, double tienKhoiTao) {
        this.tenNguoiChoi = tenNguoiChoi;
        this.tien = tienKhoiTao;
        this.chuong = new Chuong();
        this.vuon = new Vuon();
        this.kho = new Kho();
 
        this.danhSachNhiemVu = new ArrayList<>();
        khoiTaoNhiemVuBanDau(); // Gọi hàm tạo NV
        
        System.out.println("\n[+] Người chơi " + tenNguoiChoi + " đã bắt đầu!");
    }
    
    // CONSTRUCTOR 2: Tải Game (Dùng trong LuuQuaTrinh)
    public NguoiChoi(String tenNguoiChoi, double tienLoad, Chuong chuong, Vuon vuon, Kho kho) {
        this.tenNguoiChoi = tenNguoiChoi;
        this.tien = tienLoad;
        this.chuong = chuong;
        this.vuon = vuon;
        this.kho = kho;
        
        this.danhSachNhiemVu = new ArrayList<>();
        khoiTaoNhiemVuBanDau();
        
        System.out.println("\n[+] Người chơi " + tenNguoiChoi + " đã tải game thành công!");
    }
    
    // --- Quản lý Tiền ---

    /**
     * Trừ tiền của người chơi
     * @param soTienCanTru Số tiền cần trả
     * @return true nếu trừ thành công, false nếu không đủ tiền
     */
    public boolean truTien(double soTienCanTru) {
        if (this.tien >= soTienCanTru) {
            this.tien -= soTienCanTru;
            System.out.println("[Giao dịch] Trừ: " + soTienCanTru + " | Còn lại: " + this.tien);
            return true;
        } else {
            System.out.println("[X] LỖI GIAO DỊCH: Không đủ tiền! Cần " + soTienCanTru + " nhưng chỉ có " + this.tien);
            return false;
        }
    }

    /**
     * Cộng tiền cho người chơi (nhận tiền từ bán hàng, nhiệm vụ)
     */
    public void nhanTien(double soTienNhan) {
        this.tien += soTienNhan;
        System.out.println("[Giao dịch] Nhận: " + soTienNhan + " | Tổng: " + this.tien);
    }
    
    // --- Hành động Nông Trại ---

    public void thuHoach(Thuhoach sinhVat) {
        Sanpham sanPham = sinhVat.chosanpham();
        kho.themSanPham(sanPham);
        System.out.println("Thu hoạch thành công: " + sanPham.getTenSP());
    }
    
    public void nangCapChuong() {
        double chiPhi = chuong.getChiPhiNangCap();
        if (truTien(chiPhi)) {
            chuong.nangCap();
        }
    }

    public void nangCapVuon() {
        double chiPhi = vuon.getChiPhiNangCap();
        if (truTien(chiPhi)) {
            vuon.nangCap();
        }
    }
    
    //  Các hàm quản lý Nhiệm Vụ ---
    
    /**
     * (Hàm này nên được gọi từ Constructor)
     * Tạo các nhiệm vụ ban đầu cho người chơi.
     */
    private void khoiTaoNhiemVuBanDau() {
        // Lấy từ file NhiemVuNangCap.java và NhiemVuThuHoach.java
        danhSachNhiemVu.add(new NhiemVuNangCap("Nâng cấp Chuồng lên cấp 2", 100.0, 2, "CHUONG"));
        danhSachNhiemVu.add(new NhiemVuThuHoach("Thu hoạch 5 Sữa", 50.0, "Sữa", 5));
        danhSachNhiemVu.add(new NhiemVuNangCap("Nâng cấp Vườn lên cấp 2", 100.0, 2, "VUON"));
    }

    /**
     * (Hàm này GameMenu sẽ gọi)
     * Kiểm tra tất cả các nhiệm vụ chưa hoàn thành.
     */
    public void kiemTraTatCaNhiemVu() {
        // System.out.println("Đang kiểm tra nhiệm vụ..."); // Bỏ comment nếu muốn debug
        for (NhiemVu nv : danhSachNhiemVu) {
            if (!nv.isHoanThanh()) {
                // Tự động gọi hàm kiemTraHoanThanh của lớp con tương ứng
                // và truyền "this" (NguoiChoi) vào
                nv.kiemTraHoanThanh(this); 
            }
        }
    }
    
    public List<NhiemVu> getDanhSachNhiemVu() {
        return danhSachNhiemVu;
    }

    // --- Hiển thị Trạng thái ---

    public void hienThiTrangThai() {
        System.out.println("\n==================================");
        System.out.println("Tên Nông Dân: " + tenNguoiChoi);
        System.out.println("Tiền mặt: " + tien);
        System.out.println("Cấp Chuồng: " + chuong.getCapDo());
        System.out.println("Cấp Vườn: " + vuon.getCapDo());
        System.out.println("==================================");
        kho.hienThiTonKho();
        chuong.hienThiDanhSach();
        vuon.hienThiDanhSach();
        
        System.out.println("\n--- NHIỆM VỤ ---");
        if (danhSachNhiemVu.isEmpty()) {
            System.out.println("(Không có nhiệm vụ)");
        } else {
            for (NhiemVu nv : danhSachNhiemVu) {
                String trangThai = nv.isHoanThanh() ? "[HOÀN THÀNH]" : "[Chưa làm]";
                System.out.println(trangThai + " " + nv.getMoTa());
            }
        }
    }

    // --- Getters ---

    public String getTenNguoiChoi() {
        return tenNguoiChoi;
    }

    public double getTien() {
        return tien;
    }

    public Chuong getChuong() {
        return chuong;
    }

    public Vuon getVuon() {
        return vuon;
    }

    public Kho getKho() {
        return kho;
    }
    
 // --- Setters (Cần thiết cho việc đồng bộ tài nguyên trong GameMenu) ---
    public void setChuong(Chuong chuong) {
        this.chuong = chuong;
    }

    public void setVuon(Vuon vuon) {
        this.vuon = vuon;
    }

    public void setKho(Kho kho) {
        this.kho = kho;
    }
}
