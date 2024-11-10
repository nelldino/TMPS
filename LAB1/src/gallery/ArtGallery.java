package gallery;

import art.Artwork;
import search.SearchFilter;

import java.util.ArrayList;
import java.util.List;

public class ArtGallery {
    private static ArtGallery instance;
    private List<Artwork> artworks;
    private List<Exhibition> exhibitions;

    private ArtGallery() {
        artworks = new ArrayList<>();
        exhibitions = new ArrayList<>();
    }

    public static ArtGallery getInstance() {
        if (instance == null) {
            instance = new ArtGallery();
        }
        return instance;
    }


    public List<Artwork> searchArtworks(SearchFilter filter) {
        List<Artwork> results = new ArrayList<>();
        for (Artwork artwork : artworks) {
            boolean matchesTitle = filter.getTitle() == null || artwork.getTitle().equalsIgnoreCase(filter.getTitle());
            boolean matchesAuthor = filter.getAuthor() == null || artwork.getAuthor().equalsIgnoreCase(filter.getAuthor());

            if (matchesTitle && matchesAuthor) {
                results.add(artwork);
            }
        }
        return results;
    }
    public void addArtwork(Artwork artwork) {
        artworks.add(artwork);
    }

    public void addExhibition(Exhibition exhibition) {
        exhibitions.add(exhibition);
    }

    public List<Artwork> getArtworks() {
        return artworks;
    }

    public void displayAllArtworks() {
        if (artworks.isEmpty()) {
            System.out.println("No artworks in the gallery.");
        } else {
            for (Artwork artwork : artworks) {
                System.out.println("------------------------------------");
                artwork.displayDetails();
                System.out.println("------------------------------------");
            }
        }
    }

    public void displayExhibitions() {
        if (exhibitions.isEmpty()) {
            System.out.println("No exhibitions available.");
        } else {
            for (Exhibition exhibition : exhibitions) {
                System.out.println("====================================");
                exhibition.displayExhibition();
                System.out.println("====================================");
            }
        }
    }
}
