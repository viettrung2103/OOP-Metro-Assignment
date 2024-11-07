package Week3.A32.Task2;

abstract class AbstractVehicle implements Vehicle {
    protected String type;
    protected String fuel;

    public AbstractVehicle(String type, String fuel) {
        this.type = type;
        this.fuel = fuel;
    }

    @Override
    public void start() {
        System.out.println(this.type + "is starting...");
    }

    @Override
    public void stop() {
        System.out.println(this.type + " is stop...");
    }

    @Override
    public void getInfo() {
        System.out.println("Type: " + this.type);
        System.out.println("Fuel: " + this.fuel);
    }
}
