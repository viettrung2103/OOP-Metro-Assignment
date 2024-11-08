package Week3.A33.Task3.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LibraryMember {
    private static int _id = 0;
    private String name;
    private int id;
    private List<Book> borrowedBooks;
    private List<Book> reservedBooks;

    public LibraryMember(String name) {
        this.name = name;
        this.id = ++_id;
        this.borrowedBooks = new ArrayList<>();
        this.reservedBooks = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void borrowBook(Book book) {
        System.out.println(this.name + " borrows " + book);
        this.borrowedBooks.add(book);
    }

    public boolean returnBook(Book book) {
        boolean canReturn = borrowedBooks.remove(book);
        if (canReturn)
            System.out.println(this.name + " is returning " + book);
        else
            System.out.println(this.name + " does not borrow " + book);
        return canReturn;
    }

    public List<Book> getBookList() {
        return this.borrowedBooks;
    }

    public void displayBorrowedBookList() {
        System.out.println("this is " + this.name + "\'s borrowed book list:");
        Iterator<Book> iterator = this.borrowedBooks.iterator();
        if (!iterator.hasNext()) {
            System.out.println("There is no books.");
        }
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void reserveBook(Book book) {
        this.reservedBooks.add(book);
    }

    public void cancelReservation(Book book) {
        this.reservedBooks.remove(book);
    }

    public void displayReserveBookList() {
        System.out.println("this is " + this.name + "\'s reserved book list:");
        Iterator<Book> iterator = this.reservedBooks.iterator();
        if (!iterator.hasNext()) {
            System.out.println("There is no books.");
        }
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Override
    public String toString() {
        return "Member with name \"" + this.name + "\" and id \"" + this.id + "\"";
    }
}
