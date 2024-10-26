package factories;

import art.Artwork;

public abstract class ArtworkFactory {
    public abstract Artwork createArtwork(String author, String title, String medium, String size);
}

