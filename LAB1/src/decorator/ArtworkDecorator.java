package decorator;

import art.Artwork;

public abstract class ArtworkDecorator implements Artwork {
    protected Artwork artwork;  // The wrapped artwork object

    public ArtworkDecorator(Artwork artwork) {
        this.artwork = artwork;
    }

    @Override
    public void displayDetails() {
        artwork.displayDetails();
    }

    @Override
    public String getAuthor() {
        return artwork.getAuthor();
    }

    @Override
    public String getTitle() {
        return artwork.getTitle();
    }

    @Override
    public String getSize() {
        return artwork.getSize();
    }

    @Override
    public String getMedium() {
        return artwork.getMedium();
    }
}
