package Week2.A23.Task5;

public class LibraryMain {
    public static void main(String[] args) {
        System.out.println("Library Catalog:");

        Library library = new Library();
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("Data Structures and Algorithms123", "Jane Doe", 2018);
        Book book4 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.displayBook();

        String existingAuthor = "Jane Doe";
        String nonExistingAuthor = "author1";
        library.findBookByAuthor(existingAuthor);
        library.findBookByAuthor(nonExistingAuthor);

        String existingTitle = "Introduction to Java Programming";
        String nonExistingTitle = "Title1";
        library.borrowBook(existingTitle);
        library.borrowBook(nonExistingTitle);
        library.borrowBook(existingTitle);

        Book nonExistBook = new Book("Title1", "Author1", 1111);
        library.returnBook(book1);
        library.returnBook(nonExistBook);

        library.isBookAvailable(existingTitle);
        library.isBookAvailable(nonExistingTitle);

        book1.addRatingAndReview("Good book", 4.0);
        book1.addRatingAndReview("Normal book", 3.8);
        book2.addRatingAndReview("Excellent book", 5.0);
        book2.addRatingAndReview("Supper good book", 4.5);
//        book1.setAverageRating();
//        book2.setAverageRating();

        library.getAverageBookRating();
        Book mostReviewBook = library.getMostReviewedBook();
        if (mostReviewBook != null) {
            System.out.println("The Book with highest reviews:");
            System.out.println(mostReviewBook);
        } else {
            System.out.println("There is no reviews in the library");
        }

    }

}
