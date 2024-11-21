package Week5.A51_Threads.Task1;


public class Main {
    public static void main(String[] args) {
//        System.out.println(Runtime.getRuntime().availableProcessors());
        Runnable oddThread = new OddThread();
        Runnable evenThread = new EvenThread();
        Thread t1 = new Thread(oddThread);
        Thread t2 = new Thread(evenThread);

        t1.start();
        t2.start();

//        try {
//            // join() == Promise.all()
//            t1.join();
//            t2.join();
//            //
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
        System.out.println("Print complete");
    }

}
