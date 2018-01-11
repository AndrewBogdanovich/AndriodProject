package com.andrewbogdanovich.github.andriodproject.Activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.andrewbogdanovich.github.andriodproject.R;


public class WebViewActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = findViewById(R.id.news_web_view);
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        webView.loadUrl(bundle.getString("Link"));
    }
}
