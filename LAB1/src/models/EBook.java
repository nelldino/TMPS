package models;

public class EBook extends Book {
    private String fileSize;

    public EBook(String title, String author, String ISBN, int bookQuantity, String fileSize) {
        super(title, author, ISBN, bookQuantity);
        this.fileSize = fileSize;
    }

    @Override
    public String getType() {
        return "EBook";
    }
}
