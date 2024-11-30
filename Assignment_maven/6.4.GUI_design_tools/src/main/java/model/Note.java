package model;

public class Note {

    private static int _id = 0;
    private String title;
    private String content;
    private final int id;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.id = _id++;
    }

    //overload constructor
    public Note(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // to copy, might not need
    public Note(Note other) {
        this.id = other.id;
        this.title = other.title;
        this.content = other.content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public boolean isContentLongerThan10Chars() {
        return this.content.length() > 10;
    }

    @Override
    public String toString() {
        String endingStr = "";
        if (this.isContentLongerThan10Chars()) {
            endingStr = this.content.substring(0, 10) + "...";

        } else {
            endingStr = this.content;
        }
        return "#" + this.id + ". " + this.title + ": " + endingStr;
    }


}
