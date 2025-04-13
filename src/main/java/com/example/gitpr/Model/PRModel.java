package com.example.gitpr.Model;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PRModel {

    @JsonProperty("html_url")
    private String title;

    @JsonProperty("sha")
    private String description;

    @JsonProperty("commit")
    private Commit commit;
}
