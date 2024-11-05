package Week3.A31.Task4;

public class Circle extends ColoredShape {
    private double radius;
//    private String color;


    public Circle(String type, String color, double radius) {
        super(type, color);
        this.radius = radius;
//        this.color = color;
        //        this.area = 0;

    }


    public double getRadius() {
        return this.radius;
    }

    @Override
    public void calculateArea() {
        double result = 0;
        result = Math.PI * radius * radius;
        this.setArea(result);

    }

    @Override
    public String toString() {
        return super.toString() + " base " + this.radius + ": " + this.getArea();
    }
}
