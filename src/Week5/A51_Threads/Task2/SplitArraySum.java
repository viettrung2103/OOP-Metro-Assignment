package Week5.A51_Threads.Task2;

import java.util.ArrayList;
import java.util.Random;

public class SplitArraySum {
    private int cores;
    private ArrayList<Integer> numList;
    private ArrayList<CountThread> countThreads;
    private int finalSum;

    public SplitArraySum() {
        cores = this.findNumCores();
        numList = createNumList();
        countThreads = new ArrayList<>();
        finalSum = 0;
    }

    public int findNumCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    public ArrayList<Integer> createNumList() {
        ArrayList<Integer> list = new ArrayList<>();
        Random numGenerator = new Random();
        for (int i = 0; i <= 100000; i++) {
            int num = numGenerator.nextInt(100000);
            list.add(num);
        }
        return list;
    }


    public void executeNoSplit() {
        long start = System.nanoTime();
        int sum = 0;
        for (Integer num : this.numList) {
            sum += num;
        }
        long end = System.nanoTime();
        long elapsed = end - start;
        System.out.println("Duration of calculation without split:");
        System.out.println("Time elapsed " + elapsed / 10e6 + " ms. The result is " + sum);
    }
    // get array


    // find core

    public void execute() {
        //split array
        int splitArraySize = (this.numList.size() / this.cores) + 1;
        int slice = 0;

        for (int i = 0; i < this.cores; i++) {
            int startIdx = slice;
            int endIdx = Math.min(this.numList.size() - 1, startIdx + splitArraySize - 1);
            CountThread curThread = new CountThread(this.numList, startIdx, endIdx);
            countThreads.add(curThread);
            slice += splitArraySize;
        }

        // start threads
        long start = System.nanoTime();
        for (CountThread curThread : countThreads) {
            curThread.start();
        }

        // wait for all thread to complete and collect the result;
        for (CountThread curThread : countThreads) {
            try {
                curThread.join();
            } catch (InterruptedException e) {
                // thread was interrupted, the result may be incorrect
                e.printStackTrace();
            }
            this.finalSum += curThread.getSum();
        }
        long end = System.nanoTime();
        long elapsed = end - start;
        String coreStr = "core";
        if (this.cores > 1) {
            coreStr += "s";
        }
        System.out.println("Duration with split array to thread");
        System.out.println("There are " + this.cores + " " + coreStr);
        System.out.println("Time elapsed " + elapsed / 10e6 + " ms. The result is " + this.finalSum);
    }

    // split array according to  number of thread and assign to corresponding thread

    // find total sum


}
