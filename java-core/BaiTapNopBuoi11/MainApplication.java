package BaiTapNopBuoi11;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class MainApplication {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		// Bai 1:
		Fraction phanSo1 = new Fraction();
		phanSo1.enter(s);
		
		Fraction phanSo2 = new Fraction();
		phanSo2.enter(s);
		
		Fraction phanSoCong = phanSo1.add(phanSo2);
		phanSoCong.display();
		
		Fraction phanSoTru = phanSo1.subtract(phanSo2);
		phanSoTru.display();
		
		Fraction phanSoNhan = phanSo1.multiply(phanSo2);
		phanSoNhan.display();
		
		Fraction phanSoChia = phanSo1.divide(phanSo2);
		phanSoChia.display();
		
		// Bai 2:
		Athlete athlete1 = new Athlete();
		athlete1.enter(s);
		
		Athlete athlete2 = new Athlete();
		athlete2.enter(s);
		
		athlete1.displayComparison(athlete2);
		
		// Bai 3:
		List<Employee> employees = new ArrayList<>();
		employees.add(new OfficeEmployee("A", LocalDate.of(1996, 9, 10), 18));
		employees.add(new ManufacturingEmployee("B", LocalDate.of(2000, 8, 21), BigDecimal.valueOf(4500000), 189));
		
		BigDecimal total = BigDecimal.valueOf(0);
		for(Employee em: employees) {
			total = total.add(em.calculateSalary());
		}
		
		System.out.println("Tong tien luong cong phai tra: " + total);
		
		// Bai 4:
		Car car = new Car();
		List<Vehicle> cars = car.enterMany(s, "oto");
		
		car.displayMany(cars, "Danh sach cac xe oto duoc nhap thong tin");
		
		Dictionary<Double, List<Vehicle>> speedsAndCars= new Hashtable<>();
		
		for(Vehicle c: cars) {
			if(speedsAndCars.get(c.getMaxSpeed()) == null) {
				speedsAndCars.put(c.getMaxSpeed(), new ArrayList<>());
			}
			speedsAndCars.get(c.getMaxSpeed()).add(c);
		}
		
		Enumeration<Double> speeds = speedsAndCars.keys();
		while (speeds.hasMoreElements()) {
			double speed = speeds.nextElement();
            List<Vehicle> sameSpeedCars = speedsAndCars.get(speed);
            car.displayMany(sameSpeedCars, "Cac xe co cung van toc toi da " + speed + "km/h:");
        }
		
		s.close();
	}

}
