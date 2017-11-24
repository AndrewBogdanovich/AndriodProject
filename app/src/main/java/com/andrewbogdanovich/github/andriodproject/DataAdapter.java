package com.andrewbogdanovich.github.andriodproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Article> articles;

    public DataAdapter(Context context, List<Article> articles) {
        this.articles = articles;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_article, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.nameView.setText(article.getName());
        holder.authorView.setText(article.getAuthor());
        holder.titleView.setText(article.getTitle());
        holder.descriptionView.setText(article.getDescription());
        holder.urlView.setText(article.getUrl());

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, authorView, titleView, descriptionView, urlView;

        ViewHolder(View view) {
            super(view);
            nameView = view.findViewById(R.id.name_text_view);
            authorView = view.findViewById(R.id.author_text_view);
            titleView = view.findViewById(R.id.title_text_view);
            descriptionView = view.findViewById(R.id.description_text_view);
            urlView = view.findViewById(R.id.url_text_view);
        }
    }

}
