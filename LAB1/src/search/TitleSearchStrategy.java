package search;

import art.Artwork;
import java.util.List;
import java.util.stream.Collectors;

public class TitleSearchStrategy implements SearchStrategy {
    @Override
    public List<Artwork> search(List<Artwork> artworks, String title) {
        return artworks.stream()
                .filter(artwork -> artwork.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }
}
