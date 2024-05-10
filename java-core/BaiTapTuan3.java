package demojava06;

import java.math.BigDecimal;
import java.util.Scanner;

public class BaiTapTuan3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		CalculateHypotenuse(scanner);
		
		CalculateMonomial(scanner);
		
		CalculateSumOfDigitsOfANumber(scanner);
		
		CalculateAverage(scanner);
		
		ConvertCToF(scanner);
		
		ConvertUSDToVND(scanner);
		
		scanner.close();
	}
	
	public static void CalculateHypotenuse(Scanner s) {
		System.out.print("Nhap do dai canh 1: ");
		double side1 = s.nextDouble();
		
		System.out.print("Nhap do dai canh 2: ");
		double side2 = s.nextDouble();
		
		double h = Math.sqrt(side1*side1 + side2*side2);
		System.out.println("Do dai canh huyen: " + h);
	}
	
	public static void CalculateMonomial(Scanner s) {
		System.out.print("Nhap so thuc a: ");
		double a = s.nextDouble();
		
		int n;
		do {
			System.out.print("Nhap so nguyen khong am: ");
			n = s.nextInt();
		} while(n < 0);
		
		double result = a * Math.pow(8, n);
		System.out.println("P(x) = a * (8 ^ n) =  " + result);
	}
	
	public static void CalculateSumOfDigitsOfANumber(Scanner s) {
		int n;
		do {
			System.out.print("Nhap vao so nguyen duong co 2 ky so: ");
			n = s.nextInt();
		}while(n < 10 || n > 99);
		
		int number1 = n % 10;
		int number2 = (n - number1)/10;
		
		System.out.println("Tong cua " + number1 + " va " + number2 + " la : " + (number1 + number2));
	}
	
	public static void CalculateAverage(Scanner s) {
		final int totalCount = 5;
		double sum = 0;
		for(int i = 0; i < 5; i++) {
			System.out.print("Nhap vao so nguyen thu " + (i + 1) + ": ");
			sum += s.nextDouble();
		}
		
		System.out.println("Average: " + (double)sum/totalCount);
	}
	
	public static void ConvertCToF(Scanner s) {
		System.out.print("Nhap vao nhiet do Celcius: ");
		double c = s.nextDouble();
		
		System.out.println("==> " + c + "oC tuong duong " + (c*1.8 + 32) + "oF.");
	}
	
	public static void ConvertUSDToVND(Scanner s) {
		final BigDecimal usdToVnd = new BigDecimal(23500);
		final BigDecimal zero = new BigDecimal(0);
		BigDecimal amount;
		do {
			System.out.print("Nhap vao so luong USD de quy doi ra VND: ");
			amount = s.nextBigDecimal();
		}while(amount.compareTo(zero) < 0);
		
		System.out.println(amount + " USD = " + amount.multiply(usdToVnd) + " VND.");
	}
}
