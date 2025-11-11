/**
 * Lớp CuaHang quản lý việc mua bán vật phẩm và sản phẩm.
 * Lớp này thực thi (implements) interface MuaBan.
 */
public class CuaHang implements MuaBan {

    /**
     * Constructor cho CuaHang.
     */
    public CuaHang() {
        // (Có thể khởi tạo danh sách mặt hàng Cửa Hàng bán ở đây)
    }

    /**
     * Ghi đè phương thức banSanPham từ interface MuaBan.
     * Logic: Người chơi BÁN sản phẩm cho cửa hàng để lấy tiền.
     */
    @Override
    public void banSanPham(NguoiChoi nguoiChoi, String tenSanPham, int soLuong) {
        System.out.println("Dang xu ly BAN san pham: " + tenSanPham + " (SL: " + soLuong + ")");
        
        // 1. Lấy kho của người chơi
        Kho khoNguoiChoi = nguoiChoi.getKho();
        
        // 2. Kiểm tra xem người chơi có đủ sản phẩm để bán không
        SanPham sp = khoNguoiChoi.timSanPham(tenSanPham);
        
        if (sp == null || sp.getSoLuong() < soLuong) {
            System.out.println("-> Loi: Ban khong co du " + soLuong + " " + tenSanPham + " de ban.");
            return;
        }

        // 3. Thực hiện giao dịch
        double giaBan = sp.getGiaBan();
        double tienNhanDuoc = giaBan * soLuong;
        
        khoNguoiChoi.giamSoLuong(tenSanPham, soLuong); // Trừ hàng khỏi kho
        nguoiChoi.nhanTien(tienNhanDuoc); // Cộng tiền cho người chơi

        System.out.println("-> Ban thanh cong " + soLuong + " " + tenSanPham + ".");
    }

    /**
     * Ghi đè phương thức muaVatPham từ interface MuaBan.
     * Logic: Người chơi MUA vật phẩm từ cửa hàng (ví dụ: hạt giống, con giống).
     */
    @Override
    public void muaVatPham(NguoiChoi nguoiChoi, String tenVatPham, int soLuong) {
        System.out.println("Dang xu ly MUA vat pham: " + tenVatPham + " (SL: " + soLuong + ")");
        
        // 1. (Giả lập) Lấy giá vật phẩm từ cửa hàng
        double giaMua = 0;
        String loaiVatPham = ""; // Dùng để biết thêm vào Vườn hay Chuồng

        if (tenVatPham.equalsIgnoreCase("HatGiongVietQuat")) {
            giaMua = 5; // Giả sử giá 5
            loaiVatPham = "VUON";
        } else if (tenVatPham.equalsIgnoreCase("BoCon")) {
            giaMua = 150; // Giả sử giá 150
            loaiVatPham = "CHUONG";
        } else {
            System.out.println("-> Loi: Cua hang khong ban " + tenVatPham);
            return;
        }

        // 2. Kiểm tra người chơi có đủ tiền không
        double tongTienPhaiTra = giaMua * soLuong;
        if (!nguoiChoi.truTien(tongTienPhaiTra)) {
             // Hàm truTien() của NguoiChoi đã in thông báo lỗi
            return;
        }

        // 3. Thêm vật phẩm cho người chơi
        for (int i = 0; i < soLuong; i++) {
             if (loaiVatPham.equals("VUON")) {
                 // Giả sử tên vật phẩm cũng là tên lớp ThucVat
                 nguoiChoi.getVuon().themCay(new VietQuat("VQ" + i, "Viet Quat " + i));
             } else if (loaiVatPham.equals("CHUONG")) {
                 // Giả sử tên vật phẩm là tên lớp DongVat
                 nguoiChoi.getChuong().themDongVat(new Bo("BO" + i, "Bo " + i));
             }
        }
        System.out.println("-> Ban mua thanh cong " + soLuong + " " + tenVatPham + ".");
    }
}