package Week3.A32.Task4;

public class ElectricMotorcycle extends Motocycle {
    public ElectricMotorcycle(String type, String fuel, String color, double efficiency) {
        super(type, fuel, color,efficiency);
        this.isElecTric = true;
    }
}
