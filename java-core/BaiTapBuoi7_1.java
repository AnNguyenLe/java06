package demojava06;

import java.util.Scanner;

public class BaiTapBuoi7_1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		checkPositiveOrNegativeInt(s);
		
		oddOrEvenNum(s);
		
		checkPrimeNum(s);
		
		translateNumberToWord(s);
		
		sumOfEvenNums(s);
		
		calculateAvg(s);
		
		findMinMax(s);
		
		calculateSquareShape(s);
		
		int[] elements = new int[] {5,4,8,2,7,1,0,3,6,9};
		displayArrayElements(elements);
		
		displayEvenElements(elements);
		
		s.close();
	}

	public static void checkPositiveOrNegativeInt(Scanner s) {
		System.out.print("Nhap so nguyen: ");
		boolean isPositive = s.nextInt() >= 0;
		System.out.println("--> Day la so nguyen " + (isPositive ? "duong." : "am."));
	}

	public static void oddOrEvenNum(Scanner s) {
		System.out.print("Nhap so nguyen: ");
		boolean isEvenNum = s.nextInt() % 2 == 0;
		System.out.println("--> So " + (isEvenNum ? "chan." : "le."));
	}

	public static void checkPrimeNum(Scanner s) {
		System.out.print("Nhap so nguyen: ");
		int num = s.nextInt();

		int limit = (int)Math.sqrt(num);
		boolean isPrime = true;
		for (int i = 2; i <= limit; i++) {
			if (num % i == 0) {
				isPrime = false;
				break;
			}
		}

		System.out.println((isPrime ? "--> So " : "--> Khong phai so ") + "nguyen to.");
	}

	public static void translateNumberToWord(Scanner s) {
		int n = 1;
		do {
			System.out.print("Nhap so nguyen tu 1 - 10: ");
			n = s.nextInt();
		}while(n < 1 || n > 10);
		
		String word = switch (n) {
			case 1 -> "Mot";
			case 2 -> "Hai";
			case 3 -> "Ba";
			case 4 -> "Bon";
			case 5 -> "Nam";
			case 6 -> "Sau";
			case 7 -> "Bay";
			case 8 -> "Tam";
			case 9 -> "Chin";
			case 10 -> "Muoi";
			default -> "Mot";
		};
		
		System.out.println("So " + n + " viet ra thanh chu la: " + word);
	}
	
	public static void sumOfEvenNums(Scanner s) {
		int n = enterAPositiveInterger(s, "Nhap so nguyen duong");
		
		int limit = n % 2 == 1 ? n : n + 1;
		
		int sum = 0;
		for(int i = 2; i < limit; i++) {
			if(i % 2 == 0) sum += i;
		}
		
		System.out.println("--> Tong cac so chan tu 0 - " + n + " la: " + sum);
	}
	
	public static void calculateAvg(Scanner s) {
		int n = enterAPositiveInterger(s, "Nhap so luong phan tu");
		
		double sum = 0;
		for(int i = 0; i < n; i++) {
			System.out.print("Nhap gia tri cua phan tu thu " + (i + 1) + ": ");
			sum += s.nextDouble();
		}
		
		System.out.printf("--> Gia tri trung binh cua %d phan tu la: %f.%n", n, (double)(sum/n));
	}
	
	public static void findMinMax(Scanner s) {
		int n = enterAPositiveInterger(s, "Nhap so luong phan tu");
		
		System.out.print("Nhap gia tri cua phan tu thu 1: ");
		double value = s.nextDouble();
		double min = value, max = value;
		
		for(int i = 1; i < n; i++) {
			System.out.print("Nhap gia tri cua phan tu thu " + (i + 1) + ": ");
			value = s.nextDouble();
			
			if(min > value) min = value;
			
			if(max < value) max = value;
		}
		
		System.out.printf("--> Max: %f va Min: %f%n", max, min);
	}
	
	public static void calculateSquareShape(Scanner s) {
		double sideLength;
		do {
			System.out.print("Nhap do dai canh hinh vuong (> 0): ");
			sideLength = s.nextDouble();
		}while(sideLength < 1);
		
		System.out.printf("--> Chu vi: %f va Dien tich: %f%n", 4*sideLength, sideLength*sideLength);
	}
	
	public static void displayArrayElements(int[] elements) {
		System.out.print("--> Cac phan tu trong mang: [");
		for(int ele: elements) {
			System.out.print(" " + ele);
		}
		System.out.println(" ]");
	}
	
	public static void displayEvenElements(int[] elements) {
		System.out.print("--> Cac phan tu la so chan: [");
		for(int ele: elements) {
			if(ele % 2 == 0) System.out.print(" " + ele);
		}
		System.out.println(" ]");
	}
	
	private static int enterAPositiveInterger(Scanner s, String message) {
		int n;
		do {
			System.out.print(message + " (> 0): ");
			n = s.nextInt();
		}while(n < 1);
		
		return n;
	}
}
