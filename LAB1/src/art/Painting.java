package art;
public class Painting implements Artwork {
    private String author;
    private String title;
    private String medium;
    private String size;

    public Painting(String author, String title, String medium, String size) {
        this.author = author;
        this.title = title;
        this.medium = medium;
        this.size = size;
    }

    @Override
    public void displayDetails() {
        System.out.println("Type: Painting");
        System.out.println("Author: " + author);
        System.out.println("Title: " + title);
        System.out.println("Medium: " + medium);
        System.out.println("Size: " + size);
    }

    public String getAuthor() { return author; }
    public String getTitle() { return title; }
    public String getMedium() { return medium; }
    public String getSize() { return size; }
}

// Similar display structure for Sculpture and DigitalArt classes
