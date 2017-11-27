package com.andrewbogdanovich.github.andriodproject.Activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.andrewbogdanovich.github.andriodproject.Article;
import com.andrewbogdanovich.github.andriodproject.DataAdapter;
import com.andrewbogdanovich.github.andriodproject.ParseTask;
import com.andrewbogdanovich.github.andriodproject.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Article> articles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new ParseTask().execute();

        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.Recycler_View);
        DataAdapter adapter = new DataAdapter(this, articles);
        recyclerView.setAdapter(adapter);

    }
    private void setInitialData(){
        articles.add(new Article("Sostav.ru","null","Bitcoin", "some descriprion_1","http://1111111", "http://222222.jpg", "2017.10.10"));
        articles.add(new Article("Vice News", "Jordan Person","A second bitcoin Fork Is Looming", "some descriprion_2","http://1111111", "http://222222.jpg", "2017.10.10"));
        articles.add(new Article("news", "jon","News title","some descriprion_3","http://1111111", "http://222222.jpg", "2017.10.10"));
        articles.add(new Article("Sostav.ru","null","Bitcoin", "some descriprion_1","http://1111111", "http://222222.jpg", "2017.10.10"));
        articles.add(new Article("Vice News", "Jordan Person","A second bitcoin Fork Is Looming", "some descriprion_2","http://1111111", "http://222222.jpg", "2017.10.10"));
        articles.add(new Article("news", "jon","News title","some descriprion_3","http://1111111", "http://222222.jpg", "2017.10.10"));
        articles.add(new Article("Sostav.ru","null","Bitcoin", "some descriprion_1","http://1111111", "http://222222.jpg", "2017.10.10"));
        articles.add(new Article("Vice News", "Jordan Person","A second bitcoin Fork Is Looming", "some descriprion_2","http://1111111", "http://222222.jpg", "2017.10.10"));
        articles.add(new Article("news", "jon","News title","some descriprion_3","http://1111111", "http://222222.jpg", "2017.10.10"));

    }
}
