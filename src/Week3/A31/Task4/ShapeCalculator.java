package Week3.A31.Task4;

import java.util.ArrayList;

public class ShapeCalculator {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();

        Triangle triangle = new Triangle("Triangle","red", 8, 3);
        Rectangle rectangle = new Rectangle("Rectangle","yellow", 6, 4);
        Circle circle = new Circle("Circle","blue", 5);

        shapes.add(triangle);
        shapes.add(rectangle);
        shapes.add(circle);

        for (Shape shape : shapes) {
            shape.calculateArea();
            System.out.println(shape);
        }
    }


}
