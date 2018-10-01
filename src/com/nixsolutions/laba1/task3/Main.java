package com.nixsolutions.laba1.task3;

import com.nixsolutions.laba1.task2.Circle;
import com.nixsolutions.laba1.task2.Shape;
import com.nixsolutions.laba1.task2.Triangle;

/**
 * @version 1.0
 * @autor Alexander Sinkevich
 */
public class Main {

    public static void main(String[] args) {
        double randX, randY, randRadius;
        Shape[] shapes = new Shape[15];

        for (int i = 0; i < shapes.length; i++) {
            int circleOrRect = (int) (Math.random() * 2 + 1);

            randX = (int) ((Math.random() * 100) + 1);
            randY = (int) ((Math.random() * 100) + 1);
            randRadius = (int) ((Math.random() * 100) + 1);

            // If random number is 1, create/add a circle to array, else, add rectangle
            if (circleOrRect == 1) {
                // Create new circle with random (x, y)`
                shapes[i] = new Circle(randX, randY);
                // Cast AbstractShape to Circle and set random radius
                ((Circle) shapes[i]).setRadius(randRadius);
                // Print out the object's info
                System.out.println((i + 1) + " = " + shapes[i].toString());
            } else {
                // Create new triangle with random (x, y)
                shapes[i] = new Triangle(randX, randY);
                // Print out the object's info
                System.out.println((i + 1) + " = " + shapes[i].toString());
            }
        }
    }
}