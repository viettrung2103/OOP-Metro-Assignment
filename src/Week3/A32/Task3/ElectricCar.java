package Week3.A32.Task3;
public class ElectricCar extends Car {
    public ElectricCar(String type, String fuel, String color) {
        super(type, fuel, color);
        this.isElecTric = true;
    }
}