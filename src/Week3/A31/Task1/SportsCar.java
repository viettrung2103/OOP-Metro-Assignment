package Week3.A31.Task1;

public class SportsCar extends Car {
    public SportsCar(String typeName, double gasolineCapacity, double topSpeed) {
        super(typeName, gasolineCapacity, topSpeed);
    }

    @Override
    public void accelerate() {
        double increasedSpd = 0;
        if (this.getGasolineLevel() > 0 && (this.getSpeed() <= (this.getTopSpeed() - 10*1.2))) {
//            increasedSpd = Math.min(this.getTopSpeed(), this.getSpeed() + 10*1.2);
            this.setSpeed(10 * 1.2);
            this.consumeGasoline();
        } else
            this.setSpeed(0);
    }


    @Override
    void decelerate(int amount) {
        double decreasedSpd = 0;
        if (this.getGasolineLevel() > 0) {
            if (amount > 0) {
//                decreasedSpd = Math.max(0, this.getSpeed() - amount * 1.2);
                this.setSpeed(-1 * amount * 1.2);
                this.consumeGasoline();
            }
        } else
            this.setSpeed(0);
    }

    @Override
    public void consumeGasoline() {
        if (this.getGasolineLevel() >= 20) {
            this.setGasolineLevel(this.getGasolineLevel() - 20);
        }
    }

}
