package demojava06.BaiTapNopBuoi9;

public abstract class ElectronicDevice {
    private String brand;
    private String model;
    private boolean poweredOn;

    public ElectronicDevice(String brand, String model) {
    	setBrand(brand);
    	setModel(model);
        this.poweredOn = false;
    }

    public void turnOn() {
        poweredOn = true;
        System.out.println(brand + " " + model + " is now powered on.");
    }

    public void turnOff() {
        poweredOn = false;
        System.out.println(brand + " " + model + " is now powered off.");
    }

    public void displayStatus() {
        String status = poweredOn ? "ON" : "OFF";
        System.out.println(brand + " " + model + " is currently " + status);
    }

    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
    	if(Validator.isEmptyString(brand)) {
    		throw new IllegalArgumentException("Brand cannot be empty!");
    	}
    	this.brand = brand;
    }

    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
    	if(Validator.isEmptyString(model)) {
    		throw new IllegalArgumentException("Brand cannot be empty!");
    	}
    	this.model = model;
    }

    public boolean isPoweredOn() {
        return poweredOn;
    }
}
