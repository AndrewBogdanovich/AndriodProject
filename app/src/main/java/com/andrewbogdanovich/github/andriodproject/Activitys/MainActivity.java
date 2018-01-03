package com.andrewbogdanovich.github.andriodproject.Activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.andrewbogdanovich.github.andriodproject.Models.Article.Articles;
import com.andrewbogdanovich.github.andriodproject.Models.Article.MainModel;
import com.andrewbogdanovich.github.andriodproject.Models.Article.Source;
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

        TextView textView = findViewById(R.id.Api_text_view);
        // textView.setText(parseText);
        MainModel mainModel = new Gson().fromJson(parseText, MainModel.class);
        Log.i("GSON", mainModel.getStatus() + " " + mainModel.getTotalResults());
        Source source = new Gson().fromJson(parseText, Source.class);
        Log.i("GSON2", source.getId() + " " + source.getName());
        Articles articles = new Gson().fromJson(parseText, Articles.class);
        Log.i("GSON3", articles.getAuthor() + " " + articles.getDescription());


        //Toast.makeText(this, parseText, Toast.LENGTH_SHORT).show();


    }


}
