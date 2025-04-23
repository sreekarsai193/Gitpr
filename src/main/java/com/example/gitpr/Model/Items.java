package com.example.gitpr.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Items {

    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    String title;

    @JsonProperty("repository_url")
    String repository_url;

    public String getName(){
        String[] parts = repository_url.split("/");
        if (parts.length >= 2) {
            return parts[parts.length - 2] + "/" + parts[parts.length - 1];
        } else {
            return parts[0];
        }
    }



}
