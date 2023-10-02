package Ex2;
import java.util.Scanner;

public class Q3LongWord {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.print("Enter some text: ");
        String text = sc.nextLine();
        String[] words = text.replaceAll("[.?,!:;]", " ").split(" ");
        String longestWord = "";
        for(String word : words) {
            if(word.replace("'", "").length() > longestWord.replace("'", "").length()) {
                longestWord = word;
            }
        }

        int longestWordIndex = text.indexOf(longestWord);
        System.out.println(String.format("The longest word in the sentence is \"%s\", at index %d", longestWord, longestWordIndex));
        sc.close();
    }
}
