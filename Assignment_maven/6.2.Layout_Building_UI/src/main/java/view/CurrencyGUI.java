package view;

import controller.CurrencyController;
import entity.Transaction;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import entity.Currency;

import java.util.List;
import java.util.Map;

public class CurrencyGUI extends Application {
    private String currentBaseCurrencyStr = "";
    private String currentToCurrencyStr = "";

    private final String title = "Currency Converter";
    private CurrencyController controller;
    private boolean databaseError = false;
    private boolean initilizeDatabase = false;

    //components
    private Label appLabel;
    private Label instructionLabel1;
    private Label instructionLabel2;
    private Label baseCurrencyLabel;
    private Label toCurrencyLabel;
    private Label baseCurrencyNameLabel;
    private Label toCurrencyNameLabel;


    TextField valueInput;
    TextField convertedValueOutput;

    private Button convertButton, addButton, transactionButton;
    private Label rateLabel;


    ChoiceBox baseCurrencyAbbrNameChoiceBox;
    ChoiceBox toCurrencyAbbrNameChoiceBox;

    //layout
    BorderPane root;
    StackPane topCenter;
    VBox left;
    HBox optionsLayout;
    HBox instructionLayout1;
    HBox instructionLayout2;
    HBox baseCurrencyLayout;
    HBox toCurrencyLayout;

    //for transactionView
    TableView transactionTableView;
    double rowCount;

    @Override
    public void start(Stage stage) {
        if (databaseError) {
            rateLabel.setText("Error: Unable to connect to the database. Please try again later.");
        } else {
            rateLabel.setText("Connecting to database...");
        }
        // setup UI:
        this.root = new BorderPane();

        this.appLabel = new Label("Currency Converter");
        this.instructionLabel1 = new Label("Choose the base currency and the currency that you want to convert to. Type the value and press convert");
        this.instructionLabel2 = new Label("Please insert a Currency when the application starts.");
        this.baseCurrencyLabel = new Label("From Currency: ");
        this.toCurrencyLabel = new Label("To Currency: ");
        this.convertButton = new Button("Convert");
        this.addButton = new Button("Add Currency");
        this.transactionButton = new Button("Transaction List");
        this.baseCurrencyNameLabel = new Label("");
        this.toCurrencyNameLabel = new Label("");
//        this.rateLabel = new Label("");

        // create layout componet and add layout
        this.left = new VBox();
        this.optionsLayout = new HBox();
        this.instructionLayout1 = new HBox();
        this.instructionLayout2 = new HBox();
        this.baseCurrencyLayout = new HBox();
        this.toCurrencyLayout = new HBox();

        this.topCenter = new StackPane();
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
                if (!baseCurrencyStr.equals(currentBaseCurrencyStr) || !toCurrencyStr.equals(currentToCurrencyStr)) {
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
            if (this.initilizeDatabase) {

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

                final double initialAddWidth = 550;
                final double initialAddHeight = 350;
                Stage addStage = new Stage();
                Scene addScene = new Scene(addRoot, initialAddWidth, initialAddHeight);
                addStage.setScene(addScene);
                addStage.setTitle(addTitle);
                addStage.showAndWait();
            }
        });

        transactionButton.setOnAction(event -> {
            final String title = "Transaction List";
            rowCount = 0;
            System.out.println("Showing transaction list");

            // layout
            BorderPane transactionRoot = new BorderPane();
            StackPane topLayout = new StackPane();
            transactionTableView = new TableView();
            VBox middleLayout = new VBox(transactionTableView);

            // components
            Label titleLabel = new Label(title);


            // assemble
            transactionRoot.setTop(topLayout);
            topLayout.getChildren().addAll(titleLabel);
            topLayout.setAlignment(Pos.CENTER);

            transactionRoot.setCenter(middleLayout);

            TableColumn<Transaction, String> column1 =
                    new TableColumn<>("Base Currency");

            column1.setCellValueFactory(
                    new PropertyValueFactory<>("baseCurrency"));


            TableColumn<Transaction, String> column2 =
                    new TableColumn<>("Convert Currency");

            column2.setCellValueFactory(
                    new PropertyValueFactory<>("toCurrency"));

            TableColumn<Transaction, String> column3 =
                    new TableColumn<>("Amount");
            column3.setCellValueFactory(
                    new PropertyValueFactory<>("amount"));

            //add table header
            transactionTableView.getColumns().add(column1);
            transactionTableView.getColumns().add(column2);
            transactionTableView.getColumns().add(column3);

            this.controller.startDisplayTransactionCalculation();

            Platform.runLater(() -> {
                final double initialAddWidth = 250;
                final double initialAddHeight = 300;
                // cannot make a dynamic height adjustment
//                    final double initialAddHeight = 70 + (this.rowCount * oneRowHeight);

                Scene transactionScene = new Scene(transactionRoot, initialAddWidth, initialAddHeight);
                Stage transactionStage = new Stage();
                transactionStage.setScene(transactionScene);
                transactionStage.setTitle(title);
                transactionStage.showAndWait();
//                try {
//                    Thread.sleep(50);
//
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            });


        });


        optionsLayout.getChildren().addAll(this.addButton, this.transactionButton);

        instructionLayout1.getChildren().add(this.instructionLabel1);

        instructionLayout2.getChildren().add(this.instructionLabel2);

