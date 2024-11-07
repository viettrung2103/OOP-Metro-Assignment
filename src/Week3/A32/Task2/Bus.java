package Week3.A32.Task2;

public class Bus implements Vehicle {
    private String type;
    private String fuel;
    private int passengers;

    public Bus(int passengers) {
        this.type = "Motocycle";
        this.fuel = "Gasoline";
        this.passengers = passengers;


    }

    @Override
    public void start() {
        System.out.println(this.type + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(this.type + " is stopping");
    }

    @Override
    public void getInfo() {
        System.out.println("Type: " + this.type);
        System.out.println("Fuel: " + this.type);
        System.out.println("Capacity: " + this.passengers);
    }
}
