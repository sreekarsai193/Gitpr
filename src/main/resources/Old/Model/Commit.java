package Old.Controller.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Commit {
    @JsonProperty("message")
    String message;

    @JsonProperty("author")
    Author author;

    public Author getAuthor() {
        return author;
    }
}
