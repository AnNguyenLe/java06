package BaiTapNopBuoi11;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Vehicle {
	private String id;
	private String manufacturer;
	private String vehicleName;
	private int yearOfManufacturing;
	private double maxSpeed;
	
	public void enter(Scanner s) {
		id = UUID.randomUUID().toString();
		
		System.out.print("Nhap ten hang san xuat: ");
		setManufacturer(s.nextLine());
		
		System.out.print("Nhap ten phuong tien: ");
		setVehicleName(s.nextLine());
		
		System.out.print("Nhap nam san xuat: ");
		setYearOfManufacturing(s.nextInt());
		
		System.out.print("Nhap van toc toi da: ");
		setMaxSpeed(s.nextDouble());
	}
	
	public List<Vehicle> enterMany(Scanner s, String vehicleType) {
		System.out.print("So luong " + vehicleType + " can nhap thong tin: ");
		
		int n = s.nextInt();
		s.nextLine();
		
		List<Vehicle> vehicles = new ArrayList<>(n);
		
		for(int i = 0; i < n; i++) {
			System.out.println("Nhap thong tin " + vehicleType + " " + (i+1) + ":");
			vehicles.add(createVehicle());
			vehicles.get(i).enter(s);;
			System.out.println();
		}
		
		return vehicles;
	}
	
	public void displayMany(List<Vehicle> vehicles, String message) {
		System.out.println(message);
		for(Vehicle vehicle: vehicles) {
			vehicle.display();
			System.out.println();
		}
	}
	
	public void display() {
		System.out.println("Hang san xuat: " + manufacturer);
		System.out.println("Ten phuong tien: " + vehicleName);
		System.out.println("Nam san xuat: " + yearOfManufacturing);
		System.out.println("Van toc toi da: " + maxSpeed);
	}
	
	protected Vehicle createVehicle() {
		return new Vehicle();
	}
	
	public String getId() {
		return id;
	}

	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getVehicleName() {
		return vehicleName;
	}
	
	public void setVehicleName(String vehicleName) {
		if(vehicleName.trim().equals("")) {
			throw new IllegalArgumentException("Vehicle name cannot be empty!");
		}
		this.vehicleName = vehicleName;
	}
	
	public int getYearOfManufacturing() {
		return yearOfManufacturing;
	}
	
	public void setYearOfManufacturing(int yearOfManufacturing) {
		if(yearOfManufacturing > LocalDate.now().getYear()) {
			throw new IllegalArgumentException("Year of manufacturing cannot be in the future!");
		}
		this.yearOfManufacturing = yearOfManufacturing;
	}
	
	public double getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setMaxSpeed(double maxSpeed) {
		if(maxSpeed < 0) {
			throw new IllegalArgumentException("Max speed cannot be a negative value!");
		}
		this.maxSpeed = maxSpeed;
	}
}
