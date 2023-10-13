package Ex1a;
import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		var input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = input.nextInt();
		int fac_num = 1;
		for(int i = 1; i <= num; i++) {
			fac_num *= i;
		}
		System.out.println(num + "! = " + fac_num);
	}
}

