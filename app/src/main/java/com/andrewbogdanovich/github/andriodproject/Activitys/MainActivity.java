package com.andrewbogdanovich.github.andriodproject.Activitys;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.andrewbogdanovich.github.andriodproject.Adapters.ArticleDataAdapter;
import com.andrewbogdanovich.github.andriodproject.Models.Article.Articles;
import com.andrewbogdanovich.github.andriodproject.Models.Article.MainModel;
import com.andrewbogdanovich.github.andriodproject.ParseTask;
import com.andrewbogdanovich.github.andriodproject.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    List<Articles> articleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        loadParser();
        loadDataInRecyclerView();
        //Toast.makeText(this, parseText, Toast.LENGTH_SHORT).show();
    }

    private void loadDataInRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.Recycler_View);

        //GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        //recyclerView.setLayoutManager(gridLayoutManager);

        ArticleDataAdapter articleDataAdapter = new ArticleDataAdapter(this, articleList);
        recyclerView.setAdapter(articleDataAdapter);
    }

    @SuppressLint("SetTextI18n")
    private void loadParser() {
        ParseTask parseTask = new ParseTask();
        parseTask.execute();

        String parseText = null;
        try {
            parseText = parseTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        MainModel mainModel = new Gson().fromJson(parseText, MainModel.class);


        Log.i("GSON", mainModel.getStatus() + " " + mainModel.getTotalResults());
        for (Articles articles : mainModel.getArticles()) {
            articleList.add(articles);

            Log.i("GSON1",  articles.getUrlToImage());
        }
    }
}
