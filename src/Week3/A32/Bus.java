package Week3.A32;

public class Bus extends Car {
    private int customers;
    private int maximumCustomers;

    public Bus(String typeName, double gasolineCapacity, double topSpeed, int maximumCustomers) {
        super(typeName, gasolineCapacity, topSpeed);
        this.customers = 0;
        this.maximumCustomers = maximumCustomers;
    }

    public int getCustomers(){
        return this.customers;
    }

    public void setCustomers(int customers){
        this.customers = Math.min(customers, this.maximumCustomers);
    }

    public void passengerEnter(int customers){
        if (this.customers+ customers > this.maximumCustomers){
            System.out.println("Too much customer, cannot board the board");
        } else {
            this.customers += customers;
        }
    }

    public void passengerExit(int customers){
        if (this.customers - customers < 0){
            System.out.println("Too much customers exit. Cannot exit");
        }else {
            this.customers -= customers;
        }
    }

    @Override
    public void accelerate() {
        double increasedSpd = 0;
        if (this.getGasolineLevel() > 0 && (this.getSpeed() <= (this.getTopSpeed() - 10*1.1))) {
//            increasedSpd = Math.min(this.getTopSpeed(), this.getSpeed() + 10*1.2);
            this.setSpeed(10 * 1.1);
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
                this.setSpeed(-1 * amount * 1.1);
                this.consumeGasoline();
            }
        } else
            this.setSpeed(0);
    }

    @Override
    public void consumeGasoline() {
        if (this.getGasolineLevel() >= 15) {
            this.setGasolineLevel(this.getGasolineLevel() - 15);
        }
    }



}
