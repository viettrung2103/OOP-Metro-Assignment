package Week2.A23.Task6;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private Book mostReviewedBook;

    public Library() {

        books = new ArrayList<>();
        this.mostReviewedBook = null;
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

    public Book borrowBook(User user, String title) {
        System.out.println(user.getName() + " borrows book \"" + title + "\" :");
        for (Book book : this.books) {
            if (book.getTitle().equals(title)) {
                if (book.getIsAvailable()) {
                    System.out.println("Successfully");
                    book.setIsAvailableOnOff();
                    user.borrowBook(book);
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

    public void returnBook(User user, Book book) {
//        boolean isFound = false;
        for (Book curBook : this.books) {
            if (curBook.getTitle().equals(book.getTitle())) {
                if (curBook.getIsAvailable()) {
                    System.out.println("The book is already returned.");
                    System.out.println("Are you sure you return to the right library.");
                    return;
                } else {
                    Book returnedBook = user.returnBook(book.getTitle());
                    if (returnedBook != null) {
                        curBook.setIsAvailableOnOff();
                        System.out.println("Thank you for return Book \"" + book.getTitle() + "\" to us.");
                    } else {
                        System.out.println("User \"" + user.getName() + "\" did not borrow the book \"" + book.getTitle());
                    }
                    return;

                }
            }
        }
        System.out.println("The book \"" + book.getTitle() + "\" does not exisit in our library.");
        System.out.println("Are you sure you return the correct book?");
    }

    public boolean isBookAvailable(String title) {
        System.out.println("Is the book \"" + title + "\" available?");
        for (Book book : this.books) {
            if (book.getTitle().equals(title)) {
                if (book.getIsAvailable()) {
                    System.out.println("Yes. It is available");
                    return true;
                } else {
                    System.out.println("No. It is not available");
                    return false;
                }
            }
        }
        System.out.println("The book \"" + title + "\" does not exist in our system.");
        return false;
    }

    public void getAverageBookRating() {
//        double averageSum = 0;
        if (!this.books.isEmpty()) {
            System.out.println("List of books and their average ratings:");
            for (Book book : this.books) {
                book.setAverageRating();
                System.out.println(book);
            }
        } else {
            System.out.println("The library is empty");
        }
    }

    public void setMostReviewdBook() {
        Book mostReviewBook = null;
        if (!this.books.isEmpty()) {
            for (int i = 0; i < this.books.size(); i++) {
                if (i == 0) {
                    mostReviewBook = books.get(0);
                } else {
                    Book curBook = books.get(i);
                    if (!mostReviewBook.hasMoreReview(curBook)) {
                        mostReviewBook = curBook;
                    }
                }
            }
        }
        this.mostReviewedBook = mostReviewBook;
    }

    public Book getMostReviewedBook() {
        setMostReviewdBook();
        return this.mostReviewedBook;
    }

    public void displayMostReviewBook() {
        Book mostReviewBook = this.getMostReviewedBook();
        if (mostReviewBook != null) {
            System.out.println("The Book with highest reviews:");
            System.out.println(mostReviewBook);
        } else {
            System.out.println("There is no reviews in the library");
        }
    }


}
