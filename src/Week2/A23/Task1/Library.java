package Week2.A23.Task1;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBook() {
        for (int i = 0; i < this.books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    public void findBookByAuthor(String author) {
        boolean isFound = false;
        System.out.println("Books by Author: \"" + author + "\" :");
        for (Book book : this.books) {
            if (book.getAuthor().equals(author)) {
                System.out.println(book);
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("There is not books with author \"" + author + "\"");
        }
//        return foundBook;
    }


}
