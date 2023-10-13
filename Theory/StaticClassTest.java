package Theory;
import static Utils.Input.printf;

class ClassToLoad {
    public int numMarks = 0;
    public static int marks = 0;
    public ClassToLoad() {
        printf("In default constructor!\n");
    }
    public ClassToLoad(int marks) {
        numMarks = 0;
        printf("In parametered constructor!\n");
    }
    public void printMarks() {
        printf("Marks: %d\n", numMarks);
    }
    static {
        printf("Class Loaded!\n");
        marks = 5;
    }

    public static void doAThing() {
        printf("Thing done!\n");
    }
}

public class StaticClassTest {
    public static void main(String[] args) {
        printf("Value of ClassToLoad.numMarks stuff=%d\n", ClassToLoad.marks);
    }
}
