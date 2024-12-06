package application;

import datasource.MariaDbConnection;
import view.CurrencyGUI;

public class CurrencyApp {
    public static void main(String[] args) {

        CurrencyGUI.launch(CurrencyGUI.class);
        MariaDbConnection.terminate();
    }
}
