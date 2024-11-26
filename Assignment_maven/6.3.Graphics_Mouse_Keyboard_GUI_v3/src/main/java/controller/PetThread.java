package controller;

import javafx.application.Platform;
import model.Pet;
import view.DrawingArea;

public class PetThread extends Thread {
    private final Pet pet;
    private final DrawingArea area;
    private volatile boolean isRunning = true;

    public PetThread(Pet pet, DrawingArea area) {
        this.pet = pet;
        this.area = area;
    }

    @Override
    public void run() {
        while (isRunning) {
            double mouseX = area.getMouseX();
            double mouseY = area.getMouseY();

            if (mouseX != -1 && mouseY != -1) {
                // calcuate direction vector
                double dx = mouseX - pet.getX();
                double dy = mouseY - pet.getY();

                double distance = Math.sqrt(dx * dx + dy * dy);

                if (distance < 1) {
                    dx = 0;
                    dy = 0;
                } else {
                    // normalize the vector, to find the direction vector
                    // time the speed to find the corresponding speed
                    // the further, the faster it will go
                    dx = (dx / distance) * pet.getSpeed();
                    dy = (dy / distance) * pet.getSpeed();
                }

                // update pet position
                double newX = pet.getX() + dx;
                double newY = pet.getY() + dy;
                pet.setPosition(newX, newY);

                // draw pet
                Platform.runLater(() -> area.drawPet(newX, newY));
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopRunning() {
        this.isRunning = false;
    }


}
