package Week2.A23.Task1;

public class Book {
    private String title;
    private String author;
    private int publicYear;

    public Book(String title, String author, int publicYear) {
        this.title = title;
        this.author = author;
        this.publicYear = publicYear;
    }

    public int getPublicYear() {
        return this.publicYear;

    }

    public String getTitle() {
        return this.title;

    }

    public String getAuthor() {
        return this.author;
    }

    @Override
    public String toString() {
        return "Title: \""+this.title + "\", Author: \"" + this.author + "\", Year: " + this.publicYear;
    }
}
