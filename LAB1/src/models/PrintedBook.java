package models;

public class PrintedBook extends Book {
    private String versionType;

    public PrintedBook(String title, String author, String ISBN, int bookQuantity, String versionType) {
        super(title, author, ISBN, bookQuantity);
        this.versionType = versionType;
    }

    @Override
    public String getType() {
        return "PrintedBook";
    }
}
