package com.nixsolutions.laba1.task2;

/**
 * @version 1.0
 * @autor Alexander Sinkevich
 */
public class Circle extends Shape {
    public Circle() {
    }

    private double radius;

    /**
     * @param xPos x position
     * @param yPos y position
     */
    public Circle(double xPos, double yPos) {
        super(xPos, yPos);
    }

    /**
     * @param r
     */
    public void setRadius(double r) {
        radius = r;
    }

    /**
     * @return radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @param c
     * @return equals
     */
    public boolean equals(Circle c) {
        return c.radius == this.radius && c.getX() == this.getX()
                && c.getY() == this.getY();
    }

    /**
     * Drawing a Circle
     */
    public void draw() {
        System.out.println(
                "Drawing a Circle at:(" + getX() + ", " + getY() + ")");
    }

    /**
     * @param plusSize to scale a shape
     */
    public void scale(int plusSize) {
        setRadius(getRadius() + plusSize);
    }

    //    public double perimeter() {
    //        double perimeter = 2 * Math.PI * radius;
    //        return perimeter;
    //    }
}
