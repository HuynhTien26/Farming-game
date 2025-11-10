import java.util.ArrayList;
import java.util.List;

public class Vuon implements NangCap {

    private List<Thucvat> danhSachCayTrong;
    private int capDo;
    private int sucChuaToiDa;
    private double chiPhiNangCap;

    // Static counter for generating IDs
    private static int demVuon = 0;
    private String maVuon;

    public Vuon() {
        this.maVuon = "VN" + (++demVuon);
        this.danhSachCayTrong = new ArrayList<>();
        this.capDo = 1;
        this.sucChuaToiDa = 10; // Cấp 1 trồng tối đa 10 cây
        this.chiPhiNangCap = 300.0;
    }

    // CRUD Operations

    /**
     * Thêm cây trồng vào vườn
     */
    public boolean themThucVat(Thucvat thucVat) {
        if (danhSachCayTrong.size() >= sucChuaToiDa) {
            System.out.println(
                "[X] Vườn đã đầy! Sức chứa tối đa: " + sucChuaToiDa
            );
            return false;
        }
        danhSachCayTrong.add(thucVat);
        System.out.println(
            "[+] Đã trồng " + thucVat.getTen() + " vào vườn " + maVuon
        );
        return true;
    }

    /**
     * Xóa cây trồng theo mã số
     */
    public boolean xoaThucVat(String maSo) {
        for (int i = 0; i < danhSachCayTrong.size(); i++) {
            if (danhSachCayTrong.get(i).getMaso().equals(maSo)) {
                Thucvat tv = danhSachCayTrong.remove(i);
                System.out.println("[+] Đã nhổ " + tv.getTen() + " khỏi vườn");
                return true;
            }
        }
        System.out.println("[X] Không tìm thấy cây trồng có mã: " + maSo);
        return false;
    }

    /**
     * Tìm kiếm cây trồng theo mã số
     */
    public Thucvat timKiemThucVat(String maSo) {
        for (Thucvat tv : danhSachCayTrong) {
            if (tv.getMaso().equals(maSo)) {
                return tv;
            }
        }
        return null;
    }

    /**
     * Tìm kiếm cây trồng theo tên
     */
    public List<Thucvat> timKiemTheoTen(String ten) {
        List<Thucvat> ketQua = new ArrayList<>();
        for (Thucvat tv : danhSachCayTrong) {
            if (tv.getTen().toLowerCase().contains(ten.toLowerCase())) {
                ketQua.add(tv);
            }
        }
        return ketQua;
    }

    /**
     * Tưới nước cho tất cả cây trồng
     */
    public void tuoiNuocTatCa() {
        if (danhSachCayTrong.isEmpty()) {
            System.out.println("Vườn trống, không có cây nào để tưới.");
            return;
        }

        System.out.println("\n--- Đang tưới nước cho cây ---");
        for (Thucvat tv : danhSachCayTrong) {
            tv.tuoiNuoc();
        }
        System.out.println("[+] Đã tưới nước cho tất cả cây trồng!");
    }

    /**
     * Hiển thị danh sách cây trồng
     */
    public void hienThiDanhSach() {
        System.out.println("\n=== VƯỜN " + maVuon + " ===");
        System.out.println(
            "Cấp độ: " +
                capDo +
                " | Sức chứa: " +
                danhSachCayTrong.size() +
                "/" +
                sucChuaToiDa
        );

        if (danhSachCayTrong.isEmpty()) {
            System.out.println("(Vườn trống)");
        } else {
            System.out.println("\nDanh sách cây trồng:");
            for (int i = 0; i < danhSachCayTrong.size(); i++) {
                System.out.println((i + 1) + ". ");
                danhSachCayTrong.get(i).hienthitrangthai();
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
        sucChuaToiDa += 5; // Mỗi cấp tăng thêm 5 chỗ
        chiPhiNangCap *= 1.5; // Chi phí tăng 50% mỗi cấp
        System.out.println("[+] Đã nâng cấp vườn lên cấp " + capDo);
        System.out.println("    Sức chứa mới: " + sucChuaToiDa);
        System.out.println("    Chi phí nâng cấp tiếp theo: " + chiPhiNangCap);
    }

    // Getters
    public List<Thucvat> getDanhSachCayTrong() {
        return danhSachCayTrong;
    }

    public int getSoLuongCayTrong() {
        return danhSachCayTrong.size();
    }

    public String getMaVuon() {
        return maVuon;
    }
}
