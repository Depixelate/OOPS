package Ex7Generics;
import java.util.ArrayList;

abstract class Shape {
    public abstract double getArea();
}

class Circle extends Shape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return String.format("Circle(radius=%f)", radius);
    }
}

class Rectangle extends Shape {
    private double length;
    private double breadth;
    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double getArea() {
        return length * breadth;
    }

    @Override
    public String toString() {
        return String.format("Rectangle(length=%f, breadth=%f)", length, breadth);
    }
}

class Triangle extends Shape {
    private double s1, s2, s3;
    public Triangle(double s1, double s2, double s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    @Override
    public double getArea() {
        double semiperimeter = (s1 + s2 + s3)/2;
        double S = semiperimeter;
        double area = Math.sqrt(S * (S-s1) * (S-s2) * (S-s3));
        return area;
    }

    @Override
    public String toString() {
        return String.format("Triangle(s1=%f,s2=%f,s3=%f)", s1, s2, s3);
    }
}


class ShapeBox<T extends Shape> {
    private ArrayList<T> shapes;
    public ShapeBox() {
        shapes = new ArrayList<>();
    }
    public void add(T shape) {
        shapes.add(shape);
    }

    public double totalArea() {
        double area = 0;
        for(var shape: shapes) {
            area += shape.getArea();
        }
        return area;
    }

    public String toString() {
        return shapes.toString();
    }
}

class Main {
    public static void main(String[] args) {
        var sbC = new ShapeBox<Circle>();
        System.out.println("Created ShapeBox<Circle>...");
        var sbR = new ShapeBox<Rectangle>();
        System.out.println("Created ShapeBox<Rectangle>...");
        var sbT = new ShapeBox<Triangle>();
        System.out.println("Created ShapeBox<Triangle>...");

        System.out.println();

        System.out.println(String.format("Current Circle ShapeBox: %s, Current Area = %f", sbC, sbC.totalArea()));
        System.out.println(String.format("Current Rectangle ShapeBox: %s, Current Area = %f", sbR, sbR.totalArea()));
        System.out.println(String.format("Current Triangle ShapeBox: %s, Current Area = %f", sbT, sbT.totalArea()));

        sbC.add(new Circle(1));
        sbR.add(new Rectangle(2, 3));
        sbT.add(new Triangle(3, 4, 5));

        System.out.println();

        System.out.println("Adding elements to the shapeboxes...");

        System.out.println();

        System.out.println(String.format("Current Circle ShapeBox: %s, Current Area = %f", sbC, sbC.totalArea()));
        System.out.println(String.format("Current Rectangle ShapeBox: %s, Current Area = %f", sbR, sbR.totalArea()));
        System.out.println(String.format("Current Triangle ShapeBox: %s, Current Area = %f", sbT, sbT.totalArea()));

        sbC.add(new Circle(2));
        sbR.add(new Rectangle(7, 1));
        sbT.add(new Triangle(3, 3, 3));

        System.out.println();

        System.out.println("Adding elements to the shapeboxes...");

        System.out.println();

        System.out.println(String.format("Current Circle ShapeBox: %s, Current Area = %f", sbC, sbC.totalArea()));
        System.out.println(String.format("Current Rectangle ShapeBox: %s, Current Area = %f", sbR, sbR.totalArea()));
        System.out.println(String.format("Current Triangle ShapeBox: %s, Current Area = %f", sbT, sbT.totalArea()));
        
    }
}
