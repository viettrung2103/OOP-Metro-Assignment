package Week3.A33;

public class Rectangle extends Shape {
    private double width;
    private double height;


    public Rectangle(String type, double height, double width) {
        super(type);
        this.height = height;
        this.width = width;
//        this.area = 0;

    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    @Override
    public void calculateArea() {
        double result = 0;
        result =  this.height * this.width * 1.0;
        this.setArea(result);

    }

    @Override
    public String toString() {
        return super.toString() + " width " + this.width + " and height " + this.height + ": " + this.getArea();
    }
}
