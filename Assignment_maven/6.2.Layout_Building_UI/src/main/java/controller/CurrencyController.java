package controller;

import model.Currency;
import model.CurrencyApp;
import view.CurrencyGUI;

import java.util.HashMap;

public class CurrencyController {


    CurrencyApp currencyApp;
    CurrencyGUI gui;

    public CurrencyController(CurrencyGUI gui) {
        this.gui = gui;
        this.currencyApp = new CurrencyApp();
    }

//    public void setCurrencyApp() {
//        this.currencyApp = currencyApp;
//    }

    public void addCurrency(String currencyName, double rate) {
        this.currencyApp.addCurrency(currencyName, rate);

    }

    public HashMap<String, Currency> getCurrencyList() {
        return this.currencyApp.getCurrencyList();
    }

    // when implement UI, change from return double to void as return value is display in UI
    public double convert(double value, String baseCurrency, String convertedCurrency) {

        double result = this.currencyApp.convert(value, baseCurrency, convertedCurrency);
        return result;
    }


}
