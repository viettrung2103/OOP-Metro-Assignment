package Week2.A23.Task6;

import java.util.ArrayList;

public class User {
    private String name;
    private int age;
    private ArrayList<Book> borrowedBooks;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void displayBorrowedBooks() {
        System.out.println(this.name + " borrowed books list:");
        if (!this.borrowedBooks.isEmpty()) {
            for (Book book : this.borrowedBooks) {
                System.out.println(book);
            }
        } else {
            System.out.println("The list is empty");
        }
    }

    public void borrowBook(Book book) {
        System.out.println(this.name + " borrow book " + book.getTitle());
        this.borrowedBooks.add(book);
    }


    public Book returnBook(String title) {
        Book foundBook = null;
        if (!this.borrowedBooks.isEmpty()) {
            for (Book book : this.borrowedBooks) {
                if (book.getTitle().equals(title)) {
                    this.borrowedBooks.remove(book);
                    foundBook = book;
                    break;
                }
            }
        }
        return foundBook;
    }
}


