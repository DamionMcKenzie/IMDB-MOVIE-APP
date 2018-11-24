package com.damionmckenzie.imdb_movie_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.damionmckenzie.imdb_movie_app.DetailActivity;
import com.damionmckenzie.imdb_movie_app.R;
import com.damionmckenzie.imdb_movie_app.model.Movie;

import org.parceler.Parcels;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private Context context;
    private List<Movie> movies;
    public static final String MOVIE = "movie";

    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("viewholder", "creating new view...");
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("viewholder", "binding view at position " + position);
        Movie movie = movies.get(position);
        //Bind the movie data into the ViewHolder
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public MoviesAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle, tvOverView;
        private ImageView ivPoster;
        private View container;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverView = itemView.findViewById(R.id.tvOverview);
            ivPoster = itemView.findViewById(R.id.ivPoster);
            container = itemView.findViewById(R.id.container);
        }

        public void bind(Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvOverView.setText(movie.getOverView());
            Glide.with(context).load(movie.getPosterPath()).into(ivPoster);
            container.setOnClickListener(v -> {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(MOVIE, Parcels.wrap(movie.getId()));
                context.startActivity(intent);
            });
        }
    }
}
