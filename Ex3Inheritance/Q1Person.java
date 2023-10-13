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
		float pf = basicpay * 0.08f;
		float medicalInsurance = basicpay * 0.085f;
		float hra = basicpay * 0.1f;
		float da = basicpay * 0.6f;
		float deductions = medicalInsurance + pf;
		float grossSalary = basicpay + da + hra;
		return grossSalary - deductions;
	}
	
	private String designation;
	private String department;
	private float basicpay;
}

class TestInheritance {
	public static void main(String[] args) {
		System.out.println("Starting tests...");
		var student = new Student(1, "Sukessh", "PMO, India", 'M', "CSC", 2022, 400);		
		var faculty = new Faculty(1, "Deborah", "SSN, India", 'F', "Associate Professor", "CSC", 1000);
		System.out.println("Testing student.getProgram()...");		
		assert student.getProgram().equals("CSC");
		System.out.println("Testing student.getYear()...");		
		assert student.getYear() == 2022;
		System.out.println("Testing student.getTotal()...");
		assert student.getTotal() == 400;
		System.out.println("Testing student.calGPA()...");
		assert student.calGPA() == 8 : student.calGPA();
		System.out.println("Testing faculty.getDesig()...");
		assert faculty.getDesig().equals("Associate Professor");
		System.out.println("Testing faculty.getBasic()...");
		assert faculty.getBasic() == 1000;
		float salary = faculty.calSalary();
		//System.out.println(salary);
		System.out.println("Testing faculty.calSalary()...");
		assert salary == 1535 : salary;
		System.out.println("All tests done, successful!");
	}
}
