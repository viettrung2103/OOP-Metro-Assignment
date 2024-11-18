package Week5.A51_Threads.Task1;

public class EvenThread implements Runnable {
    private int max = 20;

    @Override
    public void run() {
        try {

            for (int i = 1; i <= max; i++) {
                if (i % 2 == 0) {
                    System.out.println("Even thread: " + i);
                }
                Thread.sleep(1000);

            }
        } catch (InterruptedException e) {
            return;
        }

    }
}
