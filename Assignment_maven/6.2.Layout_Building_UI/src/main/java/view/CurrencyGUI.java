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
    private String currentBaseCurrencyStr = "";
    private String currentToCurrencyStr = "";

    private final String title = "Currency Converter";

    private CurrencyController controller;
    private Label appLabel;
    private Label instructionLabel;
    private Label baseCurrencyLabel;
    private Label toCurrencyLabel;
    private Label baseCurrencyNameLabel;
    private Label toCurrencyNameLabel;


    TextField valueInput;
    TextField convertedValueOutput;

    private Button convertButton, addButton;
    private Label rateLabel;

    private boolean databaseError = false;

    ChoiceBox baseCurrencyAbbrNameChoiceBox;
    ChoiceBox toCurrencyAbbrNameChoiceBox;


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
        this.baseCurrencyNameLabel = new Label("");
        this.toCurrencyNameLabel = new Label("");
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

        baseCurrencyAbbrNameChoiceBox = new ChoiceBox();
        this.updateChoiceBox(baseCurrencyAbbrNameChoiceBox);

        toCurrencyAbbrNameChoiceBox = new ChoiceBox();
        this.updateChoiceBox(toCurrencyAbbrNameChoiceBox);

        // set default value
        if (!this.databaseError) {
            baseCurrencyAbbrNameChoiceBox.setValue(currentBaseCurrencyStr);
            toCurrencyAbbrNameChoiceBox.setValue(currentToCurrencyStr);

        }

        baseCurrencyAbbrNameChoiceBox.setOnAction(event -> {
            // first way, acces the model of the choicebox to get the index and item, int and Object type
//            int selectedIdx = baseCurrencyAbbrNameChoiceBox.getSelectionModel().getSelectedIndex();
//            Object selectedItem = baseCurrencyAbbrNameChoiceBox.getSelectionModel().getSelectedItem();
//            String baseCurrency = (String) baseCurrencyAbbrNameChoiceBox.getValue();
            String baseCurrencyStr = (String) baseCurrencyAbbrNameChoiceBox.getValue();
            String toCurrencyStr = (String) toCurrencyAbbrNameChoiceBox.getValue();

//            System.out.println("To currency:" + toCurrency);
//            if (!baseCurrencyStr.equals("") && !toCurrencyStr.equals("")) {
            if (baseCurrencyStr != null && toCurrencyStr != null) {
                if (!baseCurrencyStr.equals(currentBaseCurrencyStr) || !toCurrencyStr.equals(currentToCurrencyStr)){
                valueInput.setText("");
                    convertedValueOutput.setText("");
                    this.controller.startUnitConvertComputation(baseCurrencyStr, toCurrencyStr);

                }
            }

        });


        valueInput = new TextField("");
        convertedValueOutput = new TextField("");

        toCurrencyAbbrNameChoiceBox.setOnAction(event -> {
            String baseCurrencyStr = (String) baseCurrencyAbbrNameChoiceBox.getValue();
            String toCurrencyStr = (String) toCurrencyAbbrNameChoiceBox.getValue();
//            System.out.println("To currency:" + toCurrency);
//            if (!baseCurrencyStr.equals("") && !toCurrencyStr.equals("")) {
            if (baseCurrencyStr != null && toCurrencyStr != null) {
                if (!baseCurrencyStr.equals(currentBaseCurrencyStr) || !toCurrencyStr.equals(currentToCurrencyStr)) {
                    valueInput.setText("");
                    convertedValueOutput.setText("");
                    this.controller.startUnitConvertComputation(baseCurrencyStr, toCurrencyStr);

                }
            }
        });


