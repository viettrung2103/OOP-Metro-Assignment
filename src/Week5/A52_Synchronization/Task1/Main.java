package Week5.A52_Synchronization.Task1;

import java.util.ArrayList;

public class Main {
    static final int availableTicket = 10;

    public static void main(String[] agrs) {
        Reservation reservation = new Reservation(availableTicket);

        ArrayList<Thread> customerList = new ArrayList<>();

        Thread customer1 = new Thread(new Customer("1", 2, reservation));
        Thread customer2 = new Thread(new Customer("2", 1, reservation));
        Thread customer3 = new Thread(new Customer("3", 3, reservation));
        Thread customer4 = new Thread(new Customer("4", 1, reservation));
        Thread customer5 = new Thread(new Customer("5", 2, reservation));
        Thread customer6 = new Thread(new Customer("6", 2, reservation));
        Thread customer7 = new Thread(new Customer("7", 1, reservation));
        Thread customer8 = new Thread(new Customer("8", 1, reservation));
        Thread customer9 = new Thread(new Customer("9", 3, reservation));
        Thread customer10 = new Thread(new Customer("10", 3, reservation));
        Thread customer11 = new Thread(new Customer("11", 2, reservation));
        Thread customer12 = new Thread(new Customer("12", 4, reservation));
        Thread customer13 = new Thread(new Customer("13", 1, reservation));
        Thread customer14 = new Thread(new Customer("14", 4, reservation));
        Thread customer15 = new Thread(new Customer("15", 3, reservation));

        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);
        customerList.add(customer5);
        customerList.add(customer6);
        customerList.add(customer7);
        customerList.add(customer8);
        customerList.add(customer9);
        customerList.add(customer10);
        customerList.add(customer11);
        customerList.add(customer12);
        customerList.add(customer13);
        customerList.add(customer14);
        customerList.add(customer15);

        for (Thread customer : customerList) {
            customer.start();
        }

        try {
            for (Thread customer : customerList) {
                customer.join();
            }

        } catch (InterruptedException e) {
            System.out.println("Program interrupted");
        }
    }
}
