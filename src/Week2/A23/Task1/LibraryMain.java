package Week2.A23.Task1;

public class LibraryMain {
    public static void main(String[]args){
        System.out.println("Library Catalog:");

        Library library = new Library();
        Book book1 = new Book("Introduction to Java Programming","John Smith",2020);
        Book book2 = new Book("Data Structures and Algorithms","Jane Doe",2018);
        Book book3 = new Book("Data Structures and Algorithms123","Jane Doe",2018);
        Book book4 = new Book("The Art of Fiction","Alice Johnson",2019);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.displayBook();

        String existingAuthor = "Jane Doe";
        String nonExistingAuthor = "author1";
        library.findBookByAuthor(existingAuthor);
        library.findBookByAuthor(nonExistingAuthor);
    }

}
