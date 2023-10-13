package Ex1b.Q3Employee;

import java.util.Scanner;

import java.util.function.BiFunction;

public class Employee {

	public static final double HOURLY_WAGE = 300;
	
	// enum Designation 
	// {
	// 	INTERN, MANAGER, TRAINEE, ANALYST, SOFTWARE_ENGINEER, TEAM_LEAD
	// }
	
	public Employee(String name, String id, String designation, int yearsExp, double basePay, double lic, int hoursWorked) {
		this.name = name;
		this.id = id;
		this.designation = designation;
		this.yearsExp = yearsExp;
		this.basePay = basePay;
		switch(designation.toUpperCase()) {
			case "INTERN":
				da = 2000;
				break;
			case "MANAGER":
				da = 0.4 * basePay;
				break;
			default:
				da = 0.3 * basePay;
				break;
		}
		this.hra = designation.equalsIgnoreCase("INTERN") ? 1000 : 0.1 * basePay;
		this.lic = lic;
		this.pf = designation.equalsIgnoreCase("INTERN") ? 500 : 0.08 * basePay;
		this.hoursWorked = hoursWorked;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getYearsExp() {
		return yearsExp;
	}
		
	public double calcGrossPay() {
		if(designation.equalsIgnoreCase("INTERN")) {
			return hoursWorked * HOURLY_WAGE + da + hra;	
		}
		return basePay + da + hra;
	}
	
	public double calcNetPay() {
		return calcGrossPay() - lic - pf;
	}
	
	public String payslip() {
		double grossPay = calcGrossPay();
		double deductions = lic + pf;
		double netPay = calcNetPay();
		String formatString = "General Information:\n"
			+ "\n" 
			+ "Name: %s\n"
			+ "ID: %s\n"
			+ "Designation: %s\n"
			+ "Years Of Experience: %d\n"
			+ "Hours Worked: %d\n"
			+ "\n"
			+ "Salary Information:\n"
			+ "\n"
			+ "Base Pay: %f\n"
			+ "DA: %f\n"
			+ "HRA: %f\n"
			+ "LIC: %f\n"
			+ "PF: %f\n"
			+ "Gross Pay: %f\n"
			+ "Deductions: %f\n"
			+ "Net Pay: %f\n";
		
		return String.format(formatString, name, id, designation.toString(), yearsExp, hoursWorked, basePay, da, hra, lic, pf, grossPay, deductions, netPay);
	}
	
	public String payrollRow(int colWidth) {
		BiFunction<String, Integer, String> rightPad = (String str, Integer width) -> String.format("%" + width + "s", str);
		BiFunction<Double, Integer, String> formatSal = (Double sal, Integer width) -> rightPad.apply(String.format("%.2f", sal), width);
		double grossPay = calcGrossPay(), deductions = lic + pf, netPay = calcNetPay();
		return rightPad.apply(id, colWidth) + rightPad.apply(name, colWidth) + formatSal.apply(basePay, colWidth) + formatSal.apply(grossPay, colWidth) + formatSal.apply(deductions, colWidth) + formatSal.apply(netPay, colWidth); 
	}
	
	// private String rightPad(String str, int width) {
	// 	return String.format("%" + width + "s", str);
	// }
	
	// private String formatSal(double sal, int width) {
	// 	return rightPad(String.format("%.2f", sal), width);
	// }
	
	private String name;
	private String id;
	private String designation;
	private int yearsExp;
	private double basePay;
	private double da;
	private double hra;
	private double lic;
	private double pf;
	private int hoursWorked;
}

class Main {

	public static void print(Object obj) {
		System.out.print(obj);
	}
	
	public static void println(Object obj) {
		System.out.println(obj);
	}
	
	public static Employee search(Employee[] emps, String id) {
		for(Employee emp: emps) {
			if (emp.getId().equalsIgnoreCase(id)) {
				return emp;
			}
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		print("Enter how many employees you would like to enter details of: ");
		int n = Integer.parseInt(sc.nextLine());
		var emps = new Employee[n];
		for(int i = 0; i < n; i++) {
			println(String.format("=============EMPLOYEE %d=========", i+1));
			print("Enter name: ");
			String name = sc.nextLine();
			print("Enter id: ");
			String id = sc.nextLine();
			print("Enter designation: ");
			String designation = sc.nextLine().toUpperCase();
			print("Enter years of experience: ");
			int yearsExp = Integer.parseInt(sc.nextLine());
			print("Enter base pay: ");
			double basePay = Double.parseDouble(sc.nextLine());
			print("Enter LIC amount: ");
			double lic = Double.parseDouble(sc.nextLine());
			print("Enter total no. hours worked: ");
			int hoursWorked = Integer.parseInt(sc.nextLine());
			emps[i] = new Employee(name, id, designation, yearsExp, basePay, lic, hoursWorked);
		}
		println("");
		println("==============PAYROLL===============");
		println("");
		println(String.format("%15s%15s%15s%15s%15s%15s", "ID", "NAME", "BASE PAY", "GROSS PAY", "DEDUCTIONS", "NET PAY"));
		for(var emp : emps) {
			println(emp.payrollRow(15));
		}
		while(true) {
			print("Enter the employee id to search for, or q to quit this section: ");
			var id = sc.nextLine();
			if (id.equalsIgnoreCase("q")) {
				break;
			}
			
			Employee result = search(emps, id);
			if (result == null) {
				println("No employee with that id was found.");
				continue;
			} 
			println("");
			println(result.payslip());
			println("");
		}
		
		for(var emp : emps) {
			if(emp.getYearsExp() >= 10) {
				println(String.format("Employee ID = %s(%s) is eligible for a promotion.", emp.getId(), emp.getName()));
			}
		}
		
		sc.close();
	}
}

