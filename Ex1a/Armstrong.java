package Ex1a;

import java.util.Scanner;

public class Armstrong {
	public static void main(String[] args) {
		var input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int n = input.nextInt();
		var n_str = Integer.toString(n);
		int len = n_str.length();
		int sum = 0;
		for(int i = 0; i < len; i++) {
			int digit = Integer.parseInt("" + n_str.charAt(i));
			sum += Math.pow(digit, len);
		}
		if(sum == n) {
			System.out.println("It is an armstrong number.");
		} else {
			System.out.println("It isn't an armstrong number.");
		}
	}
}
