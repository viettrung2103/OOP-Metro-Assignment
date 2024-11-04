package Week3.A33;

public class Shape {
    //    private int side;
    private double area;
    private String type;

    public Shape(String type) {
//        this.side = side;
        this.area = 0;
        this.type = type;
    }

    public void calculateArea() {

    }

    public Double getArea() {
        return this.area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return"Area of " + this.type + " with";
    }
}
