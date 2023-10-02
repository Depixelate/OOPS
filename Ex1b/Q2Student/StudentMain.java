package Ex1b.Q2Student;

import java.util.Scanner;

public class StudentMain {
	public static void print(String s) {
		System.out.print(s);
	}
	
	public static void println(String s) {
		System.out.println(s);
	}
	
	public static Student[] inputStudents(Scanner input) {
		print("Enter the number of students you would like to enter: ");
		int numStudents = input.nextInt();
		input.nextLine();
		var students = new Student[numStudents];
		for(int i = 0; i < numStudents; i++) {
			var initString = "Enter student " + (i + 1) + "'s ";
			print(initString + "name: ");
			var name = input.nextLine();
			print(initString + "ID: ");
			var id = input.nextLine();
			print(initString + "department: "); 
			var dept = input.nextLine();
			print(initString + "marks for 3 subjects(separated by space): ");
			double mark1 = input.nextDouble(), mark2 = input.nextDouble(), mark3 = input.nextDouble();
			students[i] = new Student(name, id, dept, mark1, mark2, mark3);
			input.nextLine();
		}
		return students;
	}
	
	public static double[] avg(Student[] students) {
		double[] avgs = new double[students.length];
		for(int  i = 0; i < students.length; i++) {
			double[] marks = students[i].marks;
			avgs[i] = (marks[0] + marks[1] + marks[2])/3;
		}
		return avgs;
	}
	
	public static Student searchID(Student[] students, String id) {
		for(int i = 0; i < students.length; i++) {
			var student = students[i];
			if(student.id.equals(id)) {
				return student;
			} 
		}
		
		return null;
	}
	
	public static Student searchName(Student[] students, String name) {
		for(int i = 0; i < students.length; i++) {
			var student = students[i];
			if(student.name.equals(name)) {
				return student;
			}
		}
		return null;
	}
	
	public static Student searchName(Student[] students, String name, String dept) {
		for(int i = 0; i < students.length; i++) {
			var student = students[i];
			if(student.name.equals(name) && student.dept.equals(dept)) {
				return student;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		var input = new Scanner(System.in);
		var students = inputStudents(input);
		double[] avgs = avg(students);
		for(int i = 0; i < students.length; i++) {
			println(students[i].toString());
			println("Avg: " + avgs[i]);
			println("");
		}
		while(true) {	
			println("1. Search by name");
			println("2. Search by name and department");
			println("3. Search by id");
			println("4. Quit");
			print("What do you want to do?: ");
			int option = input.nextInt();
			input.nextLine();
			Student result = null;
			String name = "";
			switch(option) {
				case 1:
					print("Enter the name to search: ");
					name = input.nextLine();
					result = searchName(students, name);
					break;
				case 2:
					print("Enter the name to search: ");
					name = input.nextLine();
					print("Enter the department to search: ");
					var dept = input.nextLine();
					result = searchName(students, name, dept);
					break;
				case 3:
					print("Enter the id to search: ");
					var id = input.nextLine();
					result = searchID(students, id);
					break;
				case 4:
					return;
			}
			if (result == null) {
				println("No student matches the given info!");
			} else {
				println(result.toString());
			}
		}
	}
}
