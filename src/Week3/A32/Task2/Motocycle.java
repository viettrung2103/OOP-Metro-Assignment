package Week3.A32.Task2;

public class Motocycle extends AbstractVehicle {
    //    private String type;
//    private String fuel;
    private String color;

    public Motocycle(String type, String fuel, String color) {
        super(type, fuel);
        this.color = color;


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
        System.out.println("Color: " + this.color);
    }
}
