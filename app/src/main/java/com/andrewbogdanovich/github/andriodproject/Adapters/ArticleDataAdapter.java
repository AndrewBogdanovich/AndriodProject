package com.andrewbogdanovich.github.andriodproject.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andrewbogdanovich.github.andriodproject.Models.Article.Articles;
import com.andrewbogdanovich.github.andriodproject.R;

import java.util.List;

public class ArticleDataAdapter extends RecyclerView.Adapter<ArticleDataAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Articles> articleList;

    public ArticleDataAdapter(Context context, List<Articles> articleList){
        this.articleList = articleList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ArticleDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleDataAdapter.ViewHolder holder, int position) {
        Articles article = articleList.get(position);
        holder.titleView.setText(article.getTitle());
        holder.descriptionView.setText(article.getDescription());

    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        final TextView titleView, descriptionView;

        ViewHolder(View view){
            super(view);
            titleView = view.findViewById(R.id.title_text_view);
            descriptionView = view.findViewById(R.id.description_text_view);

        }
    }
}
