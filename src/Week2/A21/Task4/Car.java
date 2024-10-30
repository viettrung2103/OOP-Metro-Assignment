package Week2.A21.Task4;

import java.util.Scanner;


/* Define a class Car (convention capitalizes class names).
 * Car is public (as classes usually are, more on this later).
 */
public class Car {
    /* An object of class Car will have instance variables speed and gasolineLevel.
     * Both are private (they can not be accessed outside the class methods).
     * Keep instance variables private whenever possible.
     */
    private double speed;
    private double gasolineLevel;
    private double gasolineCapacity;
    private double topSpeed;
    private String typeName;
    private CruiseControl cruiseControl;
    private boolean status;


    /* This is the method (constructor) called when a new instance of Car is created (with new).
     * Constructors may also have arguments.
     */
    public Car(String typeName, double gasolineCapacity, double topSpeed) {
        speed = 0;
        gasolineLevel = 0;
        this.gasolineCapacity = gasolineCapacity;
        this.topSpeed = topSpeed;
        this.typeName = typeName;
        this.cruiseControl = new CruiseControl(topSpeed);
        this.status = false;
        // this refers to the object itself
        // The reference is useful if you want to use parameter names that are
        // identical to instance variable names (and for more, later on)

    }

    /*
    . With cruise control feature, the driver can set the target speed,
     read the current target speed, and turn cruise control on or off.
      For cruise control,
      there is a minimum and maximum speed that can be set.
       After target speed has been set and cruise control turned on,
        the car should accelerate or decelerate to reach the target speed.
         If reaching the target speed is not possible,
          cruise control must be turned off, and the driver be informed
          about this (perhaps the returning value of turnOn method
           could be used for this).

     */
    public void runCruiseControl() {
        Scanner scanner = new Scanner(System.in);
        int tryCount = 0;
        if (this.isOn()) {
            while (true) {
                System.out.print("What speed woudld you like to set? ");
                double targetSpeed = Double.parseDouble(scanner.nextLine());
                this.cruiseControl.turnOnOff();
                boolean isSet = this.cruiseControl.setTargetSpeed(targetSpeed);
                System.out.println("Cruise Control Start");
                if (isSet) {
                    while (this.speed != this.cruiseControl.getTargetSpeed()) {
                        System.out.println("Current Speed: " + this.getSpeed());
                        if (this.speed < this.cruiseControl.getTargetSpeed()) {
                            System.out.println("Speed up");
                            this.accelerate();
                        } else {
                            System.out.println("Slow down");
                            this.decelerate();
                        }
                    }
                    System.out.println("Current Speed: " + this.getSpeed());
                    System.out.println("Reach Design Speed");
                    this.cruiseControl.turnOnOff();
                    if (!this.cruiseControl.isOn()) {
                        System.out.println("Cruise Control stop");
                    }
                    break;
                } else {
                    System.out.println("cannot set the speed, please set the speed in the range [0-" + this.cruiseControl.getMaxSpeed() + "]");
                    tryCount++;
                }
                if (tryCount == 3) {
                    System.out.println("Cruise Control stop.");
                    break;
                }
            }
        } else {
            System.out.println("Car needs to be on before using Cruise Control");
        }


    }

    /* Implementations of some methods.
     * Note that methods refer to and change instance variable values.
     */
    public void accelerate() {
        if (this.isOn()) {
            if (gasolineLevel > 0 && (this.speed <= this.topSpeed - 10))
                speed += 10;
            else
                speed = 0;

        } else {
            System.out.println("Car must be on to accelerate");
        }
    }

    public void decelerate() {
        if (this.isOn()) {
            if (gasolineLevel > 0 && (this.speed <= this.topSpeed - 10))
                speed -= 10;
            else
                speed = 0;

        } else {
            System.out.println("Car must be on to decelerate");
        }
    }


//    public void decelerateByAmount(int amount) {
//        if (this.isOn()) {
//            if (gasolineLevel > 0) {
//                if (amount > 0)
//                    speed = Math.max(0, speed - amount);
//            } else
//                speed = 0;
//
//        } else {
//            System.out.println("Car must be on before decelerate");
//        }
//    }

    public void turnOnOff() {
        this.status = !this.status;
    }

    public boolean isOn() {
        return this.status;
    }

//    public boolean getStatus() {
//        return this.status;
//    }

    public double getSpeed() {
        return speed;
    }

    public String getTypeName() {
        return typeName;
    }

    public void fillTank() {
        gasolineLevel = this.gasolineCapacity;
    }

//    public double getGasolineLevel() {
//        return gasolineLevel;
//    }
}