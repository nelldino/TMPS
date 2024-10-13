package models;

public class EBook extends Book {
    private String fileSize;

    // Constructor to initialize EBook-specific fields and parent Book fields
    public EBook(String title, String author, String ISBN, int bookQuantity, String fileSize) {
        super(title, author, ISBN, bookQuantity);  // Call parent constructor with parameters
        this.fileSize = fileSize;                  // Set the fileSize specific to EBook
    }

    @Override
    public String getDetails() {
        return "Type: EBook, Title: " + getTitle() + ", Author: " + getAuthor() +
                ", ISBN: " + getISBN() + ", Quantity: " + getBookQuantity() +
                ", File Size: " + fileSize;
    }
}
