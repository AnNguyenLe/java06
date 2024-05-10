package demojava06.BaiTapNopBuoi9;

import java.util.UUID;

public class Student implements Rankable, Displayable {
	private String name;
	private String id;
	private int age;
	private double avgScore;
	
	private Student(String name, String id, int age, double avgScore) {
		setName(name);
		this.id = id;
		setAge(age);
		setAvgScore(avgScore);
	}
	
	public Student(String name, int age, double avgScore) {
		this(name, UUID.randomUUID().toString(), age, avgScore);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(Validator.isEmptyString(name)) {
			throw new IllegalArgumentException("Student name cannot be empty!");
		}
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(Validator.isOutOfRange(age, 1, 125)) {
			throw new IllegalArgumentException("Student age must be in range of 1 - 125!");
		}
		this.age = age;
	}

	public double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(double mathScore) {
		if(Validator.isOutOfRange(avgScore, 0, 10)) {
			throw new IllegalArgumentException("Student average score must be in range of 0 - 10!");
		}
		this.avgScore = mathScore;
	}
	
	public String evaluateRank() {
		if(avgScore >= 9) {
			return "Excellent.";
		} else if(avgScore >= 8) {
			return "Very good.";
		} else if(avgScore >= 7) {
			return "Good.";
		} else if(avgScore >= 6) {
			return "Above average.";
		} else if(avgScore >= 5) {
			return "Average.";
		} else {
			return "Weak.";
		}
	}
	
	public void display() {
		System.out.printf("Student name: %s%nStudent ID: %s%nAge: %d%nAverage Score: %f%nRanking: %s%n%n", name, id, age,avgScore, evaluateRank());
	}

}
