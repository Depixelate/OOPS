package Ex4Abstract;

import java.util.Arrays;
import static java.lang.System.out;

import static Utils.Input.*;

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


class TestDriver {
    public static void main(String[] args) {
        out.printf("Welcome to the test!\n");
        var facName = readString("Enter faculty name: ");
        var facAddr = readString("Enter faculty address: ");
        var facId = readString("Enter faculty id: ");
        var facDept = readString("Enter faculty dept: ");
        var facBasic = readInt("Enter faculty basic salary: ");
        var facDesig = readString("Enter faculty designation: ");
        var facCourse = readString("Enter faculty course: ");
        var fac = new Faculty(facName, facAddr, facId, facDept, facBasic, facDesig, facCourse);
        out.printf("Faculty:\n");
        out.printf("Name: %s, Address: %s, EmpId: %s, Dept: %s, Basic Salary: %d, Salary: %f, Designation: %s, Course: %s\n", fac.getName(), fac.getAddress(), fac.getEmpid(), fac.getDept(), fac.getBasic(), fac.calSalary(), fac.getDesig(), fac.getCourse());
        
        var taName = readString("Enter TA name: ");
        var taAddr = readString("Enter TA address: ");
        var taId = readString("Enter TA id: ");
        var taDept = readString("Enter TA dept: ");
        var taBasic = readInt("Enter TA basic salary: ");
        var taProject = readString("Enter TA project: ");
        var taCourse = readString("Enter TA course: ");
        String taMarksStr = readString("Enter space separated TA marks: ");
        String[] taMarkStrs = taMarksStr.split(" ");
        float[] taMarks = new float[taMarkStrs.length];
        for(int i = 0; i < taMarkStrs.length; i++) {
            taMarks[i] = Float.parseFloat(taMarkStrs[i]);
        }
        var ta = new TeachingAssistant(taName, taAddr, taId, taDept, taBasic, taProject, taCourse, taMarks);
        out.printf("TA:\n");
        out.printf("Name: %s, Address: %s, EmpId: %s, Dept: %s, Basic Salary: %d, Salary: %f, Project: %s, Course: %s, Marks: %s, GPA: %f\n", ta.getName(), ta.getAddress(), ta.getEmpid(), ta.getDept(), ta.getBasic(), ta.calSalary(), ta.getProject(), ta.getCourse(), Arrays.toString(ta.getMarks()), ta.calcGPA());
    }
}


