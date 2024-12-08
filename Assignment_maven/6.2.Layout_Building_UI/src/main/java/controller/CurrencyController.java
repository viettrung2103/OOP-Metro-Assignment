package controller;

import dao.CurrencyDao;
import dao.TransactionDao;
import entity.Currency;
import entity.CurrencyApp;
import entity.Transaction;
import javafx.application.Platform;
import javafx.scene.control.TableView;
import view.CurrencyGUI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyController {


    CurrencyApp currencyApp;
    CurrencyGUI gui;
    CurrencyDao currencyDao;
    TransactionDao transactionDao;

    public CurrencyController(CurrencyGUI gui) {
        this.gui = gui;
        this.currencyDao = new CurrencyDao();
        this.transactionDao = new TransactionDao();
        this.currencyApp = new CurrencyApp();

        this.initiate();

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

                System.out.println("current: " + currentBaseStr + " to: " + currentToStr);
                Platform.runLater(() -> {
                    this.gui.setInitilizeDatabase(true);
                    this.gui.setDatabaseError(false);
                    this.gui.displayConvertedRateResult(resultOneUnit, currentBaseStr, currentToStr);
                    this.gui.displayNewCurrencyNameLabel(baseCurrency.getName(), toCurrency.getName());
                    this.gui.updateChoiceBoxes();
                });
            } catch (Exception e) {

                Platform.runLater(() -> {
                    this.gui.setInitilizeDatabase(true);
                    this.gui.setDatabaseError(true);
                    this.gui.displayNoDatabaseError();
                });
            }

        }).start();

    }


//    public void addCurrency(String currencyName, double rate) {
//        this.currencyApp.addCurrency(currencyName, rate);
//
//    }

    public HashMap<String, Currency> getCurrencyList() {
        return this.currencyApp.getCurrencyList();
    }

    // when implement UI, change from return double to void as return value is display in UI
//    public double convert(double value, String baseCurrency, String convertedCurrency) {
//
//        double result = this.currencyApp.convert(value, baseCurrency, convertedCurrency);
//        return result;
//    }

    //start  thread
    public void startConvertComputation(double inputValue, String baseCurrencyStr, String toCurrencyStr) {
        new Thread(() -> {
            try {
//                Currency baseCurrency = this.currencyDao.getCurrency(baseCurrencyStr);
//                Currency toCurrency = this.currencyDao.getCurrency(toCurrencyStr);
                Currency baseCurrency = this.currencyDao.findByName(baseCurrencyStr);
                Currency toCurrency = this.currencyDao.findByName(toCurrencyStr);


                double result = baseCurrency.convert(inputValue, toCurrency);

                Transaction newTransacion = new Transaction(inputValue, baseCurrency, toCurrency);

                //addpersist transaction to db
                this.transactionDao.addPersist(newTransacion);
                System.out.println(newTransacion + " is added to databae");

                double resultOneUnit = baseCurrency.convert(1, toCurrency);
                System.out.println(inputValue + " from " + baseCurrency + " to " + toCurrency + ": " + result);
                Platform.runLater(() -> {
                            this.gui.displayConvertedResult(result, baseCurrencyStr, toCurrencyStr);
                            this.gui.displayConvertedRateResult(resultOneUnit, baseCurrencyStr, toCurrencyStr);
                        }
                );
            } catch (Exception e) {
                Platform.runLater(() -> {
                    this.gui.displayNoDatabaseError();
                });
//                this.gui.displayNoDatabaseError();
            }
        }
        ).start();
    }

    public void startUnitConvertComputation(String baseCurrencyStr, String toCurrencyStr) {
        new Thread(() -> {
            try {
                Currency baseCurrency = this.currencyDao.findByName(baseCurrencyStr);
                Currency toCurrency = this.currencyDao.findByName(toCurrencyStr);
                this.gui.setCurrentBaseCurrencyStr(baseCurrencyStr);
                this.gui.setCurrentToCurrencyStr(toCurrencyStr);
                double resultOneUnit = baseCurrency.convert(1, toCurrency);
                Platform.runLater(() -> {
                    this.gui.displayConvertedRateResult(resultOneUnit, baseCurrencyStr, toCurrencyStr);
                    this.gui.displayNewCurrencyNameLabel(baseCurrency.getName(), toCurrency.getName());

                });
            } catch (Exception e) {
                Platform.runLater(() -> {
                    this.gui.displayNoDatabaseError();
                });
//                this.gui.displayNoDatabaseError();
            }
        }).start();
    }

    public void startInsertComputation(String newAbbrName, String newCurrencyName, double newInput) {
//        String newCurrencyName = "test Currency";
        new Thread(() -> {
            System.out.println(newCurrencyName + " : " + newInput);
            Currency newCurrency = new Currency(newAbbrName, newCurrencyName, newInput);
            this.currencyDao.addPersist(newCurrency);
            HashMap<String, Currency> updateList = this.currencyDao.findAll();


            //if the currencyList is empty
            if (this.currencyApp.getCurrencyList().isEmpty()) {
                this.gui.setCurrentBaseCurrencyStr(newAbbrName);
                this.gui.setCurrentToCurrencyStr(newAbbrName);
                this.gui.setDatabaseError(false);
            }
            // update currencyList in model
            this.currencyApp.setCurrencyList(updateList);
            // update dropbox in view with new currencyList
            Platform.runLater(() -> {
                this.gui.updateChoiceBoxes();
//                this.gui.displayConvertedRateResult();
            });

            this.startUnitConvertComputation(this.gui.getCurrentBaseCurrencyStr(), this.gui.getCurrentToCurrencyStr());

        }).start();
    }

    public void startDisplayTransactionCalculation() {
        new Thread(() -> {
            try {
                List<Transaction> transactionList = transactionDao.findAll();
//                TableView<Transaction> tableView = this.gui.getTransactionTableView();
                System.out.println(transactionList);
                Platform.runLater(() -> {
                    this.gui.displayTransactionList(transactionList);
                });
            } catch (Exception e) {
                Platform.runLater(() -> {
                    this.gui.displayNoDatabaseError();
                });
            }

        }).start();
    }
}
