package com.damionmckenzie.imdb_movie_app;

import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.damionmckenzie.imdb_movie_app.Adapter.MoviesAdapter;
import com.damionmckenzie.imdb_movie_app.model.Movie;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import cz.msebera.android.httpclient.Header;

public class DetailActivity extends YouTubeBaseActivity {
    private static final String YOUTUBE_API_KEY = "AIzaSyDDrbsueEz0DWfF5z5A2L0s8Y3IKVkf9Mg";
    public static final String TRAILER_URL;

    static {
        TRAILER_URL = "https://api.themoviedb.org/3/movie/%d/videos?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
    }

    private YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final TextView tvTitle = findViewById(R.id.tvTitle);
        final TextView tvOverView = findViewById(R.id.tvOverview);
        final RatingBar ratingBar = findViewById(R.id.ratingBar);
        youTubePlayerView = findViewById(R.id.player);

        final Movie movie = Parcels.unwrap(getIntent().getParcelableExtra(MoviesAdapter.MOVIE));
        tvTitle.setText(movie.getTitle());
        tvOverView.setText(movie.getOverView());
        ratingBar.setRating((float) movie.getRating());

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(String.format(TRAILER_URL, movie.getId()), new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray results = response.getJSONArray("results");
                    if (results.length()==0){
                        return;
                    }
                    JSONObject movieTrailer = results.getJSONObject(0);
                    String youtubeKey = movieTrailer.getString("key");
                    initializeYoutube(youtubeKey);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });

    }

    private void initializeYoutube(final String youtubeKey) {

        youTubePlayerView.initialize(YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d("smile", "on init success");
                youTubePlayer.cueVideo(youtubeKey);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d("smile", "on init failure");

            }
        });
    }
}
