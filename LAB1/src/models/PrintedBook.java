package models;

public class PrintedBook extends Book {
    private String versionType;

    // Constructor to initialize PrintedBook-specific fields and parent Book fields
    public PrintedBook(String title, String author, String ISBN, int bookQuantity, String versionType) {
        super(title, author, ISBN, bookQuantity);  // Call parent constructor with parameters
        this.versionType = versionType;            // Set the versionType specific to PrintedBook
    }

    @Override
    public String getDetails() {
        return "Type: PrintedBook, Title: " + getTitle() + ", Author: " + getAuthor() +
                ", ISBN: " + getISBN() + ", Quantity: " + getBookQuantity() +
                ", Version Type: " + versionType;
    }

    @Override
    public String getType() {
        return "PrintedBook";
    }
}
