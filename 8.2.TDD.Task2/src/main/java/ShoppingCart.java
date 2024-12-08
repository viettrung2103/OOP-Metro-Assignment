import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private HashMap<String, Item> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void addItem(String name, double price) {
        Item newItem = new Item(name, price);
        items.put(name, newItem);

    }

    public void removeItem(String string) {
        this.items.remove(string);
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<String, Item> entry : this.items.entrySet()) {
            String name = entry.getKey();
            Item item = entry.getValue();
            total += item.getPrice();
        }
        return total;
    }
}
