package BaiTapNopBuoi11;

import java.util.Scanner;

public class Car extends Vehicle {
	private int noOfSeats;
	private String engineType;
	
	@Override
	public void enter(Scanner s) {
		super.enter(s);
		
		System.out.print("Nhap so cho ngoi: ");
		setNoOfSeats(s.nextInt());
		s.nextLine();
		
		System.out.print("Nhap kieu dong co: ");
		setEngineType(s.nextLine());
	}
	
	@Override
	protected Vehicle createVehicle() {
		return new Car();
	}
	
	@Override
	public void display() {
		super.display();
		
		System.out.println("So cho ngoi: " + noOfSeats);
		System.out.println("Kieu dong co: " + engineType);
	}
	
	public int getNoOfSeats() {
		return noOfSeats;
	}
	
	public void setNoOfSeats(int noOfSeats) {
		if(noOfSeats < 1) {
			throw new IllegalArgumentException("Number of seats cannot be less than 1!");
		}
		this.noOfSeats = noOfSeats;
	}
	
	public String getEngineType() {
		return engineType;
	}
	
	public void setEngineType(String engineType) {
		if(engineType.trim().equals("")) {
			throw new IllegalArgumentException("Engine type cannot be empty!");
		}
		this.engineType = engineType;
	}
	 
}
