package view;

import controller.PetController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


import java.io.*;

public class PetView extends Application {

    private final String BIRDFILENAME = "images/green-pig.png";
    private final String BIRDFILENAME1 = "C://Users/viett/IdeaProjects/Assignment/Assignment_maven/6.3.Graphics-Mouse-KeyBorad-GUI/src/green-pig.png";


    private static final int CELL_SIZE = 30;
    private GraphicsContext gc;
    private Canvas canvas;
    private StackPane root;
    private PetController petController;
    private int canvasSize;
    private Image image;
//    private int gridSize;

    @Override
    public void start(Stage stage) {
        File file = new File(BIRDFILENAME1);
//        this.gridSize = this.petController.getGridSize();
//        this.canvas = gridSize * CELL_SIZE;

        if (file.exists()) {
            System.out.println("file exist!");//I would print file path here.
        } else {
            System.out.println("file does not exist!");
        }
        final InputStream targetStream; // Creating the InputStream
        try {
//            targetStream = new DataInputStream(new FileInputStream(BIRDFILENAME1));

            FileInputStream input = new FileInputStream(BIRDFILENAME1);
            this.image = new Image(input);
//            ImageView imageView = new ImageView(image);
//
//            imageView.setX(100);
//            imageView.setY(100);
//
//            //setting the fit height and width of the image view
//            imageView.setFitHeight(CELL_SIZE);
//            imageView.setFitWidth(CELL_SIZE);
//
//            //Setting the preserve ratio of the image view
//            imageView.setPreserveRatio(true);

            canvas = new Canvas(canvasSize, canvasSize);
            gc = canvas.getGraphicsContext2D();
            gc.drawImage(this.image, 0, 0, CELL_SIZE, CELL_SIZE);

            canvas.setOnMouseMoved(event -> {
                this.clearView();
                double mouseX = event.getX();
                double mouseY = event.getY();
//                gc.drawImage(image, mouseX, mouseY, CELL_SIZE, CELL_SIZE);
                System.out.println("Mouse moved to (" + mouseY + ", " + mouseX + ")");
                petController.startComputation(mouseX, mouseY);
            });
//            int gridSize =

            StackPane root = new StackPane(canvas);

            Scene scene = new Scene(root, canvasSize, canvasSize);
            stage.setScene(scene);
            stage.setTitle("Pet Walk");
            stage.show();

        } catch (IOException e) {
            System.out.println("Cannot load photo");
        }
    }

    @Override
    public void init() {
        this.petController = new PetController(this);
//        this.gridSize = this.petController.getGridSize();
        this.canvasSize = this.petController.getGridSize() * CELL_SIZE;

    }

    public int getCanvasSize() {
        return this.canvasSize;
    }

    public static int getCELLSIZE() {
        return CELL_SIZE;
    }

    public synchronized void updatePetPosition() {
        System.out.println("updating view");
        this.clearView();
        int petX = this.petController.getPetViewX();
        int petY = this.petController.getPetViewY();
        gc.drawImage(this.image, petX, petY, CELL_SIZE, CELL_SIZE);

    }

    public void clearView() {
//        int gridSize = this.petController.getGridSize();
//        int canvasSize = gridSize * CELL_SIZE;
        gc.clearRect(0, 0, canvasSize, canvasSize);
    }


}
