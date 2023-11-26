package Ex8Collections;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.lang.reflect.Method;
import java.util.Scanner;

class StringList {
    private ArrayList<String> strings;
    public StringList(String... strings) {
        this.strings = new ArrayList<String>(Arrays.asList(strings));
    }
    public void append(String elem) {
        this.strings.add(elem);
    }

    public void insert(int index, String elem) {
        this.strings.add(index, elem);
    }

    public int search(String elem) {
        return strings.indexOf(elem);
    }

    public void display() {
        System.out.println("The strings: " + strings);
    }

    public void displayIfStartsWithChar(char startChar) {
        new StringList(
            strings.stream()
            .filter(elem -> elem.startsWith("" + startChar))
            .toArray(String[]::new)).display();
    }

    public void displayIfContainsSubstr(String substr) {
        new StringList(
            strings.stream()
            .filter(elem->elem.contains(substr))
            .toArray(String[]::new)).display();
    }
    
    public void sort() {
        strings.sort(null);
    }

    public void remove(String elem) {
        strings.remove(elem);
    }

    public void replace(String e1, String e2) {
        strings.replaceAll(elem -> (elem.equals(e1) ? e2 : elem));
    }

    public void removeDuplicates() {
        strings = new ArrayList<String>(new LinkedHashSet<String>(strings));
    }

    // @Override
    // public String toString() {
    //     return strings.toString();
    // }
}

class Main {

    public static String splitCamelCase(String camelCaseName) {
        String regex = "(?=[A-Z])";
        var res = camelCaseName.split(regex);
        res[0] = Character.toUpperCase(res[0].charAt(0)) + res[0].substring(1);
        return String.join(" ", res);
    }

    public static void printf(String fmt, Object... objs) {
        System.out.printf(fmt, objs);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringList s = new StringList();
        printf("Welcome to the Menu-Driven String List Program!\n");
        printf("What would you like to do?\n");
        Class collectionClass = StringList.class;
        var methods = Arrays.stream(collectionClass.getDeclaredMethods()).filter(method->!method.isSynthetic()).toArray(Method[]::new);
        for(int i = 1; i <= methods.length; i++) {
            printf("%d. %s\n", i, splitCamelCase(methods[i].getName()));
        }
        printf("Enter your option: ");
        s
        // printf(Arrays.toString(splitCamelCase("helloMoto")));
    }
}
