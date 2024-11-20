package Week5.A52_Synchronization.Task2;

import java.util.ArrayList;

public class SafeArrayList {
    private ArrayList<String> list;

    public SafeArrayList() {
        list = new ArrayList<>();
    }

    public synchronized void add(String name) {
        this.list.add(name);
    }

    public synchronized int size() {
        return this.list.size();
    }

    public synchronized String remove(String name) {
        int idx = this.list.indexOf(name);
        if (idx == -1) {
            return null;
        }
        return this.list.remove(idx);
    }


}
