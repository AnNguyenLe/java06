package demojava06.BaiTapNopBuoi9;

import java.time.Year;

public abstract class Vehicle implements Displayable {
	private String manufacturer;
	private String color;
	private int yearOfManufacturing;
	
	public Vehicle(String manufacturer, String color, int yearOfManufacturing) {
		setManufacturer(manufacturer);
		setColor(color);
		setYearOfManufacturing(yearOfManufacturing);
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String brand) {
		if(brand.trim().equals("")) {
			throw new IllegalArgumentException("Brand cannot be empty!");
		}
		this.manufacturer = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if(color.trim().equals("")) {
			throw new IllegalArgumentException("Color cannot be empty!");
		}
		this.color = color;
	}

	public int getYearOfManufacturing() {
		return yearOfManufacturing;
	}

	public void setYearOfManufacturing(int yearOfManufacturing) {
		if(yearOfManufacturing > Year.now().getValue()) {
			throw new IllegalArgumentException("Year of manufacturing cannot be in the future!");
		}
		this.yearOfManufacturing = yearOfManufacturing;
	}
	
	public void display() {
		System.out.printf("Manufacturer: %s%nColor: %s%nYear of manufacturing: %d%n", manufacturer, color, yearOfManufacturing);
	}
}
