package maths;
import java.util.Scanner;

import maths.operations.*;
public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void printf(String fmt, Object... args) {
        System.out.printf(fmt, args);
    }
    public static void printfn(String fmt, Object... args) {
        printf(fmt + "\n", args);
    }

    public static double readNum() {
        printf("Enter a number: ");
        return Double.parseDouble(sc.nextLine());
    }

    public static void main(String[] args) {
        printfn("1. Add");
        printfn("2. Subtract");
        printfn("3. Multiply");
        printf("What do you want to do: ");
        int option = Integer.parseInt(sc.nextLine());
        Operation m;
        double a = readNum(), b = readNum();
        switch (option) {
            case 1:
                m = new Addition(a, b);
                break;
            case 2:
                m = new Subtraction(a, b);
                break;
            default:
                m = new Multiplication(a, b);
                break;
        }
        printfn("Result: %s", m.operate());
    }
}
