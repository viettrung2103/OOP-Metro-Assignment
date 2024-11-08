package Week3.A33.Task3.model;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean reserved;
    private LibraryMember member;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.reserved = false;
        this.member = null;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getISBN() {
        return this.isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public boolean isReserved() {
        return this.reserved;
    }

    public void toggleReserveStatus(LibraryMember member) {
        if (!this.reserved) {
            this.member = member;
            this.reserved = true;
        } else {
            this.member = null;
            this.reserved = false;
        }

    }

    public void doReserve(LibraryMember member) {
        // check if the book is reserve
        if (isReserved()) {
            // check if person who reserve the book is the same as the person who has reserved the book
            if (this.member.getName().equals(member.getName())) {
                System.out.println(member + " already reserved the book " + this + ". Cannot reserve again");
            } else {
                System.out.println(member + " cannot reserve " + this);
                System.out.println("The book is already reservered by " + this.member);
            }

        } else {
            System.out.println(member + " reserve successfully the book " + this);
            this.toggleReserveStatus(member);
            member.reserveBook(this);
        }

    }

    public void cancelReserve(LibraryMember member) {
        // check if the book is reserve
        if (isReserved()) {
            // check if person who reserve the book is the same as the person who has reserved the book
            if (this.member.getName().equals(member.getName())) {
                System.out.println(member + " cancel the reservation successfully of " + this);
                this.toggleReserveStatus(member);
                member.cancelReservation(this);
            } else {
                System.out.println(member + " cannot cancel the reservation of " + this);
                System.out.println("The book is already reservered by " + this.member);
            }

        } else {
            System.out.println("Cannot cancel reservation. " + this + " is available for reservable.");
        }
    }

    @Override
    public String toString() {
        return "Book with title \"" + this.title + "\", writen by \"" + this.author + "\" has isbn \"" + this.isbn + "\"";
    }

}
