package controller;

import dao.CurrencyDao;
import entity.Currency;
import entity.CurrencyApp;
import javafx.application.Platform;
import view.CurrencyGUI;

import java.util.HashMap;

public class CurrencyController {


    CurrencyApp currencyApp;
    CurrencyGUI gui;
    CurrencyDao currencyDao;

    public CurrencyController(CurrencyGUI gui) {
        try{
            this.gui = gui;
            this.currencyDao = new CurrencyDao();
            this.currencyApp = new CurrencyApp();
            this.initiate();

        }catch (Exception e){
            // where there is error connecting database
            this.gui.setEmptyDatabase();
        }
    }

    public void initiate() {
        HashMap<String, Currency> currencyList = (HashMap<String, Currency>) this.currencyDao.getAllCurrencies();
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

    //start  thread
    public void startConvertComputation(double inputValue, String baseCurrencyStr, String toCurrencyStr) {
        new Thread(() -> {
            try {
                Currency baseCurrency = this.currencyDao.getCurrency(baseCurrencyStr);
                Currency toCurrency = this.currencyDao.getCurrency(toCurrencyStr);
                double result = baseCurrency.convert(inputValue, toCurrency);
                double resultOneUnit = baseCurrency.convert(1, toCurrency);
                System.out.println(inputValue + " from " + baseCurrency + " to " + toCurrency + ": " + result);
                Platform.runLater(() -> {
                            this.gui.displayConvertedResult(result, baseCurrencyStr, toCurrencyStr);
                            this.gui.displayConvertedRateResult(resultOneUnit, baseCurrencyStr, toCurrencyStr);
                        }
                );
            } catch (Exception e) {
                this.gui.displayNoDatabaseError();
            }
        }
        ).start();

    }


}
