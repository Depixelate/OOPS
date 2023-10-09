package Utils;

import static java.lang.System.out;
import java.util.Scanner;

public class Input {
    public final static Scanner sc = new Scanner(System.in);

    public static printf(String format, Object... args) {
        out.printf(format, args);
    }

    public static int readInt(String format, Object... args) {
        out.printf(format, args);
        return Integer.parseInt(sc.nextLine());
    }

    public static long readLong(String format, Object... args) {
        out.printf(format, args);
        return Long.parseLong(sc.nextLine());
    }

    public static double readDouble(String format, Object... args) {
        out.printf(format, args);
        return Double.parseDouble(sc.nextLine());
    }

    public static float readFloat(String format, Object... args) {
        out.printf(format, args);
        return Float.parseFloat(sc.nextLine());
    }

    public static String readString(String format, Object... args) {
        out.printf(format, args);
        return sc.nextLine();
    }

    
}