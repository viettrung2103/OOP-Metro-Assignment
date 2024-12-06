package controller;

import dao.CurrencyDao;
import entity.Currency;
import entity.CurrencyApp;
import javafx.application.Platform;
import view.CurrencyGUI;

import java.util.HashMap;
import java.util.Map;

public class CurrencyController {


    CurrencyApp currencyApp;
    CurrencyGUI gui;
    CurrencyDao currencyDao;

    public CurrencyController(CurrencyGUI gui) {
        try {
            this.gui = gui;
            this.currencyDao = new CurrencyDao();
            this.currencyApp = new CurrencyApp();
            this.initiate();

        } catch (Exception e) {
            // where there is error connecting database
            this.gui.setEmptyDatabase();
        }
    }

    public void initiate() {
//        HashMap<String, Currency> currencyList = (HashMap<String, Currency>) this.currencyDao.getAllCurrencies();
//        HashMap<String, Currency> currencyList = (HashMap<String, Currency>) this.currencyDao.findAll();
        new Thread(() -> {
            try {
                HashMap<String, Currency> currencyList = this.currencyDao.findAll();
                this.currencyApp.setCurrencyList(currencyList);
                String currentBaseStr = this.gui.getCurrentBaseCurrencyStr();
                String currentToStr = this.gui.getCurrentToCurrencyStr();

                Currency baseCurrency = this.currencyDao.findByName(currentBaseStr);
                Currency toCurrency = this.currencyDao.findByName(currentToStr);

                double resultOneUnit = baseCurrency.convert(1, toCurrency);

                System.out.println("current: " + currentBaseStr + "to: " + currentToStr);
                Platform.runLater(()->{
                    this.gui.displayConvertedRateResult(resultOneUnit,currentBaseStr,currentToStr);
                    this.gui.updateChoiceBoxes();
                });
            } catch (Exception e) {
                this.gui.displayNoDatabaseError();
            }

        }).start();
//        Platform.runLater(()->{
//        });
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
//                Currency baseCurrency = this.currencyDao.getCurrency(baseCurrencyStr);
//                Currency toCurrency = this.currencyDao.getCurrency(toCurrencyStr);
                Currency baseCurrency = this.currencyDao.findByName(baseCurrencyStr);
                Currency toCurrency = this.currencyDao.findByName(toCurrencyStr);


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

    public void startUnitConvertComputation(String baseCurrencyStr, String toCurrencyStr) {
        new Thread(() -> {
            try {
                Currency baseCurrency = this.currencyDao.findByName(baseCurrencyStr);
                Currency toCurrency = this.currencyDao.findByName(toCurrencyStr);
                double resultOneUnit = baseCurrency.convert(1, toCurrency);
                Platform.runLater(() -> {
                    this.gui.displayConvertedRateResult(resultOneUnit, baseCurrencyStr, toCurrencyStr);
                });
            } catch (Exception e) {
                this.gui.displayNoDatabaseError();
            }
        }).start();
    }

    public void startInsertComputation(String newCurrencyName, double newInput) {
        new Thread(() -> {
            System.out.println(newCurrencyName + " : " + newInput);
            Currency newCurrency = new Currency(newCurrencyName, newInput);
            this.currencyDao.addPersist(newCurrency);
            HashMap<String, Currency> updateList = this.currencyDao.findAll();
            // update currencyList in model
            this.currencyApp.setCurrencyList(updateList);
            // update dropbox in view with new currencyList
            Platform.runLater(() -> {
                this.gui.updateChoiceBoxes();
            });

        }).start();
    }
}
