package Week3.A32.Task4;

abstract class AbstractVehicle implements EletricVehicle {
    protected String type;
    protected String fuel;
    protected boolean isElecTric;
    protected double efficiency;

    public AbstractVehicle(String type, String fuel, double efficiency) {
        this.type = type;
        this.fuel = fuel;
        this.efficiency = efficiency;
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
    public void calculateFuelEfficiency() {
        String unitText = "";
        if (isElecTric) {
            unitText = "kWh per kilometer";
        } else {
            unitText = "liter per kilometer";
        }
        System.out.println("Efficiency: " + this.efficiency + " " + unitText);
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
