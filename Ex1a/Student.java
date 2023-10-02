package Ex1a;

import java.util.Arrays;

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
