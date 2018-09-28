package com.nixsolutions.laba1.task2;

public class Circle extends Shape {
    public Circle() {
    }

    private double Radius;

    public Circle(double xpos, double ypos) {
        super(xpos, ypos);
    }

    public void setRadius(double r) {
        Radius = r;
    }


    public double getRadius() {
        return Radius;
    }

    public double perimeter() {
        double perimeter = 2 * Math.PI * Radius;
        return perimeter;
    }

    public boolean equals(Circle c) {
        return c.Radius == this.Radius && c.getX() == this.getX()
                && c.getY() == this.getY();
    }

    void draw() {
        System.out.println(
                "Drawing a Circle at:(" + getX() + ", " + getY() + ")");
    }

    public void scale(int radiusPlus) {
        setRadius(getRadius() + radiusPlus);
    }
}
