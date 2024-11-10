package decorator;

import art.Artwork;

public class FeaturedArtworkDecorator extends ArtworkDecorator {
    public FeaturedArtworkDecorator(Artwork artwork) {
        super(artwork);
    }

    @Override
    public void displayDetails() {
        artwork.displayDetails();
        System.out.println("This is a featured artwork!");
    }
}
