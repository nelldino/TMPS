package search;

import art.Artwork;
import java.util.List;

public class SearchContext {
    private SearchStrategy strategy;

    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Artwork> executeSearch(List<Artwork> artworks, String criteria) {
        return strategy.search(artworks, criteria);
    }
}
