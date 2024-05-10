package demojava06;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class BaiTapBuoi8 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		List<Student> students = createListOfStudents(s);
		
		calculateAverageScores(students);
		
		rankStudents(students);
		
		findHighestAvgScoreStudent(students);
		
		findWeakStudents(students);
		
		findStudentByName(s, students);
		
		findStudentById(s, students);
		
		students = deleteStudentById(s, students);
		
		s.close();
	}
	
	public static List<Student> createListOfStudents(Scanner s) {
		
		System.out.print("Nhap so luong sinh vien: ");
		int n = s.nextInt();
		s.nextLine();
		
		List<Student> students = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			
			students.add(
					new Student(
					enterName(s, i + 1),
					UUID.randomUUID().toString(),
					generateScore(),
					generateScore(),
					generateScore()
			));
		}
		
		return students;		
	}
	
	public static void calculateAverageScores(List<Student> students) {
		System.out.println("\n--> Diem trung binh cua tung sinh vien:");
		for(Student s: students) {
			System.out.printf("(MSSV: %s) %s: %f%n", s.id, s.name, s.calculateAvg());
		}
	}
	
	public static void rankStudents(List<Student> students) {
		System.out.println("\n--> Phan loai tung sinh vien:");
		for(Student s: students) {
			System.out.printf("(MSSV: %s) %s: %s%n", s.id, s.name, s.rank());
		}
	}
	
	public static void findHighestAvgScoreStudent(List<Student> students) {
		Student maxStudent = students.get(0);
		for(Student s: students) {
			if(s.calculateAvg() > maxStudent.calculateAvg()) {
				maxStudent = s;
			}
		};
		
		System.out.printf("\n--> Diem trung binh cao nhat: %f, sinh vien: %s - %s%n", maxStudent.calculateAvg(), maxStudent.id, maxStudent.name);
	}
	
	public static void findWeakStudents(List<Student> students) {
		System.out.println("--> Nhung hoc sinh co diem trung binh la Yeu:");
		for(Student s: students) {
			if(s.rank().equals("Yeu")) {
				System.out.printf("%s - %s%n", s.name, s.id);
			}
		}
	}
	
	public static void findStudentByName(Scanner scanner, List<Student> students) {
		System.out.print("Nhap ten sinh vien can tim: ");
		String name = scanner.nextLine();
		for(Student s: students) {
			if(s.name.equals(name)) {
				System.out.println("Co ton tai sinh vien co ten: " + name);
				return;
			}
		}
		System.out.println("Khong ton tai sinh vien co ten: " + name);
	}
	
	public static void findStudentById(Scanner scanner, List<Student> students) {
		System.out.print("Nhap ma sinh vien can tim: ");
		String id = scanner.nextLine();
		for(Student s: students) {
			if(s.id.equals(id)) {
				System.out.println("Co ton tai sinh vien co ma so sinh vien: " + id);
				return;
			}
		}
		System.out.println("Khong ton tai sinh vien co ma so sinh vien: " + id);
	}
	
	public static List<Student> deleteStudentById(Scanner scanner, List<Student> students) {
		System.out.print("Nhap ma sinh vien can xoa: ");
		String id = scanner.nextLine();
		
		int size = students.size();
		int index = -1;
		for(int i = 0; i < size; i++) {
			if(students.get(i).id.equals(id)) {
				index = i;
				break;
			}
		}
		
		
		if(index == -1) {
			System.out.println("Khong ton tai sinh vien co ma so sinh vien: " + id);
			return students;
		}
		
		System.out.println("Xoa sinh vien co ma so: " + students.remove(index).id + " thanh cong!");
		return students;
	}
	
	private static String enterName(Scanner s, int index) {
		String name;
		do {
			System.out.printf("Nhap ten sinh vien %d: ", index);
			name = s.nextLine();
		}while(name.trim().equals(""));
		
		return name;
	}
	
	private static double generateScore() {
		double score = Math.random()*10;
		return Math.ceil(score*100)/100;
	}
	
}
