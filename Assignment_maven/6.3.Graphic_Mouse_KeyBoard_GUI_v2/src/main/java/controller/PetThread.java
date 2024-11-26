package controller;

import javafx.application.Platform;
import view.DrawingArea;

public class PetThread extends Thread {
    private DrawingArea area = null;
    private volatile boolean fRunning = true;
    volatile int dx = 1, dy = 1;
    private volatile speed = 2;

    public PetThread(DrawingArea pa) {
        area = pa;
    }


    @Override
    public void run() {
        while (fRunning) {
            while (!this.area.isMouseOutside()) {

//                if (this.area.xCollision()) {
//                    dx = -dx;
//                    if (Math.random() <= 0.2) {
//                        dy = -dy;
//                    }
//                }
//                if (this.area.yCollision()) {
//                    dy = -dy;
//                    if (Math.random() <= 0.2) {
//                        dx = -dx;
//                    }
//                }
//                if (!this.area.isPosXAboveMouseX()) {
//                    dx = -dx;
//                }
////                else {
////                    dx = -dx;
////                }
//                if (!this.area.isPosYAboveMouseY()) {
//                    dy = -dy;
//                }

                Platform.runLater(new Runnable() {
                    int finalDx = dx;
                    int finalDy = dy;


                    public void run() {
                        area.moveBall(finalDx, finalDy);
                    }
                });
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.area.isMouseOutside();
        }
    }


    public void terminate() {
        fRunning = false;
    }
}


