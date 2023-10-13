package Ex2;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        var sb = new StringBuilder(s);
        sb.reverse();
        var sRev = sb.toString();
        if(sRev.equalsIgnoreCase(s)) {
            System.out.println("It is a palindrome.");
        } else {
            System.out.println("Not a palindrome.");
        }
        sc.close();
    }
}