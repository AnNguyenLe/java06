package demojava06.BaiTapNopBuoi9;

public class Validator {
	public static boolean isEmptyString(String str) {
		return str.trim().isEmpty();
	}
	
	public static boolean isOutOfRange(int value, int lowerBound, int higherBound) {
		return value < lowerBound || higherBound < value;
	}
	
	public static boolean isOutOfRange(double value, double lowerBound, double higherBound) {
		return value < lowerBound || higherBound < value;
	}
}
