import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kho {

    private List<SanPham> danhSachSanPham;

    // Static counter
    private static int demKho = 0;
    private String maKho;

    public Kho() {
        this.maKho = "KHO" + (++demKho);
        this.danhSachSanPham = new ArrayList<>();
    }

    /**
     * Thêm sản phẩm vào kho
     */
    public void themSanPham(SanPham sp) {
        danhSachSanPham.add(sp);
        System.out.println("[OK] Đã thêm " + sp.getTenSP() + " vào kho");
    }

    /**
     * Xóa sản phẩm (bán hoặc sử dụng)
     */
    public boolean xoaSanPham(String tenSP) {
        for (int i = 0; i < danhSachSanPham.size(); i++) {
            if (danhSachSanPham.get(i).getTenSP().equalsIgnoreCase(tenSP)) {
                danhSachSanPham.remove(i);
                System.out.println("[OK] Đã lấy " + tenSP + " ra khỏi kho");
                return true;
            }
        }
        System.out.println("[X] Không tìm thấy " + tenSP + " trong kho");
        return false;
    }

    /**
     * Đếm số lượng sản phẩm theo tên
     */
    public int demSoLuong(String tenSP) {
        int count = 0;
        for (SanPham sp : danhSachSanPham) {
            if (sp.getTenSP().equalsIgnoreCase(tenSP)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Lấy thống kê tồn kho
     */
    public Map<String, Integer> thongKeTonKho() {
        Map<String, Integer> thongKe = new HashMap<>();
        for (SanPham sp : danhSachSanPham) {
            String ten = sp.getTenSP();
            thongKe.put(ten, thongKe.getOrDefault(ten, 0) + 1);
        }
        return thongKe;
    }

    /**
     * Hiển thị tồn kho
     */
    public void hienThiTonKho() {
        System.out.println("\n=== KHO " + maKho + " ===");
        System.out.println("Tổng số sản phẩm: " + danhSachSanPham.size());

        if (danhSachSanPham.isEmpty()) {
            System.out.println("(Kho trống)");
        } else {
            Map<String, Integer> thongKe = thongKeTonKho();
            System.out.println("\nThống kê tồn kho:");
            for (Map.Entry<String, Integer> entry : thongKe.entrySet()) {
                System.out.println(
                    "  - " +
                        entry.getKey() +
                        ": " +
                        entry.getValue() +
                        " sản phẩm"
                );
            }

            // Tính tổng giá trị kho
            double tongGiaTri = 0;
            for (SanPham sp : danhSachSanPham) {
                tongGiaTri += sp.getGiaBan();
            }
            System.out.println("\nTổng giá trị kho: " + tongGiaTri + " VNĐ");
        }
    }

    /**
     * Tìm kiếm sản phẩm theo tên
     */
    public List<SanPham> timKiemSanPham(String tenSP) {
        List<SanPham> ketQua = new ArrayList<>();
        for (SanPham sp : danhSachSanPham) {
            if (sp.getTenSP().toLowerCase().contains(tenSP.toLowerCase())) {
                ketQua.add(sp);
            }
        }
        return ketQua;
    }

    // Getters
    public List<SanPham> getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public String getMaKho() {
        return maKho;
    }
}
