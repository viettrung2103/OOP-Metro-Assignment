package Week2.A22.Task5;

import java.util.HashMap;
import java.util.Map;

public class GroceryListManager {


    private HashMap<String, ShoppingList> listsOfList = new HashMap<>();


    public GroceryListManager() {

    }

    public void addingShoppingList(ShoppingList list) {
        String listName = list.getName();
        if (!this.isShoppingListExist(listName)) {
            System.out.println("Adding to " + list.getName() + " List to system.");
            String name = list.getName();
            this.listsOfList.put(name, list);
        } else {
            System.out.println("The " + list.getName() + "List is already existed.");
        }
    }

    public boolean isShoppingListExist(String name) {
        return this.listsOfList.containsKey(name);
    }

    public void removeShoppingList(String name) {
        System.out.println("Removing " + name + " List ... Done");
        if (isShoppingListExist(name)) {
            this.listsOfList.remove(name);
        } else {
            System.out.println("The " + name + " does not exist in the system");
        }
    }

    public void displayAllListDetails() {
        System.out.println("Display all lists:");
        for (Map.Entry<String, ShoppingList> listEntry : listsOfList.entrySet()) {
            ShoppingList list = listEntry.getValue();
            System.out.println(list);
            list.displayAvailableItems();
        }
    }



    public static void main(String[] args) {
        GroceryListManager system = new GroceryListManager();
        ShoppingList groceryList = new ShoppingList("Grocery");
        ShoppingList halloweenList = new ShoppingList("Haloween");
        system.addingShoppingList(groceryList);
        system.addingShoppingList(halloweenList);
//        system.addingShoppingList(groceryList);

        system.displayAllListDetails();

        System.out.println(groceryList);
        groceryList.addItem("Apple", 10, "Fruit", 3);
        groceryList.addItem("Orange", 20, "Fruit", 3);
        groceryList.addItem("Milk", 5, "Dairy", 3);
        groceryList.addItem("Bread", 6, "Bakery", 3);
        System.out.println();

        halloweenList.addItem("Bumpkin",10,"Fruit",3);

//        System.out.println("Grocery List:");
        groceryList.displayList();
        groceryList.displaySum();
        System.out.println();
        String checkExistItem = "Milk";
        String checkNonExistItem = "Iphone";
        String checkExistCategory = "Fruit";
        String checkNonExistCategory = "Electronic";
        groceryList.displayCheckItemStr(checkExistItem);
        groceryList.displayCheckItemStr(checkNonExistItem);
        System.out.println();

        groceryList.displayProductWithCategory(checkExistCategory);
        groceryList.displayProductWithCategory(checkNonExistCategory);
        System.out.println();

        groceryList.displayRemoveItem(checkExistItem);
        groceryList.displayRemoveItem(checkNonExistItem);
        System.out.println();

        System.out.println("Update " + groceryList + " List:");
        groceryList.displayList();
        groceryList.displaySum();
        System.out.println();

        groceryList.displayAvailableItems();
        System.out.println("Updating quantity");
        int goodQuantity = 5;
        int badQuantity = -5;
        groceryList.updateQuantiTy("Apple", goodQuantity);
        groceryList.updateQuantiTy("Orange", badQuantity);
        groceryList.displayAvailableItems();
        System.out.println();

        system.displayAllListDetails();
        String existingList = "Grocery";
        String nonExistingList = "Electronic";
        system.removeShoppingList(existingList);
        system.removeShoppingList(nonExistingList);
        system.displayAllListDetails();
    }

}
