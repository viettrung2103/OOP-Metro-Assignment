package View;

import Controller.DictionaryController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class DictionaryView extends Application {

    DictionaryController controller;
    private String title = "Dictionary";
    private Label inputLabel;
    private Label translationLabel;
    private TextArea translation;
    private TextField textField;
    private Button translateButton;

    @Override
    public void start(Stage stage) {
        // set up content of components
        FlowPane pane = new FlowPane();
        this.inputLabel = new Label("What word do you want to translate? ");
        this.translateButton = new Button("Translate");
        this.textField = new TextField();
        this.translationLabel = new Label("Result:");
        this.translation = new TextArea("");

        //initialize

        //add outside margins for components
        Insets insets = new Insets(10, 10, 10, 10);
        pane.setMargin(inputLabel, insets);
        pane.setMargin(translateButton, insets);
        pane.setMargin(textField, insets);
        pane.setMargin(translation, insets);

        // reserve space for result
        translationLabel.setMinWidth(30);
        translationLabel.setAlignment(Pos.CENTER);

        pane.getChildren().add(inputLabel);
        pane.getChildren().add(textField);
        pane.getChildren().add(translateButton);
        pane.getChildren().add(translationLabel);
        pane.getChildren().add(translation);

        Scene scene = new Scene(pane);
        stage.setTitle(this.title);
        stage.setScene(scene);
        stage.show();

//        //test
//        this.controller.displayAllWords();

        //set action for button for any action
        this.translateButton.setOnAction(e ->{
            String input = this.textField.getText();
            String translation = this.controller.translate(input);
            this.translation.setText(translation);
        });

        stage.show();

    }

    public DictionaryController getController(){
        return this.controller;
    }

    public void setController(DictionaryController controller){
        this.controller = controller;
        System.out.println("set Controller" +this.controller);
    }


    public void init() {
        this.controller = new DictionaryController(this);
        this.controller.add("One", "Yksi");
        this.controller.add("Two", "Kaksi");
        this.controller.add("Three", "Kolme");
    }

    public void setResult(String result) {
        this.translation.setText(String.valueOf(result));
    }

}
