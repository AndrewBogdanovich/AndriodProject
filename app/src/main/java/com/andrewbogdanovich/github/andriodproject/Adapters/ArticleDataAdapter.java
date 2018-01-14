package com.andrewbogdanovich.github.andriodproject.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andrewbogdanovich.github.andriodproject.Activitys.WebViewActivity;
import com.andrewbogdanovich.github.andriodproject.Models.Article.Articles;
import com.andrewbogdanovich.github.andriodproject.R;

import java.util.List;

public class ArticleDataAdapter extends RecyclerView.Adapter<ArticleDataAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Articles> articleList;
    private Context context;


    public ArticleDataAdapter(Context context, List<Articles> articleList) {
        this.articleList = articleList;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public ArticleDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleDataAdapter.ViewHolder holder, int position) {
        final Articles article = articleList.get(position);
        holder.titleView.setText(article.getTitle());
        holder.publishedAtView.setText(article.getPublishedAt());
        // holder.imageView.setImageResource(Integer.parseInt(article.getUrlToImage()));


    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView titleView;
        final TextView publishedAtView;
        final RecyclerView recyclerView;
        //final ImageView imageView;

        @SuppressLint("WrongViewCast")
        ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            // imageView = view.findViewById(R.id.newsImage_image_view);
            titleView = view.findViewById(R.id.title_text_view);
            publishedAtView = view.findViewById(R.id.published_text_view);
            recyclerView = view.findViewById(R.id.Recycler_View);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            final Articles article = articleList.get(position);
            Intent intent = new Intent(context, WebViewActivity.class);
            intent.putExtra("Link", article.getUrl());
            context.startActivity(intent);
        }
    }
}
