package Week3.A33;

import java.util.ArrayList;

public class ShapeCalculator {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();

        Triangle triangle = new Triangle("Triangle", 8, 3);
        Rectangle rectangle = new Rectangle("Rectangle", 6, 4);
        Circle circle = new Circle("Circle", 5);

        shapes.add(triangle);
        shapes.add(rectangle);
        shapes.add(circle);

        for (Shape shape : shapes) {
            shape.calculateArea();
            System.out.println(shape);
        }
    }


}
