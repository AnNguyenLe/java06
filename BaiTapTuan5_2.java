package demojava06;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class BaiTapTuan5_2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
//		RockPaperScissors(s);
		
//		MinNumberAddedUpTo(10000);
		
//		SumOfAllPositiveOddNumbers(s);
		
//		CalculateGeometricSeries(s);
		
		BankingCalculator(s);
		
		s.close();
	}
	
	
	public static void RockPaperScissors(Scanner s) {
		int machineTurn, yourTurn;
		int loseCounter = 0, evenCounter = 0, winCounter = 0;
		boolean shouldContinue = true;
		do {
			int result;
			machineTurn = (int)(Math.random()*3);
			yourTurn = (int)(Math.random()*3);
			
			if(machineTurn == yourTurn) {
				++evenCounter;
				result = 0;
			} else { // You can only win if your turn result is the symbol right before the opponent's result: Rock > Scissor > Paper > Rock
				boolean didMachineWin = (machineTurn + 1)%3 == yourTurn;
				if(didMachineWin) {
					++loseCounter;
					result = -1;
				} else {
					++winCounter;
					result = 1;
				}
			}
			
			String machineTurnSymbol = TranslateRockPaperScissors(machineTurn);
			String yourTurnSymbol = TranslateRockPaperScissors(yourTurn);
			String matchResult = switch(result) {
				case -1 -> "You lose.";
				case 0 -> "Draw.";
				case 1 -> "You win.";
				default -> throw new IllegalArgumentException("Unexpected value: " + result);
			};
			
			System.out.printf("You: %s - %s: Machine --> Match result: %s%n", yourTurnSymbol, machineTurnSymbol, matchResult);
			
			System.out.print("Nhan so KHAC 0 de choi tiep - Nhan 0 de dung: ");
			shouldContinue = s.nextInt() != 0;
		}while(shouldContinue);
		
		System.out.println("Tong luot choi: " + (loseCounter + evenCounter + winCounter));
		System.out.printf("Thang: %d - Thua: %d - Hoa: %d", winCounter, loseCounter, evenCounter);
	}
	
	private static String TranslateRockPaperScissors(int symbolCode) {
		return switch(symbolCode) {
			case 0 -> "Rock";
			case 1 -> "Scissor";
			case 2 -> "Paper";
			default -> throw new IllegalArgumentException("Unexpected value: " + symbolCode);
		};
	}

	public static void MinNumberAddedUpTo(int threshold) {
		int total = 0;
		int n = 0;
		while(total <= threshold) {
			total += ++n;
		}
		
		System.out.printf("1 + 2 + 3 + ... + n > %d ==> n = %d%n", threshold, n);
	}
	
	public static void SumOfAllPositiveOddNumbers(Scanner s) {
		int n;
		do {
			System.out.print("Nhap so nguyen duong (>0 only): ");
			n = s.nextInt();
		}while(n <= 0);
		
		int total = 0;
		
		int maxOddNum = (n & 1) == 1 ? n : n + 1;
		
		for(int num = 1; num < maxOddNum; num += 2) {
			total += num;
		}
		
		System.out.println("Tong cac so le nho hon " + n + ": " + total);
	}
	
	public static void CalculateGeometricSeries(Scanner s) {
		System.out.println("S(n) = x + x^2 + x^3 + ... + x^n");
		System.out.print("Nhap x = ");
		double x = s.nextInt();
		
		System.out.print("Nhap n = ");
		int n = s.nextInt();
		
		
		if(x == 1) {
			System.out.println("--> Tong la: " + n);
			return;
		}
		
		double total = 0;
		for(int exp = 1; exp <= n; exp++) {
			double element = x;
			for(int count = 1; count < exp; count++) {
				element *= x;
			}
			
			total += element;
		}
		
		System.out.println("--> Tong la: " + total);
	}
	
	public static void BankingCalculator(Scanner s) {
		BigDecimal deposit = EnterPositiveNumber(s, "Nhap so tien gui ban dau: ");
		BigDecimal expectedAmount = EnterPositiveNumber(s, "Nhap so tien mong muon nhan duoc sau khi gui tiet kiem: ");
		BigDecimal interestRatePerYear = EnterPositiveNumber(s, "Nhap tien lai ngan hang: ");
		
		BigDecimal accummulatedDeposit = deposit;
		int yearCount = 1;
		while(accummulatedDeposit.compareTo(expectedAmount) < 0) {
			BigDecimal gain = accummulatedDeposit.multiply(interestRatePerYear);
			accummulatedDeposit = accummulatedDeposit.add(gain);
			++yearCount;
		}
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		System.out.printf("So tien gui sau %d nam la: %s", yearCount, df.format(accummulatedDeposit));
	}
	
	public static BigDecimal EnterPositiveNumber(Scanner s, String message) {
		BigDecimal num;
		BigDecimal zero = new BigDecimal(0);
		do {
			System.out.print(message);
			num = s.nextBigDecimal();
		}while(num.compareTo(zero) <= 0);
		
		return num;
	}
}
