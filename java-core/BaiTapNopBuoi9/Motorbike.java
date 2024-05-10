package demojava06.BaiTapNopBuoi9;

public class Motorbike extends Vehicle {

	public Motorbike(String manufacturer, String color, int yearOfManufacturing) {
		super(manufacturer, color, yearOfManufacturing);
	}
	
	@Override
	public void display() {
		System.out.println("Category: Motorbike");
		super.display();
	}
}
