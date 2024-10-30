package Week2.A21.Task4;


public class CarDriver {
    public static void main(String[] args) {
        Car myCar;

        myCar = new Car("Toyota Corolla", 100, 120);
        myCar.fillTank();
        myCar.turnOnOff();
        myCar.runCruiseControl();

//        for (int i = 0; i < 6; i++) {
//            myCar.accelerate();
//            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
//        }
//
//        while (myCar.getSpeed() > 0) {
//            myCar.decelerateByAmount(15);
//            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
//        }
    }
}