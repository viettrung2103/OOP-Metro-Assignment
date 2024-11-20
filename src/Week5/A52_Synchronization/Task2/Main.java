package Week5.A52_Synchronization.Task2;

public class Main {
    public static void main(String[] args) {
        SafeArrayList safeList = new SafeArrayList();

        // Create multiple customer thread
        Thread customer1 = new Thread(new Customer("Alice", safeList));
        Thread customer2 = new Thread(new Customer("Bob", safeList));
        Thread customer3 = new Thread(new Customer("Charlie", safeList));
        Thread customer4 = new Thread(new Customer("Helen", safeList));
        Thread customer5 = new Thread(new Customer("Aalto", safeList));

        //start the threads
        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
        customer5.start();

        // wait for all threads to finish
        try {
            customer1.join();
            customer2.join();
            customer3.join();
            customer4.join();
            customer5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //
        System.out.println("Final size of the safe list after all thread run and finish " + safeList.size());
    }
}
