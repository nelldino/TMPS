package models;

public abstract class Book {
    public String title;
    public String author;
    public String ISBN;
    public int bookQuantity;
    public int bookQuantityCopy;

    public Book(String title, String author, String ISBN, int bookQuantity) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.bookQuantity = bookQuantity;
        this.bookQuantityCopy = bookQuantity;
    }

    public abstract String getType();
}
