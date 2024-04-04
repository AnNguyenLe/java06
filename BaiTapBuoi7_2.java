package demojava06;

import java.util.Scanner;

public class BaiTapBuoi7_2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int[] elements = enterElements(s);
		
		displayElements(elements);
		
		showMaxValue(elements);
		
		findFirstNegative(elements);
		
		findBiggestNegative(elements);
		
		sumOfEvenNums(elements);
		
		countNegativeNums(elements);
		
		sumOfNegativeNums(elements);
		
		doesElementExist(s, elements);
		
		s.close();
	}
	
	public static int[] enterElements(Scanner s) {
		int n;
		do {
			System.out.print("Nhap so luong cho mang (phai la so nguyen duong): ");
			n = s.nextInt();
		} while(n <= 0);
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			System.out.print("Nhap gia tri cho vi tri " + i + ": ");
			arr[i] = s.nextInt();
		}
		
		return arr;
	}
	
	public static void displayElements(int[] elements) {
		System.out.print("--> Mang da nhap: [");
		for(int ele: elements) {
			System.out.printf(" %d", ele);
		}
		System.out.println(" ]");
	}
	
	public static void showMaxValue(int[] elements) {
		int index = 0, max = elements[index];
		int length = elements.length;
		for(int i = 0; i < length; i++) {
			if(elements[i] > max) {
				index = i;
				max = elements[index];
			}
		}
		
		System.out.printf("--> Gia tri lon nhat: %d, tai vi tri: %d%n", elements[index], index);
	}
	
	public static int findIndexOfFirstNegative(int[] elements) {
		int index = -1;
		for(int i = 0; i < elements.length; i++) {
			if(elements[i] < 0) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	public static void findFirstNegative(int[] elements) {
		int index = findIndexOfFirstNegative(elements);
		if(index == -1) {
			System.out.println("--> Khong co so am trong mang nay.");
			return;
		}
		System.out.printf("--> So am dau tien trong mang: %d, tai vi tri %d%n", elements[index], index);
	}
	
	public static void findBiggestNegative(int[] elements) {
		int index = findIndexOfFirstNegative(elements);
		if(index == -1) {
			System.out.println("--> Khong co so am trong mang nay.");
			return;
		}
		int maxNegative = elements[index];
		int length = elements.length;
		
		
		for(int i = index; i < length; i++) {
			if(elements[i] < 0 && elements[i] > maxNegative) {
				maxNegative = elements[i];
			}
		}
		
		System.out.printf("--> So am lon nhat trong mang: %d, tai vi tri %d%n", elements[index], index);
	}
	
	public static void sumOfEvenNums(int[] elements) {
		int sum = 0;
		for(int num: elements) {
			if(num % 2 == 0) {
				sum += num;
			}
		}
		
		System.out.println("--> Tong cac so chan trong mang: " + sum);
	}
	
	public static void countNegativeNums(int[] elements) {
		int counter = 0;
		for(int num: elements) {
			if(num < 0) {
				++counter;
			}
		}
		
		System.out.printf("--> Co tong cong %d so am ton tai trong mang nay.%n", counter);
	}
	
	public static void sumOfNegativeNums(int[] elements) {
		int sum = 0;
		for(int num: elements) {
			if(num < 0) {
				sum += num;
			}
		}
		
		System.out.println("--> Tong cac song am trong mang: " + sum);
	}
	
	public static void doesElementExist(Scanner s, int[] elements) {
		System.out.print("Nhap vao 1 so nguyen de kiem tra co ton tai trong mang hay khong: ");
		int num = s.nextInt();
		boolean hasBeenFound = false;
		for(int ele: elements) {
			if(ele == num) {
				hasBeenFound = true;
				break;
			}
		}
		
		System.out.printf("--> So %d %s ton tai trong mang nay.%n", num, (hasBeenFound ? "co" : "khong"));
	}
	
}
