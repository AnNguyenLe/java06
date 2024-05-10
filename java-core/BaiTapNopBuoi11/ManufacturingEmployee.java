package BaiTapNopBuoi11;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ManufacturingEmployee extends Employee {
	private BigDecimal baseSalary;
	private int noOfProducts;

	public ManufacturingEmployee(String fullName, LocalDate doB, BigDecimal baseSalary, int noOfProducts) {
		super(fullName, doB);
		setBaseSalary(baseSalary);
		setNoOfProducts(noOfProducts);
	}

	@Override
	public BigDecimal calculateSalary() {
		return baseSalary.add(BigDecimal.valueOf(noOfProducts).multiply(BigDecimal.valueOf(5000)));
	}

	public BigDecimal getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(BigDecimal baseSalary) {
		if(baseSalary.compareTo(BigDecimal.valueOf(0)) <= 0) {
			throw new IllegalArgumentException("Luong co ban khong duoc phep nho hon 0!");
		}
		this.baseSalary = baseSalary;
	}

	public int getNoOfProducts() {
		return noOfProducts;
	}

	public void setNoOfProducts(int noOfProducts) {
		if(noOfProducts <= 0) {
			throw new IllegalArgumentException("So san pham lam ra khong the nho hon 0!");
		}
		this.noOfProducts = noOfProducts;
	}

}
