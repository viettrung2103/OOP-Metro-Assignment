package model;

public class Pet {
    private double x, y;
    private double speed = 2.0;

    public Pet(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getSpeed() {
        return this.speed;
    }
}
