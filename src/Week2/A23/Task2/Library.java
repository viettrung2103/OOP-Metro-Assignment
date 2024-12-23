package Week2.A23.Task2;

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

    public Book borrowBook(String title) {
        System.out.println("Borrow book \"" + title + "\" :");
        for (Book book : this.books) {
            if (book.getTitle().equals(title)) {
                if (book.getIsAvailable()) {
                    System.out.println("Successfully");
                    book.setIsAvailableOnOff();
                    return book;
                } else {
                    System.out.println("Fail. The book \"" + title + "\" is already borrowed.");

                    return null;
                }

            }
        }
        System.out.println("Fail. The book \"" + title + "\" does not available in the library.");
        return null;
    }

    public void returnBook(Book book) {
//        boolean isFound = false;
        for (Book curBook : this.books) {
            if (curBook.getTitle().equals(book.getTitle())) {
                if (curBook.getIsAvailable()) {
                    System.out.println("The book is already returned.");
                    System.out.println("Are you sure you return to the right library.");
                    return;
                } else {
                    curBook.setIsAvailableOnOff();
                    System.out.println("Thank you for return Book \"" + book.getTitle() + "\" to us.");
                    return;

                }
            }
        }
        System.out.println("The book \"" + book.getTitle() + "\" does not exisit in our library.");
        System.out.println("Are you sure you return the correct book?");
    }


}
