package Ex8Collections;
import java.util.Arrays;
import java.util.ArrayList;

class StringList {
    private ArrayList<String> strings;
    public StringList(String... strings) {
        this.strings = new ArrayList<String>(Arrays.asList(strings););
    }
    
}

class Main {
    public static void main(String[] args) {
        var l = new StringList();
    }
}
