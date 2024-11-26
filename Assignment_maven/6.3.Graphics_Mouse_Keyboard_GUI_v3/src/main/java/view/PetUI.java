package view;

import controller.PetThread;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.WindowEvent;
import model.Pet;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PetUI extends Application {

    @Override
    public void start(Stage stage) {
        Pet pet = new Pet(100, 100);
        DrawingArea area = new DrawingArea(400, 400);
        StackPane pane = new StackPane();
        pane.setId("pane");

        pane.getChildren().add(area);

//        BorderPane root = new BorderPane();
//        root.setCenter(pane);

        Scene scene = new Scene(pane, 400, 400);
//        System.out.println(this.getClass().getResource("styles.css").toExternalForm());
        scene.getStylesheets().add("styles.css");
        stage.setScene(scene);
        stage.setTitle("Pet Walker");
        stage.show();

        PetThread petThread = new PetThread(pet, area);
        petThread.start();

        stage.setOnCloseRequest(WindowEvente -> {
            petThread.stopRunning();
            Platform.exit();
            System.exit(0);
        });

    }
}
