package Week2.A22.Task2;

import java.util.HashMap;
import java.util.Map;

public class GroceryListManager {

    //    private ArrayList<String> groceryList = new ArrayList<>();
    private HashMap<String, Double> groceryList = new HashMap<>();
    //  [Apple, Apple, Bread]
    //  [1,2,3]

    private double sum;

    public GroceryListManager() {
//         this.groceryList =
        this.sum = 0;
    }

    public void addItem(String item, double cost) {
        if (!this.checkItem(item)) {
            System.out.println("Adding " + item + " to list..");
//            this.groceryList.add(item);  // array list
            this.groceryList.put(item, cost); // HashMap // can rewrite without check
        }
    }

    public void removeItem(String item) {
        if (this.checkItem(item))
            this.groceryList.remove(item);
    }

    public void displayRemoveItem(String item) {
        if (!checkItem(item)) {
            System.out.println("\"" + item + "\" does not exist in the list");
        } else {
            removeItem(item);
            System.out.println("Remove " + "\"" + item + "\" from the list...");
        }
    }

    public void displayList() {
        int index = 1;
        for (Map.Entry<String, Double> product : this.groceryList.entrySet()) {
            String name = product.getKey();
            Double cost = product.getValue();
            System.out.println(index + ". " + name + " - " + cost + " eurs");
            index++;
        }
//        for (int i = 0; i < this.groceryList.size(); i++) {
//            System.out.println((i + 1) + ". " + this.groceryList.get(i));
//
//        }
    }

    public void displayCheckItemStr(String item) {
        System.out.println("is \"" + item + "\" in the grocery list? " + this.checkItem(item));
    }

    public boolean checkItem(String item) {
//        return this.groceryList.contains(item); // ArrayList
        return this.groceryList.containsKey(item); // HashMap

    }

    public void totalCost() {
        double sum = 0;
        for (Map.Entry<String, Double> product : this.groceryList.entrySet()) {
            String name = product.getKey();
            double cost = product.getValue();
//            System.out.println(name + " " + cost);
            sum += cost;

        }
        this.sum = sum;

    }

    public void displaySum() {
        this.totalCost();
        System.out.println("Sum: " + this.sum);
    }


    public static void main(String[] args) {
        GroceryListManager system = new GroceryListManager();
        system.addItem("Apple", 10);
        system.addItem("Orange", 20);
        system.addItem("Milk", 5);
        system.addItem("Bread", 6);
        System.out.println();
        System.out.println("Grocery List:");
        system.displayList();
        system.displaySum();
        System.out.println();
        String checkItem = "Milk";
        String checkNonExist = "Iphone";
        system.displayCheckItemStr(checkItem);
        system.displayCheckItemStr(checkNonExist);
        System.out.println();
        system.displayRemoveItem(checkItem);
        system.displayRemoveItem(checkNonExist);
        System.out.println();
        System.out.println("Update Grocery List:");
        system.displayList();
        system.displaySum();


    }

}
