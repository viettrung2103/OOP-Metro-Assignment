package entity;

public class Currency {
    private String abbrName;
    private double rate; // from usd to other rate

    public Currency(String name, double rate) {
        this.abbrName = name;
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

    public String getAbbrName() {
        return this.abbrName;
    }

    @Override
    public String toString() {
        return this.abbrName +" : "+this.rate;
    }


}
