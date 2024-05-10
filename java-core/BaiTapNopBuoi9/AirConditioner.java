package demojava06.BaiTapNopBuoi9;

public class AirConditioner extends ElectronicDevice {
	private double temperature;
	private int fanSpeed;

	public AirConditioner(String brand, String model) {
		super(brand, model);
		setTemperature(20);
		setFanSpeed(2);
	}
	
	public double getTemperature() {
		return temperature;
	}
	
	public void setTemperature(double temperature) {
		if(Validator.isOutOfRange(temperature, 16, 30)) {
			throw new IllegalArgumentException("Air Conditioner temperature must be in range 16 - 30oC!");
		}
		this.temperature = temperature;
	}
	
	public int getFanSpeed() {
		return fanSpeed;
	}
	
	public void setFanSpeed(int fanSpeed) {
		if(Validator.isOutOfRange(fanSpeed, 1, 5)) {
			throw new IllegalArgumentException("Air Conditioner fan speed must be in range 1 - 5!");
		}
		this.fanSpeed = fanSpeed;
	}
	
	@Override
	public void displayStatus() {
		super.displayStatus();
		System.out.println("Temperature: " + temperature + "oC - " + "Fan Speed: " + fanSpeed);
	}
}
