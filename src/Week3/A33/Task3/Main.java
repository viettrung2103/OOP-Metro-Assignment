package Week3.A33.Task3;

import Week3.A33.Task3.model.Book;
import Week3.A33.Task3.model.LibraryMember;
import Week3.A33.Task3.system.Library;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("book1", "author1", "123");
        Book book2 = new Book("book2", "author2", "234");
        Book nonExistBook = new Book("non exist Book", "non-exist author", "345");
        Book nonBorrowBook = new Book("non borrow Book", "non-exist author", "345");
        LibraryMember member1 = new LibraryMember("user1");
        LibraryMember member2 = new LibraryMember("user2");
        LibraryMember nonExisitMember = new LibraryMember("nonexist member");
        Library library = new Library();
        library.addMember(member1);
        library.addMember(member1);
        library.addMember(member2);
        System.out.println();

        library.addBook(book1);
        library.addBook(book1);
        library.addBook(book2);
        System.out.println();

        library.borrowBook(member1, book1);
        library.borrowBook(member1, book2);
        library.borrowBook(nonExisitMember, book1);
        library.borrowBook(member1, nonExistBook);
        System.out.println();

        library.displayBorrowedBooksByMember(member1);
        library.displayBorrowedBooksByMember(nonExisitMember);
        System.out.println();

        library.returnBook(member1, nonBorrowBook);
        library.returnBook(member1, book1);
        System.out.println();

        library.reserveBook(member1, book1);
        library.reserveBook(member1, book1);
        library.reserveBook(member2, book1);
        library.reserveBook(member2, nonExistBook);
        library.reserveBook(nonExisitMember, book1);
        System.out.println();

        library.displayReservedBooksByMember(member1);
        library.displayReservedBooksByMember(nonExisitMember);
        System.out.println();

        library.cancelReserveBook(nonExisitMember, book1);
        library.cancelReserveBook(member2, nonExistBook);

        library.cancelReserveBook(member2, book1);
        library.cancelReserveBook(member2, book2);
        library.cancelReserveBook(member1, book1);
        library.cancelReserveBook(member1, book1);

    }
}
