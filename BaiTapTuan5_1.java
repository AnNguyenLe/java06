package demojava06;

import java.util.Arrays;
import java.util.Scanner;

public class BaiTapTuan5_1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		DisplayPositiveNumbersUsingFor(100);
		DisplayPositiveNumbersUsingWhile(100);
		DisplayPositiveNumbersUsingForAndModulo(100);
		DisplayPositiveNumbersUsingWhileAndModulo(100);
		
		CalculateSumUsingForLoopFrom1To(scanner);
		CalculateSumUsingWhileLoopFrom1To(scanner);
		
		CountNumberDividedTo3UsingForLoop(0, 1000);
		CountNumberDividedTo3UsingWhileLoop(0, 1000);
		
		scanner.close();
	}
	
	public static void DisplayPositiveNumbersUsingFor(int n) {
		int half = n/2;
		int[] odds = new int[half];
		int[] evens = new int[half];
		
		int num = 0;
		for(int index = 0; index < half; index++) {
			odds[index] = ++num;
			evens[index] = ++num;
		}
		System.out.printf("In tat ca cac so nguyen duong chan/le nho hon %d su dung FOR LOOP%n", n);
		System.out.printf("Cac so nguyen duong le nho hon %d:%n %s%n", n, String.join(", ", Arrays.toString(odds)));
		System.out.printf("Cac so nguyen duong chan nho hon %d:%n %s%n", n, String.join(", ", Arrays.toString(evens)));
		System.out.println();
	}
	
	public static void DisplayPositiveNumbersUsingWhile(int n) {
		int half = n/2;
		int[] odds = new int[half];
		int[] evens = new int[half];
		
		int index = 0, num = 0;
		while(index < half) {
			odds[index] = ++num;
			evens[index++] = ++num;
		}
		
		System.out.printf("In tat ca cac so nguyen duong chan/le nho hon %d su dung WHILE LOOP%n", n);
		System.out.printf("Cac so nguyen duong le nho hon %d:%n %s%n", n, String.join(", ", Arrays.toString(odds)));
		System.out.printf("Cac so nguyen duong chan nho hon %d:%n %s%n", n, String.join(", ", Arrays.toString(evens)));
		System.out.println();
	}
	
	public static void DisplayPositiveNumbersUsingForAndModulo(int n) {
		int half = n/2;
		int[] odds = new int[half];
		int[] evens = new int[half];
		
		int oddIndex = 0, evenIndex = 0;
		for(int num = 1; num <= n; num++) {
			if(num % 2 == 0) {
				evens[evenIndex] = num;
				++evenIndex;
			} else {
				odds[oddIndex] = num;
				++oddIndex;
			}
		}
		
		System.out.printf("In tat ca cac so nguyen duong chan/le nho hon %d su dung FOR LOOP va MODULO%n", n);
		System.out.printf("Cac so nguyen duong le nho hon %d:%n %s%n", n, String.join(", ", Arrays.toString(odds)));
		System.out.printf("Cac so nguyen duong chan nho hon %d:%n %s%n", n, String.join(", ", Arrays.toString(evens)));
		System.out.println();
	}
	
	public static void DisplayPositiveNumbersUsingWhileAndModulo(int n) {
		int half = n/2;
		int[] odds = new int[half];
		int[] evens = new int[half];
		
		int oddIndex = 0, evenIndex = 0;
		int num = 1;
		while(num <= n) {
			if(num % 2 == 0) {
				evens[evenIndex] = num++;
				++evenIndex;
			} else {
				odds[oddIndex] = num++;
				++oddIndex;
			}
		}
		
		System.out.printf("In tat ca cac so nguyen duong chan/le nho hon %d su dung WHILE LOOP va MODULO%n", n);
		System.out.printf("Cac so nguyen duong le nho hon %d:%n %s%n", n, String.join(", ", Arrays.toString(odds)));
		System.out.printf("Cac so nguyen duong chan nho hon %d:%n %s%n", n, String.join(", ", Arrays.toString(evens)));
		System.out.println();
	}
	
	public static void CalculateSumUsingForLoopFrom1To(Scanner s) {
		int n;
		
		do {
			System.out.print("Nhap so nguyen duong (> 0): ");
			n = s.nextInt();
		} while(n < 0);
		
		int total = 0;
		for(int num = 1; num <= n; num++) {
			total += num;
		}
		
		System.out.printf("Tong cac so nguyen tu 1 toi %d su dung FOR LOOP la %d%n%n", n, total);
		
	}
	
	public static void CalculateSumUsingWhileLoopFrom1To(Scanner s) {
		int n;
		do {
			System.out.print("Nhap so nguyen duong (> 0): ");
			n = s.nextInt();
		} while(n < 0);
		
		int total = 0;
		int num = 1;
		while(num <= n) {
			total += num++;
		}
		
		System.out.printf("Tong cac so nguyen tu 1 toi %d su dung WHILE LOOP la %d%n%n", n, total);
	}
	
	public static void CountNumberDividedTo3UsingForLoop(int fromNum, int toNum) {
		int counter = 0;
		for(int num = fromNum; num <= toNum; num++) {
			if(num % 3 == 0) {
				++counter;
			}
		}
		
		System.out.printf("FOR LOOP: Co %d so chia het cho 3 tu %d toi %d%n%n", counter, fromNum, toNum);
	}
	
	public static void CountNumberDividedTo3UsingWhileLoop(int fromNum, int toNum) {
		int counter = 0;
		int num = fromNum;
		while(num <= toNum) {
			if(num % 3 == 0) {
				++counter;
			}
			++num;
		}
		
		System.out.printf("WHILE LOOP: Co %d so chia het cho 3 tu %d toi %d%n%n", counter, fromNum, toNum);
	}

}
