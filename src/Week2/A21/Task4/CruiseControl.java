package Week2.A21.Task4;

public class CruiseControl {
    //    private double curSpeed;
    private double targetSpeed;
    private double maxSpeed;
    private boolean status;

    public CruiseControl(double maxSpeed) {
        this.targetSpeed = 0;
        this.maxSpeed = maxSpeed;
        this.status = false;
    }

    public void turnOnOff() {
        this.status = !this.status;
    }

    public double getMaxSpeed() {
        return this.maxSpeed;
    }

    public boolean isOn() {
            return this.status;
//        if (car.isOn()) {
//            return this.status;
//
//        }
//        else {
//        }

    }

    public double getTargetSpeed() {
        return this.targetSpeed;
    }

    public boolean setTargetSpeed(double speed) {
        if (this.isOn() && 0 <= speed && speed <= this.maxSpeed) {
            this.targetSpeed = speed;
            return true;
        }
        return false;
    }


}

