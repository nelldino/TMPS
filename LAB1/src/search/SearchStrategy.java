package search;

import art.Artwork;
import java.util.List;

public interface SearchStrategy {
    List<Artwork> search(List<Artwork> artworks, String criteria);
}
