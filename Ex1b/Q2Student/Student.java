package Ex1b.Q2Student;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.out;


public class Student {
	public String name;
	public String id;
	public String dept;
	public double[] marks;
	
	public Student(String name, String id, String dept, double mark1, double mark2, double mark3) {
		this.name = name;
		this.id = id;
		this.dept = dept;
		this.marks = new double[]{mark1, mark2, mark3};
	}
	
	public String toString() {
		return "Name: " + name +
		"\nID: " + id + 
		"\nDepartment: " + dept + 
		"\nMarks: " + Arrays.toString(marks);
	}
}

class Main {
	// public static void out.print(String s) {
	// 	System.out.out.print(s);
	// }
	
	// public static void out.println(String s) {
	// 	System.out.out.println(s);
	// }
	
	public static Student[] inputStudents(Scanner input) {
		out.print("Enter the number of students you would like to enter: ");
		int numStudents = input.nextInt();
		input.nextLine();
		var students = new Student[numStudents];
		for(int i = 0; i < numStudents; i++) {
			var initString = "Enter student " + (i + 1) + "'s ";
			out.print(initString + "name: ");
			var name = input.nextLine();
			out.print(initString + "ID: ");
			var id = input.nextLine();
			out.print(initString + "department: "); 
			var dept = input.nextLine();
			out.print(initString + "marks for 3 subjects(separated by space): ");
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
			out.println(students[i].toString());
			out.println("Avg: " + avgs[i]);
			out.println("");
		}
		while(true) {	
			out.println("1. Search by name");
			out.println("2. Search by name and department");
			out.println("3. Search by id");
			out.println("4. Quit");
			out.print("What do you want to do?: ");
			int option = input.nextInt();
			input.nextLine();
			Student result = null;
			String name = "";
			switch(option) {
				case 1:
					out.print("Enter the name to search: ");
					name = input.nextLine();
					result = searchName(students, name);
					break;
				case 2:
					out.print("Enter the name to search: ");
					name = input.nextLine();
					out.print("Enter the department to search: ");
					var dept = input.nextLine();
					result = searchName(students, name, dept);
					break;
				case 3:
					out.print("Enter the id to search: ");
					var id = input.nextLine();
					result = searchID(students, id);
					break;
				case 4:
					return;
			}
			if (result == null) {
				out.println("No student matches the given info!");
			} else {
				out.println(result.toString());
			}
		}
	}
}
