package Week2.A21.Task3;

public class Program {
    public static void main(String[] args) {
        CoffeeMaker maker1 = new CoffeeMaker("espresso", 50);
        maker1.pressOnOff();
        maker1.setAmount(20);
        maker1.printStatus();
        maker1.printType();
        maker1.printAmount();
        maker1.pressOnOff();
        maker1.printStatus();

    }
}
