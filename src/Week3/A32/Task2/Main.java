package Week3.A32.Task2;

public class Main {
    public static void main(String[] args) {
        Bus bus1 = new Bus("Bus", "Diesel", 40);
        Car car1 = new Car("Car", "Petrol", "Red");
        Motocycle motocycle1 = new Motocycle("Motorcycle", "Gasoline", "Black");

        Vehicle[] vehicles = {bus1, car1, motocycle1};

        for (Vehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
            vehicle.getInfo();
            System.out.println();
        }
    }
}
