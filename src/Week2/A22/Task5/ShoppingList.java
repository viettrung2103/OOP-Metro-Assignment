package Week2.A22.Task5;

import java.util.HashMap;
import java.util.Map;

public class ShoppingList {
    private HashMap<String, Product> productList = new HashMap<>();
    private double sum;
    private String name;

    public ShoppingList(String name) {
        this.name = name;
        this.sum = 0;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addItem(String item, double cost, String category, int quantity) {
        if (!this.checkItem(item)) {
            Product newProduct = new Product(item, cost, category, quantity);
            System.out.println("Adding " + newProduct.getName() + " to list..");
//            this.productList.add(item);  // array list
            this.productList.put(item, newProduct); // HashMap
        }
    }

    public void removeItem(String item) {
        if (this.checkItem(item))
            this.productList.remove(item);
    }

    public void displayRemoveItem(String item) {
        if (!checkItem(item)) {
            System.out.println("\"" + item + "\" does not exist in the \""+this.name+"\" list");
        } else {
            removeItem(item);
            System.out.println("Remove " + "\"" + item + "\" from the \""+this.name+"\" list...");
        }
    }

    public void displayList() {
        int index = 1;
        System.out.println("List:");
        for (Map.Entry<String, Product> productEntry : this.productList.entrySet()) {
            String name = productEntry.getKey();
            Product product = productEntry.getValue();
            double cost = product.getCost();
            String category = product.getCategory();
            System.out.println(index + ". " + product);
            index++;
        }
    }

    public void displayCheckItemStr(String item) {
        System.out.println("is \"" + item + "\" in the \""+this.name+"\" list? " + this.checkItem(item));
    }

    public boolean checkItem(String item) {
//        return this.productList.contains(item); // ArrayList
        return this.productList.containsKey(item); // HashMap

    }

    public void totalCost() {
        double sum = 0;
        for (Map.Entry<String, Product> productEntry : this.productList.entrySet()) {
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
        for (Map.Entry<String,Product> productEntry : this.productList.entrySet()) {
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
        for (Map.Entry<String, Product> productEntry : this.productList.entrySet()) {
            String name = productEntry.getKey();
            Product product = productEntry.getValue();
            String category = product.getCategory();
            if (category.equals(checkCategory)) {
                System.out.println((countProduct + 1) + ". " + product);
                countProduct++;
            }
        }
        if (countProduct == 0) {
            System.out.println(this.name+"has no products in \""+ checkCategory+"\" category.");
        }
    }

    public Product findProduct(String item) {
        if (this.checkItem(item)) {
            return this.productList.get(item);
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
        for (Map.Entry<String, Product> productEntry : productList.entrySet()) {
            String name = productEntry.getKey();
            Product product = productEntry.getValue();
            if (!product.noStock()) {
                countProduct++;
                System.out.println(countProduct + ". " + product);
            }

        }
    }

    @Override
    public String toString(){
        return this.name+" List:";
    }

}
