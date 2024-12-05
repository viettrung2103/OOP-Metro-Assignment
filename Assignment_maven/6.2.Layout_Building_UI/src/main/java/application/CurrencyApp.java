package application;

import datasource.MariaDbConnection;
import view.CurrencyGUI;

public class CurrencyApp {
    public static void main(String[] args) {

//        CurrencyDao currencyDao = new CurrencyDao();
//
//        System.out.println(currencyDao.findById(1));

        CurrencyGUI.launch(CurrencyGUI.class);
        MariaDbConnection.terminate();
    }
}
