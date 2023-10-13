package Ex2;

import java.util.Scanner;

class Matrix {
    public double[][] elems;
    public Matrix(int m, int n) {
        elems = new double[m][n];
    }

    public Matrix mult(Matrix b) {
        Matrix c = new Matrix(this.elems.length, b.elems[0].length);
        for(int i = 0; i < this.elems.length; i++) {
            for(int j = 0; j < b.elems[0].length; j++) {
                double sum = 0;
                for(int k = 0; k < b.elems.length; k++) {
                    sum += this.elems[i][k] * b.elems[k][j];
                }
                c.elems[i][j] = sum;
            }
        }

        return c;
    }

    public Matrix add(Matrix b) {
        Matrix c = new Matrix(this.elems.length, this.elems[0].length);
        for(int i = 0; i < elems.length; i++) {
            for(int j = 0; j < elems[0].length; j++) {
                c.elems[i][j] = elems[i][j] + b.elems[i][j];
            }
        }

        return c;
    }



    public Matrix sub(Matrix b) {
        Matrix c = new Matrix(this.elems.length, this.elems[0].length);
        for(int i = 0; i < elems.length; i++) {
            for(int j = 0; j < elems[0].length; j++) {
                c.elems[i][j] = elems[i][j] - b.elems[i][j];
            }
        }

        return c;
    }

    public String toString() {
        String s = "";
        for(int i = 0; i < elems.length; i++) {
            for(int j = 0; j < elems[0].length; j++) {
                s += String.format("%8.2f ", elems[i][j]);
            }
            s += "\n";
        }

        return s;
    }
}

class Main {
    public static void print(Object obj) {
        System.out.print(obj);
    }

    public static void fillMat(Matrix m, String name, Scanner sc) {
        for(int i = 0; i < m.elems.length; i++) {
            for(int j = 0; j < m.elems[0].length; j++) {
                print(String.format("Enter %s%d%d: ", name, i, j));
                m.elems[i][j] = Double.parseDouble(sc.nextLine());
            }
        }
    }
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        print("Enter n: ");
        int n = Integer.parseInt(sc.nextLine());
        Matrix a = new Matrix(n, n);
        Matrix b = new Matrix(n, n);

        fillMat(a, "A", sc);
        fillMat(b, "B", sc);

        Matrix c1 = a.add(b), c2 = a.sub(b), c3 = a.mult(b);
        print(String.format("A = \n%s", a.toString()));
        print(String.format("B = \n%s", b.toString()));
        print(String.format("A + B = \n%s", c1.toString()));
        print(String.format("A - B = \n%s", c2.toString()));
        print(String.format("A * B = \n%s", c3.toString()));
        sc.close();
    }
}
