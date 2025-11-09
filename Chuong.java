import java.util.ArrayList;
import java.util.List;

public class Chuong implements NangCap {

    private List<DongVat> danhSachDongVat;
    private String trangThai;
    private int capDo;
    private int sucChuaToiDa;
    private double chiPhiNangCap;

    // Static counter for generating IDs
    private static int demChuong = 0;
    private String maChuong;

    public Chuong() {
        this.maChuong = "CH" + (++demChuong);
        this.danhSachDongVat = new ArrayList<>();
        this.trangThai = "Bình thường";
        this.capDo = 1;
        this.sucChuaToiDa = 5; // Cấp 1 chứa tối đa 5 con
        this.chiPhiNangCap = 500.0;
    }

    // CRUD Operations

    /**
     * Thêm động vật vào chuồng
     */
    public boolean themDongVat(DongVat dongVat) {
        if (danhSachDongVat.size() >= sucChuaToiDa) {
            System.out.println(
                "[X] Chuồng đã đầy! Sức chứa tối đa: " + sucChuaToiDa
            );
            return false;
        }
        danhSachDongVat.add(dongVat);
        System.out.println(
            "[OK] Đã thêm " + dongVat.getTen() + " vào chuồng " + maChuong
        );
        return true;
    }

    /**
     * Xóa động vật theo mã số
     */
    public boolean xoaDongVat(String maSo) {
        for (int i = 0; i < danhSachDongVat.size(); i++) {
            if (danhSachDongVat.get(i).getMaso().equals(maSo)) {
                DongVat dv = danhSachDongVat.remove(i);
                System.out.println(
                    "[OK] Đã xóa " + dv.getTen() + " khỏi chuồng"
                );
                return true;
            }
        }
        System.out.println("[X] Không tìm thấy động vật có mã: " + maSo);
        return false;
    }

    /**
     * Tìm kiếm động vật theo mã số
     */
    public DongVat timKiemDongVat(String maSo) {
        for (DongVat dv : danhSachDongVat) {
            if (dv.getMaso().equals(maSo)) {
                return dv;
            }
        }
        return null;
    }

    /**
     * Tìm kiếm động vật theo tên
     */
    public List<DongVat> timKiemTheoTen(String ten) {
        List<DongVat> ketQua = new ArrayList<>();
        for (DongVat dv : danhSachDongVat) {
            if (dv.getTen().toLowerCase().contains(ten.toLowerCase())) {
                ketQua.add(dv);
            }
        }
        return ketQua;
    }

    /**
     * Cho tất cả động vật ăn
     */
    public void choTatCaAn() {
        if (danhSachDongVat.isEmpty()) {
            System.out.println(
                "Chuồng trống, không có động vật nào để cho ăn."
            );
            return;
        }

        System.out.println("\n--- Đang cho động vật ăn ---");
        for (DongVat dv : danhSachDongVat) {
            dv.an();
        }
        System.out.println("[OK] Đã cho tất cả động vật ăn xong!");
    }

    /**
     * Hiển thị danh sách động vật
     */
    public void hienThiDanhSach() {
        System.out.println("\n=== CHUỒNG " + maChuong + " ===");
        System.out.println(
            "Cấp độ: " +
                capDo +
                " | Sức chứa: " +
                danhSachDongVat.size() +
                "/" +
                sucChuaToiDa
        );
        System.out.println("Trạng thái: " + trangThai);

        if (danhSachDongVat.isEmpty()) {
            System.out.println("(Chuồng trống)");
        } else {
            System.out.println("\nDanh sách động vật:");
            for (int i = 0; i < danhSachDongVat.size(); i++) {
                System.out.println((i + 1) + ". ");
                danhSachDongVat.get(i).hienthitrangthai();
                System.out.println("---");
            }
        }
    }

    // NangCap Interface Implementation

    @Override
    public int getCapDo() {
        return capDo;
    }

    @Override
    public double getChiPhiNangCap() {
        return chiPhiNangCap;
    }

    @Override
    public void nangCap() {
        capDo++;
        sucChuaToiDa += 3; // Mỗi cấp tăng thêm 3 chỗ
        chiPhiNangCap *= 1.5; // Chi phí tăng 50% mỗi cấp
        System.out.println("[OK] Đã nâng cấp chuồng lên cấp " + capDo);
        System.out.println("     Sức chứa mới: " + sucChuaToiDa);
        System.out.println("     Chi phí nâng cấp tiếp theo: " + chiPhiNangCap);
    }

    // Getters
    public List<DongVat> getDanhSachDongVat() {
        return danhSachDongVat;
    }

    public int getSoLuongDongVat() {
        return danhSachDongVat.size();
    }

    public String getMaChuong() {
        return maChuong;
    }
}
