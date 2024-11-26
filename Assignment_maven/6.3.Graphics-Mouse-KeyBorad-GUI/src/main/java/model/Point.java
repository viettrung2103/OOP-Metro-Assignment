package model;

public class Point {
    private int x;
    private int y;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;

    }


    public double distance(Point anotherPoint) {
        double result = Math.pow(this.x - anotherPoint.getX(), 2) + Math.pow(this.y - anotherPoint.getY(), 2);
        return Math.sqrt(result);
    }

    public int getX() {
        return this.x;

    }

    public void setX(int x) {
        this.x += x;
    }


    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y += y;
    }

    public boolean samePlace(Point anotherPoint) {
        return (this.x == anotherPoint.getX()) && (this.y == anotherPoint.getY());
    }


}
