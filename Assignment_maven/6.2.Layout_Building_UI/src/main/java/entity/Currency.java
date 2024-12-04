package entity;

public class Currency {
    private String name;
    private double rate; // from usd to other rate

    public Currency(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    public double convert(double money, Currency anotherCurrency) {
        double result = money * anotherCurrency.getRate() * 1.0 / this.rate;
        return result;
    }

    public double getRate() {
        return this.rate;
    }

    public void setRate(double newRate){
        this.rate = newRate;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }


}
