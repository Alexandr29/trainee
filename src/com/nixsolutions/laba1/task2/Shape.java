package com.nixsolutions.laba1.task2;

public abstract class Shape {
    public Shape() {
    }

    private double x;
    private double y;

    Shape(double newx, double newy) {
        moveTo(newx, newy);
    }

    abstract void draw();

    void moveTo(double newx, double newy) {
        setX(newx);
        setY(newy);
    }

    abstract void scale(int plusSize);

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    void setX(double newx) {
        x = newx;
    }

    void setY(double newy) {
        y = newy;
    }

    public String toString() {
        String message = this.getClass().getSimpleName() + ".    xPos: " + x
                + "   yPos: " + y;
        return message;
    }

}
