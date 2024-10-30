package Week2.A22;

import java.util.ArrayList;

public class GrceryListManager {

    private ArrayList<String> groceryList = new ArrayList<>();

    public GrceryListManager() {
//         this.groceryList =
    }

    public void addItem(String item) {
        if (!this.checkItem(item)) {
            System.out.println("Adding " + item + " to list..");
            this.groceryList.add(item);
        }
    }

    public void removeItem(String item) {
        if (this.checkItem(item))
            this.groceryList.remove(item);
    }

    public void displayRemoveItem(String item) {
        if (!checkItem(item)) {
            System.out.println("\""+item+"\" does not exist in the list");
        } else {
            removeItem(item);
            System.out.println("Remove " + "\"" + item + "\" from the list...");
        }
    }

    public void displayList() {
        for (int i = 0; i < this.groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + this.groceryList.get(i));

        }
    }

    public void displayCheckItemStr(String item) {
        System.out.println("is \"" + item + "\" in the grocery list? " + this.checkItem(item));
    }

    public boolean checkItem(String item) {
        return this.groceryList.contains(item);

    }


    public static void main(String[] args) {
        GrceryListManager system = new GrceryListManager();
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
