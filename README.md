### NhiemVuThuHoach.java (Lớp con)
@Override public void kiemTraHoanThanh(NguoiChoi nguoiChoi)

Phương thức này ghi đè (override) hàm trừu tượng của lớp cha. Nó cung cấp logic cụ thể cho nhiệm vụ thu hoạch: truy cập vào Kho của người chơi và so sánh số lượng sản phẩm.

Đây là ví dụ về tính đa hình (Polymorphism). Nó cho phép một đối tượng NhiemVuThuHoach thực thi "hợp đồng" kiemTraHoanThanh theo cách riêng của nó, tập trung hoàn toàn vào logic kiểm tra kho hàng.




### NhiemVuNangCap.java (Lớp con)
@Override public void kiemTraHoanThanh(NguoiChoi nguoiChoi)

Tương tự như trên, phương thức này cũng ghi đè (override) hàm trừu tượng, nhưng với logic hoàn toàn khác: nó kiểm tra capDo của Vuon hoặc Chuong của người chơi.

Đây cũng là tính đa hình. Mặc dù cả NhiemVuNangCap và NhiemVuThuHoach đều là NhiemVu, nhưng khi gọi phương thức kiemTraHoanThanh(), Java sẽ tự động chạy đúng phiên bản (phiên bản kiểm tra cấp độ hoặc phiên bản kiểm tra kho) tùy thuộc vào đối tượng thực tế




### CuaHang.java (Lớp thực thi Giao diện) (Lớp này thực thi (implements) một Giao diện (Interface) tên là MuaBan)
@Override public void banSanPham(...)

Hàm này định nghĩa logic khi người chơi BÁN sản phẩm cho cửa hàng. Nó kiểm tra Kho của người chơi, trừ sản phẩm khỏi kho và cộng tiền cho người chơi.

Bằng cách thực thi một Giao diện (Interface), lớp CuaHang cam kết rằng nó sẽ cung cấp chức năng banSanPham. Điều này giúp đóng gói (encapsulation) toàn bộ logic bán hàng phức tạp vào một nơi.


@Override public void muaVatPham(...)
Hàm này định nghĩa logic khi người chơi MUA vật phẩm từ cửa hàng. Nó kiểm tra tiền của người chơi, trừ tiền và thêm vật phẩm (như BoCon, HatGiongVietQuat) vào đúng nơi (như Chuong hoặc Vuon).

Giống như banSanPham, hàm này thực thi hợp đồng của Giao diện MuaBan. Nó che giấu toàn bộ logic mua hàng (kiểm tra giá, kiểm tra tiền, thêm vật phẩm) khỏi các phần khác của chương trình. Các lớp khác chỉ cần gọi cuaHang.muaVatPham(...) mà không cần biết chi tiết bên trong.
