package Ex4Abstract;

import java.util.Arrays;

class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

abstract class Employee extends Person {
    private String empid;
    private String dept;
    private int basic;

    public Employee(String name, String address, String empid, String dept, int basic) {
        super(name, address);
        this.empid = empid;
        this.dept = dept;
        this.basic = basic;
    }

    public int getEmpid() {
        return Integer.parseInt(empid);
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getBasic() {
        return basic;
    }

    public void setBasic(int basic) {
        this.basic = basic;
    }

    abstract public float calSalary();
}

class Faculty extends Employee {
    private String designation;
    private String course;
    public Faculty(String name, String address, String empid, String dept, int basic, String desig, String course) {
        super(name, address, empid, dept, basic);
        designation = desig;
        this.course = course;
    }

    public String getDesig() {
        return designation;
    }

    public void setDesig(String desig) {
        designation = desig;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public float calSalary() {
        return 100000.0f;
    }

}

interface Student {
    float[] getMarks();
    float calcGPA();
}

class TeachingAssistant extends Employee implements Student {
    private String project;
    private String course;
    private float[] marks;

    public TeachingAssistant(String name, String address, String empid, String dept, int basic, String project, String course, float[] marks) {
        super(name, address, empid, dept, basic);
        this.project = project;
        this.course = course;
        this.marks = marks;
    }

    public String getProject() {
        return project;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public float[] getMarks() {
        return marks;
    }

    public float calcGPA() {
        float avg_mark = 0;
        for(var mark : marks) {
            avg_mark += mark;
        }

        avg_mark /= marks.length;

        return avg_mark / 100 * 10;
    }

    public float calSalary() {
        return 50000;
    }
}

// class TestDriver {
//     public Test() {

//     }
// }


public class Q1Person {
    public static void main(String[] args) {

    }
}


