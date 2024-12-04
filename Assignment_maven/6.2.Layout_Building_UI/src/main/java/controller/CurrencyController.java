package controller;

import dao.CurrencyDao;
import entity.Currency;
import entity.CurrencyApp;
import view.CurrencyGUI;

import java.util.HashMap;

public class CurrencyController {


    CurrencyApp currencyApp;
    CurrencyGUI gui;
    CurrencyDao currencyDao;

    public CurrencyController(CurrencyGUI gui) {
        this.gui = gui;
        this.currencyDao = new CurrencyDao();
        this.currencyApp = new CurrencyApp();
        this.initiate();
    }

    public void initiate(){
        HashMap<String,Currency> currencyList = (HashMap<String, Currency>) this.currencyDao.getAllCurrencies();
        this.currencyApp.setCurrencyList(currencyList);
    }


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
