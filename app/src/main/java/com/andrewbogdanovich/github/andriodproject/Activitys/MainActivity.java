package com.andrewbogdanovich.github.andriodproject.Activitys;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.andrewbogdanovich.github.andriodproject.Adapters.ArticleDataAdapter;
import com.andrewbogdanovich.github.andriodproject.Models.Article.Articles;
import com.andrewbogdanovich.github.andriodproject.Models.Article.MainModel;
import com.andrewbogdanovich.github.andriodproject.ArticleParseTask;
import com.andrewbogdanovich.github.andriodproject.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends FragmentActivity implements SwipeRefreshLayout.OnRefreshListener {

    List<Articles> articleList = new ArrayList<>();
    SwipeRefreshLayout swipeRefreshLayout;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadParser();
        loadDataInRecyclerView();
        initView();
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);

    }

    public void initView() {
        imageView = findViewById(R.id.search_ico_image_view);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(MainActivity.this, SearchActivity.class));
            }
        });
    }

    private void loadDataInRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.Recycler_View);
        ArticleDataAdapter articleDataAdapter = new ArticleDataAdapter(this, articleList);
        recyclerView.setAdapter(articleDataAdapter);

    }

    @SuppressLint("SetTextI18n")
    private void loadParser() {
        ArticleParseTask parseTask = new ArticleParseTask();
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
        Intent intent = new Intent(this, this.getClass());
        finish();
        this.startActivity(intent);
        swipeRefreshLayout.setRefreshing(true);
        swipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 3000);
    }
}
