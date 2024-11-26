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

//    public synchronized void move(Point anotherPoint) {
//        if (this.isMovable && this.distance(anotherPoint) != 0) {
//            System.out.println("Is moving");
//            if (this.getX() != anotherPoint.getX()) {
//                if (this.getX() < anotherPoint.getX()) {
//                    int x = this.getX() + this.speed;
////                    this.setX(this.speed);
//                    this.setX(x);
//                } else {
////                    this.getX() -= this.speed;
//                    int x = this.getX() - this.speed;
////                    this.setY(this.speed);
//                    this.setX(x);
//                }
//            }
////                this.setX(this.speed);
//            if (this.getY() != anotherPoint.getY()) {
//                if (this.getY() < anotherPoint.getY()) {
////                    this.getY() += this.speed;
//                    int y = this.getY() + this.speed;
//                    this.setY(y);
//                } else {
//                    int y = this.getY() - this.speed;
//                    this.setY(y);
////                    this.getY() -= this.speed;
//                }
//            }
//        }
//    }
}

