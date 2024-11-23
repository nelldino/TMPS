
import adapters.ArtworkAdapter;
import adapters.DescribableArtwork;
import art.Artwork;
import decorator.FeaturedArtworkDecorator;
import decorator.LimitedEditionDecorator;
import factories.PaintingFactory;
import factories.SculptureFactory;
import gallery.ArtGallery;
import gallery.Exhibition;
import search.AuthorSearchStrategy;
import search.SearchContext;
import search.SearchFilter;
import search.TitleSearchStrategy;

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
            System.out.println("6. Categorize an Artwork");
            System.out.println("7. Display a specific artwork");
            System.out.println("8. Exit");
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
                    SearchContext context = new SearchContext();

                    System.out.println("Choose search type: 1) Author 2) Title");
                    int searchType = scanner.nextInt();
                    scanner.nextLine();

                    if (searchType == 1) {
                        context.setStrategy(new AuthorSearchStrategy());
                        System.out.print("Enter author name: ");
                        author = scanner.nextLine();
                        context.executeSearch(gallery.getArtworks(), author)
                                .forEach(Artwork::displayDetails);
                    } else if (searchType == 2) {
                        context.setStrategy(new TitleSearchStrategy());
                        System.out.print("Enter title: ");
                        title = scanner.nextLine();
                        context.executeSearch(gallery.getArtworks(), title)
                                .forEach(Artwork::displayDetails);
                    } else {
                        System.out.println("Invalid search type.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Exhibition Title: ");
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
                    System.out.println("Exhibition created successfully!");
                    break;

                case 5:
                    gallery.displayExhibitions();
                    break;

                case 6:
                    System.out.print("Enter title of artwork to decorate: ");
                    String decorateTitle = scanner.nextLine();

                    Artwork artworkToDecorate = gallery.getArtworks().stream()
                            .filter(a -> a.getTitle().equalsIgnoreCase(decorateTitle))
                            .findFirst()
                            .orElse(null);

                    if (artworkToDecorate == null) {
                        System.out.println("Artwork not found.");
                        break;
                    }

                    System.out.println("Select decoration: 1) Featured 2) Limited Edition");
                    int decorationChoice = scanner.nextInt();
                    scanner.nextLine();

                    Artwork decoratedArtwork;
                    if (decorationChoice == 1) {
                        decoratedArtwork = new FeaturedArtworkDecorator(artworkToDecorate);
                    } else if (decorationChoice == 2) {
                        decoratedArtwork = new LimitedEditionDecorator(artworkToDecorate);
                    } else {
                        System.out.println("Invalid decoration choice.");
                        break;
                    }

                    System.out.println("Artwork with decoration:");
                    decoratedArtwork.displayDetails();
                    break;

                case 7:
                    System.out.print("Enter title of artwork to display: ");
                    String displayTitle = scanner.nextLine();

                    Artwork artworkToDisplay = gallery.getArtworks().stream()
                            .filter(a -> a.getTitle().equalsIgnoreCase(displayTitle))
                            .findFirst()
                            .orElse(null);

                    if (artworkToDisplay == null) {
                        System.out.println("Artwork not found.");
                        break;
                    }

                    DescribableArtwork describableArtwork = new ArtworkAdapter(artworkToDisplay);
                    System.out.println(describableArtwork.getDescription());
                    break;

                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}