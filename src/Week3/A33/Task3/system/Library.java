package Week3.A33.Task3.system;

import Week3.A33.Task3.model.Book;
import Week3.A33.Task3.model.LibraryMember;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<LibraryMember> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (this.hasBook(book)) {
            System.out.println(book + " is already added. Add Failed");
            return;
        }
        this.books.add(book);
        System.out.println(book + "is added successfully.");
    }

    public void addMember(LibraryMember member) {
        if (this.hasMember(member)) {
            System.out.println(member + " is already added. Add failed");
            return;
        }
        this.members.add(member);
        System.out.println(member + " is added successfully");
    }

    public boolean hasMember(LibraryMember member) {
        return this.members.contains(member);
    }

    public boolean hasBook(Book book) {
        return this.books.contains(book);
    }

    public void displayBorrowedBooksByMember(LibraryMember member) {
        if (!this.hasMember(member)) {
            System.out.println("Library does not have " + member);
            return;
        }
        member.displayBorrowedBookList();
    }

    public void displayReservedBooksByMember(LibraryMember member) {
        if (!this.hasMember(member)) {
            System.out.println("Library does not have " + member);
            return;
        }
        member.displayReserveBookList();
    }

    public void borrowBook(LibraryMember member, Book book) {
        if (!this.hasMember(member)) {
            System.out.println("Library does not have " + member);
            return;
        }
        if (!this.hasBook(book)) {
            System.out.println("Library does not have " + book);
            return;
        }
        this.books.remove(book);
        member.borrowBook(book);
    }

    public void returnBook(LibraryMember member, Book book) {
        boolean canReturn = member.returnBook(book);
        if (canReturn) {
            this.books.add(book);
            System.out.println(book + " is returned");
        }
    }

    public void reserveBook(LibraryMember member, Book book) {
        if (!this.hasMember(member)) {
            System.out.println("Library does not have " + member);
            return;
        }
        if (!this.hasBook(book)) {
            System.out.println("Library does not have " + book);
            return;
        }

        book.doReserve(member);
    }

    public void cancelReserveBook(LibraryMember member, Book book) {
        if (!this.hasMember(member)) {
            System.out.println("Library does not have " + member);
            return;
        }
        if (!this.hasBook(book)) {
            System.out.println("Library does not have " + book);
            return;
        }
        book.cancelReserve(member);
    }
}
