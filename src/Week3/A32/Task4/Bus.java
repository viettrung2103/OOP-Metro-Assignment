package Week3.A32.Task4;

public class Bus extends AbstractVehicle {
    //    private String type;
//    private String fuel;
    private int passengers;

    public Bus(String type, String fuel, int passengers, double efficiency) {
        super(type, fuel, efficiency);
        this.passengers = passengers;
        this.isElecTric = false;


    }


    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Capacity: " + this.passengers);
    }
}
