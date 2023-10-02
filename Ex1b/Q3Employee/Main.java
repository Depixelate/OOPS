package Ex1b.Q3Employee;

import java.util.Scanner;

public class Main {

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
			String desgnStr = sc.nextLine().toUpperCase().replace(" ", "_");
			Employee.Designation designation = Employee.Designation.valueOf(desgnStr);
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
