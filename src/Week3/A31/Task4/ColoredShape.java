package Week3.A31.Task4;

public class ColoredShape extends Shape {
    private String color;

    public ColoredShape(String type, String color) {
        super(type);
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + ", color \"" + this.color + "\" with";
    }
}
