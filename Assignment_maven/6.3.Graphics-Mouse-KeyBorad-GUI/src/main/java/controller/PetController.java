package controller;

import javafx.application.Platform;
import model.Pet;
import model.Point;
import view.PetView;

public class PetController {
    private PetView gui;

    private Pet pet;
    private int gridSize;
//    private Mouse mouse;

    public PetController(PetView gui) {
        this.gui = gui;
        this.pet = new Pet(0, 0, 1);
        this.gridSize = 20;
    }

//    public setPetPosition(int x, int y){
//
//    }

    public int getPetViewX() {
        return this.pet.getX() * PetView.getCELLSIZE();
    }

    public int getPetViewY() {
        return this.pet.getY() * PetView.getCELLSIZE();
    }

//    public checkMouseMovable(double mouseX, double mouseY) {
//        int mousePosX = this.mapFromPixelToGrid(mouseX);
//        int mousePosY = this.mapFromPixelToGrid(mouseY);
//
//    }

    public int getGridSize() {
        return this.gridSize;
    }

    // canvas size =
    public int mapFromPixelToGrid(double value) {
        int canvasSize = this.gui.getCanvasSize();
        double result = value * this.gridSize / canvasSize;
        return (int) result;

    }

    public void startComputation(double mouseX, double mouseY) {
        new Thread(() -> {
            try {
                int mousePosX = this.mapFromPixelToGrid(mouseX);
                int mousePosY = this.mapFromPixelToGrid(mouseY);
                Point newMouse = new Point(mousePosX, mousePosY);
                this.pet.move(newMouse);
                //
//                this.
                Platform.runLater(() -> gui.updatePetPosition());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
