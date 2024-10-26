package factories;

import art.Artwork;
import art.Painting;
import art.Sculpture;

public class SculptureFactory extends ArtworkFactory {
    public Artwork createArtwork(String author, String title, String medium, String size) {
        return new Sculpture(author, title, medium, size);
    }
}