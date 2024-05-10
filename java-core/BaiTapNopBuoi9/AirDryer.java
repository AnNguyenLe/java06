package demojava06.BaiTapNopBuoi9;

public class AirDryer extends ElectronicDevice {
	private int blowLevel;
	
	public AirDryer(String brand, String model) {
		super(brand, model);
		setBlowLevel(2);
	}
	
	public int getBlowLevel() {
		return blowLevel;
	}
	
	public void setBlowLevel(int blowLevel) {
		if(Validator.isOutOfRange(blowLevel, 1, 3)) {
			throw new IllegalArgumentException("Air Dryer blow level must be in range 1 - 3!");
		}
		this.blowLevel = blowLevel;
	}

	@Override
	public void displayStatus() {
		super.displayStatus();
		System.out.println("Current blow level: " + blowLevel);
	}
}
