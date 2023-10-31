package maths.operations;

abstract public class Operation {
    protected double a;
    protected double b;
    public Operation(double a, double b) {
        this.a = a;
        this.b = b;
    }

    abstract public double operate();
}
