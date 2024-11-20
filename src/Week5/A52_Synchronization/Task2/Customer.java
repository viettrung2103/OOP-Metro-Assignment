package Week5.A52_Synchronization.Task2;

public class Customer implements Runnable {
    private String name;
    private SafeArrayList safeList;

    public Customer(String name, SafeArrayList safeArrayList) {
        this.name = name;
        this.safeList = safeArrayList;
    }

    @Override
    public void run() {

        //Add the customer's name to the list
        safeList.add(this.name);
        System.out.println(this.name + " added to the list. size now is. " + this.safeList.size());

        // call the size of the list
        int size = safeList.size();
        System.out.println("After add " + this.name + " to list: list size is " + size);

        // Remove the customer's name from the list
        String removedName = this.safeList.remove(this.name);
        if (removedName != null) {
            System.out.println(removedName + " removed from the list. Size now is: " + this.safeList.size());
        } else {
            System.out.println(this.name + " was not found in t");
        }
    }


}
