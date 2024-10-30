package Week2.A22.Task4;

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

    public void addItem(String item, double cost, String category, int quantity) {
        if (!this.checkItem(item)) {
            Product newProduct = new Product(item, cost, category, quantity);
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
        for (Map.Entry<String, Product> productEntry : this.groceryList.entrySet()) {
            String name = productEntry.getKey();
            Product product = productEntry.getValue();
            double cost = product.getCost();
            String category = product.getCategory();
            System.out.println(index + ". " + product);
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
        for (Map.Entry<String, Product> productEntry : this.groceryList.entrySet()) {
            String name = productEntry.getKey();
            Product product = productEntry.getValue();
//            System.out.println(name + " " + cost);
            double cost = product.getCost();
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
        for (Map.Entry<String, Product> productEntry : this.groceryList.entrySet()) {
            String name = productEntry.getKey();
            Product product = productEntry.getValue();
            String category = product.getCategory();
            if (category.equals(checkCategory)) {
                isExist = true;
                break;
            }

        }
        return isExist;
    }

    public void displayProductWithCategory(String checkCategory) {
        int countProduct = 0;
        System.out.println("Products with category \"" + checkCategory + "\":");
        for (Map.Entry<String, Product> productEntry : this.groceryList.entrySet()) {
            String name = productEntry.getKey();
            Product product = productEntry.getValue();
            String category = product.getCategory();
            if (category.equals(checkCategory)) {
                System.out.println((countProduct + 1) + ". " + product);
                countProduct++;
            }
        }
        if (countProduct == 0) {
            System.out.println("There are no products in this category.");
        }
    }

    public Product findProduct(String item) {
        if (this.checkItem(item)) {
            return this.groceryList.get(item);
        } else
            return null;
    }

    public void updateQuantiTy(String item, int newQuantity) {
        Product product = this.findProduct(item);
        if (product != null) {
            product.updateQuantity(newQuantity);
        }
    }

    public void displayAvailableItems() {
        System.out.println("List of available Items:");
        int countProduct = 0;
        for (Map.Entry<String, Product> productEntry : groceryList.entrySet()) {
            String name = productEntry.getKey();
            Product product = productEntry.getValue();
            if (!product.noStock()) {
                countProduct++;
                System.out.println(countProduct + ". " + product);
            }

        }
    }


    public static void main(String[] args) {
        GroceryListManager system = new GroceryListManager();
        system.addItem("Apple", 10, "Fruit", 3);
        system.addItem("Orange", 20, "Fruit", 3);
        system.addItem("Milk", 5, "Dairy", 3);
        system.addItem("Bread", 6, "Bakery", 3);
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
        System.out.println();
        system.displayAvailableItems();
        System.out.println("Updating quantity");
        int goodQuantity = 5;
        int badQuantity = -5;
        system.updateQuantiTy("Apple", goodQuantity);
        system.updateQuantiTy("Orange", badQuantity);
        system.displayAvailableItems();


    }

}
