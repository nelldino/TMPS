package gallery;

import art.Artwork;

import java.util.ArrayList;
import java.util.List;

public class Exhibition {
    private String title;
    private List<Artwork> artworks;

    public Exhibition(String title) {
        this.title = title;
        this.artworks = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void addArtwork(Artwork artwork) {
        artworks.add(artwork);
    }

    public void displayExhibition() {
        System.out.println("gallery.Exhibition Title: " + title);
        System.out.println("Artworks in this gallery.Exhibition:");
        for (Artwork artwork : artworks) {
            System.out.println("------------------------------------");
            artwork.display();
            System.out.println("------------------------------------");
        }
    }
}
