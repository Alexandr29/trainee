package com.nixsolutions.laba1.task2;

public class Triangle extends Shape {
    public Triangle() {
    }

    private int a;
    private int b;
    private int c;

    public Triangle(double newx, double newy) {
        super(newx, newy);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    void draw() {
        System.out.println(
                "Drawing a Triangle at:(" + getX() + ", " + getY() + ")");
    }

    public double perimeter() {
        double perimeter = getA() + getB() + getC();
        return perimeter;
    }

    @Override void scale(int plusSize) {
        setA(getA() + plusSize);
        setB(getB() + plusSize);
        setC(getC() + plusSize);
    }
}