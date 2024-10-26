package search;

public class SearchFilter {
    private String title;
    private String author;

    private SearchFilter(Builder builder) {
        this.title = builder.title;
        this.author = builder.author;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    // Builder Pattern
    public static class Builder {
        private String title;
        private String author;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public SearchFilter build() {
            return new SearchFilter(this);
        }
    }
}
