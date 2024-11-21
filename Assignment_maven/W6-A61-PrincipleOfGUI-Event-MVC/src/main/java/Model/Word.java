package Model;

public class Word {
    private String name;
    private String translation;

    public Word(String name, String translation) {
        this.name = name.toLowerCase();
        this.translation = translation.toLowerCase();
    }

    public String getName() {
        return this.name;
    }

    public String getTranslation() {
        return this.translation;
    }

    @Override
    public String toString() {
        return this.name + " : " + this.translation;
    }
}
