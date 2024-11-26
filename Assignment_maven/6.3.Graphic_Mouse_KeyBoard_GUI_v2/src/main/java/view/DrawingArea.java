package view;


import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;


public class DrawingArea extends Canvas {

    private int x = 40;
    private int y = 60;
    private boolean xCollision = false;
    private boolean yCollision = false;
    private boolean mouseOutside = false;
    private boolean posXAboveMouseX = false;
    private boolean posYAboveMouseY = false;
    private int mouseX = 0;
    private int mouseY = 0;

    private final GraphicsContext gc;


    public DrawingArea(int w, int h) {
        super(w, h);
        gc = this.getGraphicsContext2D();

//        this.setEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>(){
        this.setEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                DrawingArea.this.mouseX = (int) e.getX();
////                int mouseX = (int) e.getX();
////                int mouseY = (int) e.getY();
//                DrawingArea.this.setMouseX(());
                DrawingArea.this.mouseY = (int) e.getY();
//                System.out.println("");
//                System.out.println("Mouse move : (" + DrawingArea.this.mouseX + ", " + DrawingArea.this.mouseY + ")");
//                newPosition(mouseX, mouseY);

            }
        });

        this.setEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Mouse is exit");
//                mouseOutside = true;
                DrawingArea.this.mouse X = -1;
                DrawingArea.this.mouseY = -1;;
            }
        });

//        this.setEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                System.out.println("Mouse is enter");
//                mouseOutside = false;
//            }
//        });
    }

    private int getMouseX() {
        return this.mouseX;
    }

    private int getMouseY() {
        return this.mouseY;
    }

    private void setMouseX(int x) {
        this.mouseX = x;
    }

    private void setMouseY(int y) {
        this.mouseY = y;
    }

    private void clrDisplay() {
        gc.setFill(Color.YELLOW);
        gc.fillRect(0, 0, this.getWidth(), this.getHeight());
    }


    public void drawBall() {
//        gc.setFill(Color.YELLOW);// set background
//        gc.fillRect(0, 0, this.getWidth(), this.getHeight());
        this.clrDisplay();
        gc.setFill(Color.GREEN);
        gc.fillOval(x, y, 30, 30);
    }

    public boolean isMouseOutside() {
        return this.mouseOutside;
    }

    private boolean isPosXAboveMouseX(int x, int mouseX) {
        return x < mouseX; // need to reverse as x origin is at top
    }

    public boolean isPosXAboveMouseX() {
        return this.posXAboveMouseX;
    }

    private boolean isPosYAboveMouseY(int y, int mouseY) {
        return y < mouseY;
    }

    public boolean isPosYAboveMouseY() {
        return this.posYAboveMouseY;
    }

    private boolean isXCollision(int x) {
        return x < 0 || x > this.getWidth() - 30;
    }


    public boolean xCollision() {
        return this.xCollision;
    }

    private boolean isYCollision(int y) {
        return y < 0 || y > this.getHeight() - 30;
    }

    public boolean yCollision() {
        return this.yCollision;
    }

    public void moveBall(int dx, int dy) {
        // check collisionx when moving
        if (!isXCollision(x + dx)) {
            x += dx;
            this.xCollision = false;
        } else {
            this.xCollision = true;
        }
        // check collisiony when moving
        if (!isYCollision(y + dy)) {
            y += dy;
            this.yCollision = false;
        } else {
            this.yCollision = true;
        }
        // check positionx vs mousex when moving
        if (isPosXAboveMouseX(x + dx, this.mouseX)) {
            this.posXAboveMouseX = true;
        } else {
            this.posXAboveMouseX = false;
        }
//        x+= dx;
        // chekc position y vs mousey when moving
        if (isPosYAboveMouseY(y + dy, this.mouseY)) {
            this.posYAboveMouseY = true;
        } else {
            this.posYAboveMouseY = false;
        }
//        y += dy;
        System.out.println("ball x is above mouse x " + this.posXAboveMouseX + " - ball y above mouse y " + this.posYAboveMouseY + " Ball(" + this.x + "," + this.y + ") - Mouse(" +
                this.mouseX + "," + this.mouseY + ")");
        drawBall();
    }

    public void newPosition(int x, int y) {
        if (!isXCollision(x) && !isYCollision(y)) {
            this.x = x;
            this.y = y;
            drawBall();
        }
    }
}
