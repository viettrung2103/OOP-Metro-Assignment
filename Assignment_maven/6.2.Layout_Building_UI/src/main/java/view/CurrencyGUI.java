package view;

import controller.CurrencyController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import entity.Currency;

import java.util.Map;

public class CurrencyGUI extends Application {

    private final String title = "Currency Converter";

    private CurrencyController controller;
    private Label appLabel;
    private Label instructionLabel;
    private Label baseCurrencyLabel;
    private Label toCurrencyLabel;


//    private TextArea inputValue;
//    private TextArea convertedValue;

    TextField valueInput;
    TextField convertedValueOutput;

    private Button convertButton;
    private Label rateLabel;

    private boolean databaseError = false;


    @Override
    public void start(Stage stage) {
        if (databaseError) {
            rateLabel.setText("Error: Unable to connect to the database. Please try again later.");
        }
        // setup UI:


        BorderPane root = new BorderPane();

        this.appLabel = new Label("Currency Converter");
        this.instructionLabel = new Label("Choose the base currency and the currency that you want to convert to. Type the value and press convert");
        this.baseCurrencyLabel = new Label("From Currency: ");
        this.toCurrencyLabel = new Label("To Currency: ");
        this.convertButton = new Button("Convert");
//        this.rateLabel = new Label("");


        // create layout componet and add layout
        VBox left = new VBox();
        HBox instructionLayout = new HBox();
        HBox baseCurrencyLayout = new HBox();
        HBox toCurrencyLayout = new HBox();

        StackPane topCenter = new StackPane();
        root.setTop(topCenter);
        topCenter.getChildren().add(this.appLabel);
        topCenter.setAlignment(Pos.CENTER);

        ChoiceBox baseCurrencyChoiceBox = new ChoiceBox();
        for (Map.Entry<String, Currency> entry : this.controller.getCurrencyList().entrySet()) {
            String currencyName = entry.getKey();
            baseCurrencyChoiceBox.getItems().add(currencyName);
        }
//        String baseCurrency;
        baseCurrencyChoiceBox.setOnAction(event -> {
            // first way, acces the model of the choicebox to get the index and item, int and Object type
//            int selectedIdx = baseCurrencyChoiceBox.getSelectionModel().getSelectedIndex();
//            Object selectedItem = baseCurrencyChoiceBox.getSelectionModel().getSelectedItem();
            String baseCurrency = (String) baseCurrencyChoiceBox.getValue();
//            System.out.println("Selection made: [" + selectedIdx + "] " + selectedItem);
            System.out.println("base currency" + baseCurrency);
        });

        ChoiceBox toCurrencyChoiceBox = new ChoiceBox();
        for (Map.Entry<String, Currency> entry : this.controller.getCurrencyList().entrySet()) {
            String currencyName = entry.getKey();
            toCurrencyChoiceBox.getItems().add(currencyName);
        }

        toCurrencyChoiceBox.setOnAction(event -> {
            String toCurrency = (String) toCurrencyChoiceBox.getValue();
            System.out.println("To currency:" + toCurrency);
        });

        // set default value
        if (!this.databaseError) {
            baseCurrencyChoiceBox.setValue("USD");
            toCurrencyChoiceBox.setValue("EUR");
        }

        valueInput = new TextField("");
        convertedValueOutput = new TextField("");
//        String input = valueInput.getText();

        convertButton.setOnAction(event -> {
            if (!this.databaseError) {
                String baseCurrencyStr = (String) baseCurrencyChoiceBox.getValue();
                String toCurrencyStr = (String) toCurrencyChoiceBox.getValue();
                rateLabel.setText("");
                if (baseCurrencyStr == null) {
                    rateLabel.setText("Base currency missing");
                } else if (toCurrencyStr == null) {
                    rateLabel.setText("Convert currency missing");
                } else {
                    try {
                        // if

                        double inputValue = Double.parseDouble(valueInput.getText());
                        // 7.2
                        this.controller.startConvertComputation(inputValue, baseCurrencyStr, toCurrencyStr);

                        // 6.2
//                    double result = this.controller.convert(inputValue, baseCurrencyStr, toCurrencyStr);
//                    double resultOneUnit = this.controller.convert(1.0, baseCurrencyStr, toCurrencyStr);
//                    System.out.println("from " + baseCurrencyStr + ": " + inputValue + " to " + toCurrencyStr + ": " + result);
//                    convertedValueOutput.setText(String.format("%.2f", result));
//                    rateLabel.setText("1 " + baseCurrencyStr + " = " + String.format("%.2f", resultOneUnit) + " " + toCurrencyStr);
                    } catch (NullPointerException e) {
                        rateLabel.setText("Missing number");
                    } catch (NumberFormatException e) {
                        rateLabel.setText("Please type number");
                    }
                }
            }
        });


        instructionLayout.getChildren().add(this.instructionLabel);
        baseCurrencyLayout.getChildren().
                add(this.baseCurrencyLabel);
        baseCurrencyLayout.getChildren().
                add(baseCurrencyChoiceBox);
        baseCurrencyLayout.getChildren().
                add(valueInput);
        baseCurrencyLayout.getChildren().
                add(this.convertButton);
        toCurrencyLayout.getChildren().
                add(this.toCurrencyLabel);
        toCurrencyLayout.getChildren().
                add(toCurrencyChoiceBox);
        toCurrencyLayout.getChildren().
                add(convertedValueOutput);
        toCurrencyLayout.getChildren().add(rateLabel);
        left.getChildren().add(instructionLayout);
        left.getChildren().
                add(baseCurrencyLayout);
        left.getChildren().
                add(toCurrencyLayout);
        root.setLeft(left);


        //add outside margin:
        Insets lineInsets = new Insets(0, 20, 0, 20);
        Insets insets = new Insets(20, 40, 20, 40);
//        toCurrencyChoiceBox.setMar
        StackPane.setMargin(topCenter, insets);
        VBox.setMargin(instructionLayout, insets);
        HBox.setMargin(instructionLabel, lineInsets);
        VBox.setMargin(baseCurrencyLayout, insets);
        HBox.setMargin(baseCurrencyLabel, lineInsets);
        HBox.setMargin(baseCurrencyChoiceBox, lineInsets);
        HBox.setMargin(convertButton, lineInsets);

        VBox.setMargin(toCurrencyLayout, insets);
        HBox.setMargin(toCurrencyLabel, lineInsets);
        HBox.setMargin(toCurrencyChoiceBox, lineInsets);
        HBox.setMargin(rateLabel, lineInsets);

        BorderPane.setMargin(left, insets);

        Scene scene = new Scene(root);
        stage.setTitle("Currency Converter");
        stage.setScene(scene);
        stage.show();
    }


    public void displayConvertedResult(double result, String baseCurrencyStr, String toCurrencyStr) {
        convertedValueOutput.setText(String.format("%.2f", result));
//        rateLabel.setText("1 " + baseCurrencyStr + " = " + String.format("%.2f", resultOneUnit) + " " + toCurrencyStr);

    }

    public void displayConvertedRateResult(double resultOneUnit, String baseCurrencyStr, String toCurrencyStr) {
        rateLabel.setText("1 " + baseCurrencyStr + " = " + String.format("%.2f", resultOneUnit) + " " + toCurrencyStr);
    }

    public void setEmptyDatabase() {
        databaseError = true;
    }

    public void displayNoDatabaseError() {
//        databaseError = true;
        rateLabel.setText("Cannot connect to database");
    }

    @Override
    public void init() {
        this.rateLabel = new Label("");
        this.controller = new CurrencyController(this);
    }
}
