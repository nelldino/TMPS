package factories;

import art.Artwork;
import art.Painting;

public class PaintingFactory extends ArtworkFactory {
    public Artwork createArtwork(String author, String title, String medium, String size) {
        return new Painting(author, title, medium, size);
    }
}