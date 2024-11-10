package adapters;

import art.Artwork;

public class ArtworkAdapter implements DescribableArtwork {
    private Artwork artwork;

    public ArtworkAdapter(Artwork artwork) {
        this.artwork = artwork;
    }

    @Override
    public String getDescription() {
        return "Artwork by " + artwork.getAuthor() + ": " + artwork.getTitle() + ", a " + artwork.getMedium() + " piece of size " + artwork.getSize();
    }
}
