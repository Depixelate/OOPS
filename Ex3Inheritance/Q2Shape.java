package Ex3Inheritance;

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
		this.color = color;
		this.radius = radius;
	}
	
	public float getRadius() {
		return this.radius;
	}
	
	public void setRadius(float radius) {
		this.radius = radius;
	}
	
	public float getArea() {
		return (float)(Math.PI * Math.pow(radius, 2));
	}
	
	public float getPerimeter() {
		return (float) (2 * Math.PI * radius);
	}
	
	public String toString() {
		return String.format("Circle(col=%s,rad=%f)", this.color, this.radius);
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
		this(width, length);
		this.color = color;
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

	public String toString() {
		return String.format("Rectangle(col=%s,width=%f,length=%f)", this.color, this.width, this.length);
	}
	
	public float getPerimeter() {
		return 2 * (width + length);
	}
	
	protected float width = 1.0f;
	protected float length = 1.0f;
}

class Square extends Rectangle {
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
		this.length = side;
	}

	public String toString() {
		return String.format("Square(col=%s,side = %f)", this.color, this.width);
	}
	
}

class TestShape {

	public static void main(String[] args) {
		System.out.println("Starting tests...");
		var shapes = new Shape[3];
		shapes[0] = new Circle(2, "green");
		shapes[1] = new Rectangle(3, 4, "blue");
		shapes[2] = new Square(5, "orange");
		String[] expected = {"green", "blue", "orange"};
		for(int i = 0; i < shapes.length; i++) {
			System.out.println(String.format("Testing getColor() of %s", shapes[i]));
			assert shapes[i].getColor().equals(expected[i]) : "getColor failed: " + shapes[i].getColor();
			shapes[i].setColor("mauve");
		}
		
		for(int i = 0; i < shapes.length; i++) {
			System.out.println(String.format("Testing setColor(color) of %s", shapes[i]));
			assert shapes[i].getColor().equals("mauve") : "setColor failed: " + shapes[i].getColor();
			//shapes[i].setColor("mauve");
		}
		float[] expected2 = {(float)(Math.PI * 4), 12, 25};
		for(int i = 0; i < shapes.length; i++) {
			System.out.println(String.format("Testing getArea() of %s", shapes[i]));
			float area = shapes[i].getArea();
			System.out.println(String.format("%s Area: %f", shapes[i], area)); 
			assert area == expected2[i] : area;
		}

		float[] expected3 = {(float)(Math.PI * 4), 14, 20};
		for(int i = 0; i < shapes.length; i++) {
			System.out.println(String.format("Testing getPerimeter() of %s", shapes[i]));
			float perimeter = shapes[i].getPerimeter();
			System.out.println(String.format("%s Perimeter: %f", shapes[i], perimeter)); 
			assert perimeter == expected3[i] : perimeter;
		}

		Circle c = (Circle)shapes[0];
		System.out.println(String.format("Testing getRadius() of %s", c));
		assert c.getRadius() == 2 : "getRadius failed: " + c.getRadius();
		c.setRadius(5);
		System.out.println(String.format("Testing setRadius(radius) of %s", c));

		assert c.getRadius() == 5 : "setRadius failed: " + c.getRadius();
		Rectangle r = (Rectangle)shapes[1];
		System.out.println(String.format("Testing getWidth() of %s", r));
		assert r.getWidth() == 3 : "getWidth failed: " + r.getWidth();
		r.setWidth(5);
		System.out.println(String.format("Testing setWidth(width) of %s", r));
		assert r.getWidth() == 5 : "setWidth failed: " + r.getWidth();

		Square s = (Square)shapes[2];
		System.out.println(String.format("Testing getSide() of %s", s));
		assert s.getSide() == 5 : "getSide failed: " + s.getSide();
		s.setSide(6);
		System.out.println(String.format("Testing setSide(width) of %s", s));
		assert s.getSide() == 6 : "setSide failed: " + s.getSide();

		Rectangle r2 = (Rectangle)shapes[1];
		System.out.println(String.format("Testing getLength() of %s", r2));
		assert r2.getLength() == 4 : "getLength failed: " + r2.getLength();
		r2.setLength(5);
		System.out.println(String.format("Testing setLength() of %s", r2));
		assert r2.getLength() == 5 : "setLength failed: " + r2.getLength();
		
		System.out.println("All tests done, successful!");
	}
}


