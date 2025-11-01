import java.util.Scanner;

public class GameMenu {
	
	// vai trò 3
	private Chuong chuong;
	private Vuon vuon;
	private Kho kho;
	private XuLyFile File;
	
	// vai trò 4
	private CuaHang cuaHang;
	private NguoiChoi nguoiChoi;
	
	//nhập lệnh
	private Scanner scanner;
	
	public GameMenu() {
		chuong = new Chuong();
		vuon = new Vuon();
		kho = new Kho();
		File = new XuLyFile();
		
		cuaHang = new CuaHang();
		nguoiChoi = new NguoiChoi("Nông dân zui zẻ", 1000.0);
		
		scanner = new Scanner (System.in);
	}
	
	public static void main(String[] args) {
        GameMenu game = new GameMenu();
        game.chayGame();
    }
	
	//vong lap chinh
	public void chayGame () {
		boolean dangChoi = true;
		while (dangChoi) {
			hienThiMenu();
			int luaChon = Inter.praseInt(scanner.nextLine());
			
			switch (luaChon) {
			case 1: 
				//vai trò 3
				System.out.print("Thêm động vật..."); //đợi code
				break;
			
			case 2:
				//vai trò 3
				System.out.println("Trồng cây...");
				break;
				
			case 3:
				//vai trò 3
				System.out.println("Vào cửa hàng");
				break;
			
			case 4:
				//vai trò 4
				System.out.println("Lưu trò chơi");
				break;
				
			//case 5:......
				
			case 9: 
				dangChoi = false;
				System.out.println("Thoát");
				break;
			
			default:
				System.out.println("Lựa chọn không hợp lệ!!!!");
			}
		}
	}
	
	private void hienThiMenu() {
		System.out.println("\n--- GAME NÔNG TRẠI ---");
		System.out.println("Tiền: " + nguoiChoi.getTien()); //Vai trò 4
        System.out.println("1. Thêm động vật");
        System.out.println("2. Trồng cây");
        System.out.println("3. Vào cửa hàng");
        System.out.println("4. Lưu game");
        System.out.println("9. Thoát");
        System.out.print("Chọn: ");
	}
	
}
