package models;

public abstract class Book {
    public String title;
    public String author;
    public String ISBN;
    public int bookQuantity;
    public int bookQuantityCopy;

    // Constructor
    public Book(String title, String author, String ISBN, int bookQuantity) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.bookQuantity = bookQuantity;
        this.bookQuantityCopy = bookQuantity;
    }

    // Getters for the book properties
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public int getBookQuantityCopy() {
        return bookQuantityCopy;
    }

    // Abstract method to define the type of book
    public abstract String getType();
}
