package com.andrewbogdanovich.github.andriodproject.db;


public class Table {
    public static final String ARTICLES_TABLE = "CREATE TABLE IF NOT EXISTS" +
            ArticlesDb.TABLE + "(" +
            ArticlesDb.ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
            ArticlesDb.PUBLISHED_AT + " VARCHAR(500)," +
            ArticlesDb.TITLE + " VARCHAR(500) )";

    public static final String INSERT_ARTICLES = "INSERT INTO" +
            ArticlesDb.TABLE + "(" +
            ArticlesDb.PUBLISHED_AT + "," +
            ArticlesDb.TITLE  + "VALUES(?,?)";

}
