package art;

public abstract class BaseArtwork implements Artwork {
    protected String author;
    protected String title;
    protected String medium;
    protected String size;

    public BaseArtwork(String author, String title, String medium, String size) {
        this.author = author;
        this.title = title;
        this.medium = medium;
        this.size = size;
    }

    @Override
    public String getAuthor() { return author; }

    @Override
    public String getTitle() { return title; }

    @Override
    public String getSize() { return size; }

    @Override
    public String getMedium() { return medium; }

    @Override
    public void displayDetails() {
        System.out.println("Author: " + author);
        System.out.println("Title: " + title);
        System.out.println("Medium: " + medium);
        System.out.println("Size: " + size);
    }
}
