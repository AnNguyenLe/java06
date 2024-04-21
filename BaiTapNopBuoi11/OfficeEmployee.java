package BaiTapNopBuoi11;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OfficeEmployee extends Employee {
	private int noOfWorkingDays;
	
	public OfficeEmployee(String fullName, LocalDate doB, int noOfWorkingDays) {
		super(fullName, doB);
		setNoOfWorkingDays(noOfWorkingDays);
	}

	@Override
	public BigDecimal calculateSalary() {
		return BigDecimal.valueOf(noOfWorkingDays).multiply(BigDecimal.valueOf(100000));
	}

	public int getNoOfWorkingDays() {
		return noOfWorkingDays;
	}

	public void setNoOfWorkingDays(int noOfWorkingDays) {
		if(noOfWorkingDays < 0) {
			throw new IllegalArgumentException("So ngay lam viec khong the la so am!");
		}
		this.noOfWorkingDays = noOfWorkingDays;
	}
	
}
