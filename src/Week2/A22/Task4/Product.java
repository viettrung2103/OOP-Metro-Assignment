package Week2.A22.Task4;

public class Product {
    private String name;
    private double cost;
    private String category;
    private int quantity;

    public Product(String name, double cost, String category, int quantity) {
        this.name = name;
        this.cost = cost;
        this.category = category;
        this.quantity = quantity;
    }

    public double getCost() {
        return this.cost;
    }

    public String getName() {
        return this.name;
    }

    public String getCategory() {
        return this.category;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void updateQuantity(int quantity) {
        this.quantity = quantity;
        if (quantity < 0) {
            this.quantity = 0;
        }
    }

    public boolean noStock() {
        return this.quantity == 0;
    }

    @Override
    public String toString() {
        String money = "eur";
        String unit = "pc";
        if (this.cost > 1) {
            money = "eurs";
        }
        if (this.quantity > 1) {
            unit = "pcs";
        }
        return "(" + this.name + " - " + this.cost + " " + money + " - " + this.quantity + " " + unit +
                " - " + this.category + ")";
    }
}
