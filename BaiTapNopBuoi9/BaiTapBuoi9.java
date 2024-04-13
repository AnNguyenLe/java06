package demojava06.BaiTapNopBuoi9;

public class BaiTapBuoi9 {

	public static void main(String[] args) {
		Student student = new Student("An", 28, 9.5);
		student.display();
		
		Vehicle car = new Car("BMW", "Black", 2024);
		car.display();
		
		Vehicle motorbike = new Motorbike("Yamaha", "Silver", 2023);
		motorbike.display();
		
		Game game = new Game("Age of Empires", 3);
		game.start();
		
		ElectronicDevice airCon = new AirConditioner("Daikin", "P213");
		airCon.displayStatus();
		
		ElectronicDevice airDryer = new AirDryer("Panasonic", "H123");
		airDryer.displayStatus();
	}

}
