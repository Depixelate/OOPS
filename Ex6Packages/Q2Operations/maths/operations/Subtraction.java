package maths.operations;

public class Subtraction extends Operation {
    public Subtraction(double a, double b) {
        super(a, b);
    }

    public double operate() {
        return a - b;
    }
}
