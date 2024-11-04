package Week3.A32;

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

    /* This is the method (constructor) called when a new instance of Car is created (with new).
     * Constructors may also have arguments.
     */
    public Car(String typeName, double gasolineCapacity, double topSpeed) {
        this.speed = 0;
        this.gasolineLevel = 0;
        this.gasolineCapacity = gasolineCapacity;
        this.topSpeed = topSpeed;
        this.typeName = typeName;   // this refers to the object itself.
        // The reference is useful if you want to use parameter names that are
        // identical to instance variable names (and for more, later on)
    }

    /* Implementations of some methods.
     * Note that methods refer to and change instance variable values.
     */
    public void accelerate() {
        if (gasolineLevel > 0 && (this.speed <= this.topSpeed - 10)) {
            this.speed = Math.min(this.speed + 10, this.topSpeed);
            this.consumeGasoline();

        } else
            speed = 0;
    }

    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0) {

                speed = Math.max(0, speed - amount);
                this.consumeGasoline();
            }
        } else
            speed = 0;
    }

    public double getTopSpeed() {
        return this.topSpeed;
    }

    public void setSpeed(double speed) {
        this.speed = Math.min(this.topSpeed, this.speed + speed);
    }

    public void consumeGasoline() {
        if (this.gasolineLevel >= 10) {
            this.gasolineLevel -= 10;
        }
    }


    double getSpeed() {
        return speed;
    }

    String getTypeName() {
        return typeName;
    }

    public void fillTank() {
        gasolineLevel = this.gasolineCapacity;
    }

    double getGasolineLevel() {
        return gasolineLevel;
    }

    public void setGasolineLevel(Double gasolineLevel) {
        this.gasolineLevel = gasolineLevel;
    }
}