package model;

public class Pet extends Point {
    private boolean isMovable;
    private int speed;

    public Pet(int x, int y, int speed) {
        super(x, y);
        this.isMovable = true;
        this.speed = speed;
    }


    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public synchronized void move(Point targetPoint) {
        if (this.isMovable && this.distance(targetPoint) != 0) {
            double distance = this.distance(targetPoint);
            double dx = (targetPoint.getX() - this.getX()) / distance * this.speed;
            double dy = (targetPoint.getY() - this.getY()) / distance * this.speed;

            if (distance < this.speed) {
                this.setX(targetPoint.getX() - this.getX());
                this.setY(targetPoint.getY() - this.getY());
            } else {
                this.setX((int) dx);
                this.setY((int) dy);
            }
        }
    }
}

