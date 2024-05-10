package demojava06;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

public class BaiTapTuan4_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		CalculateTotalPriceOfOrder(scanner);
		
		scanner.close();
	}
	
	public static void CalculateTotalPriceOfOrder(Scanner s) {
		System.out.print("Nhap ten mat hang: ");
		String name = s.nextLine();
		
		int amount;
		do {
			System.out.print("Nhap so luong: ");
			amount = s.nextInt();
		} while(amount < 0);
		
		BigDecimal unitPrice;
		BigDecimal zero = new BigDecimal(0);
		do {
			System.out.print("Nhap don gia (gia ban le khi mua 1 mon): ");
			unitPrice = s.nextBigDecimal();
		} while(unitPrice.compareTo(zero) < 0);
		
		BigDecimal totalPrice = CalculateTotalPrice(amount, unitPrice);
		
		System.out.println("--> Tong tien cho " + amount + " " + name + " la: " + NumberFormat.getCurrencyInstance().format(totalPrice));
	}
	
	private static BigDecimal CalculateTotalPrice(int amount, BigDecimal unitPrice) {
		BigDecimal totalPrice;
		BigDecimal amountBigDecimal = new BigDecimal(amount);
		int wholeSaleNumber = 100;
		if(amount < wholeSaleNumber) {
			totalPrice = unitPrice.multiply(amountBigDecimal);
			if(amount > 50) {
				BigDecimal deductionRate = new BigDecimal(0.08);
				BigDecimal deduction = totalPrice.multiply(deductionRate);
				totalPrice = totalPrice.subtract(deduction);
			}
		} else {
			double deductionRateAfterWholeSaleNumber = 1 - 0.12;
			
			totalPrice = unitPrice.multiply(BigDecimal.valueOf(wholeSaleNumber));
			BigDecimal saleRateAfterWholeSaleNumber = new BigDecimal(deductionRateAfterWholeSaleNumber);
			int remainingAmount = amount - wholeSaleNumber;
			
			BigDecimal unitPriceAfterWholeSaleNumber = unitPrice.multiply(saleRateAfterWholeSaleNumber);
			BigDecimal totalPriceAfterWholeSaleNumber = unitPriceAfterWholeSaleNumber.multiply(BigDecimal.valueOf(remainingAmount));
			
			totalPrice = totalPrice.add(totalPriceAfterWholeSaleNumber);
		}
		
		return totalPrice;
	}
}
