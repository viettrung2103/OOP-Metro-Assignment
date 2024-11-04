package Week2.A23.Task6;

import java.util.ArrayList;

public class
Book {
    private String title;
    private String author;
    private int publicYear;
    private boolean isAvailable;
    private double averageRating;
    private ArrayList<Double> ratings;
    private ArrayList<String> reviews;

    public Book(String title, String author, int publicYear) {
        this.title = title;
        this.author = author;
        this.publicYear = publicYear;
        this.isAvailable = true;
        this.ratings = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public int getPublicYear() {
        return this.publicYear;
    }

    public boolean getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailableOnOff() {
        this.isAvailable = !this.isAvailable;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    private void setRating(double rating) {
        if (rating > 5) {
            rating = 5;
        }
        if (rating < 0) {
            rating = 0;
        }
        this.ratings.add(rating);
    }

    private void addReview(String review) {
        this.reviews.add(review);
    }

    public void addRatingAndReview(String review, double rating) {
        setRating(rating);
        addReview(review);
    }

    public double getAverageRating() {
        return this.averageRating;
    }

    public void setAverageRating() {
        double sum = 0;
        this.averageRating = 0;
        if (!this.ratings.isEmpty()) {
            for (double rating : this.ratings) {
                sum += rating;
            }
            this.averageRating = sum * 1.0 / this.ratings.size();
        }
    }

    public void displayReviews() {
        this.setAverageRating();
        System.out.println("Book: \"" + this.title + "\" average rating " + this.averageRating + ". Review List:");
        for (int i = 0; i < this.reviews.size(); i++) {
            System.out.println((i + 1) + ". " + this.reviews.get(i) + ". Rating: " + this.ratings.get(i));
        }
    }

    public double getNumberOfReview() {
        return this.reviews.size();
    }

    public boolean hasMoreReview(Book book) {
        if (this.getNumberOfReview() > book.getNumberOfReview()) {
            return true;
        }
        return false;
    }



    @Override
    public String toString() {
        return "Title: \"" + this.title + "\", Author: \"" + this.author + "\", Year: " + this.publicYear + ", Average Rating: " + this.averageRating;
    }
}
