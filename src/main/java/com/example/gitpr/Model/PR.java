package com.example.gitpr.Model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PR {

    public Items[] getItems() {
        return items;
    }

    @JsonProperty("items")
    Items[] items;

}
