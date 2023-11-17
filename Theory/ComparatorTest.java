package Theory;
import java.util.ArrayList;
import java.util.Comparator;

class Student  {
    public String id;
    public String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
    // //@Override
    // public int compareTo(Student other) {
    //     return id.compareTo(other.id); 
    // }
    
    @Override
    public String toString() {
        return String.format("{id: %s, name: %s}", id, name);
    }
}

public class ComparatorTest {
    public static void main(String[] args) {
        ArrayList<Student> studs = new ArrayList<>();
        studs.add(new Student("1", "Shyaam"));
        studs.add(new Student("3", "Ram"));
        studs.add(new Student("2", "Bomb"));
        studs.sort(new Comparator<Student>()  {
            public int compare(Student a, Student b) {
                return a.id.compareTo(b.id);
            }
        });
        System.out.println(studs);
    }
}
