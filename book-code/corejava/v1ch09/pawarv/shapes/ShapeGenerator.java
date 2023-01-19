package pawarv.shapes;

import java.util.Random;

public class ShapeGenerator {
    
    public static Shape generateShape(String shapeType, double... args) {
        Shape shape = null;
        if (shapeType.equalsIgnoreCase("triangle")) {
            shape = new Triangle(args[0], args[1]);
        } else if (shapeType.equalsIgnoreCase("rectangle")) {
            shape = new Rectangle(args[0], args[1]);
        } else if (shapeType.equalsIgnoreCase("square")) {
            shape = new Square(args[0]);
        }
        return shape;
    }
    
    public static void main(String[] args) {
        Shape shape = ShapeGenerator.generateShape("triangle", 10, 20);
        System.out.println(shape);
        shape = ShapeGenerator.generateShape("rectangle", 10, 20);
        System.out.println(shape);
        shape = ShapeGenerator.generateShape("square", 10);
        System.out.println(shape);

        Shape[] shapes = ShapeGenerator.generateRandomShapes(9);

        for (Shape s : shapes) {
            System.out.println(s);
        }
    }

    public static Shape[] generateRandomShapes(int n){

        String[] shapeTypes = {"triangle", "rectangle", "square"};
        
        Shape[] shapes = new Shape[n];
        for (int i = 0; i < n; i++) {
            int index = new Random().nextInt(shapeTypes.length);
            shapes[i] = ShapeGenerator.generateShape(shapeTypes[index], 10, 20);
        }

        return shapes;

    }


}
