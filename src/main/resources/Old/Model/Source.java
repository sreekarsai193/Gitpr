package Old.Controller.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Source {

    @JsonProperty("full_name")
    private String full_name;

//    @JsonProperty("properties")
//    private Properties property;
//
//
//    public Properties getProperty() {
//        return property;
//    }
//
//    public String getTitle() {
//        return title;
//    }

    public String getFull_name() {
        return full_name;
    }
}
