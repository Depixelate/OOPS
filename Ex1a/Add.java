package Ex1a;
import java.util.Scanner;

public class Add {
	public static void main(String[] args) {
		var input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		double a = input.nextDouble();
		System.out.print("Enter another number: ");
		double b = input.nextDouble();
		double sum = a + b;
		System.out.println("The total sum is = " + sum);
	}
}
		
