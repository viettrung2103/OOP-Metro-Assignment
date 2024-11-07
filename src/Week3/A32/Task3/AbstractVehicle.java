package Week3.A32.Task3;

abstract class AbstractVehicle implements EletricVehicle {
    protected String type;
    protected String fuel;
    protected boolean isElecTric;

    public AbstractVehicle(String type, String fuel) {
        this.type = type;
        this.fuel = fuel;
//        this.isElecTric = isElecTric;
    }

    @Override
    public void start() {
        System.out.println(this.type + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(this.type + " is stop...");
    }

    @Override
    public void getInfo() {
        System.out.println("Type: " + this.type);
        System.out.println("Fuel: " + this.fuel);
        System.out.println("Eletric: " + this.isElecTric);
    }

    @Override
    public void charge() {
        if (this.isElecTric) {
            System.out.println("Vehicle is charging...");
        } else {
            System.out.println("No possible to charge");
        }
    }
}
