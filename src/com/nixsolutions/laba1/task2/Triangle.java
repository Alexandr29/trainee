package com.nixsolutions.laba1.task2;

/**
 * @version 1.0
 * @autor Alexander Sinkevich
 */
public class Triangle extends Shape {
    public Triangle() {
    }

    private int a;
    private int b;
    private int c;

    /**
     * @param newX
     * @param newY
     */
    public Triangle(double newX, double newY) {
        super(newX, newY);
    }

    /**
     * @return a
     */
    public int getA() {
        return a;
    }

    /**
     * @param a
     */
    public void setA(int a) {
        this.a = a;
    }

    /**
     * @return b
     */
    public int getB() {
        return b;
    }

    /**
     * @param b
     */
    public void setB(int b) {
        this.b = b;
    }

    /**
     * @return c
     */
    public int getC() {
        return c;
    }

    /**
     * @param c
     */
    public void setC(int c) {
        this.c = c;
    }

    /**
     * drawing a triangle
     */
    public void draw() {
        System.out.println(
                "Drawing a Triangle at:(" + getX() + ", " + getY() + ")");
    }

    /**
     * @param plusSize to scale a shape
     */
    @Override public void scale(int plusSize) {
        setA(getA() + plusSize);
        setB(getB() + plusSize);
        setC(getC() + plusSize);
    }

    //    public double perimeter() {
    //        double perimeter = getA() + getB() + getC();
    //        return perimeter;
    //    }
}