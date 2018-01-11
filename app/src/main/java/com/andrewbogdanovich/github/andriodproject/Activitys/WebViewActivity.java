package com.andrewbogdanovich.github.andriodproject.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

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
        ImageView imageView = findViewById(R.id.back_arrow_image_view);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WebViewActivity.this, MainActivity.class));
            }
        });
    }
}
