package Week5.A51.Task1;

class OddThread implements Runnable {
    //    private int counter = 1;
    private int max = 20;

    @Override
    public void run() {
        try {
            for (int i = 1; i <= max; i++) {
                if (i % 2 == 1) {
                    System.out.println("Odd thread: " + i);
                }
                Thread.sleep(1000);

            }

        } catch (InterruptedException e) {
            return;
        }

    }
}