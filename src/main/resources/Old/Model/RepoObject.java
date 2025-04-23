package Old.Controller.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepoObject {

    @JsonProperty("name")
    private String name;

    @JsonProperty("full_name")
    private String full_name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("license")
    private License license;

    @JsonProperty("fork")
    private boolean isForked;

    @JsonProperty("source")
    private Source source;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public License getLicense() {
        return license;
    }

    public boolean isForked() {
        return isForked;
    }


    public Source getSource(){
        return source;
    }

    public String getFullName()
    {
        return full_name;
    }

}
