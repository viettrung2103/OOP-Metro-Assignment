package Week3.A33.Task2.library;

import Week3.A33.Task2.library.model.Book;
import Week3.A33.Task2.library.model.LibraryMember;
import Week3.A33.Task2.library.system.Library;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("book1", "author1", "123");
        Book book2 = new Book("book2", "author2", "234");
        Book nonExistBook = new Book("non exist Book", "non-exist author", "345");
        Book nonBorrowBook = new Book("non borrow Book", "non-exist author", "345");
        LibraryMember member1 = new LibraryMember("user1");
        LibraryMember nonExisitMember = new LibraryMember("nonexist member");
        Library library = new Library();
        library.addMember(member1);
        library.addBook(book1);
        library.addBook(book2);

        library.borrowBook(member1, book1);
        library.borrowBook(member1, book2);
        library.borrowBook(nonExisitMember, book1);
        library.borrowBook(member1, nonExistBook);

        member1.displayBookList();
        nonExisitMember.displayBookList();

        library.returnBook(member1, nonBorrowBook);
        library.returnBook(member1, book1);
    }
}
