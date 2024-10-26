
import art.Artwork;
import factories.PaintingFactory;
import factories.SculptureFactory;
import gallery.ArtGallery;
import gallery.Exhibition;
import search.SearchFilter;

import java.util.List;
import java.util.Scanner;

public class ArtGalleryApp {
    public static void main(String[] args) {
        ArtGallery gallery = ArtGallery.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Digital Art Gallery");
            System.out.println("1. Add Artwork");
            System.out.println("2. Display All Artworks");
            System.out.println("3. Search Artworks");
            System.out.println("4. Create an Exhibition");
            System.out.println("5. Display Exhibitions");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Select Artwork Type: 1) Painting 2) Sculpture");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    // Collect artwork details
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Medium: ");
                    String medium = scanner.nextLine();
                    System.out.print("Enter Size (a x b): ");
                    String size = scanner.nextLine();

                    Artwork artwork = null;
                    switch (type) {
                        case 1:
                            artwork = new PaintingFactory().createArtwork(author, title, medium, size);
                            break;
                        case 2:
                            artwork = new SculptureFactory().createArtwork(author, title, medium, size);
                            break;
                        default:
                            System.out.println("Invalid type selected.");
                            continue;
                    }
                    gallery.addArtwork(artwork);
                    System.out.println("Artwork added successfully.");
                    break;

                case 2:
                    System.out.println("All Artworks in Gallery:");
                    gallery.displayAllArtworks();
                    break;

                case 3:
                    System.out.print("Enter Title to search (leave blank if not needed): ");
                    String searchTitle = scanner.nextLine();
                    System.out.print("Enter Author to search (leave blank if not needed): ");
                    String searchAuthor = scanner.nextLine();

                    SearchFilter filter = new SearchFilter.Builder()
                            .title(searchTitle.isEmpty() ? null : searchTitle)
                            .author(searchAuthor.isEmpty() ? null : searchAuthor)
                            .build();

                    List<Artwork> results = gallery.searchArtworks(filter);
                    System.out.println("Search Results:");
                    if (results.isEmpty()) {
                        System.out.println("No artworks found matching the criteria.");
                    } else {
                        for (Artwork result : results) {
                            System.out.println("------------------------------------");
                            result.display();
                            System.out.println("------------------------------------");
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter gallery.Exhibition Title: ");
                    String exhibitionTitle = scanner.nextLine();
                    Exhibition exhibition = new Exhibition(exhibitionTitle);

                    System.out.print("How many artworks do you want to add to this exhibition? ");
                    int artworkCount = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    for (int i = 0; i < artworkCount; i++) {
                        System.out.println("Enter title of artwork " + (i + 1) + ": ");
                        String artworkTitle = scanner.nextLine();

                        Artwork artworks = gallery.getArtworks().stream()
                                .filter(a -> a.getTitle().equalsIgnoreCase(artworkTitle))
                                .findFirst()
                                .orElse(null);

                        if (artworks != null) {
                            exhibition.addArtwork(artworks);
                        } else {
                            System.out.println("Artwork titled '" + artworkTitle + "' not found in gallery.");
                        }
                    }
                    gallery.addExhibition(exhibition);
                    System.out.println("gallery.Exhibition created successfully!");
                    break;

                case 5:
                    gallery.displayExhibitions();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}