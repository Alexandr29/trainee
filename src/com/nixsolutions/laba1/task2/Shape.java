package com.nixsolutions.laba1.task2;

/**
 * @version 1.0
 * @autor Alexander Sinkevich
 */
public abstract class Shape {
    public Shape() {
    }

    private double x;
    private double y;

    /**
     * @param newX
     * @param newY
     */
    public Shape(double newX, double newY) {
        moveTo(newX, newY);
    }

    public abstract void draw();

    /**
     * @param newX
     * @param newY
     */
    public void moveTo(double newX, double newY) {
        setX(newX);
        setY(newY);
    }

    /**
     * @param plusSize
     */
    public abstract void scale(int plusSize);

    /**
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     * @return y
     */
    public double getY() {
        return y;
    }

    /**
     * @param newX
     */
    public void setX(double newX) {
        x = newX;
    }

    /**
     * @param newy
     */
    public void setY(double newy) {
        y = newy;
    }

    /**
     * @return String
     * message
     */
    public String toString() {
        return this.getClass().getSimpleName() + ".    xPos: " + x + "   yPos: "
                + y;
    }

}
