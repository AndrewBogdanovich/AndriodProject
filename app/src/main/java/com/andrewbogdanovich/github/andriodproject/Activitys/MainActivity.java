package com.andrewbogdanovich.github.andriodproject.Activitys;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.andrewbogdanovich.github.andriodproject.Adapters.ArticleDataAdapter;
import com.andrewbogdanovich.github.andriodproject.Models.Article.Articles;
import com.andrewbogdanovich.github.andriodproject.Models.Article.MainModel;
import com.andrewbogdanovich.github.andriodproject.ParseTask;
import com.andrewbogdanovich.github.andriodproject.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends FragmentActivity implements SwipeRefreshLayout.OnRefreshListener {

    List<Articles> articleList = new ArrayList<>();
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initView();
        setContentView(R.layout.activity_main);
        loadParser();
        loadDataInRecyclerView();
        //Toast.makeText(this, parseText, Toast.LENGTH_SHORT).show();

        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);


    }


    private void loadDataInRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.Recycler_View);
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
        articleList.addAll(Arrays.asList(mainModel.getArticles()));
    }


    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        swipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {

                swipeRefreshLayout.setRefreshing(false);
            }
        }, 3000);
    }
}
