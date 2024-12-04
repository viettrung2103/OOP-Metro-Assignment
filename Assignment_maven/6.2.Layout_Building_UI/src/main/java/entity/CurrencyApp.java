package entity;

import java.util.HashMap;

public class CurrencyApp {
    Currency baseCurrency;
    Currency convertedCurrency;
    HashMap<String, Currency> currencyList;

    public CurrencyApp() {
        this.currencyList = new HashMap<>();
    }

    public void addCurrency(String currencyName, double rate) {
        Currency newCurrency = new Currency(currencyName, rate);
        this.currencyList.put(currencyName, newCurrency);
    }

    public Currency getCurrency(String currencyStr) {
        return this.currencyList.get(currencyStr);
    }

    public double convert(double value, String baseCurrency, String convertedCurrency) {
        this.baseCurrency = this.getCurrency(baseCurrency);
        this.convertedCurrency = this.getCurrency(convertedCurrency);
        double result = this.baseCurrency.convert(value, this.convertedCurrency);
        return result;
    }

    public void setCurrencyList(HashMap<String, Currency> currencyList) {
        this.currencyList = currencyList;
    }

    public HashMap<String,Currency> getCurrencyList(){
        return this.currencyList;
    }

    public void setBaseCurrency(Currency baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public void setConvertedCurrency(Currency convertedCurrency) {
        this.convertedCurrency = convertedCurrency;
    }
}
