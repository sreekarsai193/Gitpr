package Old.Controller.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Properties {

    @JsonProperty("full_name")
    String full_name;

    public String getFull_name() {
        return full_name;
    }
}
