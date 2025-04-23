package Old.Controller.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Author {
    @JsonProperty("name")
    String name;

    @JsonProperty("email")
    String email;

    public String getName() {
        return name;
    }
    public String getEmail(){
        return email;
    }
}
