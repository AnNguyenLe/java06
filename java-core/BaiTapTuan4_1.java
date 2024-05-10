package demojava06;

import java.time.Year;
import java.util.Scanner;

public class BaiTapTuan4_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		GetYoungestStudent(scanner);
		
		CountOddEven(scanner);
		
		GetYoungestMaleEmployee(scanner);
		
		CalculateFurthestStudentFromUniversity(scanner);
		
		scanner.close();
	}
	
	public static void GetYoungestStudent(Scanner s) {
		String youngestStudentName = "", studentName = "";
		int maxYear = 0, year, thisYear = Year.now().getValue();
		
		for(int i = 1; i <= 3; i++) {
			do {
				System.out.print("Nhap ten sinh vien " + i + ": ");			
				studentName = s.nextLine();				
			} while (studentName.isBlank());
			
			do {
				System.out.print("Nhap nam sinh cua sinh vien " + i + " (Gia tri hop le: 1900 - " + thisYear + "): ");
				year = s.nextInt();
				//to avoid nextLine() read newline then move on in the next iteration
				s.nextLine();
				
			} while(year < 1900 || year > thisYear);
			
			if(year > maxYear) {
				maxYear = year;
				youngestStudentName = studentName;
			}
		}
		
		System.out.println("--> Sinh vien tre nhat ten la " + youngestStudentName + " sinh nam " + maxYear + ".");
		System.out.println();
	}
	
	public static void CountOddEven(Scanner s) {
		int oddCounter = 0, evenCounter = 0;
		int num;
		
		for(int i = 1; i <= 3; i++) {
			System.out.print("Nhap vao so nguyen thu " + i + ": ");
			num = s.nextInt();
			s.nextLine();
			
			if(num % 2 == 0) {
				++evenCounter;
			} else {
				++oddCounter;
			}
		}
		
		System.out.printf("--> Dua theo cac so nguyen ban nhap vao: Co %d so chan va %d so le.%n", evenCounter, oddCounter);
		System.out.println();
	}
	
	public static void GetYoungestMaleEmployee(Scanner s) {
		String youngestMaleName = "", name = "";
		boolean isMale = false;
		int maxYear = 0, year, thisYear = Year.now().getValue();
		
		for(int i = 1; i <= 3; i++) {
			do {
				System.out.print("Nhap ten nhan vien " + i + ": ");			
				name = s.nextLine();				
			} while (name.isBlank());
			
			do {
				System.out.print("Nhap nam sinh cua nhan vien " + i + " (Gia tri hop le: 1900 - " + thisYear + "): ");
				year = s.nextInt();
				//to avoid nextLine() read newline then move on in the next iteration
				s.nextLine();
				
			} while(year < 1900 || year > thisYear);
			
			System.out.print("Gioi tinh cua nhan vien (nam/nu hoac male/female hoac m/f): ");
			isMale = switch(s.nextLine().toLowerCase()) {
				case "nam", "male", "m": yield true;
				default: yield false;
			};
			
			if(isMale && year > maxYear) {
				maxYear = year;
				youngestMaleName = name;
			}
		}
		
		System.out.println("--> Nhan vien nam tre nhat ten la " + youngestMaleName + " sinh nam " + maxYear + ".");
		System.out.println();
	}
	
	public static void CalculateFurthestStudentFromUniversity(Scanner s){
		System.out.println("Toa do cua truong dai hoc: ");
		System.out.print("x: ");
		double universityX = s.nextDouble();
		System.out.print("y: ");
		double universityY = s.nextDouble();
		//to avoid nextLine() read newline then move on in the next iteration
		s.nextLine();
		
		String name = "", maxDistanceName = "";
		double coordinateX, coordinateY;
		double distance = 0, maxDistance = 0;
		for(int i = 1; i <= 3; i++) {
			do {
				System.out.print("Ten cua sinh vien thu " + i + ": ");
				name = s.nextLine();
			} while(name.isBlank());
			
			System.out.println("Toa ky tuc xa cua sinh vien " + i + ":");
			System.out.print("x: ");
			coordinateX = s.nextDouble();
			System.out.print("y: ");
			coordinateY = s.nextDouble();
			//to avoid nextLine() read newline then move on in the next iteration
			s.nextLine();
			
			double diffX = universityX - coordinateX;
			double diffY = universityY - coordinateY;
			distance = Math.sqrt(diffX*diffX + diffY*diffY);
			
			if(distance > maxDistance) {
				maxDistanceName = name;
				maxDistance = distance;
			}
		}
		
		System.out.printf("--> Sinh vien %s co cho o vi tri xa truong nhat: %s km.%n", maxDistanceName, String.format("%.2f", maxDistance));
		System.out.println();
	}
}


