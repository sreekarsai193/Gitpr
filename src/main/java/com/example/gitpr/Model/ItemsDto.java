package com.example.gitpr.Model;

public class ItemsDto {


    private String title;

    private String fullname;

    public ItemsDto(String title, String fullname) {
        this.title = title;
        this.fullname = fullname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

}
