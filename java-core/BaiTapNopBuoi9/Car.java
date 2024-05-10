package demojava06.BaiTapNopBuoi9;

public class Car extends Vehicle {
	public Car(String brand, String color, int yearOfManufacturing) {
		super(brand, color, yearOfManufacturing);
	}

	@Override
	public void display() {
		System.out.println("Category: Car");
		super.display();
	}
}
