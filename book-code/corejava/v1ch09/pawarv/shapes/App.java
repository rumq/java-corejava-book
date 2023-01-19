package pawarv.shapes;

import java.util.Random;

public class App {

    public static void main(String[] args) {

        int max = new Random().nextInt(100); 
        Shape[] shapes = ShapeGenerator.generateRandomShapes(max);

        System.out.println("Total shapes: " + shapes.length);
        for (Shape shape : shapes) {
            System.out.println("Shape : " + shape + ", Area: " + shape.getArea());
        }
    }

}
