package Ex1b.Q3Employee;

public class Employee {

	public static final double HOURLY_WAGE = 300;
	
	enum Designation 
	{
		INTERN, MANAGER, TRAINEE, ANALYST, SOFTWARE_ENGINEER, TEAM_LEAD
	}
	
	public Employee(String name, String id, Designation designation, int yearsExp, double basePay, double lic, int hoursWorked) {
		this.name = name;
		this.id = id;
		this.designation = designation;
		this.yearsExp = yearsExp;
		this.basePay = basePay;
		this.da = calcDa();
		this.hra = calcHra();
		this.lic = lic;
		this.pf = calcPf();
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
	
	public double calcDa() {
		switch(designation) {
			case INTERN:
				return 2000;
			
			case MANAGER:
				return 0.4 * basePay;
			
			default:
				return 0.3 * basePay;
		}
	}
	
	public double calcHra() {
		switch(designation) {
			case INTERN:
				return 1000;
			default:
				return 0.1 * basePay;
		}
	}
	
	public double calcPf() {
		switch(designation) {
			case INTERN:
				return 500;
			default:
				return 0.08 * basePay;
		}
	}
		
	public double calcGrossPay() {
		if(designation == Designation.INTERN) {
			return hoursWorked * HOURLY_WAGE + da + hra;	
		}
		
		return basePay + da + hra;
	}
	
	public double calcDeductions() {
		return lic + pf;
	}
	
	public double calcNetPay() {
		return calcGrossPay() - calcDeductions();
	}
	
	public String payslip() {
		double grossPay = calcGrossPay();
		double deductions = calcDeductions();
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
		double grossPay = calcGrossPay(), deductions = calcDeductions(), netPay = calcNetPay();
		return rightPad(id, colWidth) + rightPad(name, colWidth) + formatSal(basePay, colWidth) + formatSal(grossPay, colWidth) + formatSal(deductions, colWidth) + formatSal(netPay, colWidth); 
	}
	
	private String rightPad(String str, int width) {
		return String.format("%" + width + "s", str);
	}
	
	private String formatSal(double sal, int width) {
		return rightPad(String.format("%.2f", sal), width);
	}
	
	private String name;
	private String id;
	private Designation designation;
	private int yearsExp;
	private double basePay;
	private double da;
	private double hra;
	private double lic;
	private double pf;
	private int hoursWorked;
}
