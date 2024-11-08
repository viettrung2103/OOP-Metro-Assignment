package Week3.A33.Task2.library.model;

public class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getISBN() {
        return this.isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book with title \"" + this.title + "\", writen by \"" + this.author + "\" has isbn \"" + this.isbn + "\"";
    }

}
