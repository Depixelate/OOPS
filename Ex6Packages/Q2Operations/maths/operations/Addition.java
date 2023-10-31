package maths.operations;

public class Addition extends Operation {
    public Addition(double a, double b) {
        super(a, b);
    }

    public double operate() {
        return a + b;
    }
}
