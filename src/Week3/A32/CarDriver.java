package Week3.A32;

public class CarDriver {
    public static void main(String[] args) {
        Car myCar;
        SportsCar mySportsCar;
        Bus myBus;


        myCar = new Car("Toyota Corolla", 100, 120);
        mySportsCar = new SportsCar("Ferrari", 150, 200);
        myBus = new Bus("HSL Bus", 130, 120, 50);

        mySportsCar.fillTank();
        myCar.fillTank();
        myBus.fillTank();


        for (int i = 0; i < 6; i++) {
            myCar.accelerate();
            mySportsCar.accelerate();
            myBus.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h, gas level is " + myCar.getGasolineLevel() + "l");
            System.out.println(mySportsCar.getTypeName() + ": speed is " + mySportsCar.getSpeed() + "  km/h, gas level is " + mySportsCar.getGasolineLevel() + "l");
            System.out.println(myBus.getTypeName() + ": speed is " + myBus.getSpeed() + "  km/h, gas level is " + myBus.getGasolineLevel() + "l");

        }

        while (myCar.getSpeed() > 0) {
            myCar.decelerate(15);
            mySportsCar.decelerate(15);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h, gas level is " + myCar.getGasolineLevel() + "l");
            System.out.println(mySportsCar.getTypeName() + ": speed is " + mySportsCar.getSpeed() + " km/h, gas level is " + mySportsCar.getGasolineLevel() + "l");
            System.out.println(myBus.getTypeName() + ": speed is " + myBus.getSpeed() + "  km/h, gas level is " + myBus.getGasolineLevel() + "l");

        }

        for (int i = 0; i < 6; i++) {
            myBus.passengerEnter(6);
            System.out.println(myBus.getTypeName() + ": has " + myBus.getCustomers() + " customers");
        }

        while (myBus.getCustomers() >0){
            myBus.passengerExit(6);
            System.out.println(myBus.getTypeName()+ ": has remain "+ myBus.getCustomers()+ " customers");
        }

    }
}