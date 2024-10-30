package Week2.A22.Task3;

public class Product {
    private String name;
    private double cost;
    private String category;

    public Product(String name, double cost, String category) {
        this.name = name;
        this.cost = cost;
        this.category = category;
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

    @Override
    public String toString() {
        return "(" + this.name + " - " + this.cost + " - " + this.category + ")";
    }
}
