package Week3.A32.Task4;

public class Main {
    public static void main(String[] args) {
        Bus bus1 = new Bus("Bus", "Diesel", 40, 12);
        Car car1 = new Car("Car", "Petrol", "Red", 7.6);
        Motocycle motocycle1 = new Motocycle("Motorcycle", "Gasoline", "Black", 5);
        Bus bus2 = new ElectricBus("Electric Bus", "Diesel", 30, 20);
        Car car2 = new ElectricCar("Electric Car", "Petrol", "Grey", 30);
        Motocycle motocycle2 = new ElectricMotorcycle("Electric Motorcycle", "Gasoline", "Blue", 15);


        EletricVehicle[] vehicles = {bus1, car1, motocycle1, bus2, car2, motocycle2};

        for (EletricVehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
            vehicle.charge();
            vehicle.getInfo();
            vehicle.calculateFuelEfficiency();
            System.out.println("");
        }
    }
}
