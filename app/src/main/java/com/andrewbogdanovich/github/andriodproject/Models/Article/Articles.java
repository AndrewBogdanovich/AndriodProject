package com.andrewbogdanovich.github.andriodproject.Models.Article;

public class Articles {

    private String publishedAt;

    private String author;

    private String urlToImage;

    private String title;

    private Source source;

    private String description;

    private String url;

    public Articles(String publishedAt, String author, String urlToImage, String title, Source source, String description, String url) {
        this.publishedAt = publishedAt;
        this.author = author;
        this.urlToImage = urlToImage;
        this.title = title;
        this.source = source;
        this.description = description;
        this.url = url;
    }

    public Articles(String articleId, String articlePublishedAt, String articleTitle, Object o) {

    }


    public String getPublishedAt() {
        return publishedAt;
    }

    public String getAuthor() {
        return author;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getTitle() {
        return title;
    }

    public Source getSource() {
        return source;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
