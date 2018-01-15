package com.andrewbogdanovich.github.andriodproject.ImageLoader;

import android.widget.ImageView;

import com.andrewbogdanovich.github.andriodproject.Models.Article.Articles;

import java.lang.ref.WeakReference;

public class ImageRequest {
    String url;
    WeakReference<ImageView> target;
    int width;
    int height;

    private ImageRequest(Builder builder) {
        url = builder.url;
        target = builder.target;
    }

    public static final class Builder {
        private final Image image;
        private String url;
        private WeakReference<ImageView> target;

        Builder(Image image) {
            this.image = image;
        }

        Builder load(String val) {
            url = val;
            return this;
        }

        public void into(ImageView val) {
            target = new WeakReference<>(val);
            image.enqueue(this.build());
        }

        ImageRequest build() {
            return new ImageRequest(this);
        }
    }
}
