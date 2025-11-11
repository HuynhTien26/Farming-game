import java.util.ArrayList;
import java.util.List;

class GameData {

    double tien;
    int chuongCap;
    int vuonCap;
    List<String> dongVatData = new ArrayList<>();
    List<String> thucVatData = new ArrayList<>();
    List<String> sanPhamData = new ArrayList<>();

    // Parse dữ liệu sản phẩm
    // Format: "TenSP,GiaBan,SoLuong"
    // Thí dụ: "Sua,50.0,5"
    public String[] parseSanPham(String data) {
        return data.split(",");
    }
    

    // Parse dữ liệu sinh vật
    // Format: "MaSo,Ten,Tuoi"
    // Thí dụ: "SV001,Bo,2"
    public String[] parseSinhVat(String data) {
        return data.split(",");
    }
}
