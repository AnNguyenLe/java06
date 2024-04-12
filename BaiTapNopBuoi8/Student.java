package demojava06.BaiTapNopBuoi8;

public class Student {
	
	public String name;
	public String id;
	public double mathScore;
	public double physicScore;
	public double chemistryScore;
	
	public Student(String name, String id, double mathScore, double physicScore, double chemistryScore) {
		this.name = name;
		this.id = id;
		this.mathScore = mathScore;
		this.physicScore = physicScore;
		this.chemistryScore = chemistryScore;
	}

	public double calculateAvg() {
		return (double)(mathScore + physicScore + chemistryScore)/3;
	}

	public String rank() {
		double avg = calculateAvg();
		String ranking = "";
		if(avg >= 9) {
			ranking = "Xuat sac";
		} else if(avg >= 8) {
			ranking = "Gioi";
		} else if(avg >= 7) {
			ranking = "Kha";
		} else if(avg >= 6) {
			ranking = "Trung binh Kha";
		} else if(avg >= 5) {
			ranking = "Trung binh";
		} else {
			ranking = "Yeu";
		}
		
		return ranking;
	}
	
	
}
