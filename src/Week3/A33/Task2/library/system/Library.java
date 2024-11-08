package Week3.A33.Task2.library.system;

import Week3.A33.Task2.library.model.Book;
import Week3.A33.Task2.library.model.LibraryMember;

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
        this.books.add(book);
    }

    public void addMember(LibraryMember member) {
        this.members.add(member);
    }

    public boolean hasMember(LibraryMember member) {
        return this.members.contains(member);
    }

    public boolean hasBook(Book book) {
        return this.books.contains(book);
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
}
