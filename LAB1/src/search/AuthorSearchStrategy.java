package search;

import art.Artwork;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorSearchStrategy implements SearchStrategy {
    @Override
    public List<Artwork> search(List<Artwork> artworks, String author) {
        return artworks.stream()
                .filter(artwork -> artwork.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }
}
