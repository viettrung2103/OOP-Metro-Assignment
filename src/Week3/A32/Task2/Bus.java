package Week3.A32.Task2;

public class Bus extends AbstractVehicle {
    //    private String type;
//    private String fuel;
    private int passengers;

    public Bus(String type, String fuel, int passengers) {
        super(type, fuel);
        this.passengers = passengers;


    }

//    @Override
//    public void start() {
//        System.out.println(this.type + " is starting...");
//    }
//
//    @Override
//    public void stop() {
//        System.out.println(this.type + " is stopping");
//    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Capacity: " + this.passengers);
    }
}
