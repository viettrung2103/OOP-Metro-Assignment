package view;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;

public class DrawingArea extends Canvas {
    public static int CELL_SIZE = 20;
    private final String PIGFILENAME = "C://Users/viett/IdeaProjects/Assignment/Assignment_maven/6.3.Graphics-Mouse-KeyBorad-GUI/src/green-pig.png";
    private final String BIRDFILENAME = "C://Users/viett/IdeaProjects/Assignment/Assignment_maven/6.3.Graphics_Mouse_Keyboard_GUI_v3/src/red-bird.png";

    private ImageView graphic = null;

    private Image birdImage;
    private Image pigImage;
    private GraphicsContext gc;
    private double mouseX = -1;
    private double mouseY = -1;

    public DrawingArea(double width, double height) {
        super(width, height);
        try {
//            targetStream = new DataInputStream(new FileInputStream(BIRDFILENAME1));

//            FileInputStream birdInput = new FileInputStream(BIRDFILENAME);
//            FileInputStream pigInput = new FileInputStream(PIGFILENAME);
            graphic = new ImageView();
            // this way can set image in resources folder
            this.birdImage = new Image("red-bird.png",100,100,true,true);
            this.pigImage = new Image("green-pig.png",100,100, true, true);


//            this.birdImage = new Image("C:/Users/viett/IdeaProjects/Assignment/Assignment_maven/6.3.Graphics_Mouse_Keyboard_GUI_v3/src/green-pig.png");
            gc = this.getGraphicsContext2D();
            gc.clearRect(0, 0, width, height);
//            gc = canvas.getGraphicsContext2D();
//            gc.drawImage(this.birdImage, 0, 0, CELL_SIZE, CELL_SIZE);
            this.graphic.setImage(this.birdImage);
            this.graphic.setImage(this.pigImage);
            this.setupMouseListeners();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawPet(double x, double y) {
//        GraphicsContext gc = this.getGraphicsContext2D();
//        gc.clearRect(0, 0, this.getWidth(), this.getHeight());
        this.clearDisplay();
        this.gc.drawImage(pigImage, this.mouseX, this.mouseY, CELL_SIZE, CELL_SIZE);
        this.gc.drawImage(birdImage, x, y, CELL_SIZE, CELL_SIZE);
    }

    private void setupMouseListeners() {
        this.setOnMouseMoved(e -> {
            this.mouseX = e.getX();
            this.mouseY = e.getY();
//            System.out.println("mouse move to " + this.mouseX + "," + this.mouseY);
        });

        this.setOnMouseExited(e -> {
            this.mouseX = -1;
            this.mouseY = -1;
//            System.out.println("mouse exit");
        });
    }

    private void clearDisplay() {
        this.gc.clearRect(0, 0, this.getWidth(), this.getHeight());
    }

    public double getMouseX() {
        return this.mouseX;
    }

    public double getMouseY() {
        return this.mouseY;
    }
}
