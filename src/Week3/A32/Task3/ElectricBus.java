package Week3.A32.Task3;

public class ElectricBus extends Bus {
    public ElectricBus(String type, String fuel, int passengers, double efficiency) {
        super(type, fuel, passengers,efficiency);
        this.isElecTric = true;
    }
}
