import java.util.ArrayList;
import java.util.List;

public class Kho {

    private List<Sanpham> danhSachSanPham;

    // Static counter
    private static int demKho = 0;
    private String maKho;

    public Kho() {
        this.maKho = "KHO" + (++demKho);
        this.danhSachSanPham = new ArrayList<>();
    }

    /**
     * Thêm sản phẩm vào kho (có stack)
     * Nếu sản phẩm đã có trong kho, tăng số lượng
     */
    public void themSanPham(Sanpham sp) {
        // Tìm xem sp đã có trong kho chưa
        Sanpham spTonTai = timSanPham(sp.getTenSP());

        if (spTonTai != null) {
            // Sp đã có, tăng số lượng
            spTonTai.tangsoluong(sp.getSoluong());
            System.out.println(
                "[+] Đã thêm " + sp.getSoluong() + " " + sp.getTenSP() + " vào kho"
            );
            System.out.println("    Tổng số lượng: " + spTonTai.getSoluong());
        } else {
            // Sp mới, thêm vào danh sách
            danhSachSanPham.add(sp);
            System.out.println(
                "[+] Đã thêm sản phẩm mới " + sp.getTenSP() + " vào kho"
            );
        }
    }

    /**
     * Tìm sp theo tên (trả về object đầu tiên tìm thấy)
     */
    private Sanpham timSanPham(String tenSP) {
        for (Sanpham sp : danhSachSanPham) {
            if (sp.getTenSP().equalsIgnoreCase(tenSP)) {
                return sp;
            }
        }
        return null;
    }

    /**
     * Lấy sp ra khỏi kho (giảm số lượng hoặc xóa)
     * @param tenSP   Tên sp
     * @param soLuong Số lượng muốn lấy
     * @return true   nếu thành công
     */
    public boolean laySanPham(String tenSP, int soLuong) {
        Sanpham sp = timSanPham(tenSP);

        if (sp == null) {
            System.out.println("[X] Không tìm thấy " + tenSP + " trong kho");
            return false;
        }

        if (sp.getSoluong() < soLuong) {
            System.out.println("[X] Không đủ " + tenSP + " trong kho");
            System.out.println(
                "   Có sẵn: " + sp.getSoluong() + " | Yêu cầu: " + soLuong
            );
            return false;
        }

        // Giảm số lượng
        sp.tangsoluong(-soLuong);
        System.out.println(
            "[+] Đã lấy " + soLuong + " " + tenSP + " ra khỏi kho"
        );

        // Nếu hết, xóa khỏi danh sách
        if (sp.getSoluong() <= 0) {
            danhSachSanPham.remove(sp);
            System.out.println("    (Đã hết " + tenSP + " trong kho)");
        } else {
            System.out.println("    Còn lại: " + sp.getSoluong());
        }

        return true;
    }

    /**
     * Xóa toàn bộ sp theo tên
     */
    public boolean xoaSanPham(String tenSP) {
        Sanpham sp = timSanPham(tenSP);
        if (sp != null) {
            danhSachSanPham.remove(sp);
            System.out.println("[+] Đã xóa " + tenSP + " khỏi kho");
            return true;
        }
        System.out.println("[X] Không tìm thấy " + tenSP + " trong kho");
        return false;
    }

    /**
     * Đếm số lượng sp theo tên
     */
    public int demSoLuong(String tenSP) {
        Sanpham sp = timSanPham(tenSP);
        return (sp != null) ? sp.getSoluong() : 0;
    }

    /**
     * Kiểm tra có đủ sp ko
     */
    public boolean coDuSanPham(String tenSP, int soLuongCanThiet) {
        return demSoLuong(tenSP) >= soLuongCanThiet;
    }

    /**
     * Hiển thị tồn kho
     */
    public void hienThiTonKho() {
        System.out.println("\n=== KHO " + maKho + " ===");

        if (danhSachSanPham.isEmpty()) {
            System.out.println("(Kho trống)");
        } else {
            System.out.println("Danh sách sản phẩm trong kho:\n");

            int stt = 1;
            double tongGiaTri = 0;

            for (Sanpham sp : danhSachSanPham) {
                System.out.print(stt++ + ". ");
                sp.hienthithongtin();
                tongGiaTri += sp.getGiaban() * sp.getSoluong();
                System.out.println("---");
            }

            System.out.println("\nTổng giá trị kho: " + tongGiaTri + " VNĐ");
        }
    }

    /**
     * Tìm kiếm sp theo tên (có tìm gần đúng)
     */
    public List<Sanpham> timKiemSanPham(String tuKhoa) {
        List<Sanpham> ketQua = new ArrayList<>();
        for (Sanpham sp : danhSachSanPham) {
            if (sp.getTenSP().toLowerCase().contains(tuKhoa.toLowerCase())) {
                ketQua.add(sp);
            }
        }
        return ketQua;
    }

    // Getters
    public List<Sanpham> getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public String getMaKho() {
        return maKho;
    }

    public int getTongSoLoaiSanPham() {
        return danhSachSanPham.size();
    }
}
