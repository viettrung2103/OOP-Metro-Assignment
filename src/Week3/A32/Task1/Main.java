package Week3.A32.Task1;

public class Main {
    public static void main(String[] args) {
        Bus bus1 = new Bus(40);
        Car car1 = new Car("Black");
        Motocycle motocycle1 = new Motocycle("Red");

        Vehicle[] vehicles = {bus1, car1, motocycle1};

        for (Vehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
            vehicle.getInfo();
            System.out.println();
        }
    }
}
