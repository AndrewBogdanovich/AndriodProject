package com.andrewbogdanovich.github.andriodproject.Models.Article;

public class MainModel {
    private Articles[] articles;

    private String totalResults;

    private String status;

    public MainModel(Articles[] articles, String totalResults, String status) {
        this.articles = articles;
        this.totalResults = totalResults;
        this.status = status;
    }

    public Articles[] getArticles() {
        return articles;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public String getStatus() {
        return status;
    }

    public void setArticles(Articles[] articles) {
        this.articles = articles;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
