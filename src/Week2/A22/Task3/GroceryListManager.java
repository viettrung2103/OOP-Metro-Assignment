package Week2.A22.Task3;

import java.util.HashMap;
import java.util.Map;

public class GroceryListManager {

    //    private ArrayList<String> groceryList = new ArrayList<>();
    private HashMap<String, Product> groceryList = new HashMap<>();
    private double sum;

    public GroceryListManager() {
//         this.groceryList =
        this.sum = 0;
    }

    public void addItem(String item, double cost, String category) {
        if (!this.checkItem(item)) {
            Product newProduct = new Product(item, cost, category);
            System.out.println("Adding " + newProduct.getName() + " to list..");
//            this.groceryList.add(item);  // array list
            this.groceryList.put(item, newProduct); // HashMap
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
        for (Map.Entry<String, Product> product : this.groceryList.entrySet()) {
            String name = product.getKey();
            Product curProduct = product.getValue();
            double cost = curProduct.getCost();
            String category = curProduct.getCategory();
            System.out.println(index + ". " + curProduct);
            index++;
        }
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
        for (Map.Entry<String, Product> product : this.groceryList.entrySet()) {
            String name = product.getKey();
            Product curProduct = product.getValue();
//            System.out.println(name + " " + cost);
            double cost = curProduct.getCost();
            sum += cost;

        }
        this.sum = sum;

    }

    public void displaySum() {
        this.totalCost();
        System.out.println("Sum: " + this.sum);
    }

    public boolean checkCategory(String checkCategory) {
        boolean isExist = false;
        for (Map.Entry<String, Product> product : this.groceryList.entrySet()) {
            String name = product.getKey();
            Product curProduct = product.getValue();
            String category = curProduct.getCategory();
            if (category.equals(checkCategory)) {
                isExist = true;
                break;
            }

        }
        return isExist;
    }

    public void displayProductWithCategory(String checkCategory) {
        int countProduct = 0;
        System.out.println("Products with category \"" + checkCategory+"\":");
        for (Map.Entry<String, Product> product : this.groceryList.entrySet()) {
            String name = product.getKey();
            Product curProduct = product.getValue();
            String category = curProduct.getCategory();
            if (category.equals(checkCategory)) {
                System.out.println((countProduct + 1) + ". " + product);
                countProduct++;
            }
        }
        if (countProduct == 0) {
            System.out.println("There are no products in this category.");
        }
    }

    public static void main(String[] args) {
        GroceryListManager system = new GroceryListManager();
        system.addItem("Apple", 10, "Fruit");
        system.addItem("Orange", 20, "Fruit");
        system.addItem("Milk", 5, "Dairy");
        system.addItem("Bread", 6, "Bakery");
        System.out.println();
        System.out.println("Grocery List:");
        system.displayList();
        system.displaySum();
        System.out.println();
        String checkExistItem = "Milk";
        String checkNonExistItem = "Iphone";
        String checkExistCategory = "Fruit";
        String checkNonExistCategory = "Electronic";
        system.displayCheckItemStr(checkExistItem);
        system.displayCheckItemStr(checkNonExistItem);
        System.out.println();
        system.displayProductWithCategory(checkExistCategory);
        system.displayProductWithCategory(checkNonExistCategory);
        System.out.println();
        system.displayRemoveItem(checkExistItem);
        system.displayRemoveItem(checkNonExistItem);
        System.out.println();
        System.out.println("Update Grocery List:");
        system.displayList();
        system.displaySum();


    }

}
