package BaiTapNopBuoi11;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Employee {
	private String fullName;
	private LocalDate doB;
	
	public Employee(String fullName, LocalDate doB) {
		setFullName(fullName);
		setDoB(doB);
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		if(fullName.trim().equals("")) {
			this.fullName = "Name Unknown.";
			return;
		}
		this.fullName = fullName;
	}
	
	public LocalDate getDoB() {
		return doB;
	}
	
	public void setDoB(LocalDate doB) {
		if(doB.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("Ngay sinh khong the trong tuong lai!");
		}
		this.doB = doB;
	}
	
	public abstract BigDecimal calculateSalary();
}
