public class Pen {
    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;

        Color(String color) {
            this.color = color;
        }

        ;

        @Override
        public String toString() {
            return color;
        }
    }

    private Color color;
    private boolean hasCap;

    public Pen() {
        this.color = Color.RED;
        this.hasCap = true;
    }

    public Pen(Color color) {
        this.color = color;
        this.hasCap = true;
    }


    public void capOff() {
        this.hasCap = false;
    }

    public void capOn() {
        this.hasCap = true;
    }

    public String draw() {
        if (this.hasCap) {
            return "";
        } else {
            return "Drawing " + this.color;
        }
    }

    public void changeColor(Color color) {
        if (this.hasCap) {
            this.color = color;

        }
    }


}
