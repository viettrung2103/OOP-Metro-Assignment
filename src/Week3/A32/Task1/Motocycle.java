package Week3.A32.Task1;

public class Motocycle implements Vehicle {
    private String type;
    private String fuel;
    private String color;

    public Motocycle(String color) {
        this.type = "Motocycle";
        this.fuel = "Gasoline";
        this.color = color;


    }

    @Override
    public void start() {
        System.out.println(this.type + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(this.type + " is stopping...");
    }


    @Override
    public void getInfo() {
        System.out.println("Type: " + this.type);
        System.out.println("Fuel: " + this.fuel);
        System.out.println("Color: " + this.color);
    }
}
