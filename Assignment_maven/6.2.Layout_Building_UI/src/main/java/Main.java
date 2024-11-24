import controller.CurrencyController;
import model.CurrencyApp;
import view.CurrencyGUI;

public class Main {
    public static void main(String[] args) {
//        Currency baseCurrency = new Currency("USD", 1);
//        Currency GBP = new Currency("GBP", 0.8);
//        Currency EUR = new Currency("EUR", 0.96);
//        Currency VND = new Currency("VND", 25418.97);
//        CurrencyApp currencyApp = new CurrencyApp();
//        currencyApp.addCurrency("USD",1);
//        currencyApp.addCurrency("GBP",0.8);
//        currencyApp.addCurrency("EUR",0.96);
//        currencyApp.addCurrency("VND",25418.97);
//
//        CurrencyController controller = new CurrencyController();
//        controller.setCurrencyApp(currencyApp);
//
//        double value = 10.0;
//        String inputCurrencyStr = "EUR";
//        String convertedCurrencyStr = "VND";
//        double converted = controller.convert(value, inputCurrencyStr, convertedCurrencyStr);
//        System.out.println(inputCurrencyStr + ": " + value);
//        System.out.println(convertedCurrencyStr + ": " + converted);

        CurrencyGUI.launch(CurrencyGUI.class);
    }
}
