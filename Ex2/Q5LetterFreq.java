package Ex2;
import java.util.Scanner;
import java.util.HashMap;

public class Q5LetterFreq {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        s = s.toLowerCase();
        var map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        boolean isParagram = true;
        for(char c = 'a'; c <= 'z'; c++) {
            if(!map.containsKey(c)) {
                isParagram = false;
                break;
            }
        }
        if(isParagram) {
            System.out.println("The String is a paragram.");
        } else {
            System.out.println("The String isn't a paragram.");
        }
        for(char c = 'a'; c <= 'z'; c++) {
            
            System.out.println(String.format("%c: %d", c, map.getOrDefault(c, 0)));
        }
        sc.close();
    }
}
