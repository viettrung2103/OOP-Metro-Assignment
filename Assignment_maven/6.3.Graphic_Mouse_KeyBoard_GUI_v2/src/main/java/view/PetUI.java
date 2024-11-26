package view;

import controller.PetThread;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class PetUI extends Application {

    @Override
    public void start(Stage stage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 400, 400);
            DrawingArea area = new DrawingArea(300, 300);

            root.setCenter(area);
            stage.setScene(scene);
            stage.show();

            //set close event hanlder
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent windowEvent) {
                    Platform.exit();
                    System.exit(0);
                }
            });

            PetThread petThread = new PetThread(area);
            petThread.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
