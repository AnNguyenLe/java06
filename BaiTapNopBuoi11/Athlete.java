package BaiTapNopBuoi11;

import java.util.Scanner;

public class Athlete {
	private String fullName;
	private int age;
	private String sport;
	private double weight;
	private double height;
	
	public void enter(Scanner s) {
		System.out.println("Nhap thong tin van dong vien:");
		
		System.out.print("Nhap ho ten: ");
		setFullName(s.nextLine());
		
		System.out.print("Nhap tuoi: ");
		setAge(s.nextInt());
		s.nextLine();
		
		System.out.print("Nhap mon thi dau: ");
		setSport(s.nextLine());
		
		System.out.print("Nhap can nang: ");
		setWeight(s.nextDouble());
		
		System.out.print("Nhap chieu cao: ");
		setHeight(s.nextDouble());
		s.nextLine();
	}
	
	public void display() {
		System.out.println("Thong tin van dong vien:");
		System.out.printf("%nHo ten: %s%n", fullName);
		System.out.printf("%nTuoi: %d%n", age);
		System.out.printf("%nBo mon thi dau: %s%n", sport);
		System.out.printf("%nChieu cao: %f%n", height);
		System.out.printf("%nCan nang: %f%n", weight);
	}
	
	public void displayComparison(Athlete a) {
		String result = switch(this.compareTo(a)) {
			case 1 -> "--> " + this.fullName + " > " + a.fullName;
			case -1 -> "--> " +  this.fullName + " < " + a.fullName;
			default -> "--> " +  this.fullName + " = " + a.fullName;
		};
		
		System.out.println(result);
	}
	
	private int compareTo(Athlete a) {
		if(height > a.height) {
			return 1;
		} else if(height < a.height) {
			return -1;
		}
		
		if(weight > a.weight) {
			return 1;
		} else if(weight < a.weight) {
			return -1;
		}
		
		return 0;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		if(fullName.trim().equals("")) {
			this.fullName = "Name not declared.";
			return;
		}
		this.fullName = fullName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age <= 0) {
			this.age = 1;
		}
		this.age = age;
	}
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		if(sport.trim().equals("")) {
			this.sport = "Unknown sport name.";
			return;
		}
		this.sport = sport;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		if(weight <= 0) {
			this.weight = 1;
			return;
		}
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		if(height <= 0) {
			this.height = 1;
			return;
		}
		this.height = height;
	}
	
	
}
