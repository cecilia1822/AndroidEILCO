package com.example.tdpokedex;

public class Pokemon {

    public String name;
    public String url;
    public String Id;

    public String getName() {
        return name;
    }

    public String getId() {
        return Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Pokemon(String name, String url) {
        this.name = name;
        this.url = url;
        String[]Url = this.url.split("/");
        Id=Url[6];
    }
}
