package BaiTapNopBuoi11;

import java.util.Scanner;

enum AlgebraOperation{
	Addition,
	Subtraction,
	Multiplication,
	Division
}

public class Fraction {
	private double numerator;
	private double denominator;
	
	public void enter(Scanner scanner) {
		System.out.print("Nhap tu so: ");
		setNumerator( scanner.nextDouble() );
		System.out.print("Nhap mau so: ");
		setDenominator( scanner.nextDouble() );
	}
	
	public Fraction add(Fraction f) {
		return performOperation(f, AlgebraOperation.Addition);
	}
	
	public Fraction subtract(Fraction f) {
		return performOperation(f, AlgebraOperation.Subtraction);
	}
	
	public Fraction multiply(Fraction f) {
		return performOperation(f, AlgebraOperation.Multiplication);
	}
	
	public Fraction divide(Fraction f) {
		return performOperation(f, AlgebraOperation.Division);
	}
	
	private Fraction performOperation(Fraction f, AlgebraOperation operation) {
		Fraction result = new Fraction();
		switch (operation) {
		case Addition:
			result.setNumerator(this.numerator*f.denominator + f.numerator*this.denominator);			
			result.setDenominator(this.denominator * f.denominator);
			break;
		case Subtraction:
			result.setNumerator(this.numerator*f.denominator - f.numerator*this.denominator);
			result.setDenominator(this.denominator * f.denominator);
			break;
		case Multiplication:
			result.setNumerator(this.numerator * f.numerator);
			result.setDenominator(this.denominator * f.denominator);
			break;
		case Division:
			if(f.numerator == 0) {
				System.out.println("Khong the thuc hien phep chia cho so 0!");
			}
			result.setNumerator(this.numerator * f.denominator);
			result.setDenominator(this.denominator * f.numerator);
			break;
		}
		return result;
	}
	
	public void display() {
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
		return "Phan so: " + this.numerator + "/" + this.denominator;
	}
	
	public double getNumerator() {
		return numerator;
	}
	
	public void setNumerator(double numerator) {
		this.numerator = numerator;
	}
	
	public double getDenominator() {
		return denominator;
	}
	
	public void setDenominator(double denominator) {
		if(denominator == 0) {
			System.out.println("Mau so khong duoc la so 0. Mac dinh la so 1.");
			this.denominator = 1;
			return;
		}
		this.denominator = denominator;
	}
	
}