        baseCurrencyLayout.getChildren().addAll(
                this.baseCurrencyLabel,
                this.baseCurrencyAbbrNameChoiceBox,
                this.baseCurrencyNameLabel,
                this.valueInput,
                this.convertButton
        );


        toCurrencyLayout.getChildren().addAll(
                this.toCurrencyLabel,
                this.toCurrencyAbbrNameChoiceBox,
                this.toCurrencyNameLabel,
                this.convertedValueOutput,
                this.rateLabel
        );


        left.getChildren().addAll(
                this.instructionLayout1,
                this.instructionLayout2,
                this.optionsLayout,
                this.baseCurrencyLayout,
                this.toCurrencyLayout
        );

        root.setLeft(left);


        //add outside margin:
        Insets lineInsets = new Insets(0, 20, 0, 20);
        Insets insets = new Insets(20, 40, 20, 40);
//        toCurrencyAbbrNameChoiceBox.setMar
        StackPane.setMargin(topCenter, insets);
        VBox.setMargin(instructionLayout1, insets);
        HBox.setMargin(instructionLabel1, lineInsets);

        VBox.setMargin(instructionLayout2, insets);
        HBox.setMargin(instructionLabel2, lineInsets);

        VBox.setMargin(optionsLayout, insets);
        HBox.setMargin(addButton, lineInsets);
        HBox.setMargin(transactionButton, lineInsets);

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

    public TableView getTransactionTableView() {
        return this.transactionTableView;
    }

    public void setTransactionTableView(TableView newTransactionTableView) {
        this.transactionTableView = newTransactionTableView;
    }

    public void displayTransactionList(List<Transaction> transactions) {
        int count = 0;
        this.transactionTableView.getItems().clear();
        for (Transaction transaction : transactions) {
            count++;
            this.transactionTableView.getItems().add(transaction);
        }
        this.rowCount = count;
    }

    public void platformDisplayTransactionList(List<Transaction> transactions) {
        Platform.runLater(() -> {
            this.displayTransactionList(transactions);
        });
    }

    public void displayConvertedResult(double result, String baseCurrencyStr, String toCurrencyStr) {
        convertedValueOutput.setText(String.format("%.2f", result));
//        rateLabel.setText("1 " + baseCurrencyStr + " = " + String.format("%.2f", resultOneUnit) + " " + toCurrencyStr);
    }

    public void platformStartConvertComputation(double result, String baseCurrencyStr, String toCurrencyStr, double resultOneUnit) {
        Platform.runLater(() -> {
                    this.displayConvertedResult(result, baseCurrencyStr, toCurrencyStr);
                    this.displayConvertedRateResult(resultOneUnit, baseCurrencyStr, toCurrencyStr);
                }
        );
    }

    public void displayConvertedRateResult(double resultOneUnit, String baseCurrencyStr, String toCurrencyStr) {
        rateLabel.setText("1 " + baseCurrencyStr + " = " + String.format("%.2f", resultOneUnit) + " " + toCurrencyStr);
    }

    public void platformStartUnitConvertComputation(double resultOneUnit, String baseCurrencyStr, String toCurrencyStr, String baseCurrencyName, String toCurrencyName) {
        Platform.runLater(() -> {
            this.displayConvertedRateResult(resultOneUnit, baseCurrencyStr, toCurrencyStr);
            this.displayNewCurrencyNameLabel(baseCurrencyName, toCurrencyName);

        });
    }

    public void setEmptyDatabase() {
        databaseError = true;
    }

    public void displayNoDatabaseError() {
        if (databaseError) {
            rateLabel.setText("Cannot connect to database");
        }
    }
    // update dropbox in view with new currencyList

    public void platformDisplayNoDatabaseError() {
        Platform.runLater(() -> {
            this.displayNoDatabaseError();
        });
    }
    public void platformInitiateError(){
        Platform.runLater(() -> {
            this.setInitilizeDatabase(true);
            this.setDatabaseError(true);
            this.displayNoDatabaseError();
        });
    }

    public void setDatabaseError(boolean state) {
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

    public void platformUpdateChoiceBoxes() {
        Platform.runLater(() -> {
            this.updateChoiceBoxes();
//                this.gui.displayConvertedRateResult();
        });
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

    public void setCurrentBaseCurrencyStr(String string) {
        this.currentBaseCurrencyStr = string;
    }

    public String getCurrentToCurrencyStr() {
        return currentToCurrencyStr;
    }

    public void setInitilizeDatabase(boolean state) {
        this.initilizeDatabase = state;
    }

    public void setCurrentToCurrencyStr(String string) {
        this.currentToCurrencyStr = string;
    }

    public void platformInitiate(double resultOneUnit, String currentBaseStr, String currentToStr, String baseCurrencyName, String toCurrencyname){
        Platform.runLater(() -> {
            this.setInitilizeDatabase(true);
            this.setDatabaseError(false);
            this.displayConvertedRateResult(resultOneUnit, currentBaseStr, currentToStr);
            this.displayNewCurrencyNameLabel(baseCurrencyName, toCurrencyname);
            this.updateChoiceBoxes();
        });
    }


    //    public
    @Override
    public void init() {
        this.rateLabel = new Label("");
        this.controller = new CurrencyController(this);
    }

}



