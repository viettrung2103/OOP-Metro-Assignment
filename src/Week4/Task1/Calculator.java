package Week4.Task1;

public class Calculator {
    private int sum;

    public Calculator() {
        this.sum = 0;
    }

    // Method to reset the calculator to zero
    public void reset() {
        this.sum = 0;
    }

    // Method to add an integer to the calculator
    // throw exception when add negative number
    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed");
        }
        this.sum += number;
    }

    // Method to return the current value of the calculator
    public int getValue() {
        return this.sum;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.add(5);
        calculator.add(10);
        System.out.println("Current sum: " + calculator.getValue()); // Output: Current sum: 15
        calculator.reset();
        System.out.println("After reset: " + calculator.getValue()); // Output: After reset: 0

        try {
            calculator.add(-5); // This will throw an exception
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage()); // Output: Negative numbers are not allowed
        }
    }
}