abstract class Shape {
	public Shape(String color) {
		this.color = color;
	}
	public Shape() {
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	abstract public float getArea();
	
	abstract public float getPerimeter();
	
	protected String color = "red";
}

class Circle extends Shape {
	public Circle() {
	}
	
	public Circle(float radius) {
		this.radius = radius;
	}
	
	public Circle(float radius, String color) {
		super(color);
		this(radius);
	}
	
	public float getRadius() {
		return this.radius;
	}
	
	public void setRadius(float radius) {
		this.radius = radius;
	}
	
	public float getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public float getPerimeter() {
		return 2 * Math.PI * radius;
	}	
	
	protected float radius = 1.0f;
}

class Rectangle extends Shape {
	public Rectangle() {}
	
	public Rectangle(float width, float length) {
		this.width = width;
		this.length = length;
	}
	
	public Rectangle (float width, float length, String color) {
		super(color);
		this(width, length);
	}
	
	public float getWidth() {
		return this.width;
	}
	
	public void setWidth(float width) {
		this.width = width;
	}
	
	public float getLength() {
		return this.length;
	}
	
	public void setLength(float length) {
		this.length = length;
	}
	
	public float getArea() {
		return width * length;
	}
	
	public float getPerimeter() {
		return 2 * (width + height);
	}
	
	protected float width = 1.0;
	protected float height = 1.0;
}

class Square extends Rectange {
	public Square() {}
	public Square(float side) {
		super(side, side);
	}
	
	public Square(float side, String color) {
		super(side, side, color);
	}
	
	public float getSide() {
		return this.width;
	}
	
	public void setSide(float side) {
		this.width = side;
		this.height = side;
	}
	
}

class TestShape {

	public TestShape() {
		shapes = new Shape[3];
		shapes[0] = new Circle(2, "green");
		shapes[1] = new Rectangle(3, 4, "blue");
		shapes[2] = new Square(5, "orange");
	}
	
	public void testColor() {
		String[] expected = {"green", "blue", "orange"};
		for(int i = 0; i < shapes.length; i++) {
			assert shapes[i].getColor().equals(expected[i]) : "getColor failed: " + shapes[i].getColor();
			shapes[i].setColor("mauve");
		}
		
		for(int i = 0; i < shapes.length; i++) {
			assert shapes[i].getColor().equals("mauve") : "setColor failed: " + shapes[i].getColor();
			//shapes[i].setColor("mauve");
		}	
	}
	
	public void testArea() {
		float[] expected = {Math.PI * 4, 12, 25};
		for(int i = 0; i < shapes.length; i++) {
			float area = shapes[i].getArea();
			System.out.println(String.format("Shape %d Area: %f", i, area)); 
			assert area == expected[i] : area;
		}
	}
	
	public void testPerimeter() {
		float[] expected = {Math.PI * 4, 14, 20};
		for(int i = 0; i < shapes.length; i++) {
			float perimeter = shapes[i].getPerimeter();
			System.out.println(String.format("Shape %d Perimeter: %f", i, perimeter)); 
			assert perimeter == expected[i] : perimeter;
		}
	}
	
	public void testRadius() {
		Circle c = (Circle)shapes[0];
		assert c.getRadius() == 2 : "getRadius failed: " + c.getRadius();
		c.setRadius(5);
		assert c.getRadius() == 5 : "setRadius failed: " + c.getRadius();
	}
	
	public void testWidth() {
		Rectangle r = (Rectangle)shapes[1];
		assert r.getWidth() == 3 : "getWidth failed: " + r.getWidth();
		r.setWidth(5);
		assert r.getWidth() == 5 : "setWidth failed: " + r.getWidth();
	}
	
	public void testSide() {
		Square s = (Square)shapes[2];
		assert s.getSide() == 5 : "getSide failed: " + s.getSide();
		s.setSide(6);
		assert s.getSide() == 6 : "setSide failed: " + s.getSide();
	}
	
	public void testLength() {
		Rectangle r = (Rectangle)shapes[1];
		assert r.getLength() == 4 : "getLength failed: " + r.getLength();
		r.setLength(5);
		assert r.getLength() == 5 : "setLength failed: " + r.getLength();
	}
	
	private Shape[] shapes;
}

public class Q2Shape {
	public static void main(String[] args) {
		var test = new TestShape();
		System.out.println("Starting tests...");
		test.testColor();
		test.testArea();
		test.testPerimeter();
		test.testRadius();
		test.testWidth();
		test.testLength();
		test.testSide();
		System.out.println("All tests done, successful!");
	}
}
