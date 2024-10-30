package Week2.A22.Task1;

import java.util.ArrayList;

public class GroceryListManager {

    private ArrayList<String> groceryList = new ArrayList<>();
//    private HashMap<String, Double> groceryList = new HashMap<>();

    public GroceryListManager() {
//         this.groceryList =
    }

    public void addItem(String item) {
        if (!this.checkItem(item)) {
            System.out.println("Adding " + item + " to list..");
            this.groceryList.add(item);  // array list
//            this.groceryList.put(item, cost); // HashMap
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
        //HashMap
//        int index = 1;
//        for (Map.Entry<String, Double> product : groceryList.entrySet()) {
//            String name = product.getKey();
//            Double cost = product.getValue();
//            System.out.println(index + ". " + name + " - " + cost + " eurs");
//        }
        //ArrayList
        for (int i = 0; i < this.groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + this.groceryList.get(i));

        }
    }

    public void displayCheckItemStr(String item) {
        System.out.println("is \"" + item + "\" in the grocery list? " + this.checkItem(item));
    }

    public boolean checkItem(String item) {
        return this.groceryList.contains(item); // ArrayList
//        return this.groceryList.containsKey(item); // HashMap

    }

//    public double totalCost() {
//        double sum = 0;
//        for (Map.Entry<String, Double> product : groceryList.entrySet()) {
//            String name = product.getKey();
//            double cost = product.getValue();
//            sum += cost;
//        }
//        return sum;
//    }


    public static void main(String[] args) {
        GroceryListManager system = new GroceryListManager();
        system.addItem("Apple");
        system.addItem("Orange");
        system.addItem("Milk");
        system.addItem("Bread");
        System.out.println("");
        System.out.println("Grocery List:");
        system.displayList();
        System.out.println("");
        String checkItem = "Milk";
        String checkNonExist = "Iphone";
        system.displayCheckItemStr(checkItem);
        system.displayCheckItemStr(checkNonExist);
        System.out.println("");
        system.displayRemoveItem(checkItem);
        system.displayRemoveItem(checkNonExist);
        System.out.println("");
        System.out.println("Update Grocery List:");
        system.displayList();


    }

}
