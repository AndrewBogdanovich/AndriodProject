package com.andrewbogdanovich.github.andriodproject.Models.Article;

public class Source {
    private String id;

    private String name;

    public Source(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Source() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
