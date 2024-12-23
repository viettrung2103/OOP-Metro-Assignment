package Week3.A32.Task4;

public class Motocycle extends AbstractVehicle {
    //    private String type;
//    private String fuel;
    private String color;

    public Motocycle(String type, String fuel, String color, double efficiency) {
        super(type, fuel,efficiency);
        this.color = color;
        this.isElecTric = false;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Color: " + this.color);
    }
}
