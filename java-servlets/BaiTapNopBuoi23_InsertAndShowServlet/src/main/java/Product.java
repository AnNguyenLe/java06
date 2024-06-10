
public class Product {
	private String name;
	private int quantity;
	private double price;
	
	public Product(String name, int quantity, double price) {
		setName(name);
		setQuantity(quantity);
		setPrice(price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name.strip().equals("") || name.equals(null)) {
			throw new IllegalArgumentException("Product Name cannot be null or empty.");
		}
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if(quantity < 0) {
			throw new IllegalArgumentException("Product Quantity cannot be a negative number.");
		}
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if(price < 0) {
			throw new IllegalArgumentException("Product Price cannot be a negative number.");
		}
		this.price = price;
	}

}
