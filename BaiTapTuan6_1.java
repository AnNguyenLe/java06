package demojava06;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BaiTapTuan6_1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int a = 9, b = 7, c = 8;
		System.out.printf("So lon nhat trong ba so %d, %d, %d la %d%n", a, b, c, FindMax(a,b,c));
		
		int n = 8;
		System.out.printf("%d la so %s%n", n, IsOddNumber(n) ? "le." : "chan.");

		DecimalFormat df = new DecimalFormat("#.##");
		int repeat = 3;
		System.out.printf("Tong %d so do nguoi dung nhap vao: %s%n", repeat, df.format( AccumulateValues(s, repeat) ));
		
		SimpleCalculator(s);
		
		s.close();
	}
	
	public static int FindMax(int a, int b, int c) {
		int max = a;
		
		if(b > max) {
			max = b;
		}
		
		return c > max ? c : max;
	}
	
	public static boolean IsOddNumber(int n) {
		return (n & 1) == 1;
	}
	
	public static double AccumulateValues(Scanner s, int repeat) {
		double accumulatedValue = 0;
		while(repeat-- > 0) {
			System.out.print("Nhap vao gia tri: ");
			accumulatedValue += s.nextDouble();
		}
		return accumulatedValue;
	}
	
	public static void SimpleCalculator(Scanner s) {
		boolean shouldStop = false;
		System.out.printf("%nSimple Calculator:%n");
		int operator;
		while(!shouldStop) {
			
			operator = SelectOperator(s);
			
			System.out.print("Nhap so a: ");
			double a = s.nextDouble();
			
			System.out.print("Nhap so b: ");
			double b = s.nextDouble();
			
			switch(operator) {
				case 1 -> Add(a,b);
				case 2 -> Subtract(a,b);
				case 3 -> Multiply(a,b);
				case 4 -> Divide(a,b);
			}
			
			shouldStop = DoesUserWantToStop(s);
			if(shouldStop) {
				System.out.println("Program stopped...");
			}
		}
	}
	
	public static int SelectOperator(Scanner s) {
		System.out.printf("%nChon phep tinh ban muon thuc hien:%n");
		System.out.println("Phep cong - Nhan 1 (Default)");
		System.out.println("Phep tru - Nhan 2");
		System.out.println("Phep nhan - Nhan 3");
		System.out.println("Phep chia - Nhan 4");
		System.out.print("--> Lua chon cua ban: ");
		int selectedOperation = s.nextInt();
		
		return switch(selectedOperation) {
			case 1,2,3,4 -> selectedOperation;
			default -> 1;
		};
	}
	
	public static boolean DoesUserWantToStop(Scanner s) {
		s.nextLine();
		System.out.printf("%nBan co muon tiep tuc?%n");
		System.out.print("Stop press 'n' - Continue press any key: ");
		return s.nextLine().toLowerCase().equals("n");
	}
	
	public static void Add(double a, double b) {
		System.out.printf("%n==> %f + %f = %f%n", a, b, a + b);
	}
	
	public static void Subtract(double a, double b) {
		System.out.printf("%n==> %f - %f = %f%n", a, b, a - b);
	}
	
	public static void Multiply(double a, double b) {
		System.out.printf("%n==> %f x %f = %f%n", a, b, a * b);
	}
	
	public static void Divide(double a, double b) {
		System.out.printf("%n==> %f / %f = %f%n", a, b, (double)(a / b));
	}

}
