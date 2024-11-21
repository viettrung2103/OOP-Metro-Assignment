package Week5.A51_Threads.Task2;

public class Main {
    private static  int size = 1000000;
    public static void main(String[] args) {
        SplitArraySum application = new SplitArraySum(size);
        application.execute();
        application.executeNoSplit();
    }
}
