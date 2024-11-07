package Week3.A32.Task3;
public class Main {
    public static void main(String[] args) {
        Bus bus1 = new Bus("Bus", "Diesel", 40);
        Car car1 = new Car("Car", "Petrol", "Red");
        Motocycle motocycle1 = new Motocycle("Motorcycle", "Gasoline", "Black");
        Bus bus2 = new ElectricBus("Electric Bus", "Diesel", 30);
        Car car2 = new ElectricCar("Electric Car", "Petrol", "Grey");
        Motocycle motocycle2 = new ElectricMotorcycle("Electric Motorcycle", "Gasoline", "Blue");
        EletricVehicle[] vehicles = {bus1, car1, motocycle1, bus2, car2, motocycle2};
        for (EletricVehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
            vehicle.charge();
            vehicle.getInfo();
            System.out.println();
        }
    }
}