import java.util.Scanner;
import java.util.Arrays;

public class Intro {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int size=0; 
        System.out.print("Enter the amount of numbers you would like to enter: ");
        size = sc.nextInt();
        sc.nextLine();
        var nums = new double[size];
        double sum = 0;
        for(int i = 0; i < size; i++) {
            System.out.print("Enter a number: ");
            nums[i] = sc.nextDouble();
            sum += nums[i];
            sc.nextLine();
        }
        System.out.print("The numbers: ");
        System.out.println(Arrays.toString(nums));
        System.out.print("Their sum: ");
        System.out.println(sum);
        sc.close();
    }
}