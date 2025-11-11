import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XuLyFile {

    private static final String FILE_SAVE = "game_save.txt";

    /** 
     * Save game
     */
    public void luuGame(
        Chuong chuong,
        Vuon vuon,
        Kho kho,
        double tienNguoiChoi
    ) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_SAVE))) {
            // Lưu tiền người chơi
            writer.println("TIEN:" + tienNguoiChoi);

            // Lưu thông tin chuồng
            writer.println("CHUONG_CAP:" + chuong.getCapDo());
            writer.println("CHUONG_COUNT:" + chuong.getSoLuongDongVat());
            for (DongVat dv : chuong.getDanhSachDongVat()) {
                writer.println("DONGVAT:" + dv.getMaso() + "," + dv.getTen() + "," + dv.getTuoi());
            }

            // Lưu thông tin vườn
            writer.println("VUON_CAP:" + vuon.getCapDo());
            writer.println("VUON_COUNT:" + vuon.getSoLuongCayTrong());
            for (Thucvat tv : vuon.getDanhSachCayTrong()) {
                writer.println("THUCVAT:" + tv.getMaso() + "," + tv.getTen() + "," + tv.getTuoi());
            }

            // Lưu thông tin kho (với số lượng)
            writer.println("KHO_COUNT:" + kho.getTongSoLoaiSanPham());
            for (Sanpham sp : kho.getDanhSachSanPham()) {
                writer.println("SANPHAM:" + sp.getTenSP() + "," + sp.getGiaban() + "," + sp.getSoluong());
            }

            System.out.println("[+] Đã lưu game thành công vào file: " + FILE_SAVE);
        } catch (IOException e) {
            System.out.println("[X] Lỗi khi lưu game: " + e.getMessage());
        }
    }

    /**
     * Tải game
     * Note: Phương thức này cần được hoàn thiện với constructor cụ thể của các class
     * Hiện tại chỉ đọc dữ liệu thô
     * TODO Cần Tiên cung cấp constructor để khởi tạo đối tượng
     */
    public GameData taiGame() {
        GameData data = new GameData();

        try (
            BufferedReader reader = new BufferedReader(
                new FileReader(FILE_SAVE)
            )
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("TIEN:")) {
                    data.tien = Double.parseDouble(line.substring(5));
                } else if (line.startsWith("CHUONG_CAP:")) {
                    data.chuongCap = Integer.parseInt(line.substring(11));
                } else if (line.startsWith("VUON_CAP:")) {
                    data.vuonCap = Integer.parseInt(line.substring(9));
                } else if (line.startsWith("DONGVAT:")) {
                    data.dongVatData.add(line.substring(8));
                } else if (line.startsWith("THUCVAT:")) {
                    data.thucVatData.add(line.substring(8));
                } else if (line.startsWith("SANPHAM:")) {
                    data.sanPhamData.add(line.substring(8));
                }
            }

            System.out.println("[+] Đã tải game thành công từ file: " + FILE_SAVE);
            System.out.println("    Tiền: " + data.tien);
            System.out.println("    Cấp chuồng: " + data.chuongCap);
            System.out.println("    Cấp vườn: " + data.vuonCap);
            System.out.println("    Số động vật: " + data.dongVatData.size());
            System.out.println("    Số thực vật: " + data.thucVatData.size());
            System.out.println("    Số loại sản phẩm: " + data.sanPhamData.size());
        } catch (FileNotFoundException e) {
            System.out.println("[!] Không tìm thấy file save. Bắt đầu game mới.");
        } catch (IOException e) {
            System.out.println("[X] Lỗi khi tải game: " + e.getMessage());
        }

        return data;
    }

    /**
     * Kiểm tra file save có tồn tại ko
     */
    public boolean coFileSave() {
        File file = new File(FILE_SAVE);
        return file.exists();
    }

    /**
     * Xóa file save (bắt đầu game mới)
     */
    public boolean xoaSave() {
        File file = new File(FILE_SAVE);
        if (file.exists()) {
            boolean deleted = file.delete();
            if (deleted) {
                System.out.println("[+] Đã xóa file save cũ");
            }
            return deleted;
        }
        return false;
    }
}
