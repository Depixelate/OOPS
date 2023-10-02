package Ex3Inheritance;

class Person {
	// enum Gender {
	//	MALE, FEMALE
	// }
	public Person(int aadhar, String name, String address, char gender) {
		this.aadhar = aadhar; 
		this.name = name; 
		this.address = address; 
		this.gender = gender;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public char getGender() {
		return this.gender;
	}
	
	private int aadhar;
	private String name;
	private String address;
	private char gender;
}

class Student extends Person {
	public Student(int aadhar, String name, String address, char gender, String program, int year, float total) {
		super(aadhar, name, address, gender);
		this.program = program;
		this.year = year;
		this.totalmark = total;
	}
	
	public String getProgram() {
		return this.program;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public float getTotal() {
		return this.totalmark;
	}
	
	public void setTotal(float tot) {
		this.totalmark = tot;
	}
	
	public float calGPA() {
		return this.totalmark / 5 / 100 * 10; // Assuming that total is the total mark for 5 subjects, each out of 100, and GPA is out of 10.
	}
	
	private String program;
	private int year;
	private float totalmark;
}

class Faculty extends Person {
	public Faculty(int aadhar, String name, String address, char gender, String designation, String dept, float pay) {
		super(aadhar, name, address, gender);
		this.designation = designation;
		this.department = dept;
		this.basicpay = pay;
	}
	
	public String getDesig() {
		return this.designation;
	}
	
	public void setDesign(String desig) {
		this.designation = desig;
	}
	
	public float getBasic() {
		return this.basicpay;
	}
	
	public void setBasic(float basic) {
		this.basicpay = basic;
	}
	
	public float calSalary() {
		return calGrossSalary() - calDeductions();
	}
	
	private float calGrossSalary() {
		return this.basicpay + calDA() + calHRA();
	}
	
	private float calDeductions() {
		return calMedicalInsurance() + calPF();
	}
	
	private float calDA() {
		return this.basicpay * 0.6f;
	}
	
	private float calHRA() {
		return this.basicpay * 0.1f;
	}
	
	private float calMedicalInsurance() {
		return this.basicpay * 0.085f;
	}
	
	private float calPF() {
		return this.basicpay * 0.08f;
	}
	
	private String designation;
	private String department;
	private float basicpay;
}

class TestInheritance {

	public TestInheritance() {
		this.student = new Student(1, "Sukessh", "PMO, India", 'M', "CSC", 2022, 400);		
		this.faculty = new Faculty(1, "Deborah", "SSN, India", 'F', "Associate Professor", "CSC", 1000);
	}
	
	
	
	public void testProgram() {		
		assert this.student.getProgram().equals("CSC");
	}
	
	public void testYear() {		
		assert this.student.getYear() == 2022;
	}
	
	public void testTotal() {		
		assert this.student.getTotal() == 400;
	}
	
	public void testGPA() {		
		assert this.student.calGPA() == 8 : this.student.calGPA();
	}
	
	public void testDesig() {
		assert this.faculty.getDesig().equals("Associate Professor");
	}
	
	public void testBasic() {
		assert this.faculty.getBasic() == 1000;
	}
	
	public void testSalary() {
		float salary = this.faculty.calSalary();
		//System.out.println(salary);
		assert salary == 1535 : salary;
	}
	
	private Faculty faculty;
	private Student student;
}

public class Q1Person {
	public static void main(String[] args) {
		var test = new TestInheritance();
		System.out.println("Starting tests...");
		test.testProgram();
		test.testYear();
		test.testTotal();
		test.testGPA();
		test.testDesig();
		test.testBasic();
		test.testSalary();
		System.out.println("All tests done, successful!");
	}
}
