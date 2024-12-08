package entity;


import jakarta.persistence.*;

@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "abbreviation")
    private String abbrName;
    private String name;
    private double rate; // from usd to other rate

    public Currency(String abbrName, String name, double rate) {
        this.abbrName = abbrName;
        this.name = name;
        this.rate = rate;
    }
    public Currency(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRate() {
        return this.rate;
    }

    public void setRate(double newRate) {
        this.rate = newRate;
    }

    public String getAbbrName() {
        return this.abbrName;
    }

    public void setAbbrName(String abbrName) {
        this.abbrName = abbrName;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public double convert(double money, Currency anotherCurrency) {
        double result = money * anotherCurrency.getRate() * 1.0 / this.rate;
        return result;
    }

    @Override
    public String toString() {
        return this.abbrName;
    }


}
