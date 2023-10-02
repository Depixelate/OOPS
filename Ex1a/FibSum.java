package Ex1a;

import java.util.Scanner;

public class FibSum {

	public static void main(String[] args) {
		var input = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = input.nextInt();
		int a = 0, b = 1, sum = 0;
		var sum_str = "";
		for(int i = 0; i < n; i++) {
			sum += a;
			sum_str += a + " + ";
			int next_fib = a + b;
			a = b;
			b = next_fib;
		}
		
		int last_plus_index = sum_str.lastIndexOf('+');
		if (last_plus_index < 0) {
			sum_str = "0";
		} else {
			sum_str = sum_str.substring(0, last_plus_index-1); // Don't include the space after the plus sign.
		System.out.println("The sum of the first " + n + " fibonacci numbers = " + sum_str + " = " + sum);
		}
	}
}
		
