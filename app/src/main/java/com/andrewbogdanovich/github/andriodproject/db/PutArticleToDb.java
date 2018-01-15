package com.andrewbogdanovich.github.andriodproject.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.andrewbogdanovich.github.andriodproject.Models.Article.Articles;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class PutArticleToDb {

    SQLiteConnector sqLiteConnector;
    List<Articles> articleList = new ArrayList<>();

    public void putData(){

        SQLiteDatabase writeConnection = sqLiteConnector.getWritableDatabase();
        writeConnection.beginTransaction();
        for (Articles articles : articleList) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(ArticlesDb.PUBLISHED_AT, articles.getPublishedAt());
            contentValues.put(ArticlesDb.TITLE, articles.getTitle());
        }
        writeConnection.setTransactionSuccessful();
        writeConnection.endTransaction();

        SQLiteDatabase readableConnection = sqLiteConnector.getReadableDatabase();
        Cursor cursor = readableConnection.query(ArticlesDb.TABLE,
                new String[]{ArticlesDb.ID, ArticlesDb.PUBLISHED_AT, ArticlesDb.TITLE},
                ArticlesDb.PUBLISHED_AT + "=? AND" + ArticlesDb.TITLE + "NOT NULL",
                new String[]{"2012 Trump"},null,null,null,null);
        while (cursor.moveToNext()){
            String articleId = cursor.getString(cursor.getColumnIndex(ArticlesDb.ID));
            String articlePublishedAt = cursor.getString(cursor.getColumnIndex(ArticlesDb.PUBLISHED_AT));
            String articleTitle = cursor.getString(cursor.getColumnIndex(ArticlesDb.TITLE));
            Articles articles = new Articles(articleId, articlePublishedAt, articleTitle, null);
            articleList.add(articles);
        }
        cursor.close();

        assertEquals(articleList.size(), 1);
        assertEquals(articleList.get(0).getTitle(), "Trump");


        Cursor usersDbCursor = readableConnection.query(ArticlesDb.TABLE, null, null,
                null, null, null, null, null);


        assertEquals(usersDbCursor.getCount(), 5);

        usersDbCursor.close();
    }
}
