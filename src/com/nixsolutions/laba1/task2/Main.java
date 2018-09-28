package com.nixsolutions.laba1.task2;

public class Main {

    public static void main(String[] args) {
        Shape shape = new Triangle(5, 4);
        shape.draw();
        Shape shape2 = new Circle(3, 2);
        shape2.moveTo(4, 3);
        shape2.draw();
        shape.scale(5);
        shape2.scale(5);
        shape.draw();
        shape2.draw();
    }

}