//        String input = valueInput.getText();

        convertButton.setOnAction(event -> {
            if (!this.databaseError) {
                String baseCurrencyStr = (String) baseCurrencyAbbrNameChoiceBox.getValue();
                String toCurrencyStr = (String) toCurrencyAbbrNameChoiceBox.getValue();
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
            Label newNameLabel = new Label("Name:");
            Label newAbbrNameLabel = new Label("Abbreviation:");
            Label newRateLabel = new Label("Rate:");
            Label errorLabel = new Label("");

            TextField newNameInput = new TextField("");
            TextField newAbbrInput = new TextField("");
            TextField newRateInput = new TextField("");


            BorderPane addRoot = new BorderPane();

            VBox center = new VBox();
            HBox newCurrencyNameLayout = new HBox();
            HBox newAbbrLayout = new HBox();
            HBox newRateLayout = new HBox();
            HBox addButtonLayout = new HBox();

            addButton.setOnAction(e -> {
                String newAbbrStr = newAbbrInput.getText();
                String newCurrencyStr = newNameInput.getText();
                String newRateStr = newRateInput.getText();

                errorLabel.setText("");
                if (newAbbrStr.equals("")) {
                    errorLabel.setText("Missing Currency abbreviation");
                } else if (!checkCurrencyNameLength(newAbbrStr)) {
                    errorLabel.setText("currency abbreviation must have 3 characters");
                } else if (!checkAllAlphebets(newAbbrStr)) {
                    errorLabel.setText("currency abbreviation must all be alphabet");
                } else if (newCurrencyStr.equals("")) {
                    errorLabel.setText("Missing name for the currency");
                } else if (newRateStr.equals("")) {
                    errorLabel.setText("Missing Rate");
                } else {
                    try {
                        // if
                        double inputRateValue = Double.parseDouble(newRateStr);
                        // 7.2
                        this.controller.startInsertComputation(newAbbrStr.toUpperCase(), newCurrencyStr, inputRateValue);
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

            newCurrencyNameLayout.getChildren().addAll(newNameLabel, newNameInput);
            newAbbrLayout.getChildren().addAll(newAbbrNameLabel, newAbbrInput);
            newRateLayout.getChildren().addAll(newRateLabel, newRateInput);
            addButtonLayout.getChildren().addAll(addButton, errorLabel);

//            center.getChildren().add(newCurrencyNameLayout);
            center.getChildren().addAll(addLabel, newCurrencyNameLayout, newAbbrLayout, newRateLayout, addButtonLayout);
            // set inset
            Insets lineInsets = new Insets(0, 20, 0, 20);
            Insets insets = new Insets(20, 40, 20, 40);

            VBox.setMargin(addLabel, insets);
            VBox.setMargin(newCurrencyNameLayout, insets);
            VBox.setMargin(newAbbrLayout, insets);
            VBox.setMargin(newRateLayout, insets);
            VBox.setMargin(addButtonLayout, insets);

            HBox.setMargin(newNameLabel, lineInsets);
            HBox.setMargin(newNameInput, lineInsets);
            HBox.setHgrow(newNameInput, Priority.ALWAYS);

            HBox.setMargin(newAbbrNameLabel, lineInsets);
            HBox.setMargin(newAbbrInput, lineInsets);
            HBox.setHgrow(newAbbrInput, Priority.ALWAYS);

            HBox.setMargin(newRateLabel, lineInsets);
//            HBox.setMargin(newRateInput,lineInsets);
            HBox.setMargin(newRateInput, lineInsets);
            HBox.setHgrow(newRateInput, Priority.ALWAYS);

            HBox.setMargin(addButton, lineInsets);
            HBox.setMargin(errorLabel, lineInsets);

            newNameInput.prefWidthProperty().bind(newRateInput.prefWidthProperty());
            newAbbrInput.prefWidthProperty().bind(newRateInput.prefWidthProperty());

            addRoot.setCenter(center);

            final double initialAddWidth = 500;
            final double initialAddHeight = 350;
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
                add(baseCurrencyAbbrNameChoiceBox);
        baseCurrencyLayout.getChildren().add(baseCurrencyNameLabel);
        baseCurrencyLayout.getChildren().
                add(valueInput);
        baseCurrencyLayout.getChildren().
                add(this.convertButton);

        toCurrencyLayout.getChildren().
                add(this.toCurrencyLabel);
        toCurrencyLayout.getChildren().
                add(toCurrencyAbbrNameChoiceBox);
        toCurrencyLayout.getChildren().add(toCurrencyNameLabel);
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
//        toCurrencyAbbrNameChoiceBox.setMar
        StackPane.setMargin(topCenter, insets);
        VBox.setMargin(instructionLayout, insets);
        HBox.setMargin(instructionLabel, lineInsets);

        VBox.setMargin(addButton, insets);

        VBox.setMargin(baseCurrencyLayout, insets);
        HBox.setMargin(baseCurrencyLabel, lineInsets);
        HBox.setMargin(baseCurrencyAbbrNameChoiceBox, lineInsets);
        HBox.setMargin(baseCurrencyNameLabel, lineInsets);
        HBox.setMargin(valueInput, lineInsets);
        HBox.setMargin(convertButton, lineInsets);

        VBox.setMargin(toCurrencyLayout, insets);
        HBox.setMargin(toCurrencyLabel, lineInsets);
        HBox.setMargin(toCurrencyAbbrNameChoiceBox, lineInsets);
        HBox.setMargin(toCurrencyNameLabel, lineInsets);
        HBox.setMargin(convertedValueOutput, lineInsets);
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
        if (databaseError) {
            rateLabel.setText("Cannot connect to database");

        }
//        databaseError = true;
//        Platform.runLater(() -> {
//            rateLabel.setText("Cannot connect to database");
//        });
    }

    public void setDatabaseError(boolean state){
        this.databaseError = state;
    }


    public void updateChoiceBox(ChoiceBox choiceBox) {
        choiceBox.getItems().clear();
        for (Map.Entry<String, Currency> entry : this.controller.getCurrencyList().entrySet()) {
            String currencyName = entry.getKey();
            choiceBox.getItems().add(currencyName);
        }
    }

    public void updateChoiceBoxes() {
        updateChoiceBox(this.baseCurrencyAbbrNameChoiceBox);
        updateChoiceBox(this.toCurrencyAbbrNameChoiceBox);
        baseCurrencyAbbrNameChoiceBox.setValue(currentBaseCurrencyStr);
        toCurrencyAbbrNameChoiceBox.setValue(currentToCurrencyStr);

    }

    public void displayNewCurrencyNameLabel(String baseCurrencyName, String toCurrencyLabelName) {
        baseCurrencyNameLabel.setText(baseCurrencyName);
        toCurrencyNameLabel.setText(toCurrencyLabelName);
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

    public void setCurrentBaseCurrencyStr(String string){
        this.currentBaseCurrencyStr = string;
    }

    public String getCurrentToCurrencyStr() {
        return currentToCurrencyStr;
    }

    public void setCurrentToCurrencyStr(String string){
        this.currentToCurrencyStr = string;
    }

//    public

    @Override
    public void init() {
        this.rateLabel = new Label("");
        this.controller = new CurrencyController(this);
    }

}



