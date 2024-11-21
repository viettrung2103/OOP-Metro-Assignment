package Week5.A52_Synchronization.Task2;

public class Main {
    public static void main(String[] args) {
        SafeArrayList safeList = new SafeArrayList();

        // Create multiple customer thread
        Customer customer1 = new Customer("Alice", safeList); // a thread
        Customer customer2 = new Customer("Bob", safeList); // a thread
        Customer customer3 = new Customer("Charlie", safeList); // a thread
        Customer customer4 = new Customer("Helen", safeList); // a thread
        Customer customer5 = new Customer("Aalto", safeList);  // a thread




//        //start the threads
        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
        customer5.start();
//
//        // wait for all threads to finish
//        try {
//            customer1.join();
//            customer2.join();
//            customer3.join();
//            customer4.join();
//            customer5.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //
//        System.out.println("Final size of the safe list after all thread run and finish " + safeList.size());
    }
}
