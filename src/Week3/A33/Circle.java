package Week3.A33;

public class Circle extends Shape{
    private double radius;



    public Circle(String type, double radius) {
        super(type);
        this.radius = radius;
        //        this.area = 0;

    }


    public double getRadius() {
        return this.radius;
    }

    @Override
    public void calculateArea() {
        double result = 0;
        result = Math.PI * radius*radius;
        this.setArea(result);

    }

    @Override
    public String toString() {
        return super.toString() + " base " + this.radius +  ": " + this.getArea();
    }
}
