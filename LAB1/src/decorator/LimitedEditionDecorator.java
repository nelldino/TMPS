package decorator;

import art.Artwork;

public class LimitedEditionDecorator extends ArtworkDecorator {
    public LimitedEditionDecorator(Artwork artwork) {
        super(artwork);
    }

    @Override
    public void displayDetails() {
        artwork.displayDetails();
        System.out.println("This artwork is a limited edition!");
    }
}
