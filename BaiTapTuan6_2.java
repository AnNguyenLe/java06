package demojava06;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

enum RentalService{
	CAR,
	SUV,
	BLACK
}

public class BaiTapTuan6_2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		RentalService service = SelectRentalService(s);
		
		double distance = EnterPositiveNumber(s, "Nhap so quang duong da di (km): ");
		double waitTime = EnterPositiveNumber(s, "Nhap tong thoi gian cho doi (phut - minutes): ");
		
		BigDecimal totalFee = switch(service) {
			case CAR -> CalcualteCarServiceFee(distance, waitTime);
			case SUV -> CalcualteSUVServiceFee(distance, waitTime);
			case BLACK -> CalcuateBlackServiceFee(distance, waitTime);
			default -> CalcualteCarServiceFee(distance, waitTime);
		};
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		System.out.printf("==> Tong tien cho chuyen di: %s", df.format(totalFee));
		
		s.close();
	}
	
	private static RentalService SelectRentalService(Scanner s) {
		System.out.println("Chon dich vu xe:");
		
		System.out.println("Car - Nhan 1 (Default)");
		System.out.println("SUV - Nhan 2");
		System.out.println("Black - Nhan 3");
		
		System.out.print("\n--> Su lua chon cua ban: ");
		int selection = s.nextInt();
		
		return switch(selection) {
			case 1 -> RentalService.CAR;
			case 2 -> RentalService.SUV;
			case 3 -> RentalService.BLACK;
			default -> RentalService.CAR;
		};
	}
	
	private static double EnterPositiveNumber(Scanner s, String message) {
		double num;
		do {
			System.out.print(message);
			num = s.nextDouble();
		}while(num <= 0);
		return num;
	}
	
	
	public static BigDecimal CalcualteCarServiceFee(double distance, double waitTime) {
		double firstDistanceUpperBound = 1;
		double secondDistanceUpperBound = 19;
		double waitTimeThreshold = 3;
		
		BigDecimal firstDistanceUpperBoundFeePerUnit = new BigDecimal(8000);
		BigDecimal secondDistanceUpperBoundFeePerUnit = new BigDecimal(7500);
		BigDecimal aboveSecondDistanceUpperBoundFeePerUnit = new BigDecimal(7000);
		
		BigDecimal everyWaitTimeThresholdFee = new BigDecimal(2000);
		
		double[] distanceUpperBounds = new double[] {firstDistanceUpperBound, secondDistanceUpperBound};
		BigDecimal[] feePerUnitAccordingToDistanceUpperBounds = new BigDecimal[] {firstDistanceUpperBoundFeePerUnit, secondDistanceUpperBoundFeePerUnit, aboveSecondDistanceUpperBoundFeePerUnit};
		
		return CalculateServiceFee(
				distance, 
				waitTime, 
				waitTimeThreshold,
				everyWaitTimeThresholdFee,
				distanceUpperBounds, 
				feePerUnitAccordingToDistanceUpperBounds
		);
	}
	
	public static BigDecimal CalcualteSUVServiceFee(double distance, double waitTime) {
		double firstDistanceUpperBound = 1;
		double secondDistanceUpperBound = 19;
		double waitTimeThreshold = 3;
		
		BigDecimal firstDistanceUpperBoundFeePerUnit = new BigDecimal(9000);
		BigDecimal secondDistanceUpperBoundFeePerUnit = new BigDecimal(8500);
		BigDecimal aboveSecondDistanceUpperBoundFeePerUnit = new BigDecimal(8000);
		
		BigDecimal everyWaitTimeThresholdFee = new BigDecimal(3000);
		
		double[] distanceUpperBounds = new double[] {firstDistanceUpperBound, secondDistanceUpperBound};
		BigDecimal[] feePerUnitAccordingToDistanceUpperBounds = new BigDecimal[] {firstDistanceUpperBoundFeePerUnit, secondDistanceUpperBoundFeePerUnit, aboveSecondDistanceUpperBoundFeePerUnit};
		
		return CalculateServiceFee(
				distance, 
				waitTime, 
				waitTimeThreshold,
				everyWaitTimeThresholdFee,
				distanceUpperBounds, 
				feePerUnitAccordingToDistanceUpperBounds
		);
	}
	
	public static BigDecimal CalcuateBlackServiceFee(double distance, double waitTime) {
		double firstDistanceUpperBound = 1;
		double secondDistanceUpperBound = 19;
		double waitTimeThreshold = 3;
		
		BigDecimal firstDistanceUpperBoundFeePerUnit = new BigDecimal(10000);
		BigDecimal secondDistanceUpperBoundFeePerUnit = new BigDecimal(9500);
		BigDecimal aboveSecondDistanceUpperBoundFeePerUnit = new BigDecimal(9000);
		
		BigDecimal everyWaitTimeThresholdFee = new BigDecimal(3500);
		
		double[] distanceUpperBounds = new double[] {firstDistanceUpperBound, secondDistanceUpperBound};
		BigDecimal[] feePerUnitAccordingToDistanceUpperBounds = new BigDecimal[] {firstDistanceUpperBoundFeePerUnit, secondDistanceUpperBoundFeePerUnit, aboveSecondDistanceUpperBoundFeePerUnit};
		
		return CalculateServiceFee(
				distance, 
				waitTime, 
				waitTimeThreshold,
				everyWaitTimeThresholdFee,
				distanceUpperBounds, 
				feePerUnitAccordingToDistanceUpperBounds
		);
	}
	
	private static BigDecimal CalculateServiceFee(
			double distance, 
			double waitTime, 
			double waitTimeThreshold,
			BigDecimal everyWaitTimeThresholdFee,
			double[] distanceUpperBounds, 
			BigDecimal[] feePerUnitAccordingToDistanceUpperBounds
	) {
		double firstDistanceUpperBound = distanceUpperBounds[0];
		double secondDistanceUpperBound = distanceUpperBounds[1];
		
		BigDecimal firstDistanceUpperBoundFeePerUnit = feePerUnitAccordingToDistanceUpperBounds[0];
		BigDecimal secondDistanceUpperBoundFeePerUnit = feePerUnitAccordingToDistanceUpperBounds[1];
		BigDecimal aboveSecondDistanceUpperBoundFeePerUnit = feePerUnitAccordingToDistanceUpperBounds[2];
		
		double waitingFeeCoefficient = waitTime < waitTimeThreshold ? 0 : Math.ceil( waitTime / waitTimeThreshold);
		BigDecimal waitingFee = BigDecimal.valueOf(waitingFeeCoefficient).multiply(everyWaitTimeThresholdFee);
		
		if(distance <= firstDistanceUpperBound) {
			return CalculateTotalFee(firstDistanceUpperBoundFeePerUnit, waitingFee);
		}
		
		if(distance <= secondDistanceUpperBound) {
			BigDecimal withinSecondDistanceUpperBoundFee = BigDecimal.valueOf(distance - firstDistanceUpperBound).multiply(secondDistanceUpperBoundFeePerUnit);
			BigDecimal travelFee = firstDistanceUpperBoundFeePerUnit.add(withinSecondDistanceUpperBoundFee);
			return CalculateTotalFee(travelFee, waitingFee);
		}
		
		BigDecimal withinSecondDistanceUpperBoundFee = BigDecimal.valueOf(secondDistanceUpperBound - firstDistanceUpperBound).multiply(secondDistanceUpperBoundFeePerUnit);
		BigDecimal aboveSecondDistanceUpperBoundFee = BigDecimal.valueOf(distance - secondDistanceUpperBound).multiply(aboveSecondDistanceUpperBoundFeePerUnit);
		BigDecimal totalTravelFee = firstDistanceUpperBoundFeePerUnit.add(withinSecondDistanceUpperBoundFee);
		
		return totalTravelFee.add(aboveSecondDistanceUpperBoundFee);
	}
	
	private static BigDecimal CalculateTotalFee(BigDecimal travelFee, BigDecimal waitingFee) {
		return travelFee.add(waitingFee);
	}

}
