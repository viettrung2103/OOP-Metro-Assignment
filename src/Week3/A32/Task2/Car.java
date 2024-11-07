package Week3.A32.Task2;

public class Car implements Vehicle {
    private String type;
    private String fuel;
    private String color;

    public Car(String color) {
        this.type = "Car";
        this.fuel = "Petrol";
        this.color = color;


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
        System.out.println("Color: " + this.type);
    }
}
