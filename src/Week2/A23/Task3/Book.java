package Week2.A23.Task3;

public class Book {
    private String title;
    private String author;
    private int publicYear;
    private boolean isAvailable;

    public Book(String title, String author, int publicYear) {
        this.title = title;
        this.author = author;
        this.publicYear = publicYear;
        this.isAvailable = true;
    }

    public int getPublicYear() {
        return this.publicYear;
    }

    public boolean getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailableOnOff() {
        this.isAvailable = !this.isAvailable;
    }

    public String getTitle() {
        return this.title;

    }

    public String getAuthor() {
        return this.author;
    }

    @Override
    public String toString() {
        return "Title: \"" + this.title + "\", Author: \"" + this.author + "\", Year: " + this.publicYear;
    }
}
