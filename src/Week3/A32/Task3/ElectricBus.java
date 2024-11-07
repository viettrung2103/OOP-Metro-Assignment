package Week3.A32.Task3;
public class ElectricBus extends Bus {
    public ElectricBus(String type, String fuel, int passengers) {
        super(type, fuel, passengers);
        this.isElecTric = true;
    }
}