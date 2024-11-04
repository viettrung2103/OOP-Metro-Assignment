package Week3.A31;

import Week3.A32.Bus;

public class CarDriver {
    public static void main(String[] args) {
        Car myCar;
        SportsCar mySportsCar;


        myCar = new Car("Toyota Corolla",100,120);
        mySportsCar = new SportsCar("Ferrari",150,200);


        mySportsCar.fillTank();
        myCar.fillTank();

        for (int i = 0; i < 6; i++) {
            myCar.accelerate();
            mySportsCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h, gas level is "+myCar.getGasolineLevel()+"l");
            System.out.println(mySportsCar.getTypeName() + ": speed is " + mySportsCar.getSpeed() + "  km/h, gas level is "+mySportsCar.getGasolineLevel()+"l");
        }

        while (myCar.getSpeed() > 0) {
            myCar.decelerate(15);
            mySportsCar.decelerate(15);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h, gas level is "+myCar.getGasolineLevel()+"l");
            System.out.println(mySportsCar.getTypeName() + ": speed is " + mySportsCar.getSpeed() + " km/h, gas level is "+mySportsCar.getGasolineLevel()+"l");
        }
    }
}