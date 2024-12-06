package view;

import controller.CurrencyController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import entity.Currency;

import java.util.Map;

public class CurrencyGUI extends Application {
    private String currentBaseCurrencyStr = "USD";
    private String currentToCurrencyStr = "USD";

    private final String title = "Currency Converter";

    private CurrencyController controller;
    private Label appLabel;
    private Label instructionLabel;
    private Label baseCurrencyLabel;
    private Label toCurrencyLabel;

    TextField valueInput;
    TextField convertedValueOutput;

    private Button convertButton, addButton;
    private Label rateLabel;

    private boolean databaseError = false;

    ChoiceBox baseCurrencyChoiceBox;
    ChoiceBox toCurrencyChoiceBox;


    @Override
    public void start(Stage stage) {
        if (databaseError) {
            rateLabel.setText("Error: Unable to connect to the database. Please try again later.");
        } else {
            rateLabel.setText("Connecting to database...");
        }
        // setup UI:


        BorderPane root = new BorderPane();

        this.appLabel = new Label("Currency Converter");
        this.instructionLabel = new Label("Choose the base currency and the currency that you want to convert to. Type the value and press convert");
        this.baseCurrencyLabel = new Label("From Currency: ");
        this.toCurrencyLabel = new Label("To Currency: ");
        this.convertButton = new Button("Convert");
        this.addButton = new Button("Add Currency");
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

        baseCurrencyChoiceBox = new ChoiceBox();
        this.updateChoiceBox(baseCurrencyChoiceBox);

        toCurrencyChoiceBox = new ChoiceBox();
        this.updateChoiceBox(toCurrencyChoiceBox);

        // set default value
        if (!this.databaseError) {
            baseCurrencyChoiceBox.setValue(currentBaseCurrencyStr);
            toCurrencyChoiceBox.setValue(currentToCurrencyStr);

        }

        baseCurrencyChoiceBox.setOnAction(event -> {
            // first way, acces the model of the choicebox to get the index and item, int and Object type
//            int selectedIdx = baseCurrencyChoiceBox.getSelectionModel().getSelectedIndex();
//            Object selectedItem = baseCurrencyChoiceBox.getSelectionModel().getSelectedItem();
//            String baseCurrency = (String) baseCurrencyChoiceBox.getValue();
            String baseCurrencyStr = (String) baseCurrencyChoiceBox.getValue();
            String toCurrencyStr = (String) toCurrencyChoiceBox.getValue();
//            System.out.println("To currency:" + toCurrency);
            if (!baseCurrencyStr.equals("")&& !toCurrencyStr.equals("")){
                this.controller.startUnitConvertComputation(baseCurrencyStr,toCurrencyStr);
            }

        });



        valueInput = new TextField("");
        convertedValueOutput = new TextField("");

        toCurrencyChoiceBox.setOnAction(event -> {
            String baseCurrencyStr = (String) baseCurrencyChoiceBox.getValue();
            String toCurrencyStr = (String) toCurrencyChoiceBox.getValue();
//            System.out.println("To currency:" + toCurrency);
            if (!baseCurrencyStr.equals("")&& !toCurrencyStr.equals("")){
                this.controller.startUnitConvertComputation(baseCurrencyStr,toCurrencyStr);
            }
        });



//        String input = valueInput.getText();

        convertButton.setOnAction(event -> {
            if (!this.databaseError) {
                String baseCurrencyStr = (String) baseCurrencyChoiceBox.getValue();
                String toCurrencyStr = (String) toCurrencyChoiceBox.getValue();
                currentBaseCurrencyStr = baseCurrencyStr;
                currentToCurrencyStr = toCurrencyStr;
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

                    } catch (NullPointerException e) {
                        rateLabel.setText("Missing number");
                    } catch (NumberFormatException e) {
                        rateLabel.setText("Please type number");
                    }
                }
            }
        });

        addButton.setOnAction(event -> {
//            System.out.println("Add button clicked");

            String addTitle = "Add Currency";
            Button addButton = new Button("Add New Currency");
            Label addLabel = new Label("Add Currency:");
            Label newCurrencyLabel = new Label("New Currency:");
            Label newRateLabel = new Label("Rate:");
            Label errorLabel = new Label("");

            TextField newCurrencyInput = new TextField("");
            TextField newRateInput = new TextField("");


            BorderPane addRoot = new BorderPane();

            VBox center = new VBox();
            HBox newCurrencyLayout = new HBox();
            HBox newRateLayout = new HBox();
            HBox addButtonLayout = new HBox();

            addButton.setOnAction(e -> {
                String newCurrencyStr = newCurrencyInput.getText();
                String newRateStr = newRateInput.getText();

                errorLabel.setText("");
                if (newCurrencyStr.equals("")) {
                    errorLabel.setText("Missing Currency Name");
                } else if (!checkCurrencyNameLength(newCurrencyStr)) {
                    errorLabel.setText("currency name must have 3 characters");
                } else if (!checkAllAlphebets(newCurrencyStr)) {
                    errorLabel.setText("currency name must all be alphabet");
                } else if (newRateStr.equals("")) {
                    errorLabel.setText("Missing Rate");
                } else {
                    try {
                        // if
                        double inputRateValue = Double.parseDouble(newRateStr);
                        // 7.2
                        this.controller.startInsertComputation(newCurrencyStr.toUpperCase(), inputRateValue);
                        Stage currentStage = (Stage) addButton.getScene().getWindow();
                        currentStage.close();
                    } catch (NullPointerException exception) {
                        errorLabel.setText("Missing number");
                    } catch (NumberFormatException exception) {
                        errorLabel.setText("Please type number to your rate");
                    }
                }
//
            });

            newCurrencyLayout.getChildren().addAll(newCurrencyLabel, newCurrencyInput);
            newRateLayout.getChildren().addAll(newRateLabel, newRateInput);
            addButtonLayout.getChildren().addAll(addButton, errorLabel);

//            center.getChildren().add(newCurrencyLayout);
            center.getChildren().addAll(addLabel, newCurrencyLayout, newRateLayout, addButtonLayout);
            // set inset
            Insets lineInsets = new Insets(0, 20, 0, 20);
            Insets insets = new Insets(20, 40, 20, 40);

            VBox.setMargin(addLabel, insets);
            VBox.setMargin(newCurrencyLayout, insets);
            VBox.setMargin(newRateLayout, insets);
            VBox.setMargin(addButtonLayout, insets);

            HBox.setMargin(newCurrencyLabel, lineInsets);
            HBox.setMargin(newCurrencyInput, lineInsets);
            HBox.setHgrow(newCurrencyInput, Priority.ALWAYS);

            HBox.setMargin(newRateLabel, lineInsets);
//            HBox.setMargin(newRateInput,lineInsets);
            HBox.setMargin(newRateInput, lineInsets);
            HBox.setHgrow(newRateInput, Priority.ALWAYS);

            HBox.setMargin(addButton, lineInsets);
            HBox.setMargin(errorLabel, lineInsets);

            newCurrencyInput.prefWidthProperty().bind(newRateInput.prefWidthProperty());

            addRoot.setCenter(center);

            final double initialAddWidth = 500;
            final double initialAddHeight = 250;
            Stage addStage = new Stage();
            Scene addScene = new Scene(addRoot, initialAddWidth, initialAddHeight);
            addStage.setScene(addScene);
            addStage.setTitle(addTitle);
            addStage.showAndWait();
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
        //add button
        left.getChildren().add(addButton);

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

        VBox.setMargin(addButton, insets);

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
        stage.setTitle(title);
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

    public void updateChoiceBox(ChoiceBox choiceBox) {
        choiceBox.getItems().clear();
        for (Map.Entry<String, Currency> entry : this.controller.getCurrencyList().entrySet()) {
            String currencyName = entry.getKey();
            choiceBox.getItems().add(currencyName);
        }
    }

    public void updateChoiceBoxes() {
        updateChoiceBox(this.baseCurrencyChoiceBox);
        updateChoiceBox(this.toCurrencyChoiceBox);
        baseCurrencyChoiceBox.setValue(currentBaseCurrencyStr);
        toCurrencyChoiceBox.setValue(currentToCurrencyStr);

    }

    public boolean checkCurrencyNameLength(String currencyName) {
        return currencyName.length() == 3;
    }

    public boolean checkAllAlphebets(String currencyName) {
        return currencyName.chars().allMatch(Character::isLetter);
        // Character::isLetter == ch -> Character.isLetter(ch);
    }

    public String getCurrentBaseCurrencyStr() {
        return currentBaseCurrencyStr;
    }

    public String getCurrentToCurrencyStr(){
        return currentToCurrencyStr;
    }

//    public

    @Override
    public void init() {
        this.rateLabel = new Label("");
        this.controller = new CurrencyController(this);
    }
}



