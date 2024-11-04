package Week3.A33;

public class Triangle extends Shape {
    private double height;
    private double base;


    public Triangle(String type, int height, int base) {
        super(type);
        this.height = height;
        this.base = base;
//        this.area = 0;

    }

    public double getBase() {
        return this.base;
    }

    public double getHeight() {
        return this.height;
    }

    @Override
    public void calculateArea() {
        double result = 0;
        result = (1.0 / 2) * this.height * this.base;
        this.setArea(result);

    }

    @Override
    public String toString() {
        return super.toString() + " base " + this.base + " and height " + this.height + ": " + this.getArea();
    }
}
