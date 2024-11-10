package gallery;

import art.Artwork;

import java.util.ArrayList;
import java.util.List;

public class Exhibition implements Artwork {
    private String exhibitionTitle;
    private List<Artwork> artworks;

    public Exhibition(String exhibitionTitle) {
        this.exhibitionTitle = exhibitionTitle;
        this.artworks = new ArrayList<>();
    }

    // Add an Artwork (can be individual or another Exhibition)
    public void addArtwork(Artwork artwork) {
        artworks.add(artwork);
    }

    @Override
    public void displayDetails() {
        System.out.println("Exhibition Title: " + exhibitionTitle);
        for (Artwork artwork : artworks) {
            artwork.displayDetails(); // Delegate display to each Artwork
        }
    }

    // New method to display the exhibition
    public void displayExhibition() {
        System.out.println("Exhibition Title: " + exhibitionTitle);
        System.out.println("Artworks in this exhibition:");
        for (Artwork artwork : artworks) {
            artwork.displayDetails(); // Display details of each artwork
        }
    }

    @Override
    public String getAuthor() {
        return null; // Not applicable for an exhibition
    }

    @Override
    public String getTitle() {
        return exhibitionTitle;
    }

    @Override
    public String getMedium() {
        return null; // Not applicable for an exhibition
    }

    @Override
    public String getSize() {
        return null; // Not applicable for an exhibition
    }
}
