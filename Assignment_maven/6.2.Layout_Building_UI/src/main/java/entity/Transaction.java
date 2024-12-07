package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double amount;

    @ManyToOne
    @JoinColumn(name = "base_currency_id")
    private Currency baseCurrency;
    @ManyToOne
    @JoinColumn(name = "to_currency_id")
    private Currency toCurrency;

    public Transaction(double amount, Currency baseCurrency, Currency toCurrency) {

        this.amount = amount;
        this.baseCurrency = baseCurrency;
        this.toCurrency = toCurrency;
    }

    public Transaction() {

    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setBaseCurrency(Currency baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public Currency getBaseCurrency() {
        return baseCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
        this.toCurrency = toCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    @Override
    public String toString() {
        return "Convert " + this.amount + " " + this.baseCurrency + " to " + this.toCurrency;
    }
}

