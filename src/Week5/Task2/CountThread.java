package Week5.Task2;

import java.util.ArrayList;

public class CountThread extends Thread {
    private int sum, startIdx, endIdx;
    private ArrayList<Integer> numList;

    public CountThread(ArrayList<Integer> numList, int startIdx, int endIdx) {
        this.sum = 0;
        this.numList = numList;
        this.startIdx = startIdx;
        this.endIdx = endIdx;
    }

    public int getSum() {
        return this.sum;
    }

    @Override
    public void run() {
//        this.findSum();
        for (int i = this.startIdx; i <= this.endIdx; i++) {
            this.sum += numList.get(i);
        }
        Thread.yield();
    }

}
